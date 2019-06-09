package leon;
import java.net.URL;
import java.net.URLConnection;


import java.util.Date;

public class netTime
{
	public static void main(String[] args) throws Exception {
		
		URL url = new URL("http://www.bjtime.cn");
		URLConnection conn = url.openConnection();
		conn.connect();

		long ld = conn.getDate();
		Date date = new Date(ld);

		System.out.println(date);
	}
}