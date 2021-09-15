package com.geminit.sso;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class SSO {
    public static void main(String[] args) throws Exception {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        login(httpClient);
        String code = getCode(httpClient);
        System.out.println(code);
    }

    private static void login(CloseableHttpClient httpClient) throws Exception {
        String url = "http://192.168.0.111:9123/sso/login?username=admin&password=admin";
        HttpPost httpPost = new HttpPost(url);
        //发送请求
        //httpPost.setEntity(new StringEntity(content.toString(), "UTF-8"));
        CloseableHttpResponse httpResponse = httpClient.execute(httpPost);
    }

    private static String getCode(CloseableHttpClient httpClient) throws Exception {
        String url = "http://192.168.0.111:9123/sso/oauth/authorize?client_id=htst-local&response_type=code&" +
                "scope=all&redirect_uri=http://192.168.0.111:11011/";
        HttpGet httpGet = new HttpGet(url);
        //发送请求
        //httpPost.setEntity(new StringEntity(content.toString(), "UTF-8"));
        CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
        //返回结果
        HttpEntity entity = httpResponse.getEntity();
        String code = EntityUtils.toString(entity);
        return code;
    }
}
