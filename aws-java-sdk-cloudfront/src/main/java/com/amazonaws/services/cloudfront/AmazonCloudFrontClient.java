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
package com.amazonaws.services.cloudfront;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Node;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.AmazonWebServiceClient;
import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.Request;
import com.amazonaws.Response;
import com.amazonaws.ResponseMetadata;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.handlers.HandlerChainFactory;
import com.amazonaws.http.DefaultErrorResponseHandler;
import com.amazonaws.http.ExecutionContext;
import com.amazonaws.http.StaxResponseHandler;
import com.amazonaws.internal.StaticCredentialsProvider;
import com.amazonaws.metrics.RequestMetricCollector;
import com.amazonaws.services.cloudfront.model.AccessDeniedException;
import com.amazonaws.services.cloudfront.model.BatchTooLargeException;
import com.amazonaws.services.cloudfront.model.CNAMEAlreadyExistsException;
import com.amazonaws.services.cloudfront.model.CalculateBandwidthRequest;
import com.amazonaws.services.cloudfront.model.CalculateBandwidthResult;
import com.amazonaws.services.cloudfront.model.CloudFrontOriginAccessIdentityAlreadyExistsException;
import com.amazonaws.services.cloudfront.model.CloudFrontOriginAccessIdentityInUseException;
import com.amazonaws.services.cloudfront.model.CreateCloudFrontOriginAccessIdentityRequest;
import com.amazonaws.services.cloudfront.model.CreateCloudFrontOriginAccessIdentityResult;
import com.amazonaws.services.cloudfront.model.CreateDistributionRequest;
import com.amazonaws.services.cloudfront.model.CreateDistributionResult;
import com.amazonaws.services.cloudfront.model.CreateInvalidationRequest;
import com.amazonaws.services.cloudfront.model.CreateInvalidationResult;
import com.amazonaws.services.cloudfront.model.CreatePreloadRequest;
import com.amazonaws.services.cloudfront.model.CreatePreloadResult;
import com.amazonaws.services.cloudfront.model.CreateStreamingDistributionRequest;
import com.amazonaws.services.cloudfront.model.CreateStreamingDistributionResult;
import com.amazonaws.services.cloudfront.model.DeleteCloudFrontOriginAccessIdentityRequest;
import com.amazonaws.services.cloudfront.model.DeleteDistributionRequest;
import com.amazonaws.services.cloudfront.model.DeleteStreamingDistributionRequest;
import com.amazonaws.services.cloudfront.model.DistributionAlreadyExistsException;
import com.amazonaws.services.cloudfront.model.DistributionNotDisabledException;
import com.amazonaws.services.cloudfront.model.GetCloudFrontOriginAccessIdentityConfigRequest;
import com.amazonaws.services.cloudfront.model.GetCloudFrontOriginAccessIdentityConfigResult;
import com.amazonaws.services.cloudfront.model.GetCloudFrontOriginAccessIdentityRequest;
import com.amazonaws.services.cloudfront.model.GetCloudFrontOriginAccessIdentityResult;
import com.amazonaws.services.cloudfront.model.GetDistributionConfigRequest;
import com.amazonaws.services.cloudfront.model.GetDistributionConfigResult;
import com.amazonaws.services.cloudfront.model.GetDistributionRequest;
import com.amazonaws.services.cloudfront.model.GetDistributionResult;
import com.amazonaws.services.cloudfront.model.GetInvalidationRequest;
import com.amazonaws.services.cloudfront.model.GetInvalidationResult;
import com.amazonaws.services.cloudfront.model.GetStreamingDistributionConfigRequest;
import com.amazonaws.services.cloudfront.model.GetStreamingDistributionConfigResult;
import com.amazonaws.services.cloudfront.model.GetStreamingDistributionRequest;
import com.amazonaws.services.cloudfront.model.GetStreamingDistributionResult;
import com.amazonaws.services.cloudfront.model.IllegalUpdateException;
import com.amazonaws.services.cloudfront.model.InconsistentQuantitiesException;
import com.amazonaws.services.cloudfront.model.InvalidArgumentException;
import com.amazonaws.services.cloudfront.model.InvalidDefaultRootObjectException;
import com.amazonaws.services.cloudfront.model.InvalidErrorCodeException;
import com.amazonaws.services.cloudfront.model.InvalidForwardCookiesException;
import com.amazonaws.services.cloudfront.model.InvalidGeoRestrictionParameterException;
import com.amazonaws.services.cloudfront.model.InvalidHeadersForS3OriginException;
import com.amazonaws.services.cloudfront.model.InvalidIfMatchVersionException;
import com.amazonaws.services.cloudfront.model.InvalidLocationCodeException;
import com.amazonaws.services.cloudfront.model.InvalidMinimumProtocolVersionException;
import com.amazonaws.services.cloudfront.model.InvalidOriginAccessIdentityException;
import com.amazonaws.services.cloudfront.model.InvalidOriginException;
import com.amazonaws.services.cloudfront.model.InvalidProtocolSettingsException;
import com.amazonaws.services.cloudfront.model.InvalidRelativePathException;
import com.amazonaws.services.cloudfront.model.InvalidRequiredProtocolException;
import com.amazonaws.services.cloudfront.model.InvalidResponseCodeException;
import com.amazonaws.services.cloudfront.model.InvalidTTLOrderException;
import com.amazonaws.services.cloudfront.model.InvalidViewerCertificateException;
import com.amazonaws.services.cloudfront.model.InvalidWebACLIdException;
import com.amazonaws.services.cloudfront.model.ListCloudFrontOriginAccessIdentitiesRequest;
import com.amazonaws.services.cloudfront.model.ListCloudFrontOriginAccessIdentitiesResult;
import com.amazonaws.services.cloudfront.model.ListDistributionsByWebACLIdRequest;
import com.amazonaws.services.cloudfront.model.ListDistributionsByWebACLIdResult;
import com.amazonaws.services.cloudfront.model.ListDistributionsRequest;
import com.amazonaws.services.cloudfront.model.ListDistributionsResult;
import com.amazonaws.services.cloudfront.model.ListInvalidationsRequest;
import com.amazonaws.services.cloudfront.model.ListInvalidationsResult;
import com.amazonaws.services.cloudfront.model.ListStreamingDistributionsRequest;
import com.amazonaws.services.cloudfront.model.ListStreamingDistributionsResult;
import com.amazonaws.services.cloudfront.model.MissingBodyException;
import com.amazonaws.services.cloudfront.model.NoSuchCloudFrontOriginAccessIdentityException;
import com.amazonaws.services.cloudfront.model.NoSuchDistributionException;
import com.amazonaws.services.cloudfront.model.NoSuchInvalidationException;
import com.amazonaws.services.cloudfront.model.NoSuchOriginException;
import com.amazonaws.services.cloudfront.model.NoSuchStreamingDistributionException;
import com.amazonaws.services.cloudfront.model.PreconditionFailedException;
import com.amazonaws.services.cloudfront.model.QuotaRequest;
import com.amazonaws.services.cloudfront.model.QuotaResult;
import com.amazonaws.services.cloudfront.model.StreamingDistributionAlreadyExistsException;
import com.amazonaws.services.cloudfront.model.StreamingDistributionNotDisabledException;
import com.amazonaws.services.cloudfront.model.TooManyCacheBehaviorsException;
import com.amazonaws.services.cloudfront.model.TooManyCertificatesException;
import com.amazonaws.services.cloudfront.model.TooManyCloudFrontOriginAccessIdentitiesException;
import com.amazonaws.services.cloudfront.model.TooManyCookieNamesInWhiteListException;
import com.amazonaws.services.cloudfront.model.TooManyDistributionCNAMEsException;
import com.amazonaws.services.cloudfront.model.TooManyDistributionsException;
import com.amazonaws.services.cloudfront.model.TooManyHeadersInForwardedValuesException;
import com.amazonaws.services.cloudfront.model.TooManyInvalidationsInProgressException;
import com.amazonaws.services.cloudfront.model.TooManyOriginsException;
import com.amazonaws.services.cloudfront.model.TooManyStreamingDistributionCNAMEsException;
import com.amazonaws.services.cloudfront.model.TooManyStreamingDistributionsException;
import com.amazonaws.services.cloudfront.model.TooManyTrustedSignersException;
import com.amazonaws.services.cloudfront.model.TrustedSignerDoesNotExistException;
import com.amazonaws.services.cloudfront.model.UpdateCloudFrontOriginAccessIdentityRequest;
import com.amazonaws.services.cloudfront.model.UpdateCloudFrontOriginAccessIdentityResult;
import com.amazonaws.services.cloudfront.model.UpdateDistributionRequest;
import com.amazonaws.services.cloudfront.model.UpdateDistributionResult;
import com.amazonaws.services.cloudfront.model.UpdateStreamingDistributionRequest;
import com.amazonaws.services.cloudfront.model.UpdateStreamingDistributionResult;
import com.amazonaws.services.cloudfront.model.transform.AccessDeniedExceptionUnmarshaller;
import com.amazonaws.services.cloudfront.model.transform.BatchTooLargeExceptionUnmarshaller;
import com.amazonaws.services.cloudfront.model.transform.CNAMEAlreadyExistsExceptionUnmarshaller;
import com.amazonaws.services.cloudfront.model.transform.CalculateBandwidthRequestMarshaller;
import com.amazonaws.services.cloudfront.model.transform.CalculateBandwidthResultStaxUnmarshaller;
import com.amazonaws.services.cloudfront.model.transform.CloudFrontOriginAccessIdentityAlreadyExistsExceptionUnmarshaller;
import com.amazonaws.services.cloudfront.model.transform.CloudFrontOriginAccessIdentityInUseExceptionUnmarshaller;
import com.amazonaws.services.cloudfront.model.transform.CreateCloudFrontOriginAccessIdentityRequestMarshaller;
import com.amazonaws.services.cloudfront.model.transform.CreateCloudFrontOriginAccessIdentityResultStaxUnmarshaller;
import com.amazonaws.services.cloudfront.model.transform.CreateDistributionRequestMarshaller;
import com.amazonaws.services.cloudfront.model.transform.CreateDistributionResultStaxUnmarshaller;
import com.amazonaws.services.cloudfront.model.transform.CreateInvalidationRequestMarshaller;
import com.amazonaws.services.cloudfront.model.transform.CreateInvalidationResultStaxUnmarshaller;
import com.amazonaws.services.cloudfront.model.transform.CreatePreloadRequestMarshaller;
import com.amazonaws.services.cloudfront.model.transform.CreatePreloadResultStaxUnmarshaller;
import com.amazonaws.services.cloudfront.model.transform.CreateStreamingDistributionRequestMarshaller;
import com.amazonaws.services.cloudfront.model.transform.CreateStreamingDistributionResultStaxUnmarshaller;
import com.amazonaws.services.cloudfront.model.transform.DeleteCloudFrontOriginAccessIdentityRequestMarshaller;
import com.amazonaws.services.cloudfront.model.transform.DeleteDistributionRequestMarshaller;
import com.amazonaws.services.cloudfront.model.transform.DeleteStreamingDistributionRequestMarshaller;
import com.amazonaws.services.cloudfront.model.transform.DistributionAlreadyExistsExceptionUnmarshaller;
import com.amazonaws.services.cloudfront.model.transform.DistributionNotDisabledExceptionUnmarshaller;
import com.amazonaws.services.cloudfront.model.transform.GetCloudFrontOriginAccessIdentityConfigRequestMarshaller;
import com.amazonaws.services.cloudfront.model.transform.GetCloudFrontOriginAccessIdentityConfigResultStaxUnmarshaller;
import com.amazonaws.services.cloudfront.model.transform.GetCloudFrontOriginAccessIdentityRequestMarshaller;
import com.amazonaws.services.cloudfront.model.transform.GetCloudFrontOriginAccessIdentityResultStaxUnmarshaller;
import com.amazonaws.services.cloudfront.model.transform.GetDistributionConfigRequestMarshaller;
import com.amazonaws.services.cloudfront.model.transform.GetDistributionConfigResultStaxUnmarshaller;
import com.amazonaws.services.cloudfront.model.transform.GetDistributionRequestMarshaller;
import com.amazonaws.services.cloudfront.model.transform.GetDistributionResultStaxUnmarshaller;
import com.amazonaws.services.cloudfront.model.transform.GetInvalidationRequestMarshaller;
import com.amazonaws.services.cloudfront.model.transform.GetInvalidationResultStaxUnmarshaller;
import com.amazonaws.services.cloudfront.model.transform.GetStreamingDistributionConfigRequestMarshaller;
import com.amazonaws.services.cloudfront.model.transform.GetStreamingDistributionConfigResultStaxUnmarshaller;
import com.amazonaws.services.cloudfront.model.transform.GetStreamingDistributionRequestMarshaller;
import com.amazonaws.services.cloudfront.model.transform.GetStreamingDistributionResultStaxUnmarshaller;
import com.amazonaws.services.cloudfront.model.transform.IllegalUpdateExceptionUnmarshaller;
import com.amazonaws.services.cloudfront.model.transform.InconsistentQuantitiesExceptionUnmarshaller;
import com.amazonaws.services.cloudfront.model.transform.InvalidArgumentExceptionUnmarshaller;
import com.amazonaws.services.cloudfront.model.transform.InvalidDefaultRootObjectExceptionUnmarshaller;
import com.amazonaws.services.cloudfront.model.transform.InvalidErrorCodeExceptionUnmarshaller;
import com.amazonaws.services.cloudfront.model.transform.InvalidForwardCookiesExceptionUnmarshaller;
import com.amazonaws.services.cloudfront.model.transform.InvalidGeoRestrictionParameterExceptionUnmarshaller;
import com.amazonaws.services.cloudfront.model.transform.InvalidHeadersForS3OriginExceptionUnmarshaller;
import com.amazonaws.services.cloudfront.model.transform.InvalidIfMatchVersionExceptionUnmarshaller;
import com.amazonaws.services.cloudfront.model.transform.InvalidLocationCodeExceptionUnmarshaller;
import com.amazonaws.services.cloudfront.model.transform.InvalidMinimumProtocolVersionExceptionUnmarshaller;
import com.amazonaws.services.cloudfront.model.transform.InvalidOriginAccessIdentityExceptionUnmarshaller;
import com.amazonaws.services.cloudfront.model.transform.InvalidOriginExceptionUnmarshaller;
import com.amazonaws.services.cloudfront.model.transform.InvalidProtocolSettingsExceptionUnmarshaller;
import com.amazonaws.services.cloudfront.model.transform.InvalidRelativePathExceptionUnmarshaller;
import com.amazonaws.services.cloudfront.model.transform.InvalidRequiredProtocolExceptionUnmarshaller;
import com.amazonaws.services.cloudfront.model.transform.InvalidResponseCodeExceptionUnmarshaller;
import com.amazonaws.services.cloudfront.model.transform.InvalidTTLOrderExceptionUnmarshaller;
import com.amazonaws.services.cloudfront.model.transform.InvalidViewerCertificateExceptionUnmarshaller;
import com.amazonaws.services.cloudfront.model.transform.InvalidWebACLIdExceptionUnmarshaller;
import com.amazonaws.services.cloudfront.model.transform.ListCloudFrontOriginAccessIdentitiesRequestMarshaller;
import com.amazonaws.services.cloudfront.model.transform.ListCloudFrontOriginAccessIdentitiesResultStaxUnmarshaller;
import com.amazonaws.services.cloudfront.model.transform.ListDistributionsByWebACLIdRequestMarshaller;
import com.amazonaws.services.cloudfront.model.transform.ListDistributionsByWebACLIdResultStaxUnmarshaller;
import com.amazonaws.services.cloudfront.model.transform.ListDistributionsRequestMarshaller;
import com.amazonaws.services.cloudfront.model.transform.ListDistributionsResultStaxUnmarshaller;
import com.amazonaws.services.cloudfront.model.transform.ListInvalidationsRequestMarshaller;
import com.amazonaws.services.cloudfront.model.transform.ListInvalidationsResultStaxUnmarshaller;
import com.amazonaws.services.cloudfront.model.transform.ListStreamingDistributionsRequestMarshaller;
import com.amazonaws.services.cloudfront.model.transform.ListStreamingDistributionsResultStaxUnmarshaller;
import com.amazonaws.services.cloudfront.model.transform.MissingBodyExceptionUnmarshaller;
import com.amazonaws.services.cloudfront.model.transform.NoSuchCloudFrontOriginAccessIdentityExceptionUnmarshaller;
import com.amazonaws.services.cloudfront.model.transform.NoSuchDistributionExceptionUnmarshaller;
import com.amazonaws.services.cloudfront.model.transform.NoSuchInvalidationExceptionUnmarshaller;
import com.amazonaws.services.cloudfront.model.transform.NoSuchOriginExceptionUnmarshaller;
import com.amazonaws.services.cloudfront.model.transform.NoSuchStreamingDistributionExceptionUnmarshaller;
import com.amazonaws.services.cloudfront.model.transform.PreconditionFailedExceptionUnmarshaller;
import com.amazonaws.services.cloudfront.model.transform.QuotaConfigRequestMarshaller;
import com.amazonaws.services.cloudfront.model.transform.QuotaResultStaxUnmarshaller;
import com.amazonaws.services.cloudfront.model.transform.QuotaUsageRequestMarshaller;
import com.amazonaws.services.cloudfront.model.transform.StreamingDistributionAlreadyExistsExceptionUnmarshaller;
import com.amazonaws.services.cloudfront.model.transform.StreamingDistributionNotDisabledExceptionUnmarshaller;
import com.amazonaws.services.cloudfront.model.transform.TooManyCacheBehaviorsExceptionUnmarshaller;
import com.amazonaws.services.cloudfront.model.transform.TooManyCertificatesExceptionUnmarshaller;
import com.amazonaws.services.cloudfront.model.transform.TooManyCloudFrontOriginAccessIdentitiesExceptionUnmarshaller;
import com.amazonaws.services.cloudfront.model.transform.TooManyCookieNamesInWhiteListExceptionUnmarshaller;
import com.amazonaws.services.cloudfront.model.transform.TooManyDistributionCNAMEsExceptionUnmarshaller;
import com.amazonaws.services.cloudfront.model.transform.TooManyDistributionsExceptionUnmarshaller;
import com.amazonaws.services.cloudfront.model.transform.TooManyHeadersInForwardedValuesExceptionUnmarshaller;
import com.amazonaws.services.cloudfront.model.transform.TooManyInvalidationsInProgressExceptionUnmarshaller;
import com.amazonaws.services.cloudfront.model.transform.TooManyOriginsExceptionUnmarshaller;
import com.amazonaws.services.cloudfront.model.transform.TooManyStreamingDistributionCNAMEsExceptionUnmarshaller;
import com.amazonaws.services.cloudfront.model.transform.TooManyStreamingDistributionsExceptionUnmarshaller;
import com.amazonaws.services.cloudfront.model.transform.TooManyTrustedSignersExceptionUnmarshaller;
import com.amazonaws.services.cloudfront.model.transform.TrustedSignerDoesNotExistExceptionUnmarshaller;
import com.amazonaws.services.cloudfront.model.transform.UpdateCloudFrontOriginAccessIdentityRequestMarshaller;
import com.amazonaws.services.cloudfront.model.transform.UpdateCloudFrontOriginAccessIdentityResultStaxUnmarshaller;
import com.amazonaws.services.cloudfront.model.transform.UpdateDistributionRequestMarshaller;
import com.amazonaws.services.cloudfront.model.transform.UpdateDistributionResultStaxUnmarshaller;
import com.amazonaws.services.cloudfront.model.transform.UpdateStreamingDistributionRequestMarshaller;
import com.amazonaws.services.cloudfront.model.transform.UpdateStreamingDistributionResultStaxUnmarshaller;
import com.amazonaws.transform.StandardErrorUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.AWSRequestMetrics;
import com.amazonaws.util.AWSRequestMetrics.Field;

