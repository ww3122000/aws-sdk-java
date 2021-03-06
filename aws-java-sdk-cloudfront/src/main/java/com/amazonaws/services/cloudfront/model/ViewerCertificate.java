/*
 * Copyright 2010-2016 Amazon.com, Inc. or its affiliates. All Rights Reserved.
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
package com.amazonaws.services.cloudfront.model;

import java.io.Serializable;

/**
 * <p>
 * A complex type that contains information about viewer certificates
 * for this distribution.
 * </p>
 */
public class ViewerCertificate implements Serializable, Cloneable {

    /**
     * If you want viewers to use HTTPS to request your objects and you're
     * using an alternate domain name in your object URLs (for example,
     * https://example.com/logo.jpg), set to the IAM certificate identifier
     * of the custom viewer certificate for this distribution.
     */
    private String certificate;

    /**
     * If you want viewers to use HTTPS to request your objects and you're
     * using the CloudFront domain name of your distribution in your object
     * URLs (for example, https://d111111abcdef8.cloudfront.net/logo.jpg),
     * set to "cloudfront". If you want viewers to use HTTPS to request your
     * objects and you're using an alternate domain name in your object URLs
     * (for example, https://example.com/logo.jpg), set to "iam", and update
     * the Certificate field with the IAM certificate identifier of the
     * custom viewer certificate for this distribution.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Allowed Values: </b>cloudfront, iam
     */
    private String certificateSource;

    /**
     * If you specify a value for IAMCertificateId, you must also specify how
     * you want CloudFront to serve HTTPS requests. Valid values are vip and
     * sni-only. If you specify vip, CloudFront uses dedicated IP addresses
     * for your content and can respond to HTTPS requests from any viewer.
     * However, you must request permission to use this feature, and you
     * incur additional monthly charges. If you specify sni-only, CloudFront
     * can only respond to HTTPS requests from viewers that support Server
     * Name Indication (SNI). All modern browsers support SNI, but some
     * browsers still in use don't support SNI. Do not specify a value for
     * SSLSupportMethod if you specified true for
     * CloudFrontDefaultCertificate.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Allowed Values: </b>sni-only, vip
     */
    private String sSLSupportMethod;

    /**
     * Specify the minimum version of the SSL protocol that you want
     * CloudFront to use, SSLv3 or TLSv1, for HTTPS connections. CloudFront
     * will serve your objects only to browsers or devices that support at
     * least the SSL version that you specify. The TLSv1 protocol is more
     * secure, so we recommend that you specify SSLv3 only if your users are
     * using browsers or devices that don't support TLSv1. If you're using a
     * custom certificate (if you specify a value for IAMCertificateId) and
     * if you're using dedicated IP (if you specify vip for
     * SSLSupportMethod), you can choose SSLv3 or TLSv1 as the
     * MinimumProtocolVersion. If you're using a custom certificate (if you
     * specify a value for IAMCertificateId) and if you're using SNI (if you
     * specify sni-only for SSLSupportMethod), you must specify TLSv1 for
     * MinimumProtocolVersion.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Allowed Values: </b>SSLv3, TLSv1
     */
    private String minimumProtocolVersion;

    /**
     * Note: this field is deprecated. Please use "iam" as CertificateSource
     * and specify the IAM certificate Id as the Certificate. If you want
     * viewers to use HTTPS to request your objects and you're using an
     * alternate domain name in your object URLs (for example,
     * https://example.com/logo.jpg), specify the IAM certificate identifier
     * of the custom viewer certificate for this distribution. Specify either
     * this value or CloudFrontDefaultCertificate.
     */
    @Deprecated
    private String iAMCertificateId;

    /**
     * Note: this field is deprecated. Please use "cloudfront" as
     * CertificateSource and omit specifying a Certificate. If you want
     * viewers to use HTTPS to request your objects and you're using the
     * CloudFront domain name of your distribution in your object URLs (for
     * example, https://d111111abcdef8.cloudfront.net/logo.jpg), set to true.
     * Omit this value if you are setting an IAMCertificateId.
     */
    @Deprecated
    private Boolean cloudFrontDefaultCertificate;

    /**
     * If you want viewers to use HTTPS to request your objects and you're
     * using an alternate domain name in your object URLs (for example,
     * https://example.com/logo.jpg), set to the IAM certificate identifier
     * of the custom viewer certificate for this distribution.
     *
     * @return If you want viewers to use HTTPS to request your objects and you're
     *         using an alternate domain name in your object URLs (for example,
     *         https://example.com/logo.jpg), set to the IAM certificate identifier
     *         of the custom viewer certificate for this distribution.
     */
    public String getCertificate() {
        return certificate;
    }
    
