package com.frame.util;


import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;


// 动态构造调用串，灵活性更大
public class SoapUtil {
	 public static void doGet() {
		    CloseableHttpClient client = HttpClientBuilder.create().build();
		    HttpGet get = new HttpGet("http://www.thepaper.cn");
		    try {
		      // 很奇怪，使用CloseableHttpClient来请求澎湃新闻的首页，GTE请求也必须加上下面这个Header，但是使用HTTPClient则不需要
		      get.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.81 Safari/537.36");
		      HttpResponse response = client.execute(get);
		      String res = EntityUtils.toString(response.getEntity());
		      System.out.println(res);
		    } catch (IOException e) {
		      e.printStackTrace();
		    }
		  }

		  public static void doPost() {
		    CloseableHttpClient client = HttpClientBuilder.create().build();
		    HttpPost post = new HttpPost("https://www.thepaper.cn/www/commentPraise.msp");
		    try {
		      post.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.81 Safari/537.36");
		      List<NameValuePair> params = new ArrayList<>();
		      params.add(new BasicNameValuePair("commentId", "18718372"));
		      post.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));
		      HttpResponse response = client.execute(post);
		      String res = EntityUtils.toString(response.getEntity());
		      System.out.println(res);
		    } catch (UnsupportedEncodingException e) {
		      e.printStackTrace();
		    } catch (ClientProtocolException e) {
		      e.printStackTrace();
		    } catch (IOException e) {
		      e.printStackTrace();
		    }
		  }


		  public static void main(String[] args) {
		    doGet();
		    System.out.println("-----------分割线------------");
		    System.out.println("-----------分割线------------");
		    System.out.println("-----------分割线------------");
		    doPost();

		  }
		
}