/**
 * Client for accessing AmazonCloudFront.  All service calls made
 * using this client are blocking, and will not return until the service call
 * completes.
 * <p>
 * 
 */
public class AmazonCloudFrontClient extends AmazonWebServiceClient implements AmazonCloudFront {

    /** Provider for AWS credentials. */
    private AWSCredentialsProvider awsCredentialsProvider;

    /**
     * List of exception unmarshallers for all AmazonCloudFront exceptions.
     */
    protected final List<Unmarshaller<AmazonServiceException, Node>> exceptionUnmarshallers
            = new ArrayList<Unmarshaller<AmazonServiceException, Node>>();

    /**
     * Constructs a new client to invoke service methods on
     * AmazonCloudFront.  A credentials provider chain will be used
     * that searches for credentials in this order:
     * <ul>
     *  <li> Environment Variables - AWS_ACCESS_KEY_ID and AWS_SECRET_KEY </li>
     *  <li> Java System Properties - aws.accessKeyId and aws.secretKey </li>
     *  <li> Instance profile credentials delivered through the Amazon EC2 metadata service </li>
     * </ul>
     *
     * <p>
     * All service calls made using this new client object are blocking, and will not
     * return until the service call completes.
     *
     * @see DefaultAWSCredentialsProviderChain
     */
    public AmazonCloudFrontClient() {
        this(new DefaultAWSCredentialsProviderChain(), new ClientConfiguration());
    }

