package com.amazonaws.services.cloudfront;

import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

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
import com.amazonaws.services.cloudfront.model.BandwidthEnum;
import com.amazonaws.services.cloudfront.model.BatchTooLargeException;
import com.amazonaws.services.cloudfront.model.CalculateBandwidth;
import com.amazonaws.services.cloudfront.model.CalculateBandwidthRequest;
import com.amazonaws.services.cloudfront.model.CalculateBandwidthResult;
import com.amazonaws.services.cloudfront.model.CdnTypeEnum;
import com.amazonaws.services.cloudfront.model.ContentPathTypeEnum;
import com.amazonaws.services.cloudfront.model.CreateInvalidationRequest;
import com.amazonaws.services.cloudfront.model.CreateInvalidationResult;
import com.amazonaws.services.cloudfront.model.CreatePreloadRequest;
import com.amazonaws.services.cloudfront.model.CreatePreloadResult;
import com.amazonaws.services.cloudfront.model.GetInvalidationRequest;
import com.amazonaws.services.cloudfront.model.GetInvalidationResult;
import com.amazonaws.services.cloudfront.model.GetPreloadRequest;
import com.amazonaws.services.cloudfront.model.GetPreloadResult;
import com.amazonaws.services.cloudfront.model.InvalidationBatch;
import com.amazonaws.services.cloudfront.model.ListContentPathsRequest;
import com.amazonaws.services.cloudfront.model.ListContentPathsResult;
import com.amazonaws.services.cloudfront.model.ListInvalidationsRequest;
import com.amazonaws.services.cloudfront.model.ListInvalidationsResult;
import com.amazonaws.services.cloudfront.model.ListPreloadsRequest;
import com.amazonaws.services.cloudfront.model.ListPreloadsResult;
import com.amazonaws.services.cloudfront.model.Paths;
import com.amazonaws.services.cloudfront.model.PreloadBatch;
import com.amazonaws.services.cloudfront.model.Quota;
import com.amazonaws.services.cloudfront.model.QuotaNameEnum;
import com.amazonaws.services.cloudfront.model.QuotaRequest;
import com.amazonaws.services.cloudfront.model.QuotaResult;
import com.amazonaws.services.cloudfront.model.RealTimeStatusCodeHitRateRequest;
import com.amazonaws.services.cloudfront.model.RealTimeStatusCodeHitRateResult;
import com.amazonaws.services.cloudfront.model.RegionEnum;
import com.amazonaws.services.cloudfront.model.UpdateQuotaRequest;
import com.amazonaws.services.cloudfront.model.statistics.RealTimeParam;

public class AmazonCloudFrontClientTest {

    private AmazonCloudFrontClient client;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        // 1. 设置ak sk
//        final String accessKey = "wangwei-3";
//        final String accessKey = "wangwei-2";
//    	final String accessKey = "wangwei-1";
        final String accessKey = "wangwei";
        final String secretKey = "wJalrXUtnFEMI";

        AWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);
        ClientConfiguration config = new ClientConfiguration();
        config.setMaxErrorRetry(0);
        client = new AmazonCloudFrontClient(credentials, config);
        // 2. 设置 调用的地址