    /**
     * If you want viewers to use HTTPS to request your objects and you're
     * using an alternate domain name in your object URLs (for example,
     * https://example.com/logo.jpg), set to the IAM certificate identifier
     * of the custom viewer certificate for this distribution.
     *
     * @param certificate If you want viewers to use HTTPS to request your objects and you're
     *         using an alternate domain name in your object URLs (for example,
     *         https://example.com/logo.jpg), set to the IAM certificate identifier
     *         of the custom viewer certificate for this distribution.
     */
    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }
    
    /**
     * If you want viewers to use HTTPS to request your objects and you're
     * using an alternate domain name in your object URLs (for example,
     * https://example.com/logo.jpg), set to the IAM certificate identifier
     * of the custom viewer certificate for this distribution.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param certificate If you want viewers to use HTTPS to request your objects and you're
     *         using an alternate domain name in your object URLs (for example,
     *         https://example.com/logo.jpg), set to the IAM certificate identifier
     *         of the custom viewer certificate for this distribution.
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public ViewerCertificate withCertificate(String certificate) {
        this.certificate = certificate;
        return this;
    }

    /**
     * If you want viewers to use HTTPS to request your objects and you're
     * using the CloudFront domain name of your distribution in your object
     * URLs (for example, https://d111111abcdef8.cloudfront.net/logo.jpg),
     * set to "cloudfront". If you want viewers to use HTTPS to request your
     * objects and you're using an alternate domain name in your object URLs
     * (for example, https://example.com/logo.jpg), set to "iam", and update
     * the Certificate field with the IAM certificate identifier of the
     * custom viewer certificate for this distribution.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Allowed Values: </b>cloudfront, iam
     *
     * @return If you want viewers to use HTTPS to request your objects and you're
     *         using the CloudFront domain name of your distribution in your object
     *         URLs (for example, https://d111111abcdef8.cloudfront.net/logo.jpg),
     *         set to "cloudfront". If you want viewers to use HTTPS to request your
     *         objects and you're using an alternate domain name in your object URLs
     *         (for example, https://example.com/logo.jpg), set to "iam", and update
     *         the Certificate field with the IAM certificate identifier of the
     *         custom viewer certificate for this distribution.
     *
     * @see CertificateSource
     */
    public String getCertificateSource() {
        return certificateSource;
    }
    
    /**
     * If you want viewers to use HTTPS to request your objects and you're
     * using the CloudFront domain name of your distribution in your object
     * URLs (for example, https://d111111abcdef8.cloudfront.net/logo.jpg),
     * set to "cloudfront". If you want viewers to use HTTPS to request your
     * objects and you're using an alternate domain name in your object URLs
     * (for example, https://example.com/logo.jpg), set to "iam", and update
     * the Certificate field with the IAM certificate identifier of the
     * custom viewer certificate for this distribution.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Allowed Values: </b>cloudfront, iam
     *
     * @param certificateSource If you want viewers to use HTTPS to request your objects and you're
     *         using the CloudFront domain name of your distribution in your object
     *         URLs (for example, https://d111111abcdef8.cloudfront.net/logo.jpg),
     *         set to "cloudfront". If you want viewers to use HTTPS to request your
     *         objects and you're using an alternate domain name in your object URLs
     *         (for example, https://example.com/logo.jpg), set to "iam", and update
     *         the Certificate field with the IAM certificate identifier of the
     *         custom viewer certificate for this distribution.
     *
     * @see CertificateSource
     */
    public void setCertificateSource(String certificateSource) {
        this.certificateSource = certificateSource;
    }
    
    /**
     * If you want viewers to use HTTPS to request your objects and you're
     * using the CloudFront domain name of your distribution in your object
     * URLs (for example, https://d111111abcdef8.cloudfront.net/logo.jpg),
     * set to "cloudfront". If you want viewers to use HTTPS to request your
     * objects and you're using an alternate domain name in your object URLs
     * (for example, https://example.com/logo.jpg), set to "iam", and update
     * the Certificate field with the IAM certificate identifier of the
     * custom viewer certificate for this distribution.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Allowed Values: </b>cloudfront, iam
     *
     * @param certificateSource If you want viewers to use HTTPS to request your objects and you're
     *         using the CloudFront domain name of your distribution in your object
     *         URLs (for example, https://d111111abcdef8.cloudfront.net/logo.jpg),
     *         set to "cloudfront". If you want viewers to use HTTPS to request your
     *         objects and you're using an alternate domain name in your object URLs
     *         (for example, https://example.com/logo.jpg), set to "iam", and update
     *         the Certificate field with the IAM certificate identifier of the
     *         custom viewer certificate for this distribution.
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     *
     * @see CertificateSource
     */
    public ViewerCertificate withCertificateSource(String certificateSource) {
        this.certificateSource = certificateSource;
        return this;
    }

    /**
     * If you want viewers to use HTTPS to request your objects and you're
     * using the CloudFront domain name of your distribution in your object
     * URLs (for example, https://d111111abcdef8.cloudfront.net/logo.jpg),
     * set to "cloudfront". If you want viewers to use HTTPS to request your
     * objects and you're using an alternate domain name in your object URLs
     * (for example, https://example.com/logo.jpg), set to "iam", and update
     * the Certificate field with the IAM certificate identifier of the
     * custom viewer certificate for this distribution.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Allowed Values: </b>cloudfront, iam
     *
     * @param certificateSource If you want viewers to use HTTPS to request your objects and you're
     *         using the CloudFront domain name of your distribution in your object
     *         URLs (for example, https://d111111abcdef8.cloudfront.net/logo.jpg),
     *         set to "cloudfront". If you want viewers to use HTTPS to request your
     *         objects and you're using an alternate domain name in your object URLs
     *         (for example, https://example.com/logo.jpg), set to "iam", and update
     *         the Certificate field with the IAM certificate identifier of the
     *         custom viewer certificate for this distribution.
     *
     * @see CertificateSource
     */
    public void setCertificateSource(CertificateSource certificateSource) {
        this.certificateSource = certificateSource.toString();
    }
    
    /**
     * If you want viewers to use HTTPS to request your objects and you're
     * using the CloudFront domain name of your distribution in your object
     * URLs (for example, https://d111111abcdef8.cloudfront.net/logo.jpg),
     * set to "cloudfront". If you want viewers to use HTTPS to request your
     * objects and you're using an alternate domain name in your object URLs
     * (for example, https://example.com/logo.jpg), set to "iam", and update
     * the Certificate field with the IAM certificate identifier of the
     * custom viewer certificate for this distribution.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Allowed Values: </b>cloudfront, iam
     *
     * @param certificateSource If you want viewers to use HTTPS to request your objects and you're
     *         using the CloudFront domain name of your distribution in your object
     *         URLs (for example, https://d111111abcdef8.cloudfront.net/logo.jpg),
     *         set to "cloudfront". If you want viewers to use HTTPS to request your
     *         objects and you're using an alternate domain name in your object URLs
     *         (for example, https://example.com/logo.jpg), set to "iam", and update
     *         the Certificate field with the IAM certificate identifier of the
     *         custom viewer certificate for this distribution.
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     *
     * @see CertificateSource
     */
    public ViewerCertificate withCertificateSource(CertificateSource certificateSource) {
        this.certificateSource = certificateSource.toString();
        return this;
    }

    /**
     * If you specify a value for IAMCertificateId, you must also specify how
     * you want CloudFront to serve HTTPS requests. Valid values are vip and
     * sni-only. If you specify vip, CloudFront uses dedicated IP addresses
     * for your content and can respond to HTTPS requests from any viewer.
     * However, you must request permission to use this feature, and you
     * incur additional monthly charges. If you specify sni-only, CloudFront
     * can only respond to HTTPS requests from viewers that support Server
     * Name Indication (SNI). All modern browsers support SNI, but some
     * browsers still in use don't support SNI. Do not specify a value for
     * SSLSupportMethod if you specified true for
     * CloudFrontDefaultCertificate.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Allowed Values: </b>sni-only, vip
     *
     * @return If you specify a value for IAMCertificateId, you must also specify how
     *         you want CloudFront to serve HTTPS requests. Valid values are vip and
     *         sni-only. If you specify vip, CloudFront uses dedicated IP addresses
     *         for your content and can respond to HTTPS requests from any viewer.
     *         However, you must request permission to use this feature, and you
     *         incur additional monthly charges. If you specify sni-only, CloudFront
     *         can only respond to HTTPS requests from viewers that support Server
     *         Name Indication (SNI). All modern browsers support SNI, but some
     *         browsers still in use don't support SNI. Do not specify a value for
     *         SSLSupportMethod if you specified true for
     *         CloudFrontDefaultCertificate.
     *
     * @see SSLSupportMethod
     */
    public String getSSLSupportMethod() {
        return sSLSupportMethod;
    }
    
    /**
     * If you specify a value for IAMCertificateId, you must also specify how
     * you want CloudFront to serve HTTPS requests. Valid values are vip and
     * sni-only. If you specify vip, CloudFront uses dedicated IP addresses
     * for your content and can respond to HTTPS requests from any viewer.
     * However, you must request permission to use this feature, and you
     * incur additional monthly charges. If you specify sni-only, CloudFront
     * can only respond to HTTPS requests from viewers that support Server
     * Name Indication (SNI). All modern browsers support SNI, but some
     * browsers still in use don't support SNI. Do not specify a value for
     * SSLSupportMethod if you specified true for
     * CloudFrontDefaultCertificate.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Allowed Values: </b>sni-only, vip
     *
     * @param sSLSupportMethod If you specify a value for IAMCertificateId, you must also specify how
     *         you want CloudFront to serve HTTPS requests. Valid values are vip and
     *         sni-only. If you specify vip, CloudFront uses dedicated IP addresses
     *         for your content and can respond to HTTPS requests from any viewer.
     *         However, you must request permission to use this feature, and you
     *         incur additional monthly charges. If you specify sni-only, CloudFront
     *         can only respond to HTTPS requests from viewers that support Server
     *         Name Indication (SNI). All modern browsers support SNI, but some
     *         browsers still in use don't support SNI. Do not specify a value for
     *         SSLSupportMethod if you specified true for
     *         CloudFrontDefaultCertificate.
     *
     * @see SSLSupportMethod
     */
    public void setSSLSupportMethod(String sSLSupportMethod) {
        this.sSLSupportMethod = sSLSupportMethod;
    }
    
    /**
     * If you specify a value for IAMCertificateId, you must also specify how
     * you want CloudFront to serve HTTPS requests. Valid values are vip and
     * sni-only. If you specify vip, CloudFront uses dedicated IP addresses
     * for your content and can respond to HTTPS requests from any viewer.
     * However, you must request permission to use this feature, and you
     * incur additional monthly charges. If you specify sni-only, CloudFront
     * can only respond to HTTPS requests from viewers that support Server
     * Name Indication (SNI). All modern browsers support SNI, but some
     * browsers still in use don't support SNI. Do not specify a value for
     * SSLSupportMethod if you specified true for
     * CloudFrontDefaultCertificate.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Allowed Values: </b>sni-only, vip
     *
     * @param sSLSupportMethod If you specify a value for IAMCertificateId, you must also specify how
     *         you want CloudFront to serve HTTPS requests. Valid values are vip and
     *         sni-only. If you specify vip, CloudFront uses dedicated IP addresses
     *         for your content and can respond to HTTPS requests from any viewer.
     *         However, you must request permission to use this feature, and you
     *         incur additional monthly charges. If you specify sni-only, CloudFront
     *         can only respond to HTTPS requests from viewers that support Server
     *         Name Indication (SNI). All modern browsers support SNI, but some
     *         browsers still in use don't support SNI. Do not specify a value for
     *         SSLSupportMethod if you specified true for
     *         CloudFrontDefaultCertificate.
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     *
     * @see SSLSupportMethod
     */
    public ViewerCertificate withSSLSupportMethod(String sSLSupportMethod) {
        this.sSLSupportMethod = sSLSupportMethod;
        return this;
    }

    /**
     * If you specify a value for IAMCertificateId, you must also specify how
     * you want CloudFront to serve HTTPS requests. Valid values are vip and
     * sni-only. If you specify vip, CloudFront uses dedicated IP addresses
     * for your content and can respond to HTTPS requests from any viewer.
     * However, you must request permission to use this feature, and you
     * incur additional monthly charges. If you specify sni-only, CloudFront
     * can only respond to HTTPS requests from viewers that support Server
     * Name Indication (SNI). All modern browsers support SNI, but some
     * browsers still in use don't support SNI. Do not specify a value for
     * SSLSupportMethod if you specified true for
     * CloudFrontDefaultCertificate.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Allowed Values: </b>sni-only, vip
     *
     * @param sSLSupportMethod If you specify a value for IAMCertificateId, you must also specify how
     *         you want CloudFront to serve HTTPS requests. Valid values are vip and
     *         sni-only. If you specify vip, CloudFront uses dedicated IP addresses
     *         for your content and can respond to HTTPS requests from any viewer.
     *         However, you must request permission to use this feature, and you
     *         incur additional monthly charges. If you specify sni-only, CloudFront
     *         can only respond to HTTPS requests from viewers that support Server
     *         Name Indication (SNI). All modern browsers support SNI, but some
     *         browsers still in use don't support SNI. Do not specify a value for
     *         SSLSupportMethod if you specified true for
     *         CloudFrontDefaultCertificate.
     *
     * @see SSLSupportMethod
     */
    public void setSSLSupportMethod(SSLSupportMethod sSLSupportMethod) {
        this.sSLSupportMethod = sSLSupportMethod.toString();
    }
    
    /**
     * If you specify a value for IAMCertificateId, you must also specify how
     * you want CloudFront to serve HTTPS requests. Valid values are vip and
     * sni-only. If you specify vip, CloudFront uses dedicated IP addresses
     * for your content and can respond to HTTPS requests from any viewer.
     * However, you must request permission to use this feature, and you
     * incur additional monthly charges. If you specify sni-only, CloudFront
     * can only respond to HTTPS requests from viewers that support Server
     * Name Indication (SNI). All modern browsers support SNI, but some
     * browsers still in use don't support SNI. Do not specify a value for
     * SSLSupportMethod if you specified true for
     * CloudFrontDefaultCertificate.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Allowed Values: </b>sni-only, vip
     *
     * @param sSLSupportMethod If you specify a value for IAMCertificateId, you must also specify how
     *         you want CloudFront to serve HTTPS requests. Valid values are vip and
     *         sni-only. If you specify vip, CloudFront uses dedicated IP addresses
     *         for your content and can respond to HTTPS requests from any viewer.
     *         However, you must request permission to use this feature, and you
     *         incur additional monthly charges. If you specify sni-only, CloudFront
     *         can only respond to HTTPS requests from viewers that support Server
     *         Name Indication (SNI). All modern browsers support SNI, but some
     *         browsers still in use don't support SNI. Do not specify a value for
     *         SSLSupportMethod if you specified true for
     *         CloudFrontDefaultCertificate.
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     *
     * @see SSLSupportMethod
     */
    public ViewerCertificate withSSLSupportMethod(SSLSupportMethod sSLSupportMethod) {
        this.sSLSupportMethod = sSLSupportMethod.toString();
        return this;
    }

    /**
     * Specify the minimum version of the SSL protocol that you want
     * CloudFront to use, SSLv3 or TLSv1, for HTTPS connections. CloudFront
     * will serve your objects only to browsers or devices that support at
     * least the SSL version that you specify. The TLSv1 protocol is more
     * secure, so we recommend that you specify SSLv3 only if your users are
     * using browsers or devices that don't support TLSv1. If you're using a
     * custom certificate (if you specify a value for IAMCertificateId) and
     * if you're using dedicated IP (if you specify vip for
     * SSLSupportMethod), you can choose SSLv3 or TLSv1 as the
     * MinimumProtocolVersion. If you're using a custom certificate (if you
     * specify a value for IAMCertificateId) and if you're using SNI (if you
     * specify sni-only for SSLSupportMethod), you must specify TLSv1 for
     * MinimumProtocolVersion.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Allowed Values: </b>SSLv3, TLSv1
     *
     * @return Specify the minimum version of the SSL protocol that you want
     *         CloudFront to use, SSLv3 or TLSv1, for HTTPS connections. CloudFront
     *         will serve your objects only to browsers or devices that support at
     *         least the SSL version that you specify. The TLSv1 protocol is more
     *         secure, so we recommend that you specify SSLv3 only if your users are
     *         using browsers or devices that don't support TLSv1. If you're using a
     *         custom certificate (if you specify a value for IAMCertificateId) and
     *         if you're using dedicated IP (if you specify vip for
     *         SSLSupportMethod), you can choose SSLv3 or TLSv1 as the
     *         MinimumProtocolVersion. If you're using a custom certificate (if you
     *         specify a value for IAMCertificateId) and if you're using SNI (if you
     *         specify sni-only for SSLSupportMethod), you must specify TLSv1 for
     *         MinimumProtocolVersion.
     *
     * @see MinimumProtocolVersion
     */
    public String getMinimumProtocolVersion() {
        return minimumProtocolVersion;
    }
    
    /**
     * Specify the minimum version of the SSL protocol that you want
     * CloudFront to use, SSLv3 or TLSv1, for HTTPS connections. CloudFront
     * will serve your objects only to browsers or devices that support at
     * least the SSL version that you specify. The TLSv1 protocol is more
     * secure, so we recommend that you specify SSLv3 only if your users are
     * using browsers or devices that don't support TLSv1. If you're using a
     * custom certificate (if you specify a value for IAMCertificateId) and
     * if you're using dedicated IP (if you specify vip for
     * SSLSupportMethod), you can choose SSLv3 or TLSv1 as the
     * MinimumProtocolVersion. If you're using a custom certificate (if you
     * specify a value for IAMCertificateId) and if you're using SNI (if you
     * specify sni-only for SSLSupportMethod), you must specify TLSv1 for
     * MinimumProtocolVersion.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Allowed Values: </b>SSLv3, TLSv1
     *
     * @param minimumProtocolVersion Specify the minimum version of the SSL protocol that you want
     *         CloudFront to use, SSLv3 or TLSv1, for HTTPS connections. CloudFront
     *         will serve your objects only to browsers or devices that support at
     *         least the SSL version that you specify. The TLSv1 protocol is more
     *         secure, so we recommend that you specify SSLv3 only if your users are
     *         using browsers or devices that don't support TLSv1. If you're using a
     *         custom certificate (if you specify a value for IAMCertificateId) and
     *         if you're using dedicated IP (if you specify vip for
     *         SSLSupportMethod), you can choose SSLv3 or TLSv1 as the
     *         MinimumProtocolVersion. If you're using a custom certificate (if you
     *         specify a value for IAMCertificateId) and if you're using SNI (if you
     *         specify sni-only for SSLSupportMethod), you must specify TLSv1 for
     *         MinimumProtocolVersion.
     *
     * @see MinimumProtocolVersion
     */
    public void setMinimumProtocolVersion(String minimumProtocolVersion) {
        this.minimumProtocolVersion = minimumProtocolVersion;
    }
    
    /**
     * Specify the minimum version of the SSL protocol that you want
     * CloudFront to use, SSLv3 or TLSv1, for HTTPS connections. CloudFront
     * will serve your objects only to browsers or devices that support at
     * least the SSL version that you specify. The TLSv1 protocol is more
     * secure, so we recommend that you specify SSLv3 only if your users are
     * using browsers or devices that don't support TLSv1. If you're using a
     * custom certificate (if you specify a value for IAMCertificateId) and
     * if you're using dedicated IP (if you specify vip for
     * SSLSupportMethod), you can choose SSLv3 or TLSv1 as the
     * MinimumProtocolVersion. If you're using a custom certificate (if you
     * specify a value for IAMCertificateId) and if you're using SNI (if you
     * specify sni-only for SSLSupportMethod), you must specify TLSv1 for
     * MinimumProtocolVersion.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Allowed Values: </b>SSLv3, TLSv1
     *
     * @param minimumProtocolVersion Specify the minimum version of the SSL protocol that you want
     *         CloudFront to use, SSLv3 or TLSv1, for HTTPS connections. CloudFront
     *         will serve your objects only to browsers or devices that support at
     *         least the SSL version that you specify. The TLSv1 protocol is more
     *         secure, so we recommend that you specify SSLv3 only if your users are
     *         using browsers or devices that don't support TLSv1. If you're using a
     *         custom certificate (if you specify a value for IAMCertificateId) and
     *         if you're using dedicated IP (if you specify vip for
     *         SSLSupportMethod), you can choose SSLv3 or TLSv1 as the
     *         MinimumProtocolVersion. If you're using a custom certificate (if you
     *         specify a value for IAMCertificateId) and if you're using SNI (if you
     *         specify sni-only for SSLSupportMethod), you must specify TLSv1 for
     *         MinimumProtocolVersion.
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     *
     * @see MinimumProtocolVersion
     */
    public ViewerCertificate withMinimumProtocolVersion(String minimumProtocolVersion) {
        this.minimumProtocolVersion = minimumProtocolVersion;
        return this;
    }

    /**
     * Specify the minimum version of the SSL protocol that you want
     * CloudFront to use, SSLv3 or TLSv1, for HTTPS connections. CloudFront
     * will serve your objects only to browsers or devices that support at
     * least the SSL version that you specify. The TLSv1 protocol is more
     * secure, so we recommend that you specify SSLv3 only if your users are
     * using browsers or devices that don't support TLSv1. If you're using a
     * custom certificate (if you specify a value for IAMCertificateId) and
     * if you're using dedicated IP (if you specify vip for
     * SSLSupportMethod), you can choose SSLv3 or TLSv1 as the
     * MinimumProtocolVersion. If you're using a custom certificate (if you
     * specify a value for IAMCertificateId) and if you're using SNI (if you
     * specify sni-only for SSLSupportMethod), you must specify TLSv1 for
     * MinimumProtocolVersion.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Allowed Values: </b>SSLv3, TLSv1
     *
     * @param minimumProtocolVersion Specify the minimum version of the SSL protocol that you want
     *         CloudFront to use, SSLv3 or TLSv1, for HTTPS connections. CloudFront
     *         will serve your objects only to browsers or devices that support at
     *         least the SSL version that you specify. The TLSv1 protocol is more
     *         secure, so we recommend that you specify SSLv3 only if your users are
     *         using browsers or devices that don't support TLSv1. If you're using a
     *         custom certificate (if you specify a value for IAMCertificateId) and
     *         if you're using dedicated IP (if you specify vip for
     *         SSLSupportMethod), you can choose SSLv3 or TLSv1 as the
     *         MinimumProtocolVersion. If you're using a custom certificate (if you
     *         specify a value for IAMCertificateId) and if you're using SNI (if you
     *         specify sni-only for SSLSupportMethod), you must specify TLSv1 for
     *         MinimumProtocolVersion.
     *
     * @see MinimumProtocolVersion
     */
    public void setMinimumProtocolVersion(MinimumProtocolVersion minimumProtocolVersion) {
        this.minimumProtocolVersion = minimumProtocolVersion.toString();
    }
    
    /**
     * Specify the minimum version of the SSL protocol that you want
     * CloudFront to use, SSLv3 or TLSv1, for HTTPS connections. CloudFront
     * will serve your objects only to browsers or devices that support at
     * least the SSL version that you specify. The TLSv1 protocol is more
     * secure, so we recommend that you specify SSLv3 only if your users are
     * using browsers or devices that don't support TLSv1. If you're using a
     * custom certificate (if you specify a value for IAMCertificateId) and
     * if you're using dedicated IP (if you specify vip for
     * SSLSupportMethod), you can choose SSLv3 or TLSv1 as the
     * MinimumProtocolVersion. If you're using a custom certificate (if you
     * specify a value for IAMCertificateId) and if you're using SNI (if you
     * specify sni-only for SSLSupportMethod), you must specify TLSv1 for
     * MinimumProtocolVersion.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Allowed Values: </b>SSLv3, TLSv1
     *
     * @param minimumProtocolVersion Specify the minimum version of the SSL protocol that you want
     *         CloudFront to use, SSLv3 or TLSv1, for HTTPS connections. CloudFront
     *         will serve your objects only to browsers or devices that support at
     *         least the SSL version that you specify. The TLSv1 protocol is more
     *         secure, so we recommend that you specify SSLv3 only if your users are
     *         using browsers or devices that don't support TLSv1. If you're using a
     *         custom certificate (if you specify a value for IAMCertificateId) and
     *         if you're using dedicated IP (if you specify vip for
     *         SSLSupportMethod), you can choose SSLv3 or TLSv1 as the
     *         MinimumProtocolVersion. If you're using a custom certificate (if you
     *         specify a value for IAMCertificateId) and if you're using SNI (if you
     *         specify sni-only for SSLSupportMethod), you must specify TLSv1 for
     *         MinimumProtocolVersion.
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     *
     * @see MinimumProtocolVersion
     */
    public ViewerCertificate withMinimumProtocolVersion(MinimumProtocolVersion minimumProtocolVersion) {
        this.minimumProtocolVersion = minimumProtocolVersion.toString();
        return this;
    }

    /**
     * Note: this field is deprecated. Please use "iam" as CertificateSource
     * and specify the IAM certificate Id as the Certificate. If you want
     * viewers to use HTTPS to request your objects and you're using an
     * alternate domain name in your object URLs (for example,
     * https://example.com/logo.jpg), specify the IAM certificate identifier
     * of the custom viewer certificate for this distribution. Specify either
     * this value or CloudFrontDefaultCertificate.
     *
     * @return Note: this field is deprecated. Please use "iam" as CertificateSource
     *         and specify the IAM certificate Id as the Certificate. If you want
     *         viewers to use HTTPS to request your objects and you're using an
     *         alternate domain name in your object URLs (for example,
     *         https://example.com/logo.jpg), specify the IAM certificate identifier
     *         of the custom viewer certificate for this distribution. Specify either
     *         this value or CloudFrontDefaultCertificate.
     */
    @Deprecated
    public String getIAMCertificateId() {
        return iAMCertificateId;
    }
    
    /**
     * Note: this field is deprecated. Please use "iam" as CertificateSource
     * and specify the IAM certificate Id as the Certificate. If you want
     * viewers to use HTTPS to request your objects and you're using an
     * alternate domain name in your object URLs (for example,
     * https://example.com/logo.jpg), specify the IAM certificate identifier
     * of the custom viewer certificate for this distribution. Specify either
     * this value or CloudFrontDefaultCertificate.
     *
     * @param iAMCertificateId Note: this field is deprecated. Please use "iam" as CertificateSource
     *         and specify the IAM certificate Id as the Certificate. If you want
     *         viewers to use HTTPS to request your objects and you're using an
     *         alternate domain name in your object URLs (for example,
     *         https://example.com/logo.jpg), specify the IAM certificate identifier
     *         of the custom viewer certificate for this distribution. Specify either
     *         this value or CloudFrontDefaultCertificate.
     */
    @Deprecated
    public void setIAMCertificateId(String iAMCertificateId) {
        this.iAMCertificateId = iAMCertificateId;
    }
    
    /**
     * Note: this field is deprecated. Please use "iam" as CertificateSource
     * and specify the IAM certificate Id as the Certificate. If you want
     * viewers to use HTTPS to request your objects and you're using an
     * alternate domain name in your object URLs (for example,
     * https://example.com/logo.jpg), specify the IAM certificate identifier
     * of the custom viewer certificate for this distribution. Specify either
     * this value or CloudFrontDefaultCertificate.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param iAMCertificateId Note: this field is deprecated. Please use "iam" as CertificateSource
     *         and specify the IAM certificate Id as the Certificate. If you want
     *         viewers to use HTTPS to request your objects and you're using an
     *         alternate domain name in your object URLs (for example,
     *         https://example.com/logo.jpg), specify the IAM certificate identifier
     *         of the custom viewer certificate for this distribution. Specify either
     *         this value or CloudFrontDefaultCertificate.
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    @Deprecated
    public ViewerCertificate withIAMCertificateId(String iAMCertificateId) {
        this.iAMCertificateId = iAMCertificateId;
        return this;
    }

    /**
     * Note: this field is deprecated. Please use "cloudfront" as
     * CertificateSource and omit specifying a Certificate. If you want
     * viewers to use HTTPS to request your objects and you're using the
     * CloudFront domain name of your distribution in your object URLs (for
     * example, https://d111111abcdef8.cloudfront.net/logo.jpg), set to true.
     * Omit this value if you are setting an IAMCertificateId.
     *
     * @return Note: this field is deprecated. Please use "cloudfront" as
     *         CertificateSource and omit specifying a Certificate. If you want
     *         viewers to use HTTPS to request your objects and you're using the
     *         CloudFront domain name of your distribution in your object URLs (for
     *         example, https://d111111abcdef8.cloudfront.net/logo.jpg), set to true.
     *         Omit this value if you are setting an IAMCertificateId.
     */
    @Deprecated
    public Boolean isCloudFrontDefaultCertificate() {
        return cloudFrontDefaultCertificate;
    }
    
    /**
     * Note: this field is deprecated. Please use "cloudfront" as
     * CertificateSource and omit specifying a Certificate. If you want
     * viewers to use HTTPS to request your objects and you're using the
     * CloudFront domain name of your distribution in your object URLs (for
     * example, https://d111111abcdef8.cloudfront.net/logo.jpg), set to true.
     * Omit this value if you are setting an IAMCertificateId.
     *
     * @param cloudFrontDefaultCertificate Note: this field is deprecated. Please use "cloudfront" as
     *         CertificateSource and omit specifying a Certificate. If you want
     *         viewers to use HTTPS to request your objects and you're using the
     *         CloudFront domain name of your distribution in your object URLs (for
     *         example, https://d111111abcdef8.cloudfront.net/logo.jpg), set to true.
     *         Omit this value if you are setting an IAMCertificateId.
     */
    @Deprecated
    public void setCloudFrontDefaultCertificate(Boolean cloudFrontDefaultCertificate) {
        this.cloudFrontDefaultCertificate = cloudFrontDefaultCertificate;
    }
    
    /**
     * Note: this field is deprecated. Please use "cloudfront" as
     * CertificateSource and omit specifying a Certificate. If you want
     * viewers to use HTTPS to request your objects and you're using the
     * CloudFront domain name of your distribution in your object URLs (for
     * example, https://d111111abcdef8.cloudfront.net/logo.jpg), set to true.
     * Omit this value if you are setting an IAMCertificateId.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param cloudFrontDefaultCertificate Note: this field is deprecated. Please use "cloudfront" as
     *         CertificateSource and omit specifying a Certificate. If you want
     *         viewers to use HTTPS to request your objects and you're using the
     *         CloudFront domain name of your distribution in your object URLs (for
     *         example, https://d111111abcdef8.cloudfront.net/logo.jpg), set to true.
     *         Omit this value if you are setting an IAMCertificateId.
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    @Deprecated
    public ViewerCertificate withCloudFrontDefaultCertificate(Boolean cloudFrontDefaultCertificate) {
        this.cloudFrontDefaultCertificate = cloudFrontDefaultCertificate;
        return this;
    }

    /**
     * Note: this field is deprecated. Please use "cloudfront" as
     * CertificateSource and omit specifying a Certificate. If you want
     * viewers to use HTTPS to request your objects and you're using the
     * CloudFront domain name of your distribution in your object URLs (for
     * example, https://d111111abcdef8.cloudfront.net/logo.jpg), set to true.
     * Omit this value if you are setting an IAMCertificateId.
     *
     * @return Note: this field is deprecated. Please use "cloudfront" as
     *         CertificateSource and omit specifying a Certificate. If you want
     *         viewers to use HTTPS to request your objects and you're using the
     *         CloudFront domain name of your distribution in your object URLs (for
     *         example, https://d111111abcdef8.cloudfront.net/logo.jpg), set to true.
     *         Omit this value if you are setting an IAMCertificateId.
     */
    public Boolean getCloudFrontDefaultCertificate() {
        return cloudFrontDefaultCertificate;
    }

    /**
     * Returns a string representation of this object; useful for testing and
     * debugging.
     *
     * @return A string representation of this object.
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getCertificate() != null) sb.append("Certificate: " + getCertificate() + ",");
        if (getCertificateSource() != null) sb.append("CertificateSource: " + getCertificateSource() + ",");
        if (getSSLSupportMethod() != null) sb.append("SSLSupportMethod: " + getSSLSupportMethod() + ",");
        if (getMinimumProtocolVersion() != null) sb.append("MinimumProtocolVersion: " + getMinimumProtocolVersion() + ",");
        if (getIAMCertificateId() != null) sb.append("IAMCertificateId: " + getIAMCertificateId() + ",");
        if (isCloudFrontDefaultCertificate() != null) sb.append("CloudFrontDefaultCertificate: " + isCloudFrontDefaultCertificate() );
        sb.append("}");
        return sb.toString();
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;
        
        hashCode = prime * hashCode + ((getCertificate() == null) ? 0 : getCertificate().hashCode()); 
        hashCode = prime * hashCode + ((getCertificateSource() == null) ? 0 : getCertificateSource().hashCode()); 
        hashCode = prime * hashCode + ((getSSLSupportMethod() == null) ? 0 : getSSLSupportMethod().hashCode()); 
        hashCode = prime * hashCode + ((getMinimumProtocolVersion() == null) ? 0 : getMinimumProtocolVersion().hashCode()); 
        hashCode = prime * hashCode + ((getIAMCertificateId() == null) ? 0 : getIAMCertificateId().hashCode()); 
        hashCode = prime * hashCode + ((isCloudFrontDefaultCertificate() == null) ? 0 : isCloudFrontDefaultCertificate().hashCode()); 
        return hashCode;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;

        if (obj instanceof ViewerCertificate == false) return false;
        ViewerCertificate other = (ViewerCertificate)obj;
        
        if (other.getCertificate() == null ^ this.getCertificate() == null) return false;
        if (other.getCertificate() != null && other.getCertificate().equals(this.getCertificate()) == false) return false; 
        if (other.getCertificateSource() == null ^ this.getCertificateSource() == null) return false;
        if (other.getCertificateSource() != null && other.getCertificateSource().equals(this.getCertificateSource()) == false) return false; 
        if (other.getSSLSupportMethod() == null ^ this.getSSLSupportMethod() == null) return false;
        if (other.getSSLSupportMethod() != null && other.getSSLSupportMethod().equals(this.getSSLSupportMethod()) == false) return false; 
        if (other.getMinimumProtocolVersion() == null ^ this.getMinimumProtocolVersion() == null) return false;
        if (other.getMinimumProtocolVersion() != null && other.getMinimumProtocolVersion().equals(this.getMinimumProtocolVersion()) == false) return false; 
        if (other.getIAMCertificateId() == null ^ this.getIAMCertificateId() == null) return false;
        if (other.getIAMCertificateId() != null && other.getIAMCertificateId().equals(this.getIAMCertificateId()) == false) return false; 
        if (other.isCloudFrontDefaultCertificate() == null ^ this.isCloudFrontDefaultCertificate() == null) return false;
        if (other.isCloudFrontDefaultCertificate() != null && other.isCloudFrontDefaultCertificate().equals(this.isCloudFrontDefaultCertificate()) == false) return false; 
        return true;
    }
    
    @Override
    public ViewerCertificate clone() {
        try {
            return (ViewerCertificate) super.clone();
        
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException(
                    "Got a CloneNotSupportedException from Object.clone() "
                    + "even though we're Cloneable!",
                    e);
        }
        
    }

}
    