    /**
     * Constructs a new client to invoke service methods on
     * AmazonCloudFront.  A credentials provider chain will be used
     * that searches for credentials in this order:
     * <ul>
     *  <li> Environment Variables - AWS_ACCESS_KEY_ID and AWS_SECRET_KEY </li>
     *  <li> Java System Properties - aws.accessKeyId and aws.secretKey </li>
     *  <li> Instance profile credentials delivered through the Amazon EC2 metadata service </li>
     * </ul>
     *
     * <p>
     * All service calls made using this new client object are blocking, and will not
     * return until the service call completes.
     *
     * @param clientConfiguration The client configuration options controlling how this
     *                       client connects to AmazonCloudFront
     *                       (ex: proxy settings, retry counts, etc.).
     *
     * @see DefaultAWSCredentialsProviderChain
     */
    public AmazonCloudFrontClient(ClientConfiguration clientConfiguration) {
        this(new DefaultAWSCredentialsProviderChain(), clientConfiguration);
    }

    /**
     * Constructs a new client to invoke service methods on
     * AmazonCloudFront using the specified AWS account credentials.
     *
     * <p>
     * All service calls made using this new client object are blocking, and will not
     * return until the service call completes.
     *
     * @param awsCredentials The AWS credentials (access key ID and secret key) to use
     *                       when authenticating with AWS services.
     */
    public AmazonCloudFrontClient(AWSCredentials awsCredentials) {
        this(awsCredentials, new ClientConfiguration());
    }

    /**
     * Constructs a new client to invoke service methods on
     * AmazonCloudFront using the specified AWS account credentials
     * and client configuration options.
     *
     * <p>
     * All service calls made using this new client object are blocking, and will not
     * return until the service call completes.
     *
     * @param awsCredentials The AWS credentials (access key ID and secret key) to use
     *                       when authenticating with AWS services.
     * @param clientConfiguration The client configuration options controlling how this
     *                       client connects to AmazonCloudFront
     *                       (ex: proxy settings, retry counts, etc.).
     */
    public AmazonCloudFrontClient(AWSCredentials awsCredentials, ClientConfiguration clientConfiguration) {
        super(clientConfiguration);
        this.awsCredentialsProvider = new StaticCredentialsProvider(awsCredentials);
        init();
    }

