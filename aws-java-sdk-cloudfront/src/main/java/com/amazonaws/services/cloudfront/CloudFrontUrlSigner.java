/*
 * Copyright 2013-2016 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *  http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
package com.amazonaws.services.cloudfront;

import static com.amazonaws.util.StringUtils.UTF8;
import static java.util.concurrent.TimeUnit.MILLISECONDS;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.util.Calendar;
import java.util.Date;

import com.amazonaws.AmazonClientException;
import com.amazonaws.auth.PEM;
import com.amazonaws.auth.RSA;
import com.amazonaws.util.Base64;
import com.amazonaws.util.DateUtils;
import com.amazonaws.util.IOUtils;
import com.amazonaws.util.StringUtils;

// The source code originated from the .NET implementation at
// https://github.com/aws/aws-sdk-net/blob/master/AWSSDK_DotNet35/Amazon.CloudFront/AmazonCloudFrontUrlSigner.cs
/**
 * Utility class for generating pre-signed URLs for serving private CloudFront
 * content. All dates must be in UTC. Use {@link Calendar} to set the timezone
 * specifically before converting to a {@link Date} object, or else use
 * {@link DateUtils} to turn a UTC date String into a Date object.
 *
 * <pre>
 * Protocol protocol = Protocol.http;
 * String distributionDomain = "d1b2c3a4g5h6.cloudfront.net";
 * File privateKeyFile = new File("/path/to/cfcurlCloud/rsa-private-key.pem");
 * String s3ObjectKey = "a/b/images.jpeg";
 * String keyPairId = "APKAJCEOKRHC3XIVU5NA";
 * Date dateLessThan = DateUtils.parseISO8601Date("2012-11-14T22:20:00.000Z");
 * Date dateGreaterThan = DateUtils.parseISO8601Date("2011-11-14T22:20:00.000Z");
 * String ipRange = "192.168.0.1/24";
 *
 * String url1 = CloudFrontUrlSigner.getSignedURLWithCannedPolicy(
 *              protocol, distributionDomain, privateKeyFile,
 *              s3ObjectKey, keyPairId, dateLessThan);
 *
 * String url2 = CloudFrontUrlSigner.getSignedURLWithCustomPolicy(
 *              protocol, distributionDomain, privateKeyFile,
 *              s3ObjectKey, keyPairId, dateLessThan,
 *              dateGreaterThan, ipRange);
 * </pre>
 *
 * @see DateUtils
 */
public enum CloudFrontUrlSigner {
    ;
    private static final SecureRandom srand = new SecureRandom();
    /**
     * Enumeration of protocols for presigned URLs
     */
    public static enum Protocol {
        http, https, rtmp
    }

    /**
     * Returns a signed URL with a canned policy that grants universal access to
     * private content until a given date.
     * For more information, see <a href=
     * "http://docs.aws.amazon.com/AmazonCloudFront/latest/DeveloperGuide/private-content-signed-urls-overview.html"
     * >Overview of Signed URLs</a>.
     *
     * @param protocol
     *            The protocol of the URL
     * @param distributionDomain
     *            The domain name of the distribution
     * @param s3ObjectKey
     *            The s3 key of the object, or the name of the stream for rtmp
     * @param privateKeyFile
     *            The private key file. RSA private key (.pem) and pkcs8 (.der)
     *            files are supported.
     * @param keyPairId
     *            The key pair id corresponding to the private key file given
     * @param dateLessThan
     *            The expiration date of the signed URL in UTC
     * @return The signed URL.
     */
    public static String getSignedURLWithCannedPolicy(final Protocol protocol,
                                            final String distributionDomain,
                                            final File privateKeyFile,
                                            final String s3ObjectKey,
                                            final String keyPairId,
                                            final Date dateLessThan)
            throws InvalidKeySpecException, IOException {
        final String resourcePath = generateResourcePath(protocol, distributionDomain, s3ObjectKey);
        PrivateKey privateKey = loadPrivateKey(privateKeyFile);
        return getSignedURLWithCannedPolicy(resourcePath, keyPairId, privateKey, dateLessThan);
    }

