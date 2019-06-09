package leon;
import java.net.*;
public class URLDecoderTest
{
	public static void main(String[] args)throws Exception {
		String urlStr = URLEncoder.encode("test","UTF-8");
		System.out.println(urlStr);
	}
}