//        client.setEndpoint("http://cdnapilocal.ksyun.com");
//        client.setEndpoint("http://cdnapi.ksyun.com");
//        client.setEndpoint("http://localhost:8090");
//      client.setEndpoint("http://10.4.2.37:8989");
      client.setEndpoint("http://10.4.2.37:8990");
    }

    @After
    public void tearDown() throws Exception {
    }


    /**
     * cdn刷新
     *
     * @throws UnsupportedEncodingException
     */
    @Test
    public void testCreateInvalidation() throws UnsupportedEncodingException {
        // 1. 刷新的域名
//        String domain = "www.baidu.com";
//        String domain = "dl3.caohua.com";
        String domain = "dxz02.test.ksyun.8686c.com";
//        String domain = "dl3.caohua.com";
        String distributionId = new String(Base64.encodeBase64(domain.getBytes("UTF-8")), "UTF-8");
        System.out.println("distributionId: " + distributionId);

        Base64.encodeBase64URLSafe(domain.getBytes("utf-8"));

        // 2. 设置需要调用的文件路径
        Paths paths = new Paths();
        paths.withItems("/wangweitest/info_01.html");    // 刷新文件
        paths.withItems("/wangweitest/info_02.html");
        paths.withItems("/wangweitest/info_03.html");
        paths.withItems("/wangweitest/info_04/");        // 刷新目录
        // 3. 设置总个数
        paths.setQuantity(4);
        // 4. 设置调用的id，这个需要每次调用不一样，如果一样会被认为是一次调用
        String callerReference = "10001";

        InvalidationBatch batch = new InvalidationBatch(paths, callerReference);
        batch.setUserId("73400332");
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
        for (int i = 0; i < count; i++) {
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
     *
     * @throws UnsupportedEncodingException
     */
    @Test
    public void testCreatePreload() throws UnsupportedEncodingException {
        // 1. 设置预加载的域名
        String domain = "dxz02.test.ksyun.8686c.com";
//        String domain = "dl3.caohua.com";
//        String domain = "dxz02.test.ksyun.8686c.com";
        String distributionId = new String(Base64.encodeBase64(domain.getBytes("UTF-8")), "UTF-8");
        System.out.println("distributionId: " + distributionId);

        // 2. 设置预加载的路径
        Paths paths = new Paths();
        paths.withItems("/info_01.html");
//        paths.withItems("/info_02.html");
//        paths.withItems("/info_03.html");
        paths.setQuantity(1);

        String callerReference = "10002";

        PreloadBatch batch = new PreloadBatch(paths, callerReference);
        batch.setUserId("73400332");
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
        calculateBandwidth.setOutType("2");// 设置返回结果类型 1：自定义json 2：标准json 3：xml

        // 设置类型，如果域名为空则是用户维度，如果给出域名则以域名维度
        calculateBandwidth.setType(BandwidthEnum.bandwidthPeakValue.getValue());
        calculateBandwidth.setAccetype(AccetypeEnum.download.getValue());
        calculateBandwidth.setRegion(RegionEnum.all.getValue());
        calculateBandwidth.setStartTime("201601300028"); // 201512020000  开始时间
        calculateBandwidth.setEndTime("201601300048"); // 201512020010 结束时间
//        calculateBandwidth.setDomain("static.feidieshuo.com"); //查询的域名——1
        calculateBandwidth.setDomain("dl3.caohua.com;dl7.caohua.com"); //查询的域名
//        calculateBandwidth.setDomain("dl3.caohua.com"); //查询的域名 当域名不设置的时候以用户为维度
        
        calculateBandwidth.setCdnType(CdnTypeEnum.download.getValue());

        //创建流量带宽请求
        CalculateBandwidthRequest request = new CalculateBandwidthRequest(distributionId, calculateBandwidth);

        //发送流量带宽请求
        CalculateBandwidthResult result = client.calculateBandwidth(request);
        System.out.println(result.getCalculateBandwidth().getBandwidth());
    }

    @Test
    public void testCalculateBandwidth2() {
        String distributionId = null;
        CalculateBandwidth calculateBandwidth = new CalculateBandwidth();
        calculateBandwidth.setOutType("2");// 设置返回结果类型 1：自定义json 2：标准json 3：xml

        // 设置类型，如果域名为空则是用户维度，如果给出域名则以域名维度
        calculateBandwidth.setType(BandwidthEnum.bandwidth.getValue());
        calculateBandwidth.setAccetype(AccetypeEnum.download.getValue());
        calculateBandwidth.setRegion(RegionEnum.all.getValue());
        calculateBandwidth.setStartTime("201512220000"); // 201512020000  开始时间
        calculateBandwidth.setEndTime("201601212038"); // 201512020010 结束时间
        calculateBandwidth.setDomain("d1.kaopuyun.com"); //查询的域名 当域名不设置的时候以用户为维度

        //创建流量带宽请求
        CalculateBandwidthRequest request = new CalculateBandwidthRequest(distributionId, calculateBandwidth);

        //发送流量带宽请求
        CalculateBandwidthResult result = client.calculateBandwidth(request);
        System.out.println(result.getCalculateBandwidth().getBandwidth());
    }

    @Test
    public void testListInvalidation() throws UnsupportedEncodingException {
        String domain = "dxz02.test.ksyun.8686c.com";
        String distribution = new String(Base64.encodeBase64(domain.getBytes("UTF-8")), "UTF-8");
        System.out.println("distribution: " + distribution);

        ListInvalidationsRequest request = new ListInvalidationsRequest(distribution);

        ListInvalidationsResult result = client.listInvalidations(request);
        System.out.println(result.toString());

    }

    @Test
    public void testGetInvalidation() throws UnsupportedEncodingException {
        // 1. 刷新的域名
        String domain = "dl3.caohua.com";
        String distribution = new String(Base64.encodeBase64(domain.getBytes("UTF-8")), "UTF-8");
        System.out.println("distribution: " + distribution);

        // 2. id
        String requestId = "14a203a9-41e6-4ad3-9f10-635456ffcee4";

        // 3. 创建一个获取刷新结果的请求
        GetInvalidationRequest request = new GetInvalidationRequest(distribution, requestId);

        // 4. 发送请求
        GetInvalidationResult result = client.getInvalidation(request);
        System.out.println(result.toString());

    }

    @Test
    public void testListPreload() throws UnsupportedEncodingException {
        String domain = "dxz02.test.ksyun.8686c.com";
        String distribution = new String(Base64.encodeBase64(domain.getBytes("UTF-8")), "UTF-8");
        System.out.println("distribution: " + distribution);

        ListPreloadsRequest request = new ListPreloadsRequest(distribution);

        ListPreloadsResult result = client.listPreloads(request);
        System.out.println(result.toString());

    }

    @Test
    public void testGetPreload() throws UnsupportedEncodingException {
        // 1. 刷新的域名
        String domain = "dl3.caohua.com";
        String distribution = new String(Base64.encodeBase64(domain.getBytes("UTF-8")), "UTF-8");
        System.out.println("distribution: " + distribution);

        // 2. id
        String requestId = "87a25d78-3280-40f7-8dc7-abea9fda3c5e";

        // 3. 创建一个获取刷新结果的请求
        GetPreloadRequest request = new GetPreloadRequest(distribution, requestId);

        // 4. 发送请求
        GetPreloadResult result = client.getPreload(request);
        System.out.println(result.toString());

    }
    
    /**
     * 更新每天可以使用的次数<br>
     * 管理员使用
     */
    @Test
    public void testUpdateQuotaConfig() {
    	HashMap<String, Long> map = new HashMap<String, Long>();
    	// 把要使用的值放入 map
    	map.put(QuotaNameEnum.list_preloads.getValue(), 133L);
    	map.put(QuotaNameEnum.quota_config.getValue(), null);
    	Quota quota = new Quota();
    	quota.setDetail(map);
    	
    	UpdateQuotaRequest updateQuotaRequest = new UpdateQuotaRequest();
    	updateQuotaRequest.setUserId("73400247"); 
    	updateQuotaRequest.setQuota(quota);
    	
    	
    	QuotaResult result = client.updateQuotaConfig(updateQuotaRequest);
    	System.out.println(result.getQuota());
    }
    
    /**
     * 查询每天可以使用的配额数<br>
     * 
     */
    @Test
    public void testGetQuotaConfig() {
    	
    	QuotaResult result = client.getQuotaConfig();
    	System.out.println(result.getQuota());
    }
    
    /**
     * 查询用户每天可以使用的次数
     */
    @Test
    public void testGetQuotaConfigSuper() {
    	QuotaRequest quotaRequest = new QuotaRequest();
//    	quotaRequest.setUserId("73398729"); // 要查询的用户的 id
    	quotaRequest.setUserId("73400332"); // 要查询的用户的 id
    	QuotaResult result = client.getQuotaConfig(quotaRequest);
    	System.out.println(result.getQuota());
    }
    
    /**
     * 查看用户的配额使用次数<br>
     * 用户使用时什么参数都不需要传递
     */
    @Test
    public void testGetQuotaUsage() {
    	
    	QuotaResult result = client.getQuotaUsage();
    	System.out.println(result.getQuota());
    }
    
    /**
     * 查看用户的配额使用次数
     */
    @Test
    public void testGetQuotaUsageSuper() {
    	QuotaRequest quotaRequest = new QuotaRequest();
//    	quotaRequest.setUserId("73398729");	// 用户 id，可以不传
    	quotaRequest.setUserId("73400332");	// 用户 id，可以不传
    	
    	QuotaResult result = client.getQuotaUsage(quotaRequest);
    	System.out.println(result.getQuota());
    }
    
    /**
     * 刷新、预热查询接口
     */
    @Test
    public void testListContentPaths() {
    	
    	Calendar ca = Calendar.getInstance();
    	ca.add(Calendar.DAY_OF_YEAR, -100);
    	ListContentPathsRequest request = new ListContentPathsRequest();
//    	request.setUserId(73400332L);	// 用户 id
//    	request.setQueryName("wangwei");	// 模糊查询的内容，如果不输入则查询当前用户的
    	request.setType(ContentPathTypeEnum.REFRESH_DIR); // 类型：文件刷新、目录刷新、文件预热
    	request.setStartTime(ca.getTime());	// 开始时间
    	request.setEndTime(new Date(System.currentTimeMillis()));	// 结束时间
    	request.setPageIndex(0);	//	第几页  从0开始
    	request.setPageSize(10);	// 页大小 默认100
    	ListContentPathsResult result = client.listContentPaths(request);
    	System.out.println(result.getListContentPaths());
    }
    
    /**
     * 实时状态码命中率查询
     */
    @Test
    public void testRealTimeStatusCodeHitRate() {
    	RealTimeParam param = new RealTimeParam(); // 实时状态码查询参数
//    	param.setUserId("73398729"); // 不传默认为当前用户
//    	param.setStartTime(new Date(System.currentTimeMillis() - 86400 * 1000)); // 昨天
    	param.setEndTime(new Date()); // 今天，当前的时间
//    	param.setDomains("f3.market.mi-img.com");	 // 域名以分号分隔, 如果没有则为 all
//    	param.setDomains("test001.isurecloud.com");	 // 域名以分号分隔, 如果没有则为 all
    	RealTimeStatusCodeHitRateRequest request = new RealTimeStatusCodeHitRateRequest(param);
    	RealTimeStatusCodeHitRateResult result = client.realTimeStatusCodeHitRate(request);
    	System.out.println(result.getRealTimeStatusCodeHitRate());
    }

    /**
     @Test public void testDeleteCloudFrontOriginAccessIdentity() {

     }

     @Test public void testDeleteDistribution() {

     }

     @Test public void testListDistributions() {

     }

     @Test public void testCreateStreamingDistribution() {

     }

     @Test public void testCreateDistribution() {

     }

     @Test public void testUpdateCloudFrontOriginAccessIdentity() {

     }

     @Test public void testGetDistribution() {

     }

     @Test public void testDeleteStreamingDistribution() {

     }

     @Test public void testListCloudFrontOriginAccessIdentities() {

     }

     @Test public void testGetStreamingDistribution() {

     }

     @Test public void testListStreamingDistributions() {

     }

     @Test public void testUpdateDistribution() {

     }

     @Test public void testGetCloudFrontOriginAccessIdentityConfig() {

     }

     @Test public void testGetCloudFrontOriginAccessIdentity() {

     }

     @Test public void testGetInvalidation() {

     }

     @Test public void testCreateCloudFrontOriginAccessIdentity() {

     }

     @Test public void testListDistributionsByWebACLId() {

     }

     @Test public void testGetDistributionConfig() {

     }

     @Test public void testUpdateStreamingDistribution() {

     }

     @Test public void testGetStreamingDistributionConfig() {

     }

     @Test public void testListInvalidations() {

     }

     @Test public void testGetCachedResponseMetadata() {

     }
     **/
}