    /**
     * Returns a signed URL that provides tailored access to private content
     * based on an access time window and an ip range.
     * For more information, see <a href=
     * "http://docs.aws.amazon.com/AmazonCloudFront/latest/DeveloperGuide/private-content-signed-urls-overview.html"
     * >Overview of Signed URLs</a>.
     *
     * @param protocol
     *            The protocol of the URL
     * @param distributionDomain
     *            The domain name of the distribution
     * @param privateKeyFile
     *            Your private key file. RSA private key (.pem) and pkcs8 (.der)
     *            files are supported.
     * @param s3ObjectKey
     *            The s3 key of the object, or the name of the stream for rtmp
     * @param keyPairId
     *            The key pair id corresponding to the private key file given
     * @param dateLessThan
     *            The expiration date of the signed URL in UTC
     * @param dateGreaterThan
     *            The beginning valid date of the signed URL in UTC
     * @param ipRange
     *            The allowed IP address range of the client making the GET
     *            request, in CIDR form (e.g. 192.168.0.1/24).
     * @return The signed URL.
     * @throws IOException
     * @throws InvalidKeySpecException
     */
    public static String getSignedURLWithCustomPolicy(final Protocol protocol,
                                            final String distributionDomain,
                                            final File privateKeyFile,
                                            final String s3ObjectKey,
                                            final String keyPairId,
                                            final Date dateLessThan,
                                            final Date dateGreaterThan,
                                            final String ipRange)
            throws InvalidKeySpecException, IOException {
        PrivateKey privateKey = loadPrivateKey(privateKeyFile);
        final String resourcePath = generateResourcePath(protocol, distributionDomain, s3ObjectKey);
        String policy = buildCustomPolicyForSignedUrl(resourcePath, dateLessThan, ipRange, dateGreaterThan);
        return getSignedURLWithCustomPolicy(resourcePath, keyPairId, privateKey, policy);
    }

    /**
     * Generate a signed URL that allows access to distribution and S3 objects
     * by applying access restrictions specified in a custom policy document.
     * For more information, see <a href=
     * "http://docs.aws.amazon.com/AmazonCloudFront/latest/DeveloperGuide/private-content-signed-urls-overview.html"
     * >Overview of Signed URLs</a>.
     *
     * @param resourceUrlOrPath
     *            The URL or path that uniquely identifies a resource within a
     *            distribution. For standard distributions the resource URL will
     *            be <tt>"http://" + distributionName + "/" + objectKey</tt>
     *            (may also include URL parameters. For distributions with the
     *            HTTPS required protocol, the resource URL must start with
     *            <tt>"https://"</tt>. RTMP resources do not take the form of a
     *            URL, and instead the resource path is nothing but the stream's
     *            name.
     * @param keyPairId
     *            Identifier of a public/private certificate keypair already
     *            configured in your Amazon Web Services account.
     * @param privateKey
     *            The RSA private key data that corresponding to the certificate
     *            keypair identified by keyPairId.
     * @param policy
     *            A policy document that describes the access permissions that
     *            will be applied by the signed URL. To generate a custom policy
     *            use
     * @return A signed URL that will permit access to distribution and S3
     *         objects as specified in the policy document.
     */
    public static String getSignedURLWithCustomPolicy(String resourceUrlOrPath,
            String keyPairId, PrivateKey privateKey, String policy) {
        try {
            byte[] signatureBytes = signWithSha1RSA(
                    policy.getBytes(UTF8), privateKey);
            String urlSafePolicy = makeStringUrlSafe(policy);
            String urlSafeSignature = makeBytesUrlSafe(signatureBytes);
            String signedUrl = resourceUrlOrPath
                    + (resourceUrlOrPath.indexOf('?') >= 0 ? "&" : "?")
                    + "Policy=" + urlSafePolicy
                    + "&Signature=" + urlSafeSignature
                    + "&Key-Pair-Id=" + keyPairId
                    ;
            return signedUrl;
        } catch (InvalidKeyException e) {
            throw new AmazonClientException("Coudln't sign url", e);
        }
    }

