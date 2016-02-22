package com.amazonaws.services.cloudfront;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.cloudfront.model.*;
import org.apache.commons.codec.binary.Base64;
import org.junit.*;

import java.io.UnsupportedEncodingException;

/**
 * Created by dongxz on 16/2/15.
 */
public class AmazonCloudFrontClientQueryTest {

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
        final String accessKey = "akakakakakakakakakak";
        final String secretKey = "sksksksksksksksksksksksksksksksksksksksk";

        AWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);
        ClientConfiguration config = new ClientConfiguration();
        config.setMaxErrorRetry(0);
        client = new AmazonCloudFrontClient(credentials, config);

        // 2. 设置 调用的地址
        client.setEndpoint("http://localhost:8090");
        //client.setEndpoint("http://10.4.2.37:18989");
    }

    @After
    public void tearDown() throws Exception {
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
        String domain = "dxz02.test.ksyun.8686c.com";
        String distribution = new String(Base64.encodeBase64(domain.getBytes("UTF-8")), "UTF-8");
        System.out.println("distribution: " + distribution);

        // 2. id
        String requestId = "3e4b2257-a755-4240-8591-c338d1ab98a7";

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
        String domain = "dxz02.test.ksyun.8686c.com";
        String distribution = new String(Base64.encodeBase64(domain.getBytes("UTF-8")), "UTF-8");
        System.out.println("distribution: " + distribution);

        // 2. id
        String requestId = "c763039c-d277-402d-9038-61a04bd4b704";

        // 3. 创建一个获取刷新结果的请求
        GetPreloadRequest request = new GetPreloadRequest(distribution, requestId);

        // 4. 发送请求
        GetPreloadResult result = client.getPreload(request);
        System.out.println(result.toString());

    }
}
