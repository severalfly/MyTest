package org.leon;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.ContentBody;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;

public class TestClass
{
	private static String url = "https://api.weixin.qq.com/cgi-bin/media/upload?access_token=Ef3On0NDc1EGo0fVcb2DyD23V73lvVqE-l7nsMbqcJvDv-9NRe51lTR_-dVXE9NfBORhscOD3UbNlTx-PVnddT5yU-9tsBgAleCorkWxGN6h25_3sMiqHSWy3vstk2H-SVOcADADGZ&type=image";

	public static void main(String[] args) throws ClientProtocolException, IOException
	{
		CloseableHttpClient httpClient2 = HttpClients.createDefault();
		//		HttpPost uploadFile = new HttpPost("http://192.168.3.126:8080/trainact/act/wechart/informCommonMsg.action");
		//		MultipartEntityBuilder builder = MultipartEntityBuilder.create();
		//		builder.addTextBody("field1", "yes", ContentType.TEXT_PLAIN);
		//
		//		// This attaches the file to the POST:
		//		builder.addPart("file-", new FileBody(f));
		//		//		builder.addPart("file-image", new FileInputStream(f), ContentType.MULTIPART_FORM_DATA, f.getName());
		//
		//		HttpEntity multipart = builder.build();
		//		uploadFile.setEntity(multipart);
		//		CloseableHttpResponse response = httpClient2.execute(uploadFile);
		//		HttpEntity responseEntity = response.getEntity();
		//		System.out.println(EntityUtils.toString(responseEntity));

		//		File f = new File("d:/test.jpg");
		//		String imageFileName = "d:/test.jpg";
		//		HttpPost post = new HttpPost("http://192.168.3.126:8080/trainact/act/wechart/informCommonMsg.action");
		//		InputStream inputStream = new FileInputStream("d:/test.jpg");
		//		File file = new File(imageFileName);
		//		String message = "This is a multipart post";
		//		MultipartEntityBuilder builder = MultipartEntityBuilder.create();
		//		builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
		//		builder.addBinaryBody("upfile", file, ContentType.DEFAULT_BINARY, imageFileName);
		//		builder.addBinaryBody("upstream", inputStream, ContentType.create("application/zip"), "d:/test.jpg");
		//		builder.addTextBody("text", message, ContentType.TEXT_PLAIN);
		//		// 
		//		HttpEntity entity = builder.build();
		//		post.setEntity(entity);
		//		HttpResponse response = httpClient2.execute(post);

		// 转发到对应的服务器处理

		HttpClient httpClient = new DefaultHttpClient();
		HttpPost httppost = new HttpPost(url);
		MultipartEntity mpEntity = new MultipartEntity();
		File file = new File("d:/test.jpg");
		ContentBody cbFile = new FileBody(file, "jpeg");
		mpEntity.addPart("files", cbFile);
		mpEntity.addPart("filename", new StringBody("leon"));
		mpEntity.addPart("filelength", new StringBody(cbFile.getContentLength() + ""));
		httppost.addHeader("content-type", "multipart/form-data");

		httppost.setEntity(mpEntity);
		HttpResponse response = httpClient.execute(httppost);
		BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "UTF-8"));
		String line = null;
		StringBuffer sb = new StringBuffer();
		while ((line = reader.readLine()) != null)
		{
			sb.append(line).append("\r\n");
		}
		if (reader != null)
		{
			reader.close();
		}
		String result = sb.toString();
		System.out.println(result);

	}
}
