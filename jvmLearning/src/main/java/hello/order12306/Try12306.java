package hello.order12306;

import java.io.File;
import java.io.FileInputStream;
import java.security.KeyStore;

import javax.net.ssl.SSLContext;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class Try12306
{
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

		HttpGet get = new HttpGet(LeonConstant.INIT_12306_URL);
		HttpResponse response = client.execute(get);
		System.out.println(response);
	}
}
