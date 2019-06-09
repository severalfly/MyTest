package leon;
import java.io.*;
import java.net.*;
import java.util.*;
public class TestGetPost
{
	public static String sendGet(String url, String param)
	{
		String result = "";
		BufferedReader in = null;
		try
		{
			String urlName = url + "?" + param;
			URL realUrl = new URL(urlName);
			URLConnection conn = realUrl.openConnection();
			conn.setRequestProperty("accept","*/*");
			conn.setRequestProperty("connection", "Keep-alive");
			conn.setRequestProperty("user-agent",
				"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1");
			conn.connect();
			Map<String, List<String>> map = conn.getHeaderFields();
			for (String key: map.keySet()) {
				System.out.println(key + "--->" + map.get(key));
			}
			in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			while((line = in.readLine()) != null)
			{
				result += "\n" + line;
			}
		}
		catch(Exception e)
		{
			System.out.println("send Get request Exception" + e);
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(in != null)
				{
					in.close();
				}
			}
			catch(IOException ex)
			{
				ex.printStackTrace();
			}
		}
		return result;
	}

	public static String sendPost(String url, String param)
	{
		PrintWriter out = null;
		BufferedReader in = null;
		String result = "";
		try
		{
			URL realUrl = new URL(url);
			URLConnection conn = realUrl.openConnection();
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-alive");
			conn.setRequestProperty("user-agent",
				"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			conn.setDoOutput(true);
			conn.setDoInput(true);
			out=new PrintWriter(conn.getOutputStream());
			out.print(param);
			out.flush();

			in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			while((line = in.readLine()) != null)
			{
				result += "\n" + line;
			}
		}
		catch(Exception e)
		{
			System.out.println("send POST request Exception" + e);
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(out != null)
				{
					out.close();
				}
				if(in != null)
				{
					in.close();
				}
			}
			catch(IOException ex)
			{
				ex.printStackTrace();
			}
		}
		return result;
	}

	public static void main(String[] args) {
		String s = TestGetPost.sendGet("http://localhost:8080/",null);
		System.out.println(s);
		String s1 = TestGetPost.sendPost("http://localhost:8080/",null);
		System.out.println(s1);
	}
}