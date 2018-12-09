package com.hisrun.demo.underwriting;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.junit.Test;

import junit.framework.TestCase;

public class UnderWritingTest extends TestCase {
	@Test
	public void testUnderWriting() {
		
		try {

			String httpUrl = "http://192.168.1.108:10794/remoteServer";
			PostMethod getMethod = new PostMethod(httpUrl);
			HttpClient httpClient = new HttpClient();
//			Object obj = new Object();
//			String json = JsonUtils.obj2Json(obj);
			String json = "";
			getMethod.setRequestEntity(new StringRequestEntity(json, "text/xml", "GBK"));

			System.out.println(json);
			// System.out.println(AESUtil.decrypt(json, "AES"));
			httpClient.executeMethod(getMethod);
			BufferedReader reader = null;
			reader = new BufferedReader(new InputStreamReader(getMethod.getResponseBodyAsStream(), "UTF-8"));
			String lines;
			StringBuffer sb = new StringBuffer("");

			while ((lines = reader.readLine()) != null) {
				lines = new String(lines.getBytes());
				System.out.println(lines);
				sb.append(lines);
			}
		
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
