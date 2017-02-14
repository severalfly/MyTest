package leon.weather;
import java.net.URL;
import java.net.URLConnection;
import java.net.SocketTimeoutException;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileNotFoundException;


import net.sf.json.JSONObject;

public class Weather
{
	public static void main(String[] args) throws Exception{
		if (args.length > 0) {
			System.out.println(args[0]);
		}
		BufferedReader br = null;
		StringBuilder sb = null;
		URL url = new URL("http://www.weather.com.cn/adat/cityinfo/101010100.html");		
		URLConnection connectionData = url.openConnection();
		connectionData.setConnectTimeout(1000);
		try
		{
			br = new BufferedReader(new InputStreamReader(connectionData.getInputStream(),"UTF-8"));
			sb = new StringBuilder();
			String line  = null;
			while((line = br.readLine()) != null)
			{
				sb.append(line);
			}
		}
		catch(SocketTimeoutException e)
		{
			System.out.println("连接超时");
		}
		catch (FileNotFoundException e)
		{
			System.out.println("load file failed");
		}
		// System.out.println(sb.toString());
		JSONObject json = JSONObject.fromObject(sb.toString());
		JSONObject weatherInfo = JSONObject.fromObject(json.get("weatherinfo"));
		WeatherBody body = new WeatherBody();
		body.city = weatherInfo.get("city").toString();
		body.lowTemp = weatherInfo.get("temp2").toString();
		body.highTemp = weatherInfo.get("temp1").toString();
		System.out.println(body);

	}


}

class WeatherBody
{
	public String city;
	public String lowTemp;
	public String highTemp;
	@Override
	public String toString()
	{
		return this.city + " " + this.lowTemp+ " ~ " + this.highTemp ; 
	}
}