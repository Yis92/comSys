package com.sixe.comSys.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import net.sf.json.JSONObject;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;


/**
 * http客户端
 * 
 * @version 3.0
 * @author 北京市宏天信业科技发展有限公司
 */
public class HttpClientUtil {

	/**
	 * 发起http请求
	 * 
	 * @param strUrl
	 *            url地址
	 * @param
	 *
	 * @param Objparameters
	 *            参数名称以及值
	 * @param timeOut
	 *            超时时间
	 * @return strResponseString返回的内容
	 * @throws Exception
	 * @author 北京市宏天信业科技发展有限公司
	 * @throws Exception
	 */
	public static String doHttpPost(String strUrl, String strCharSet,
			Map<String, String> Objparameters, int timeOut) throws Exception {
		String strResponseString = ""; // 返回值
		PostMethod xmlpost = new PostMethod(strUrl); // 请求地址
		int statusCode = 0; // 初始化响应值
		HttpClient httpclient = new HttpClient(); // 构造httpclient
		// httpclient.setConnectionTimeout( timeOut ); // 設置超時時間
		httpclient.getParams().setParameter(
				HttpMethodParams.HTTP_CONTENT_CHARSET, strCharSet); // 设置请求的编码格式
		httpclient.getParams().setParameter(HttpMethodParams.SO_TIMEOUT,
				timeOut); // 設置超時時間
		NameValuePair[] nvps = new NameValuePair[Objparameters.size()];

		int i = 0;
		for (String strKey : Objparameters.keySet()) {
			NameValuePair nvp = new NameValuePair();
			nvp.setName(strKey);
			nvp.setValue(Objparameters.get(strKey));
			nvps[i] = nvp;
			// nvps[i].setValue( Objparameters.get( strKey ) );
			i++;
		}

		xmlpost.setRequestBody(nvps);
		statusCode = httpclient.executeMethod(xmlpost);// 接受响应参数
		strResponseString = xmlpost.getResponseBodyAsString();// 接受响应结果

		// 判断是否响应成功
		if (statusCode < HttpURLConnection.HTTP_OK
				|| statusCode >= HttpURLConnection.HTTP_MULT_CHOICE) {
			//log.error("请求接口失败，相应statusCode[ {} ]",statusCode);
			throw new Exception("请求接口失败，相应statusCode[ " + statusCode + " ]");
		}
		return strResponseString;
	}

	public static String doHttpGet(String strUrl, Map<String, String> map)
			throws Exception {
		String strResponseString = ""; // 返回值
		String param = "?";
		int i = 0;
		for (String key : map.keySet()) {
			if (i > 0)
				param += "&";
			param += key + "=" + URLEncoder.encode(map.get(key), "gbk");
			i++;
		}
		int statusCode = 0; // 初始化响应值
		HttpClient httpclient = new HttpClient(); // 构造httpclient
		GetMethod xmlget = new GetMethod(strUrl + param); // 请求地址
		xmlget.releaseConnection();
		HttpMethod httpMethod = xmlget;
		statusCode = httpclient.executeMethod(httpMethod);// 接受响应参数
		strResponseString = httpMethod.getResponseBodyAsString();// 接受响应结果
		// 判断是否响应成功
		if (statusCode < HttpURLConnection.HTTP_OK
				|| statusCode >= HttpURLConnection.HTTP_MULT_CHOICE) {
			//log.error("请求接口失败，相应statusCode[ {} ]",statusCode);
			throw new Exception("请求接口失败，相应statusCode[ " + statusCode + " ]");
		}

		return strResponseString;
	}

	public static String postXml(String urlStr, String xmlStr)
			throws IOException {
		String reStr = "";
		URL url = new URL(urlStr);
		URLConnection con = url.openConnection();
		con.setDoOutput(true);
		con.setRequestProperty("Pragma:", "no-cache");
		con.setRequestProperty("Cache-Control", "no-cache");
		con.setRequestProperty("Content-Type", "text/xml");
		con.setRequestProperty("charset", "utf-8");

		OutputStreamWriter out = new OutputStreamWriter(con.getOutputStream(),
				"utf-8");
		String xmlInfo = xmlStr;
		System.out.println("urlStr=" + urlStr);
		System.out.println("xmlInfo=" + xmlInfo);
		out.write(new String(xmlInfo.getBytes("utf-8")));
		out.flush();
		out.close();
		BufferedReader br = new BufferedReader(new InputStreamReader(
				con.getInputStream(), "utf-8"));
		// String line = "";
		// for (line = br.readLine(); line != null; line = br.readLine()) {
		// System.out.println(line);
		// }
		reStr = br.readLine();
		return reStr;
	}

	public static void main(String[] args) throws Exception {

	}


}