    /**
     * Constructs a new client to invoke service methods on
     * AmazonCloudFront using the specified AWS account credentials provider.
     *
     * <p>
     * All service calls made using this new client object are blocking, and will not
     * return until the service call completes.
     *
     * @param awsCredentialsProvider
     *            The AWS credentials provider which will provide credentials
     *            to authenticate requests with AWS services.
     */
    public AmazonCloudFrontClient(AWSCredentialsProvider awsCredentialsProvider) {
        this(awsCredentialsProvider, new ClientConfiguration());
    }

    /**
     * Constructs a new client to invoke service methods on
     * AmazonCloudFront using the specified AWS account credentials
     * provider and client configuration options.
     *
     * <p>
     * All service calls made using this new client object are blocking, and will not
     * return until the service call completes.
     *
     * @param awsCredentialsProvider
     *            The AWS credentials provider which will provide credentials
     *            to authenticate requests with AWS services.
     * @param clientConfiguration The client configuration options controlling how this
     *                       client connects to AmazonCloudFront
     *                       (ex: proxy settings, retry counts, etc.).
     */
    public AmazonCloudFrontClient(AWSCredentialsProvider awsCredentialsProvider, ClientConfiguration clientConfiguration) {
        this(awsCredentialsProvider, clientConfiguration, null);
    }

    /**
     * Constructs a new client to invoke service methods on
     * AmazonCloudFront using the specified AWS account credentials
     * provider, client configuration options, and request metric collector.
     *
     * <p>
     * All service calls made using this new client object are blocking, and will not
     * return until the service call completes.
     *
     * @param awsCredentialsProvider
     *            The AWS credentials provider which will provide credentials
     *            to authenticate requests with AWS services.
     * @param clientConfiguration The client configuration options controlling how this
     *                       client connects to AmazonCloudFront
     *                       (ex: proxy settings, retry counts, etc.).
     * @param requestMetricCollector optional request metric collector
     */
    public AmazonCloudFrontClient(AWSCredentialsProvider awsCredentialsProvider,
            ClientConfiguration clientConfiguration,
            RequestMetricCollector requestMetricCollector) {
        super(clientConfiguration, requestMetricCollector);
        this.awsCredentialsProvider = awsCredentialsProvider;
        init();
    }

    private void init() {
        exceptionUnmarshallers.add(new TooManyCookieNamesInWhiteListExceptionUnmarshaller());
        exceptionUnmarshallers.add(new TooManyHeadersInForwardedValuesExceptionUnmarshaller());
        exceptionUnmarshallers.add(new InvalidLocationCodeExceptionUnmarshaller());
        exceptionUnmarshallers.add(new TooManyDistributionsExceptionUnmarshaller());
        exceptionUnmarshallers.add(new PreconditionFailedExceptionUnmarshaller());
        exceptionUnmarshallers.add(new CNAMEAlreadyExistsExceptionUnmarshaller());
        exceptionUnmarshallers.add(new CloudFrontOriginAccessIdentityInUseExceptionUnmarshaller());
        exceptionUnmarshallers.add(new InvalidViewerCertificateExceptionUnmarshaller());
        exceptionUnmarshallers.add(new InvalidHeadersForS3OriginExceptionUnmarshaller());
        exceptionUnmarshallers.add(new TrustedSignerDoesNotExistExceptionUnmarshaller());
        exceptionUnmarshallers.add(new DistributionNotDisabledExceptionUnmarshaller());
        exceptionUnmarshallers.add(new InvalidTTLOrderExceptionUnmarshaller());
        exceptionUnmarshallers.add(new BatchTooLargeExceptionUnmarshaller());
        exceptionUnmarshallers.add(new StreamingDistributionNotDisabledExceptionUnmarshaller());
        exceptionUnmarshallers.add(new InvalidArgumentExceptionUnmarshaller());
        exceptionUnmarshallers.add(new TooManyStreamingDistributionsExceptionUnmarshaller());
        exceptionUnmarshallers.add(new TooManyTrustedSignersExceptionUnmarshaller());
        exceptionUnmarshallers.add(new InvalidWebACLIdExceptionUnmarshaller());
        exceptionUnmarshallers.add(new TooManyOriginsExceptionUnmarshaller());
        exceptionUnmarshallers.add(new InvalidRequiredProtocolExceptionUnmarshaller());
        exceptionUnmarshallers.add(new IllegalUpdateExceptionUnmarshaller());
        exceptionUnmarshallers.add(new InvalidMinimumProtocolVersionExceptionUnmarshaller());
        exceptionUnmarshallers.add(new InvalidErrorCodeExceptionUnmarshaller());
        exceptionUnmarshallers.add(new TooManyCloudFrontOriginAccessIdentitiesExceptionUnmarshaller());
        exceptionUnmarshallers.add(new NoSuchOriginExceptionUnmarshaller());
        exceptionUnmarshallers.add(new TooManyCacheBehaviorsExceptionUnmarshaller());
        exceptionUnmarshallers.add(new NoSuchDistributionExceptionUnmarshaller());
        exceptionUnmarshallers.add(new DistributionAlreadyExistsExceptionUnmarshaller());
        exceptionUnmarshallers.add(new CloudFrontOriginAccessIdentityAlreadyExistsExceptionUnmarshaller());
        exceptionUnmarshallers.add(new TooManyInvalidationsInProgressExceptionUnmarshaller());
        exceptionUnmarshallers.add(new InvalidDefaultRootObjectExceptionUnmarshaller());
        exceptionUnmarshallers.add(new InvalidIfMatchVersionExceptionUnmarshaller());
        exceptionUnmarshallers.add(new TooManyCertificatesExceptionUnmarshaller());
        exceptionUnmarshallers.add(new InvalidOriginExceptionUnmarshaller());
        exceptionUnmarshallers.add(new InvalidRelativePathExceptionUnmarshaller());
        exceptionUnmarshallers.add(new NoSuchInvalidationExceptionUnmarshaller());
        exceptionUnmarshallers.add(new StreamingDistributionAlreadyExistsExceptionUnmarshaller());
        exceptionUnmarshallers.add(new AccessDeniedExceptionUnmarshaller());
        exceptionUnmarshallers.add(new InvalidGeoRestrictionParameterExceptionUnmarshaller());
        exceptionUnmarshallers.add(new InvalidResponseCodeExceptionUnmarshaller());
        exceptionUnmarshallers.add(new MissingBodyExceptionUnmarshaller());
        exceptionUnmarshallers.add(new TooManyDistributionCNAMEsExceptionUnmarshaller());
        exceptionUnmarshallers.add(new NoSuchCloudFrontOriginAccessIdentityExceptionUnmarshaller());
        exceptionUnmarshallers.add(new InconsistentQuantitiesExceptionUnmarshaller());
        exceptionUnmarshallers.add(new InvalidOriginAccessIdentityExceptionUnmarshaller());
        exceptionUnmarshallers.add(new NoSuchStreamingDistributionExceptionUnmarshaller());
        exceptionUnmarshallers.add(new InvalidProtocolSettingsExceptionUnmarshaller());
        exceptionUnmarshallers.add(new InvalidForwardCookiesExceptionUnmarshaller());
        exceptionUnmarshallers.add(new TooManyStreamingDistributionCNAMEsExceptionUnmarshaller());
        
        exceptionUnmarshallers.add(new StandardErrorUnmarshaller());
        
        // calling this.setEndPoint(...) will also modify the signer accordingly
        this.setEndpoint("cloudfront.amazonaws.com/");
        
        HandlerChainFactory chainFactory = new HandlerChainFactory();
        requestHandler2s.addAll(chainFactory.newRequestHandlerChain(
                "/com/amazonaws/services/cloudfront/request.handlers"));
        requestHandler2s.addAll(chainFactory.newRequestHandler2Chain(
                "/com/amazonaws/services/cloudfront/request.handler2s"));
    }

