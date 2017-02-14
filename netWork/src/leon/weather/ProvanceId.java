package leon.weather;
import java.net.URL;
import java.net.URLConnection;

import java.io.File;
import java.io.FileOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.regex.Pattern;
import java.util.regex.Matcher;


public class ProvanceId
{
	public static void main(String[] args) throws Exception{
		URL url = new URL("http://m.weathercn.com/common/province.jsp");
		URLConnection conn = url.openConnection();
		Pattern p = Pattern.compile("^<div><a href=.*</div>$");
		StringBuilder sb = new StringBuilder();
		FileOutputStream out = new FileOutputStream(new File("result.txt"));

		String line = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(),"utf-8"));
		while((line = br.readLine()) != null)
		{
			line = line.trim();
			// System.out.println(line);
			Matcher m = p.matcher(line);
			if (m.matches()) {
				sb.append(line);
				sb.append("\n");
			}
		}
		br.close();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println(sb.toString());
		out.write(sb.toString().getBytes(), 0,sb.toString().getBytes().length);
	}
}