    /**
     * Generate a signed URL that allows access to a specific distribution and
     * S3 object by applying a access restrictions from a "canned" (simplified)
     * policy document.
     * For more information, see <a href=
     * "http://docs.aws.amazon.com/AmazonCloudFront/latest/DeveloperGuide/private-content-signed-urls-overview.html"
     * >Overview of Signed URLs</a>.
     *
     * @param resourceUrlOrPath
     *            The URL or path that uniquely identifies a resource within a
     *            distribution. For standard distributions the resource URL will
     *            be <tt>"http://" + distributionName + "/" + objectKey</tt>
     *            (may also include URL parameters. For distributions with the
     *            HTTPS required protocol, the resource URL must start with
     *            <tt>"https://"</tt>. RTMP resources do not take the form of a
     *            URL, and instead the resource path is nothing but the stream's
     *            name.
     * @param keyPairId
     *            Identifier of a public/private certificate keypair already
     *            configured in your Amazon Web Services account.
     * @param privateKey
     *            The private key data that corresponding to the keypair
     *            identified by keyPairId
     * @param dateLessThan
     *            The UTC time and date when the signed URL will expire.
     *            REQUIRED.
     * @return A signed URL that will permit access to a specific distribution
     *         and S3 object.
     */
    public static String getSignedURLWithCannedPolicy(String resourceUrlOrPath,
                                       String keyPairId,
                                       PrivateKey privateKey,
                                       Date dateLessThan) {
        try {
            String cannedPolicy = buildCannedPolicy(resourceUrlOrPath, dateLessThan);
            byte[] signatureBytes = signWithSha1RSA(cannedPolicy.getBytes(UTF8), privateKey);
            String urlSafeSignature = makeBytesUrlSafe(signatureBytes);
            String signedUrl = resourceUrlOrPath
                             + (resourceUrlOrPath.indexOf('?') >= 0 ? "&" : "?") 
                             + "Expires=" + MILLISECONDS.toSeconds(dateLessThan.getTime()) 
                             + "&Signature=" + urlSafeSignature
                             + "&Key-Pair-Id=" + keyPairId
                             ;
            return signedUrl;
        } catch ( InvalidKeyException e ) {
            throw new AmazonClientException("Couldn't sign url", e);
        }
    }

    /**
     * Generate a policy document that describes custom access permissions to
     * apply via a private distribution's signed URL.
     *
     * @param resourcePath
     *            An optional HTTP/S or RTMP resource path that restricts which
     *            distribution and S3 objects will be accessible in a signed
     *            URL. For standard distributions the resource URL will be
     *            <tt>"http://" + distributionName + "/" + objectKey</tt> (may
     *            also include URL parameters. For distributions with the HTTPS
     *            required protocol, the resource URL must start with
     *            <tt>"https://"</tt>. RTMP resources do not take the form of a
     *            URL, and instead the resource path is nothing but the stream's
     *            name. The '*' and '?' characters can be used as a wildcards to
     *            allow multi-character or single-character matches
     *            respectively:
     *            <ul>
     *            <li><tt>*</tt> : All distributions/objects will be accessible</li>
     *            <li><tt>a1b2c3d4e5f6g7.cloudfront.net/*</tt> : All objects
     *            within the distribution a1b2c3d4e5f6g7 will be accessible</li>
     *            <li><tt>a1b2c3d4e5f6g7.cloudfront.net/path/to/object.txt</tt>
     *            : Only the S3 object named <tt>path/to/object.txt</tt> in the
     *            distribution a1b2c3d4e5f6g7 will be accessible.</li>
     *            </ul>
     *            If this parameter is null the policy will permit access to all
     *            distributions and S3 objects associated with the certificate
     *            keypair used to generate the signed URL.
     * @param epochDateLessThan
     *            The UTC time and date when the signed URL will expire. REQUIRED.
     * @param limitToIpAddressCIDR
     *            An optional range of client IP addresses that will be allowed
     *            to access the distribution, specified as a CIDR range. If
     *            null, the CIDR will be <tt>0.0.0.0/0</tt> and any client will
     *            be permitted.
     * @param epochDateGreaterThan
     *            An optional UTC time and date when the signed URL will become
     *            active. If null, the signed URL will be active as soon as it
     *            is created.
     * @return A policy document describing the access permission to apply when
     *         generating a signed URL.
     */
    public static String buildCustomPolicyForSignedUrl(String resourcePath,
                                                 Date epochDateLessThan,
                                                 String limitToIpAddressCIDR,
                                                 Date epochDateGreaterThan) {
        if ( epochDateLessThan == null ) {
            throw new AmazonClientException("epochDateLessThan must be provided to sign CloudFront URLs");
        }
        if ( resourcePath == null ) {
            resourcePath = "*";
        }
        String ipAddress = (limitToIpAddressCIDR == null
                         ? "0.0.0.0/0" // No IP restriction
                         : limitToIpAddressCIDR)
                         ;
        return buildCustomPolicy(resourcePath, epochDateLessThan,
                epochDateGreaterThan, ipAddress);
    }