    /**
     * <p>
     * Delete an origin access identity.
     * </p>
     *
     * @param deleteCloudFrontOriginAccessIdentityRequest Container for the
     *           necessary parameters to execute the
     *           DeleteCloudFrontOriginAccessIdentity service method on
     *           AmazonCloudFront.
     * 
     * 
     * @throws InvalidIfMatchVersionException
     * @throws CloudFrontOriginAccessIdentityInUseException
     * @throws NoSuchCloudFrontOriginAccessIdentityException
     * @throws PreconditionFailedException
     * @throws AccessDeniedException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonCloudFront indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public void deleteCloudFrontOriginAccessIdentity(DeleteCloudFrontOriginAccessIdentityRequest deleteCloudFrontOriginAccessIdentityRequest) {
        ExecutionContext executionContext = createExecutionContext(deleteCloudFrontOriginAccessIdentityRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<DeleteCloudFrontOriginAccessIdentityRequest> request = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DeleteCloudFrontOriginAccessIdentityRequestMarshaller().marshall(super.beforeMarshalling(deleteCloudFrontOriginAccessIdentityRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            invoke(request, null, executionContext);

        } finally {
            
            endClientExecution(awsRequestMetrics, request, null);
        }
    }
    
    /**
     * <p>
     * Delete a distribution.
     * </p>
     *
     * @param deleteDistributionRequest Container for the necessary
     *           parameters to execute the DeleteDistribution service method on
     *           AmazonCloudFront.
     * 
     * 
     * @throws InvalidIfMatchVersionException
     * @throws NoSuchDistributionException
     * @throws DistributionNotDisabledException
     * @throws PreconditionFailedException
     * @throws AccessDeniedException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonCloudFront indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public void deleteDistribution(DeleteDistributionRequest deleteDistributionRequest) {
        ExecutionContext executionContext = createExecutionContext(deleteDistributionRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<DeleteDistributionRequest> request = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DeleteDistributionRequestMarshaller().marshall(super.beforeMarshalling(deleteDistributionRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            invoke(request, null, executionContext);

        } finally {
            
            endClientExecution(awsRequestMetrics, request, null);
        }
    }
    
    /**
     * <p>
     * List distributions.
     * </p>
     *
     * @param listDistributionsRequest Container for the necessary parameters
     *           to execute the ListDistributions service method on AmazonCloudFront.
     * 
     * @return The response from the ListDistributions service method, as
     *         returned by AmazonCloudFront.
     * 
     * @throws InvalidArgumentException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonCloudFront indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public ListDistributionsResult listDistributions(ListDistributionsRequest listDistributionsRequest) {
        ExecutionContext executionContext = createExecutionContext(listDistributionsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ListDistributionsRequest> request = null;
        Response<ListDistributionsResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ListDistributionsRequestMarshaller().marshall(super.beforeMarshalling(listDistributionsRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            response = invoke(request, new ListDistributionsResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();

        } finally {
            
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * Create a new streaming distribution.
     * </p>
     *
     * @param createStreamingDistributionRequest Container for the necessary
     *           parameters to execute the CreateStreamingDistribution service method
     *           on AmazonCloudFront.
     * 
     * @return The response from the CreateStreamingDistribution service
     *         method, as returned by AmazonCloudFront.
     * 
     * @throws TooManyTrustedSignersException
     * @throws MissingBodyException
     * @throws TooManyStreamingDistributionCNAMEsException
     * @throws StreamingDistributionAlreadyExistsException
     * @throws CNAMEAlreadyExistsException
     * @throws AccessDeniedException
     * @throws TooManyStreamingDistributionsException
     * @throws InvalidArgumentException
     * @throws InconsistentQuantitiesException
     * @throws InvalidOriginAccessIdentityException
     * @throws TrustedSignerDoesNotExistException
     * @throws InvalidOriginException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonCloudFront indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public CreateStreamingDistributionResult createStreamingDistribution(CreateStreamingDistributionRequest createStreamingDistributionRequest) {
        ExecutionContext executionContext = createExecutionContext(createStreamingDistributionRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<CreateStreamingDistributionRequest> request = null;
        Response<CreateStreamingDistributionResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new CreateStreamingDistributionRequestMarshaller().marshall(super.beforeMarshalling(createStreamingDistributionRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            response = invoke(request, new CreateStreamingDistributionResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();

        } finally {
            
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * Create a new distribution.
     * </p>
     *
     * @param createDistributionRequest Container for the necessary
     *           parameters to execute the CreateDistribution service method on
     *           AmazonCloudFront.
     * 
     * @return The response from the CreateDistribution service method, as
     *         returned by AmazonCloudFront.
     * 
     * @throws TooManyCookieNamesInWhiteListException
     * @throws InvalidGeoRestrictionParameterException
     * @throws InvalidResponseCodeException
     * @throws TooManyHeadersInForwardedValuesException
     * @throws MissingBodyException
     * @throws TooManyDistributionCNAMEsException
     * @throws InvalidLocationCodeException
     * @throws TooManyDistributionsException
     * @throws NoSuchOriginException
     * @throws InvalidArgumentException
     * @throws CNAMEAlreadyExistsException
     * @throws InconsistentQuantitiesException
     * @throws InvalidOriginAccessIdentityException
     * @throws TooManyCacheBehaviorsException
     * @throws TooManyTrustedSignersException
     * @throws InvalidWebACLIdException
     * @throws InvalidViewerCertificateException
     * @throws TooManyOriginsException
     * @throws DistributionAlreadyExistsException
     * @throws InvalidRequiredProtocolException
     * @throws InvalidDefaultRootObjectException
     * @throws InvalidProtocolSettingsException
     * @throws InvalidForwardCookiesException
     * @throws InvalidHeadersForS3OriginException
     * @throws TrustedSignerDoesNotExistException
     * @throws InvalidOriginException
     * @throws TooManyCertificatesException
     * @throws InvalidRelativePathException
     * @throws InvalidMinimumProtocolVersionException
     * @throws InvalidErrorCodeException
     * @throws AccessDeniedException
     * @throws InvalidTTLOrderException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonCloudFront indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public CreateDistributionResult createDistribution(CreateDistributionRequest createDistributionRequest) {
        ExecutionContext executionContext = createExecutionContext(createDistributionRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<CreateDistributionRequest> request = null;
        Response<CreateDistributionResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new CreateDistributionRequestMarshaller().marshall(super.beforeMarshalling(createDistributionRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            response = invoke(request, new CreateDistributionResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();

        } finally {
            
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * Update an origin access identity.
     * </p>
     *
     * @param updateCloudFrontOriginAccessIdentityRequest Container for the
     *           necessary parameters to execute the
     *           UpdateCloudFrontOriginAccessIdentity service method on
     *           AmazonCloudFront.
     * 
     * @return The response from the UpdateCloudFrontOriginAccessIdentity
     *         service method, as returned by AmazonCloudFront.
     * 
     * @throws InvalidIfMatchVersionException
     * @throws IllegalUpdateException
     * @throws MissingBodyException
     * @throws NoSuchCloudFrontOriginAccessIdentityException
     * @throws PreconditionFailedException
     * @throws AccessDeniedException
     * @throws InvalidArgumentException
     * @throws InconsistentQuantitiesException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonCloudFront indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public UpdateCloudFrontOriginAccessIdentityResult updateCloudFrontOriginAccessIdentity(UpdateCloudFrontOriginAccessIdentityRequest updateCloudFrontOriginAccessIdentityRequest) {
        ExecutionContext executionContext = createExecutionContext(updateCloudFrontOriginAccessIdentityRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<UpdateCloudFrontOriginAccessIdentityRequest> request = null;
        Response<UpdateCloudFrontOriginAccessIdentityResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new UpdateCloudFrontOriginAccessIdentityRequestMarshaller().marshall(super.beforeMarshalling(updateCloudFrontOriginAccessIdentityRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            response = invoke(request, new UpdateCloudFrontOriginAccessIdentityResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();

        } finally {
            
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * Get the information about a distribution.
     * </p>
     *
     * @param getDistributionRequest Container for the necessary parameters
     *           to execute the GetDistribution service method on AmazonCloudFront.
     * 
     * @return The response from the GetDistribution service method, as
     *         returned by AmazonCloudFront.
     * 
     * @throws NoSuchDistributionException
     * @throws AccessDeniedException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonCloudFront indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public GetDistributionResult getDistribution(GetDistributionRequest getDistributionRequest) {
        ExecutionContext executionContext = createExecutionContext(getDistributionRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<GetDistributionRequest> request = null;
        Response<GetDistributionResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new GetDistributionRequestMarshaller().marshall(super.beforeMarshalling(getDistributionRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            response = invoke(request, new GetDistributionResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();

        } finally {
            
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * Delete a streaming distribution.
     * </p>
     *
     * @param deleteStreamingDistributionRequest Container for the necessary
     *           parameters to execute the DeleteStreamingDistribution service method
     *           on AmazonCloudFront.
     * 
     * 
     * @throws InvalidIfMatchVersionException
     * @throws NoSuchStreamingDistributionException
     * @throws StreamingDistributionNotDisabledException
     * @throws PreconditionFailedException
     * @throws AccessDeniedException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonCloudFront indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public void deleteStreamingDistribution(DeleteStreamingDistributionRequest deleteStreamingDistributionRequest) {
        ExecutionContext executionContext = createExecutionContext(deleteStreamingDistributionRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<DeleteStreamingDistributionRequest> request = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DeleteStreamingDistributionRequestMarshaller().marshall(super.beforeMarshalling(deleteStreamingDistributionRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            invoke(request, null, executionContext);

        } finally {
            
            endClientExecution(awsRequestMetrics, request, null);
        }
    }
    
    /**
     * <p>
     * List origin access identities.
     * </p>
     *
     * @param listCloudFrontOriginAccessIdentitiesRequest Container for the
     *           necessary parameters to execute the
     *           ListCloudFrontOriginAccessIdentities service method on
     *           AmazonCloudFront.
     * 
     * @return The response from the ListCloudFrontOriginAccessIdentities
     *         service method, as returned by AmazonCloudFront.
     * 
     * @throws InvalidArgumentException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonCloudFront indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public ListCloudFrontOriginAccessIdentitiesResult listCloudFrontOriginAccessIdentities(ListCloudFrontOriginAccessIdentitiesRequest listCloudFrontOriginAccessIdentitiesRequest) {
        ExecutionContext executionContext = createExecutionContext(listCloudFrontOriginAccessIdentitiesRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ListCloudFrontOriginAccessIdentitiesRequest> request = null;
        Response<ListCloudFrontOriginAccessIdentitiesResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ListCloudFrontOriginAccessIdentitiesRequestMarshaller().marshall(super.beforeMarshalling(listCloudFrontOriginAccessIdentitiesRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            response = invoke(request, new ListCloudFrontOriginAccessIdentitiesResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();

        } finally {
            
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * Get the information about a streaming distribution.
     * </p>
     *
     * @param getStreamingDistributionRequest Container for the necessary
     *           parameters to execute the GetStreamingDistribution service method on
     *           AmazonCloudFront.
     * 
     * @return The response from the GetStreamingDistribution service method,
     *         as returned by AmazonCloudFront.
     * 
     * @throws NoSuchStreamingDistributionException
     * @throws AccessDeniedException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonCloudFront indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public GetStreamingDistributionResult getStreamingDistribution(GetStreamingDistributionRequest getStreamingDistributionRequest) {
        ExecutionContext executionContext = createExecutionContext(getStreamingDistributionRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<GetStreamingDistributionRequest> request = null;
        Response<GetStreamingDistributionResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new GetStreamingDistributionRequestMarshaller().marshall(super.beforeMarshalling(getStreamingDistributionRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            response = invoke(request, new GetStreamingDistributionResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();

        } finally {
            
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * List streaming distributions.
     * </p>
     *
     * @param listStreamingDistributionsRequest Container for the necessary
     *           parameters to execute the ListStreamingDistributions service method on
     *           AmazonCloudFront.
     * 
     * @return The response from the ListStreamingDistributions service
     *         method, as returned by AmazonCloudFront.
     * 
     * @throws InvalidArgumentException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonCloudFront indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public ListStreamingDistributionsResult listStreamingDistributions(ListStreamingDistributionsRequest listStreamingDistributionsRequest) {
        ExecutionContext executionContext = createExecutionContext(listStreamingDistributionsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ListStreamingDistributionsRequest> request = null;
        Response<ListStreamingDistributionsResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ListStreamingDistributionsRequestMarshaller().marshall(super.beforeMarshalling(listStreamingDistributionsRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            response = invoke(request, new ListStreamingDistributionsResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();

        } finally {
            
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * Update a distribution.
     * </p>
     *
     * @param updateDistributionRequest Container for the necessary
     *           parameters to execute the UpdateDistribution service method on
     *           AmazonCloudFront.
     * 
     * @return The response from the UpdateDistribution service method, as
     *         returned by AmazonCloudFront.
     * 
     * @throws TooManyCookieNamesInWhiteListException
     * @throws InvalidGeoRestrictionParameterException
     * @throws InvalidResponseCodeException
     * @throws MissingBodyException
     * @throws TooManyHeadersInForwardedValuesException
     * @throws TooManyDistributionCNAMEsException
     * @throws InvalidLocationCodeException
     * @throws NoSuchOriginException
     * @throws PreconditionFailedException
     * @throws InvalidArgumentException
     * @throws CNAMEAlreadyExistsException
     * @throws InconsistentQuantitiesException
     * @throws InvalidOriginAccessIdentityException
     * @throws TooManyCacheBehaviorsException
     * @throws TooManyTrustedSignersException
     * @throws NoSuchDistributionException
     * @throws InvalidWebACLIdException
     * @throws InvalidViewerCertificateException
     * @throws TooManyOriginsException
     * @throws InvalidRequiredProtocolException
     * @throws InvalidDefaultRootObjectException
     * @throws InvalidIfMatchVersionException
     * @throws IllegalUpdateException
     * @throws InvalidForwardCookiesException
     * @throws InvalidHeadersForS3OriginException
     * @throws TrustedSignerDoesNotExistException
     * @throws TooManyCertificatesException
     * @throws InvalidMinimumProtocolVersionException
     * @throws InvalidRelativePathException
     * @throws InvalidErrorCodeException
     * @throws AccessDeniedException
     * @throws InvalidTTLOrderException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonCloudFront indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public UpdateDistributionResult updateDistribution(UpdateDistributionRequest updateDistributionRequest) {
        ExecutionContext executionContext = createExecutionContext(updateDistributionRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<UpdateDistributionRequest> request = null;
        Response<UpdateDistributionResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new UpdateDistributionRequestMarshaller().marshall(super.beforeMarshalling(updateDistributionRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            response = invoke(request, new UpdateDistributionResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();

        } finally {
            
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * Get the configuration information about an origin access identity.
     * </p>
     *
     * @param getCloudFrontOriginAccessIdentityConfigRequest Container for
     *           the necessary parameters to execute the
     *           GetCloudFrontOriginAccessIdentityConfig service method on
     *           AmazonCloudFront.
     * 
     * @return The response from the GetCloudFrontOriginAccessIdentityConfig
     *         service method, as returned by AmazonCloudFront.
     * 
     * @throws NoSuchCloudFrontOriginAccessIdentityException
     * @throws AccessDeniedException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonCloudFront indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public GetCloudFrontOriginAccessIdentityConfigResult getCloudFrontOriginAccessIdentityConfig(GetCloudFrontOriginAccessIdentityConfigRequest getCloudFrontOriginAccessIdentityConfigRequest) {
        ExecutionContext executionContext = createExecutionContext(getCloudFrontOriginAccessIdentityConfigRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<GetCloudFrontOriginAccessIdentityConfigRequest> request = null;
        Response<GetCloudFrontOriginAccessIdentityConfigResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new GetCloudFrontOriginAccessIdentityConfigRequestMarshaller().marshall(super.beforeMarshalling(getCloudFrontOriginAccessIdentityConfigRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            response = invoke(request, new GetCloudFrontOriginAccessIdentityConfigResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();

        } finally {
            
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * Get the information about an origin access identity.
     * </p>
     *
     * @param getCloudFrontOriginAccessIdentityRequest Container for the
     *           necessary parameters to execute the GetCloudFrontOriginAccessIdentity
     *           service method on AmazonCloudFront.
     * 
     * @return The response from the GetCloudFrontOriginAccessIdentity
     *         service method, as returned by AmazonCloudFront.
     * 
     * @throws NoSuchCloudFrontOriginAccessIdentityException
     * @throws AccessDeniedException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonCloudFront indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public GetCloudFrontOriginAccessIdentityResult getCloudFrontOriginAccessIdentity(GetCloudFrontOriginAccessIdentityRequest getCloudFrontOriginAccessIdentityRequest) {
        ExecutionContext executionContext = createExecutionContext(getCloudFrontOriginAccessIdentityRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<GetCloudFrontOriginAccessIdentityRequest> request = null;
        Response<GetCloudFrontOriginAccessIdentityResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new GetCloudFrontOriginAccessIdentityRequestMarshaller().marshall(super.beforeMarshalling(getCloudFrontOriginAccessIdentityRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            response = invoke(request, new GetCloudFrontOriginAccessIdentityResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();

        } finally {
            
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * Get the information about an invalidation.
     * </p>
     *
     * @param getInvalidationRequest Container for the necessary parameters
     *           to execute the GetInvalidation service method on AmazonCloudFront.
     * 
     * @return The response from the GetInvalidation service method, as
     *         returned by AmazonCloudFront.
     * 
     * @throws NoSuchInvalidationException
     * @throws NoSuchDistributionException
     * @throws AccessDeniedException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonCloudFront indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public GetInvalidationResult getInvalidation(GetInvalidationRequest getInvalidationRequest) {
        ExecutionContext executionContext = createExecutionContext(getInvalidationRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<GetInvalidationRequest> request = null;
        Response<GetInvalidationResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new GetInvalidationRequestMarshaller().marshall(super.beforeMarshalling(getInvalidationRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            response = invoke(request, new GetInvalidationResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();

        } finally {
            
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * Create a new origin access identity.
     * </p>
     *
     * @param createCloudFrontOriginAccessIdentityRequest Container for the
     *           necessary parameters to execute the
     *           CreateCloudFrontOriginAccessIdentity service method on
     *           AmazonCloudFront.
     * 
     * @return The response from the CreateCloudFrontOriginAccessIdentity
     *         service method, as returned by AmazonCloudFront.
     * 
     * @throws TooManyCloudFrontOriginAccessIdentitiesException
     * @throws MissingBodyException
     * @throws InvalidArgumentException
     * @throws InconsistentQuantitiesException
     * @throws CloudFrontOriginAccessIdentityAlreadyExistsException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonCloudFront indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public CreateCloudFrontOriginAccessIdentityResult createCloudFrontOriginAccessIdentity(CreateCloudFrontOriginAccessIdentityRequest createCloudFrontOriginAccessIdentityRequest) {
        ExecutionContext executionContext = createExecutionContext(createCloudFrontOriginAccessIdentityRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<CreateCloudFrontOriginAccessIdentityRequest> request = null;
        Response<CreateCloudFrontOriginAccessIdentityResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new CreateCloudFrontOriginAccessIdentityRequestMarshaller().marshall(super.beforeMarshalling(createCloudFrontOriginAccessIdentityRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            response = invoke(request, new CreateCloudFrontOriginAccessIdentityResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();

        } finally {
            
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * List the distributions that are associated with a specified AWS WAF
     * web ACL.
     * </p>
     *
     * @param listDistributionsByWebACLIdRequest Container for the necessary
     *           parameters to execute the ListDistributionsByWebACLId service method
     *           on AmazonCloudFront.
     * 
     * @return The response from the ListDistributionsByWebACLId service
     *         method, as returned by AmazonCloudFront.
     * 
     * @throws InvalidWebACLIdException
     * @throws InvalidArgumentException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonCloudFront indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public ListDistributionsByWebACLIdResult listDistributionsByWebACLId(ListDistributionsByWebACLIdRequest listDistributionsByWebACLIdRequest) {
        ExecutionContext executionContext = createExecutionContext(listDistributionsByWebACLIdRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ListDistributionsByWebACLIdRequest> request = null;
        Response<ListDistributionsByWebACLIdResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ListDistributionsByWebACLIdRequestMarshaller().marshall(super.beforeMarshalling(listDistributionsByWebACLIdRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            response = invoke(request, new ListDistributionsByWebACLIdResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();

        } finally {
            
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * Get the configuration information about a distribution.
     * </p>
     *
     * @param getDistributionConfigRequest Container for the necessary
     *           parameters to execute the GetDistributionConfig service method on
     *           AmazonCloudFront.
     * 
     * @return The response from the GetDistributionConfig service method, as
     *         returned by AmazonCloudFront.
     * 
     * @throws NoSuchDistributionException
     * @throws AccessDeniedException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonCloudFront indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public GetDistributionConfigResult getDistributionConfig(GetDistributionConfigRequest getDistributionConfigRequest) {
        ExecutionContext executionContext = createExecutionContext(getDistributionConfigRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<GetDistributionConfigRequest> request = null;
        Response<GetDistributionConfigResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new GetDistributionConfigRequestMarshaller().marshall(super.beforeMarshalling(getDistributionConfigRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            response = invoke(request, new GetDistributionConfigResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();

        } finally {
            
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * Update a streaming distribution.
     * </p>
     *
     * @param updateStreamingDistributionRequest Container for the necessary
     *           parameters to execute the UpdateStreamingDistribution service method
     *           on AmazonCloudFront.
     * 
     * @return The response from the UpdateStreamingDistribution service
     *         method, as returned by AmazonCloudFront.
     * 
     * @throws InvalidIfMatchVersionException
     * @throws IllegalUpdateException
     * @throws MissingBodyException
     * @throws PreconditionFailedException
     * @throws InconsistentQuantitiesException
     * @throws CNAMEAlreadyExistsException
     * @throws InvalidArgumentException
     * @throws InvalidOriginAccessIdentityException
     * @throws TrustedSignerDoesNotExistException
     * @throws TooManyTrustedSignersException
     * @throws NoSuchStreamingDistributionException
     * @throws TooManyStreamingDistributionCNAMEsException
     * @throws AccessDeniedException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonCloudFront indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public UpdateStreamingDistributionResult updateStreamingDistribution(UpdateStreamingDistributionRequest updateStreamingDistributionRequest) {
        ExecutionContext executionContext = createExecutionContext(updateStreamingDistributionRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<UpdateStreamingDistributionRequest> request = null;
        Response<UpdateStreamingDistributionResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new UpdateStreamingDistributionRequestMarshaller().marshall(super.beforeMarshalling(updateStreamingDistributionRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            response = invoke(request, new UpdateStreamingDistributionResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();

        } finally {
            
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * Get the configuration information about a streaming distribution.
     * </p>
     *
     * @param getStreamingDistributionConfigRequest Container for the
     *           necessary parameters to execute the GetStreamingDistributionConfig
     *           service method on AmazonCloudFront.
     * 
     * @return The response from the GetStreamingDistributionConfig service
     *         method, as returned by AmazonCloudFront.
     * 
     * @throws NoSuchStreamingDistributionException
     * @throws AccessDeniedException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonCloudFront indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public GetStreamingDistributionConfigResult getStreamingDistributionConfig(GetStreamingDistributionConfigRequest getStreamingDistributionConfigRequest) {
        ExecutionContext executionContext = createExecutionContext(getStreamingDistributionConfigRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<GetStreamingDistributionConfigRequest> request = null;
        Response<GetStreamingDistributionConfigResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new GetStreamingDistributionConfigRequestMarshaller().marshall(super.beforeMarshalling(getStreamingDistributionConfigRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            response = invoke(request, new GetStreamingDistributionConfigResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();

        } finally {
            
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * List invalidation batches.
     * </p>
     *
     * @param listInvalidationsRequest Container for the necessary parameters
     *           to execute the ListInvalidations service method on AmazonCloudFront.
     * 
     * @return The response from the ListInvalidations service method, as
     *         returned by AmazonCloudFront.
     * 
     * @throws NoSuchDistributionException
     * @throws InvalidArgumentException
     * @throws AccessDeniedException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonCloudFront indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public ListInvalidationsResult listInvalidations(ListInvalidationsRequest listInvalidationsRequest) {
        ExecutionContext executionContext = createExecutionContext(listInvalidationsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ListInvalidationsRequest> request = null;
        Response<ListInvalidationsResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ListInvalidationsRequestMarshaller().marshall(super.beforeMarshalling(listInvalidationsRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            response = invoke(request, new ListInvalidationsResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();

        } finally {
            
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * Create a new invalidation.
     * </p>
     *
     * @param createInvalidationRequest Container for the necessary
     *           parameters to execute the CreateInvalidation service method on
     *           AmazonCloudFront.
     * 
     * @return The response from the CreateInvalidation service method, as
     *         returned by AmazonCloudFront.
     * 
     * @throws TooManyInvalidationsInProgressException
     * @throws MissingBodyException
     * @throws NoSuchDistributionException
     * @throws BatchTooLargeException
     * @throws AccessDeniedException
     * @throws InvalidArgumentException
     * @throws InconsistentQuantitiesException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonCloudFront indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public CreateInvalidationResult createInvalidation(CreateInvalidationRequest createInvalidationRequest) {
        ExecutionContext executionContext = createExecutionContext(createInvalidationRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<CreateInvalidationRequest> request = null;
        Response<CreateInvalidationResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new CreateInvalidationRequestMarshaller().marshall(super.beforeMarshalling(createInvalidationRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            response = invoke(request, new CreateInvalidationResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();

        } finally {
            
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * 预加载.
     * </p>
     *
     * @param createPreloadRequest 预加载的请求.
     * 
     * @return 预加载结果.
     * 
     * @throws TooManyInvalidationsInProgressException
     * @throws MissingBodyException
     * @throws NoSuchDistributionException
     * @throws BatchTooLargeException
     * @throws AccessDeniedException
     * @throws InvalidArgumentException
     * @throws InconsistentQuantitiesException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonCloudFront indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public CreatePreloadResult createPreload(CreatePreloadRequest createPreloadRequest) {
        ExecutionContext executionContext = createExecutionContext(createPreloadRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<CreatePreloadRequest> request = null;
        Response<CreatePreloadResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new CreatePreloadRequestMarshaller().marshall(super.beforeMarshalling(createPreloadRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            
            response = invoke(request, new CreatePreloadResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();
        } finally {
            
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * 查询限额的值
     * @param quotaRequest
     * @return
     */
    public QuotaResult getQuotaConfig() {
    	QuotaRequest quotaRequest = new QuotaRequest();
    	return getQuotaConfig(quotaRequest);
    }
    
