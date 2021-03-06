package hello.order12306;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.KeyStore;
import java.util.Random;

import javax.net.ssl.SSLContext;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import com.alibaba.fastjson.JSONObject;

import hello.order12306.util.ObjectUtil;

public class Try12306
{
	static CookieStore cookieStore = null;
	static HttpClientContext context = null;

	public static void main(String[] args) throws Exception
	{

		//		HttpClient client = new DefaultHttpClient();
		//		HttpGet httpGet = new HttpGet(LeonConstant.INIT_12306_URL);
		//				HttpGet httpGet = new HttpGet("https://www.baidu.com");
		//		HttpResponse response = client.execute(httpGet);
		//		System.out.println(response);

		//		HttpGet httpGet2 = new HttpGet(LeonConstant.LOGIN_12306_URL);
		//		HttpResponse response = client.execute(httpGet2);
		//		InputStream in = response.getEntity().getContent();
		//		byte[] buffer = new byte[1024];
		//		while (in.read(buffer, 0, 1024) > 0)
		//		{
		//			System.out.println(buffer);
		//		}
		KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
		//加载证书文件
		FileInputStream instream = new FileInputStream(new File("C:\\work\\Java_x64\\jdk1.8.0_65\\jre\\lib\\security\\cacerts"));
		try
		{
			trustStore.load(instream, "changeit".toCharArray());
		}
		finally
		{
			instream.close();
		}
		SSLContext sslcontext = SSLContexts.custom().loadTrustMaterial(trustStore).build();

		SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext, SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
		CloseableHttpClient client = HttpClients.custom().setSSLSocketFactory(sslsf).build();

		HttpGet get = new HttpGet(LeonConstant.ONT_URL);
		get.setHeader("Host", "kyfw.12306.cn");
		get.setHeader("Connection", "keep-alive");
		get.setHeader("Upgrade-Insecure-Requests", "1");
		get.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36");
		get.setHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
		get.setHeader("Referer", "https://kyfw.12306.cn/mormhweb/");
		get.setHeader("Accept-Encoding", "gzip, deflate, sdch, br");
		get.setHeader("Accept-Language", "zh-CN,zh;q=0.8");
		get.setHeader("Cookie",
				"JSESSIONID=0A02F04C98C20E3C34B1A35B821F2DCCAD6C6C1E71; _jc_save_fromStation=%u6B66%u6C49%2CWHN; _jc_save_toStation=%u961C%u9633%2CFYH; _jc_save_fromDate=2017-01-22; _jc_save_toDate=2017-01-19; _jc_save_wfdc_flag=dc; _jc_save_detail=true; BIGipServerotn=1290797578.38945.0000");
		HttpResponse response = null;
		response = client.execute(get);
		Header[] headers = response.getAllHeaders();
		headers = response.getHeaders("Set-Cookie");
		String jession = ""; // JSESSIONID
		String bigipServerotn = ""; //BIGipServerotn
		for (Header header : headers)
		{
			if (header.getValue().startsWith("JSESSIONID"))
			{
				jession = header.getValue();
			}
			else if (header.getValue().startsWith("BIGipServerotn"))
			{
				bigipServerotn = header.getValue();
			}
			//			jession +=  header.getValue();
		}
		client = HttpClients.custom().setSSLSocketFactory(sslsf).build();

		get = new HttpGet(LeonConstant.INIT_12306_URL);
		get.setHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
		get.setHeader("Accept-Encoding", "gzip, deflate, sdch, br");
		get.setHeader("Accept-Language", "zh-CN,zh;q=0.8");
		get.setHeader("Connection", "keep-alive");
		get.setHeader("Cookie", jession + "; _jc_save_fromStation=%u6B66%u6C49%2CWHN; _jc_save_toStation=%u961C%u9633%2CFYH; _jc_save_fromDate=2017-01-22; _jc_save_toDate=2017-01-19; _jc_save_wfdc_flag=dc; _jc_save_detail=true; " + bigipServerotn);
		get.setHeader("Host", "kyfw.12306.cn");
		get.setHeader("Referer", "https://kyfw.12306.cn/otn/");
		get.setHeader("Upgrade-Insecure-Requests", "1");
		get.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36");
		response = client.execute(get);
		//		System.out.println(EntityUtils.toString(response.getEntity()));

		// 开始获取验证码
		get = new HttpGet(LeonConstant.LOGIN_PASSCODE_12306_URL);
		get.setHeader("Accept", "image/webp,*/*;q=0.8");
		get.setHeader("Accept-Encoding", "gzip, deflate, sdch, br");
		get.setHeader("Accept-Language", "zh-CN,zh;q=0.8");
		get.setHeader("Connection", "keep-alive");
		get.setHeader("Cookie", jession + "; _jc_save_fromStation=%u6B66%u6C49%2CWHN; _jc_save_toStation=%u961C%u9633%2CFYH; _jc_save_fromDate=2017-01-22; _jc_save_toDate=2017-01-19; _jc_save_wfdc_flag=dc; _jc_save_detail=true; " + bigipServerotn);
		get.setHeader("Host", "kyfw.12306.cn");
		get.setHeader("Referer", "https://kyfw.12306.cn/otn/login/init");
		get.setHeader("Upgrade-Insecure-Requests", "1");
		get.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36");
		response = client.execute(get);
		InputStream in = response.getEntity().getContent();
		byte[] data = readInputStream(in);
		String imageFileName = ObjectUtil.getDay() + ".png";
		FileOutputStream out = new FileOutputStream(new File(imageFileName));

		out.write(data);
		out.close();
		System.out.println("success get passcode, filename is: " + imageFileName);

		// 开始提交验证码
		HttpPost post = new HttpPost(LeonConstant.CHECK_RANDOM_CODE_URL);
		post.setHeader("Accept", "*/*");
		post.setHeader("Accept-Encoding", "gzip, deflate, br");
		post.setHeader("Accept-Language", "zh-CN,zh;q=0.8");
		post.setHeader("Connection", "keep-alive");
		post.setHeader("Cookie", jession + "; _jc_save_fromStation=%u6B66%u6C49%2CWHN; _jc_save_toStation=%u961C%u9633%2CFYH; _jc_save_fromDate=2017-01-22; _jc_save_toDate=2017-01-19; _jc_save_wfdc_flag=dc; _jc_save_detail=true; " + bigipServerotn);
		post.setHeader("Origin", "https://kyfw.12306.cn");
		post.setHeader("Host", "kyfw.12306.cn");
		post.setHeader("Referer", "https://kyfw.12306.cn/otn/login/init");
		post.setHeader("Upgrade-Insecure-Requests", "1");
		post.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36");
		post.setHeader("X-Requested-With", "XMLHttpRequest");
		post.setHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");

		// 手动获取验证码，控制台输入
		String codeStr = getCodeStrByInput(imageFileName); // 获取对应码值
		StringEntity stringEntity = new StringEntity(String.format("randCode=%s&rand=sjrand", codeStr));
		post.setEntity(stringEntity);

		response = client.execute(post);
		String res = EntityUtils.toString(response.getEntity());
		JSONObject json = JSONObject.parseObject(res);
		JSONObject jsonData = json.getJSONObject("data");
		if (!"1".equals(jsonData.getString("result")))
		{
			System.out.println(json);
			return;
		}
		System.out.println("验证码通过，开始传用户名&&密码");
		// 开始登录了
		post = new HttpPost(LeonConstant.LOGIN_12306_URL);
		post.setHeader("Host", "kyfw.12306.cn");
		post.setHeader("Connection", "keep-alive");
		post.setHeader("Accept", "*/*");
		post.setHeader("Origin", "https://kyfw.12306.cn");
		post.setHeader("X-Requested-With", "XMLHttpRequest");
		post.setHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
		post.setHeader("Referer", "https://kyfw.12306.cn/otn/login/init");
		post.setHeader("Accept-Encoding", "gzip, deflate, br");
		post.setHeader("Accept-Language", "zh-CN,zh;q=0.8");
		post.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36");
		post.setHeader("Cookie", jession + "; _jc_save_fromStation=%u6B66%u6C49%2CWHN; _jc_save_toStation=%u961C%u9633%2CFYH; _jc_save_fromDate=2017-01-22; _jc_save_toDate=2017-01-19; _jc_save_wfdc_flag=dc; _jc_save_detail=true; " + bigipServerotn);
		String params = String.format("randCode=%s&loginUserDTO.user_name=yunfei_happyv2&userDTO.password=leon12306", codeStr);

		stringEntity = new StringEntity(params);
		response = client.execute(post);
		res = EntityUtils.toString(response.getEntity());
		System.out.println(res);

	}

