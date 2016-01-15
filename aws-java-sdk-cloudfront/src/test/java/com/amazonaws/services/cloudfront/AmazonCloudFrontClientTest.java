package com.amazonaws.services.cloudfront;

import java.io.UnsupportedEncodingException;

import org.apache.commons.codec.binary.Base64;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.cloudfront.model.BatchTooLargeException;
import com.amazonaws.services.cloudfront.model.CalculateBandwidth;
import com.amazonaws.services.cloudfront.model.CalculateBandwidthRequest;
import com.amazonaws.services.cloudfront.model.CalculateBandwidthResult;
import com.amazonaws.services.cloudfront.model.CreateInvalidationRequest;
import com.amazonaws.services.cloudfront.model.CreateInvalidationResult;
import com.amazonaws.services.cloudfront.model.CreatePreloadRequest;
import com.amazonaws.services.cloudfront.model.CreatePreloadResult;
import com.amazonaws.services.cloudfront.model.InvalidationBatch;
import com.amazonaws.services.cloudfront.model.Paths;
import com.amazonaws.services.cloudfront.model.PreloadBatch;

public class AmazonCloudFrontClientTest {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
    
    
    private AmazonCloudFrontClient client;
    

    @Before
    public void setUp() throws Exception {
//        final String accessKey = "wangwei-1";
        final String accessKey = "wangwei";
        final String secretKey = "wJalrXUtnFEMI"; 
        String domain = "www.ksyun.com";
        
//        final String accessKey = "AKIAJA2CTMPLK2JEFSBQ";
//        final String secretKey = "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"; 
//        String distributionId = "ERB0J74S8V51K";
        
        AWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);
        ClientConfiguration config = new ClientConfiguration();
        config.setMaxErrorRetry(0);
        client = new AmazonCloudFrontClient(credentials, config);
        client.setEndpoint("http://localhost:8090");
//      client.setEndpoint("http://10.4.2.37:18989");
    }

    @After
    public void tearDown() throws Exception {
    }
    

    @Test
    public void testCreateInvalidation() throws UnsupportedEncodingException {
        String domain = "www.ksyun.com";
        String distributionId = new String(Base64.encodeBase64(domain.getBytes("UTF-8")), "UTF-8");
        System.out.println("distributionId: " + distributionId);
        
        Base64.encodeBase64URLSafe(domain.getBytes("utf-8"));
        
        Paths paths = new Paths();
        paths.withItems("/info_01.html");
        paths.withItems("/info_02.html");
        paths.withItems("/info_03.html");
        paths.withItems("/info_04/*");
        paths.setQuantity(4);
        
        String callerReference = "10001";
        
        InvalidationBatch batch = new InvalidationBatch(paths, callerReference);
        CreateInvalidationRequest request = new CreateInvalidationRequest(distributionId, batch);
        CreateInvalidationResult result = client.createInvalidation(request);
        System.out.println(result.toString());
        
    }
    
    @Test
    public void testCreateInvalidation2() throws UnsupportedEncodingException {
        String domain = "www.ksyun.com";
        String distributionId = new String(Base64.encodeBase64(domain.getBytes("UTF-8")), "UTF-8");
        System.out.println("distributionId: " + distributionId);
        
        Paths paths = new Paths();
        paths.withItems("/info_01.html");
        paths.withItems("/info_02.html");
        paths.withItems("/info_03.html");
        paths.withItems("/info_04/");
        paths.withItems("/info_04/");
        paths.withItems("/info_04/");
        paths.withItems("/info_04/");
        paths.withItems("/info_04/");
        paths.withItems("/info_04/");
        paths.withItems("/info_04/");
        paths.setQuantity(10);
        
        String callerReference = "10001";
        
        InvalidationBatch batch = new InvalidationBatch(paths, callerReference);
        CreateInvalidationRequest request = new CreateInvalidationRequest(distributionId, batch);
        CreateInvalidationResult result = client.createInvalidation(request);
        System.out.println(result.toString());
        
    }
    
    
    @Test(expected = BatchTooLargeException.class)
    public void testCreateInvalidation3() throws UnsupportedEncodingException {
        String domain = "www.ksyun.com";
        String distributionId = new String(Base64.encodeBase64(domain.getBytes("UTF-8")), "UTF-8");
        System.out.println("distributionId: " + distributionId);
        
        Paths paths = new Paths();
        paths.withItems("/info_01.html");
        paths.withItems("/info_02.html");
        paths.withItems("/info_03.html");
        paths.withItems("/info_04/");
        paths.withItems("/info_05/");
        paths.withItems("/info_06/");
        paths.withItems("/info_07/");
        paths.withItems("/info_08/");
        paths.withItems("/info_09/");
        paths.withItems("/info_10/");
        paths.setQuantity(10);
        
        String callerReference = "10001";
        
        InvalidationBatch batch = new InvalidationBatch(paths, callerReference);
        CreateInvalidationRequest request = new CreateInvalidationRequest(distributionId, batch);
        CreateInvalidationResult result = client.createInvalidation(request);
        System.out.println(result.toString());
    }
    
    @Test(expected = BatchTooLargeException.class)
    public void testCreateInvalidation4() throws UnsupportedEncodingException {
        String domain = "www.ksyun.com";
        String distributionId = new String(Base64.encodeBase64(domain.getBytes("UTF-8")), "UTF-8");
        System.out.println("distributionId: " + distributionId);
        
        Paths paths = new Paths();
        String temp = "/info_%s.html";
        int count = 1001;
        for(int i=0; i < count; i++){
            paths.withItems(temp.format(temp, i));
        }
        paths.withItems("/info_04/");
        paths.setQuantity(count + 1);
        
        String callerReference = "10001";
        
        InvalidationBatch batch = new InvalidationBatch(paths, callerReference);
        CreateInvalidationRequest request = new CreateInvalidationRequest(distributionId, batch);
        CreateInvalidationResult result = client.createInvalidation(request);
        System.out.println(result.toString());
        
    }

    @Test
    public void testCreatePreload() throws UnsupportedEncodingException {
        String domain = "www.ksyun.com";
        String distributionId = new String(Base64.encodeBase64(domain.getBytes("UTF-8")), "UTF-8");
        System.out.println("distributionId: " + distributionId);
        
        Paths paths = new Paths();
        paths.withItems("/info_01.html");
        paths.withItems("/info_02.html");
        paths.withItems("/info_03.html");
        paths.withItems("/info_04/*");
        paths.setQuantity(4);
        
        String callerReference = "10002";
        
        PreloadBatch batch = new PreloadBatch(paths, callerReference);
        CreatePreloadRequest request = new CreatePreloadRequest(distributionId, batch);
        CreatePreloadResult result = client.createPreload(request);
        System.out.println(result.toString());
    }
    
    @Test
    public void testCalculateBandwidth() {
        String distributionId = null;
        CalculateBandwidth calculateBandwidth = new CalculateBandwidth();
        calculateBandwidth.setUserId("fd31621572d3f075bcfb1c91bd10926b");
        calculateBandwidth.setType("2");
        calculateBandwidth.setStartTime("201512020000");
        calculateBandwidth.setEndTime("201512020010");
        calculateBandwidth.setDomain("www.baidu.com");
        
        CalculateBandwidthRequest request = new CalculateBandwidthRequest(distributionId, calculateBandwidth);
        CalculateBandwidthResult result = client.calculateBandwidth(request);
        System.out.println(result.getCalculateBandwidth().getBandwidth());
        System.out.println(result.toString());
    }
    
    
    /**
    @Test
    public void testDeleteCloudFrontOriginAccessIdentity() {
        
    }

    @Test
    public void testDeleteDistribution() {
        
    }

    @Test
    public void testListDistributions() {
        
    }

    @Test
    public void testCreateStreamingDistribution() {
        
    }

    @Test
    public void testCreateDistribution() {
        
    }

    @Test
    public void testUpdateCloudFrontOriginAccessIdentity() {
        
    }

    @Test
    public void testGetDistribution() {
        
    }

    @Test
    public void testDeleteStreamingDistribution() {
        
    }

    @Test
    public void testListCloudFrontOriginAccessIdentities() {
        
    }

    @Test
    public void testGetStreamingDistribution() {
        
    }

    @Test
    public void testListStreamingDistributions() {
        
    }

    @Test
    public void testUpdateDistribution() {
        
    }

    @Test
    public void testGetCloudFrontOriginAccessIdentityConfig() {
        
    }

    @Test
    public void testGetCloudFrontOriginAccessIdentity() {
        
    }

    @Test
    public void testGetInvalidation() {
        
    }

    @Test
    public void testCreateCloudFrontOriginAccessIdentity() {
        
    }

    @Test
    public void testListDistributionsByWebACLId() {
        
    }

    @Test
    public void testGetDistributionConfig() {
        
    }

    @Test
    public void testUpdateStreamingDistribution() {
        
    }

    @Test
    public void testGetStreamingDistributionConfig() {
        
    }

    @Test
    public void testListInvalidations() {
        
    }

    @Test
    public void testGetCachedResponseMetadata() {
        
    }
	**/
}
