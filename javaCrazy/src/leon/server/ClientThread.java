package leon.server;
import java.net.*;
import java.io.*;

public class ClientThread extends Thread
{
	BufferedReader br = null;
	public ClientThread(BufferedReader br)
	{
		this.br = br;
	}

	@Override
	public void run()
	{
		try
		{
			String line = null;
			while((line = br.readLine()) != null)
			{
				System.out.println(line);
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(br == null)
				{
					br.close();
				}
			}
			catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}






	/*private Socket s = null;
	BufferedReader br = null;
	public ClientThread(Socket s) throws Exception
	{
		this.s = s;
		br = new BufferedReader(new InputStreamReader(s.getInputStream()));
	}
	@Override
	public void run()
	{
		try
		{
			String content = null;
			while((content = br.readLine()) != null)
			{
				System.out.println(content);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}*/
}