    /**
     * 查询限额的值
     * @param quotaRequest
     * @return
     */
    public QuotaResult getQuotaConfig(QuotaRequest quotaRequest) {
    	ExecutionContext executionContext = createExecutionContext(quotaRequest);
    	AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    	awsRequestMetrics.startEvent(Field.ClientExecuteTime);
    	Request<QuotaRequest> request = null;
    	Response<QuotaResult> response = null;
    	
    	try {
    		awsRequestMetrics.startEvent(Field.RequestMarshallTime);
    		try {
    			request = new QuotaConfigRequestMarshaller().marshall(super.beforeMarshalling(quotaRequest));
    			// Binds the request metrics to the current request.
    			request.setAWSRequestMetrics(awsRequestMetrics);
    		} finally {
    			awsRequestMetrics.endEvent(Field.RequestMarshallTime);
    		}
    		
    		response = invoke(request, new QuotaResultStaxUnmarshaller(), executionContext);
    		return response.getAwsResponse();
    	} finally {
    		
    		endClientExecution(awsRequestMetrics, request, response);
    	}
    }
    
    /**
     * 查询用户当天已经使用的配额
     * @return
     */
    public QuotaResult getQuotaUsage() {
    	QuotaRequest quotaRequest = new QuotaRequest();
    	return getQuotaUsage(quotaRequest);
    }
    
