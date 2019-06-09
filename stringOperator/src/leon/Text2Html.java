package leon;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.File;

public class Text2Html
{
	/**
	* convert text file to html file
	*/
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("test.txt"))));
		FileOutputStream out = new FileOutputStream(new File("result.html"));
		String line = null;
		while((line = br.readLine()) != null)
		{
			if(line.trim().equals(""))
			{
				continue;
			}
			line = "<p>" + line + "</p>\n" ;
			byte[] buf = line.getBytes("utf-8");
			out.write(buf, 0, buf.length);
		}
		out.close();
		br.close();
	}
}