	/**
	 * 由输入计算验证码
	 * @param imageFileName 
	 * @return 80,50;90,
	 * @throws IOException 
	 */
	private static String getCodeStrByInput(String imageFileName) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("请输入您识别的验证码结果图片为：" + imageFileName);
		String inputCodes = reader.readLine();// 控制台读取数字串，按从左到右，从上到下顺序诸读取，如 1，3
		// 一般12306 验证码为横4竖2 的，每个小图片大小为 70 * 70，下面计算以此为准，
		String result = "";
		for (String str : inputCodes.split(","))
		{
			int num = new Integer(str);
			int x = num % 4;
			int y = num / 4;
			int rand = new Random().nextInt(50);
			result += x * 70 + rand + 10 + ",";
			rand = new Random().nextInt(50);
			result += y * 70 + rand + 10 + ",";
		}
		result += ",";
		result = result.replace(",,", "");
		return result;
	}

	@Test
	public void testGetCodeStrByInput()
	{
		try
		{
			String imageFileName = ObjectUtil.getDay();
			System.out.println(getCodeStrByInput(imageFileName));
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public static byte[] readInputStream(InputStream inStream) throws Exception
	{
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		//创建一个Buffer字符串  
		byte[] buffer = new byte[1024];
		//每次读取的字符串长度，如果为-1，代表全部读取完毕  
		int len = 0;
		//使用一个输入流从buffer里把数据读取出来  
		while ((len = inStream.read(buffer)) != -1)
		{
			//用输出流往buffer里写入数据，中间参数代表从哪个位置开始读，len代表读取的长度  
			outStream.write(buffer, 0, len);
		}
		//关闭输入流  
		inStream.close();
		//把outStream里的数据写入内存  
		return outStream.toByteArray();
	}



}