    /**
     * 查询用户当天已经使用的配额
     * @return
     */
    public QuotaResult getQuotaUsage(QuotaRequest quotaRequest) {
    	ExecutionContext executionContext = createExecutionContext(quotaRequest);
    	AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    	awsRequestMetrics.startEvent(Field.ClientExecuteTime);
    	Request<QuotaRequest> request = null;
    	Response<QuotaResult> response = null;
    	
    	try {
    		awsRequestMetrics.startEvent(Field.RequestMarshallTime);
    		try {
    			request = new QuotaUsageRequestMarshaller().marshall(super.beforeMarshalling(quotaRequest));
    			// Binds the request metrics to the current request.
    			request.setAWSRequestMetrics(awsRequestMetrics);
    		} finally {
    			awsRequestMetrics.endEvent(Field.RequestMarshallTime);
    		}
    		
    		response = invoke(request, new QuotaResultStaxUnmarshaller(), executionContext);
    		return response.getAwsResponse();
    	} finally {
    		
    		endClientExecution(awsRequestMetrics, request, response);
    	}
    }
    
    /**
     * 计算带宽
     * @param calculateBandwidthRequest
     * @throws InvalidArgumentException
     * @return
     */
    public CalculateBandwidthResult calculateBandwidth(CalculateBandwidthRequest calculateBandwidthRequest) {
        ExecutionContext executionContext = createExecutionContext(calculateBandwidthRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<CalculateBandwidthRequest> request = null;
        Response<CalculateBandwidthResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new CalculateBandwidthRequestMarshaller().marshall(super.beforeMarshalling(calculateBandwidthRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            
            response = invoke(request, new CalculateBandwidthResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();
            
        } finally {
            
            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * Returns additional metadata for a previously executed successful, request, typically used for
     * debugging issues where a service isn't acting as expected.  This data isn't considered part
     * of the result data returned by an operation, so it's available through this separate,
     * diagnostic interface.
     * <p>
     * Response metadata is only cached for a limited period of time, so if you need to access
     * this extra diagnostic information for an executed request, you should use this method
     * to retrieve it as soon as possible after executing the request.
     *
     * @param request
     *            The originally executed request
     *
     * @return The response metadata for the specified request, or null if none
     *         is available.
     */
    public ResponseMetadata getCachedResponseMetadata(AmazonWebServiceRequest request) {
        return client.getResponseMetadataForRequest(request);
    }

    private <X, Y extends AmazonWebServiceRequest> Response<X> invoke(Request<Y> request,
            Unmarshaller<X, StaxUnmarshallerContext> unmarshaller,
            ExecutionContext executionContext)
    {
        request.setEndpoint(endpoint);
        request.setTimeOffset(timeOffset);
        AmazonWebServiceRequest originalRequest = request.getOriginalRequest();

        AWSCredentials credentials = awsCredentialsProvider.getCredentials();
        if (originalRequest.getRequestCredentials() != null) {
            credentials = originalRequest.getRequestCredentials();
        }

        executionContext.setCredentials(credentials);
        
        StaxResponseHandler<X> responseHandler = new StaxResponseHandler<X>(unmarshaller);
        DefaultErrorResponseHandler errorResponseHandler = new DefaultErrorResponseHandler(exceptionUnmarshallers);
        return client.execute(request, responseHandler, errorResponseHandler, executionContext);
    }
}
        