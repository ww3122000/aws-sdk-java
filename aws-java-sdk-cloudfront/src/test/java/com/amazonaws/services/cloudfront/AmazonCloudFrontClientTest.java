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
import com.amazonaws.services.cloudfront.model.AccetypeEnum;
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
import com.amazonaws.services.cloudfront.model.RegionEnum;

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
    	// 1. 设置ak sk
//        final String accessKey = "wangwei-1";
        final String accessKey = "wangwei";
        final String secretKey = "wJalrXUtnFEMI"; 
        
//        final String accessKey = "AKIAJA2CTMPLK2JEFSBQ";
//        final String secretKey = "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"; 
//        String distributionId = "ERB0J74S8V51K";
        
        AWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);
        ClientConfiguration config = new ClientConfiguration();
        config.setMaxErrorRetry(0);
        client = new AmazonCloudFrontClient(credentials, config);
        // 2. 设置 调用的地址
        client.setEndpoint("http://cdnapi.ksyun.com");
//        client.setEndpoint("http://localhost:8090");
//      client.setEndpoint("http://10.4.2.37:18989");
    }

    @After
    public void tearDown() throws Exception {
    }
    

    /**
     * cdn刷新
     * @throws UnsupportedEncodingException
     */
    @Test
    public void testCreateInvalidation() throws UnsupportedEncodingException {
    	// 1. 刷新的域名
        String domain = "www.baidu.com";
        String distributionId = new String(Base64.encodeBase64(domain.getBytes("UTF-8")), "UTF-8");
        System.out.println("distributionId: " + distributionId);
        
        Base64.encodeBase64URLSafe(domain.getBytes("utf-8"));
        
        // 2. 设置需要调用的文件路径
        Paths paths = new Paths();
        paths.withItems("/info_01.html");	// 刷新文件
        paths.withItems("/info_02.html");
        paths.withItems("/info_03.html");
        paths.withItems("/info_04/");		// 刷新目录
        // 3. 设置总个数
        paths.setQuantity(4);
        // 4. 设置调用的id，这个需要每次调用不一样，如果一样会被认为是一次调用
        String callerReference = "10001";
        
        InvalidationBatch batch = new InvalidationBatch(paths, callerReference);
        // 5. 创建一个刷新的请求
        CreateInvalidationRequest request = new CreateInvalidationRequest(distributionId, batch);
        // 6. 发送刷新请求
        CreateInvalidationResult result = client.createInvalidation(request);
        System.out.println(result.getInvalidation());
        
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

    /**
     * 预加载
     * @throws UnsupportedEncodingException
     */
    @Test
    public void testCreatePreload() throws UnsupportedEncodingException {
    	// 1. 设置预加载的域名
        String domain = "www.ksyun.com";
        String distributionId = new String(Base64.encodeBase64(domain.getBytes("UTF-8")), "UTF-8");
        System.out.println("distributionId: " + distributionId);
        
        // 2. 设置预加载的路径
        Paths paths = new Paths();
        paths.withItems("/info_01.html");
        paths.withItems("/info_02.html");
        paths.withItems("/info_03.html");
        paths.setQuantity(3);
        
        String callerReference = "10002";
        
        PreloadBatch batch = new PreloadBatch(paths, callerReference);
        // 3. 创建预加载的请求
        CreatePreloadRequest request = new CreatePreloadRequest(distributionId, batch);
        // 4. 发送预加载的请求
        CreatePreloadResult result = client.createPreload(request);
        System.out.println(result.toString());
    }
    
    /**
     * 流量带宽
     */
    @Test
    public void testCalculateBandwidth() {
        String distributionId = null;
        CalculateBandwidth calculateBandwidth = new CalculateBandwidth();
//        calculateBandwidth.setUserId("73401036"); //  设置用户id——1
        calculateBandwidth.setUserId("73398729"); //  设置用户id
        calculateBandwidth.setOutType("2");// 设置返回结果类型 1：自定义json 2：标准json 3：xml
        
        /* 设置维度
         * 1：域名维度的带宽
         * 2：域名维度查询时间范围内带宽峰值
         * 3：域名维度查询时间范围内流量总和
         * 4：用户维度的带宽
         * 5：用户维度查询时间范围内带宽峰值
         * 6：用户维度查询时间范围内流量总和
         * 7：域名维度的每天峰值
         * 8：用户维度的每天峰值
         */
        calculateBandwidth.setDimension("8");
        calculateBandwidth.setAccetype(AccetypeEnum.download.getValue());
        calculateBandwidth.setRegion(RegionEnum.all.getValue());
        calculateBandwidth.setStartTime("201601130010"); // 201512020000  开始时间
        calculateBandwidth.setEndTime("201601170010"); // 201512020010 结束时间
//        calculateBandwidth.setDomain("static.feidieshuo.com"); //查询的域名——1
        calculateBandwidth.setDomain("dl3.caohua.com;dl7.caohua.com;api.agents.caohua.com"); //查询的域名
        
        //创建流量带宽请求
        CalculateBandwidthRequest request = new CalculateBandwidthRequest(distributionId, calculateBandwidth);
        
        //发送流量带宽请求
        CalculateBandwidthResult result = client.calculateBandwidth(request);
        System.out.println(result.getCalculateBandwidth().getBandwidth());
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
