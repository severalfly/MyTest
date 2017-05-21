package com.leon.wechart.util;

import java.io.InputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.zip.GZIPInputStream;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.CoreConnectionPNames;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LeonHttpClient
{
	private static Logger logger = LoggerFactory.getLogger(LeonHttpClient.class);

	private String proxyIp;

	private final HttpClient httpClient;
	/** 发送头 */
	private final Map<String, String> headers = new HashMap<String, String>(10);
	private final Map<String, String> cookieHeaders = new HashMap<String, String>(5);
	/** 返回头原结构 */
	private Header[] responseHeaders;
	/** 返回头map结构（重复的会覆盖，所以有该类数据请勿使用） */
	private final Map<String, String> responseHeadMap = new HashMap<String, String>(5);
	private String charset = "UTF-8";

	public LeonHttpClient() throws Exception
	{
		this.httpClient = HttpClients.createDefault();
		String useragent = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.106 Safari/537.36";
		this.headers.put("User-Agent", useragent);
	}


	public String executeGet(String url) throws Exception
	{
		HttpGet httpGet = new HttpGet(url);
		return execute(httpGet);
	}

	public InputStream executeGetStream(String url) throws Exception
	{
		HttpGet httpGet = new HttpGet(url);
		return executeForStream(httpGet);
	}

	public String executeGet(String url, String charset) throws Exception
	{
		HttpGet httpGet = new HttpGet(url);
		return execute(httpGet, charset);
	}

	public String executePost(String url) throws Exception
	{
		HttpPost httpPost = new HttpPost(url);
		return execute(httpPost);
	}

	public String executePost(String url, Map<String, String> params) throws Exception
	{
		HttpPost httpPost = new HttpPost(url);
		if (params != null)
		{
			List<NameValuePair> list = new ArrayList<NameValuePair>(params.size());
			NameValuePair nvp = null;
			for (Entry<String, String> entry : params.entrySet())
			{
				nvp = new BasicNameValuePair(entry.getKey(), entry.getValue());
				list.add(nvp);
			}
			httpPost.setEntity(new UrlEncodedFormEntity(list, "UTF-8"));
		}
		return execute(httpPost);
	}

	public String executePost(String url, String paramsStr) throws Exception
	{
		HttpPost httpPost = new HttpPost(url);
		if (ObjectUtil.isNotNull(paramsStr))
		{
			httpPost.setEntity(new StringEntity(paramsStr, "UTF-8"));
		}
		return execute(httpPost);
	}

	public String execute(HttpUriRequest request) throws Exception
	{
		InputStream stream = executeForStream(request);
		return RequestProcessor.readStringContent(stream, this.charset);
	}

	public String execute(HttpUriRequest request, String charset) throws Exception
	{
		InputStream stream = executeForStream(request);
		return RequestProcessor.readStringContent(stream, charset);
	}

	public InputStream executeForStream(HttpUriRequest request) throws Exception
	{
		if (this.headers.size() > 0)
		{
			for (Entry<String, String> entry : this.headers.entrySet())
			{
				BasicHeader hd = new BasicHeader(entry.getKey(), entry.getValue());
				request.addHeader(hd);
			}
		}
		if (this.cookieHeaders.size() > 0)
		{
			for (Entry<String, String> entry : this.cookieHeaders.entrySet())
			{
				BasicHeader hd = new BasicHeader(entry.getKey(), entry.getValue());
				request.addHeader(hd);
			}
		}

		HttpResponse response = this.httpClient.execute(request);
		this.responseHeaders = response.getAllHeaders();
		for (Header hd : this.responseHeaders)
		{
			this.responseHeadMap.put(hd.getName(), hd.getValue());
		}
		if (response.getEntity().getContentEncoding() != null && response.getEntity().getContentEncoding().getValue().toLowerCase().indexOf("gzip") > -1)
		{
			//For GZip response  
			GZIPInputStream gzin = new GZIPInputStream(response.getEntity().getContent());
			return gzin;
		}
		return response.getEntity().getContent();
	}

	public HttpEntity executeForEntity(HttpUriRequest request) throws Exception
	{
		if (this.headers.size() > 0)
		{
			for (Entry<String, String> entry : this.headers.entrySet())
			{
				BasicHeader hd = new BasicHeader(entry.getKey(), entry.getValue());
				request.addHeader(hd);
			}
		}
		if (this.cookieHeaders.size() > 0)
		{
			for (Entry<String, String> entry : this.cookieHeaders.entrySet())
			{
				BasicHeader hd = new BasicHeader(entry.getKey(), entry.getValue());
				request.addHeader(hd);
			}
		}

		HttpResponse response = this.httpClient.execute(request);
		this.responseHeaders = response.getAllHeaders();
		for (Header hd : this.responseHeaders)
		{
			this.responseHeadMap.put(hd.getName(), hd.getValue());
		}

		return response.getEntity();
	}

	/**
	 * 设置连接超时
	 * @param cto 毫秒
	 */
	public void setConnectTimeout(int cto)
	{
		this.httpClient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, cto);
	}

	/**
	 * 设置超时时间
	 * @param to 毫秒
	 */
	public void setSoTimeout(int to)
	{
		this.httpClient.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, to);
	}

	public void clear()
	{
		this.headers.clear();
		this.cookieHeaders.clear();
		this.responseHeaders = null;
		this.responseHeadMap.clear();
	}

	public void close()
	{
		try
		{
			this.httpClient.getConnectionManager().shutdown();
		}
		catch (Exception e)
		{
			logger.error("", e);
		}
	}

	public void addHeaders(Map<String, String> headers)
	{
		if (headers == null)
		{
			return;
		}
		for (Entry<String, String> entry : headers.entrySet())
		{
			addHeader(entry.getKey(), entry.getValue());
		}
	}

	public static String sendRequestUrl(String url, Map<String, String> headers) throws Exception
	{
		LeonHttpClient client = null;
		try
		{
			client = new LeonHttpClient();
			if (headers == null)
			{
				headers = new HashMap<String, String>(1);
			}
			headers.put("Connection", "close");
			client.addHeaders(headers);
			return client.executeGet(url);
		}
		finally
		{
			if (client != null)
			{
				client.close();
			}
		}
	}

	/**
	 * 将参数键值对以post方式发送
	 */
	public static String sendRequestUrlPost(String url, Map<String, String> params, Map<String, String> headers) throws Exception
	{
		LeonHttpClient client = null;
		try
		{
			client = new LeonHttpClient();
			if (headers == null)
			{
				headers = new HashMap<String, String>(1);
			}
			headers.put("Connection", "close");
			client.addHeaders(headers);
			return client.executePost(url, params);
		}
		finally
		{
			if (client != null)
			{
				client.close();
			}
		}
	}

	/**
	 * 将字符串以post方式发送
	 */
	public static String sendRequestPostParamsStr(String url, String paramsStr, Map<String, String> headers) throws Exception
	{
		LeonHttpClient client = null;
		try
		{
			client = new LeonHttpClient();
			if (headers == null)
			{
				headers = new HashMap<String, String>(1);
			}
			headers.put("Connection", "close");
			client.addHeaders(headers);
			return client.executePost(url, paramsStr);
		}
		finally
		{
			if (client != null)
			{
				client.close();
			}
		}
	}

	public static byte[] sendRequestUrlForBytes(String url, Map<String, String> headers)
	{
		LeonHttpClient client = null;
		InputStream input = null;
		try
		{
			client = new LeonHttpClient();
			if (headers == null)
			{
				headers = new HashMap<String, String>(1);
			}
			headers.put("Connection", "close");
			client.addHeaders(headers);
			input = client.executeGetStream(url);
			byte[] bytes = LeonFileUtil.input2byte(input, 20);
			return bytes;
		}
		catch (Exception e)
		{
			logger.error("", e);
		}
		finally
		{
			LeonFileUtil.closeStream(input);
			if (client != null)
			{
				client.close();
			}
		}
		return null;
	}

	public static void main(String[] args) throws Exception
	{
		//		String code = URLEncoder.encode("https://omeo.alipay.com/service/checkcode?sessionID=RZ04yq01FzRhI76kaAaiwd3RuYvMNymobileclientgwRZ04&type=lduc&r=0.49111253033250946&time=0", "UTF-8");
		//		String url = "http://192.168.0.151:8080/trainnet/tool/updateIdentifyingCode.action?source=1&code="+code;
		//		sendRequestUrl(url, null);

		String code = URLEncoder.encode("https://omeo.alipay.com/service/checkcode?sessionID=RZ04yq01FzRhI76kaAaiwd3RuYvMNymobileclientgwRZ04&type=lduc&r=0.49111253033250946&time=0", "UTF-8");
		String url = "http://jt.rsscc.com/traintool/tool/getIdentifyingCodeValue.action?codeId=744736165107777536";
		System.out.println(sendRequestPostParamsStr("http://127.0.0.1:8080/trainnet/abc/smstest.action", "sdfsdfs", null));

	}

	public void addHeader(String key, String value)
	{
		this.headers.put(key, value);
	}

	public void addCookie(String cookie)
	{
		this.cookieHeaders.put("Cookie", cookie);
	}

	public void removeCookie()
	{
		this.cookieHeaders.remove("Cookie");
	}

	public void setCharset(String charset)
	{
		this.charset = charset;
	}

	public Header[] getResponseHeaders()
	{
		return this.responseHeaders;
	}

	public String getResponseHead(String name)
	{
		return this.responseHeadMap.get(name);
	}

	@Override
	public String toString()
	{
		return "proxy-" + this.proxyIp;
	}
}