    /**
     * Returns a custom policy for the given parameters.
     */
    static String buildCustomPolicy(String resourcePath,
            Date epochDateLessThan, Date epochDateGreaterThan, String ipAddress) {
        return "{\"Statement\": [{"
                + "\"Resource\":\""
                + resourcePath
                + "\""
                + ",\"Condition\":{"
                + "\"DateLessThan\":{\"AWS:EpochTime\":"
                + MILLISECONDS.toSeconds(epochDateLessThan.getTime())
                + "}"
                + ",\"IpAddress\":{\"AWS:SourceIp\":\""
                + ipAddress
                + "\"}"
                + (epochDateGreaterThan == null
                   ? ""
                   : ",\"DateGreaterThan\":{\"AWS:EpochTime\":"
                     + MILLISECONDS.toSeconds(epochDateGreaterThan.getTime()) + "}"
                  )
                + "}}]}";
    }

    /**
     * Returns a "canned" policy for the given parameters.
     * For more information, see <a href=
     * "http://docs.aws.amazon.com/AmazonCloudFront/latest/DeveloperGuide/private-content-signed-urls-overview.html"
     * >Overview of Signed URLs</a>.
     */
    static String buildCannedPolicy(String resourceUrlOrPath,
            Date dateLessThan) {
        return "{\"Statement\":[{\"Resource\":\""
                + resourceUrlOrPath
                + "\",\"Condition\":{\"DateLessThan\":{\"AWS:EpochTime\":"
                + MILLISECONDS.toSeconds(dateLessThan.getTime())
                + "}}}]}";
    }

    /**
     * Converts the given data to be safe for use in signed URLs for a private
     * distribution by using specialized Base64 encoding.
     */
    static String makeBytesUrlSafe(byte[] bytes) {
        byte[] encoded = Base64.encode(bytes);

        for (int i=0; i < encoded.length; i++) {
            switch(encoded[i]) {
                case '+':
                    encoded[i] = '-'; continue;
                case '=':
                    encoded[i] = '_'; continue;
                case '/':
                    encoded[i] = '~'; continue;
                default:
                    continue;
            }
        }
        return new String(encoded, UTF8);
    }

    /**
     * Converts the given string to be safe for use in signed URLs for a private
     * distribution.
     */
    private static String makeStringUrlSafe(String str) {
        return makeBytesUrlSafe(str.getBytes(StringUtils.UTF8));
    }

    /**
     * Returns the resource path for the given distribution, object, and
     * protocol.
     */
    private static String generateResourcePath(final Protocol protocol,
            final String distributionDomain, final String s3ObjectKey) {
        return protocol == Protocol.http || protocol == Protocol.https
             ? protocol + "://" + distributionDomain + "/" + s3ObjectKey
             : s3ObjectKey
             ;
    }

    /**
     * Creates a private key from the file given, either in RSA private key
     * (.pem) or pkcs8 (.der) format. Other formats will cause an exception to
     * be thrown.
     */
    static PrivateKey loadPrivateKey(File privateKeyFile) throws InvalidKeySpecException, IOException {
        if ( privateKeyFile.getAbsolutePath().toLowerCase().endsWith(".pem") ) {
            InputStream is = new FileInputStream(privateKeyFile);
            try {
                return PEM.readPrivateKey(is);
            } finally {
                try {is.close();} catch(IOException ignore) {}
            }
        } else if ( privateKeyFile.getAbsolutePath().toLowerCase().endsWith(".der") ) {
            InputStream is = new FileInputStream(privateKeyFile);
            try {
                return RSA.privateKeyFromPKCS8(IOUtils.toByteArray(is));
            } finally {
                try {is.close();} catch(IOException ignore) {}
            }
        } else {
            throw new AmazonClientException("Unsupported file type for private key");
        }
    }

    /**
     * Signs the data given with the private key given, using the SHA1withRSA
     * algorithm provided by bouncy castle.
     */
    private static byte[] signWithSha1RSA(byte[] dataToSign,
            PrivateKey privateKey) throws InvalidKeyException {
        Signature signature;
        try {
            signature = Signature.getInstance("SHA1withRSA");
            signature.initSign(privateKey, srand);
            signature.update(dataToSign);
            return signature.sign();
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException(e);
        } catch (SignatureException e) {
            throw new IllegalStateException(e);
        }
    }
}
