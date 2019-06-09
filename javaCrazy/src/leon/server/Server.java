package leon.server;
import java.net.*;
import java.io.*;
public class Server
{
	private static final int SERVER_PORT = 30000;
	public static YeekuMap<String, PrintStream> clients = new YeekuMap<String, PrintStream>();

	public void init()
	{
		ServerSocket ss = null;
		try
		{
			ss = new ServerSocket(SERVER_PORT);
			while(true)
			{
				Socket s = ss.accept();
				new ServerThread(s).start();
			}
		}
		catch(IOException e)
		{
			System.out.println("server startup error, is the port:" + SERVER_PORT + " been used?");
		}
		finally
		{
			try
			{
				if (ss != null)
				{
					ss.close();
				}
			}
			catch(IOException ex)
			{
				ex.printStackTrace();
			}
			System.exit(1);
		}
	}

	public static void main(String[] args) throws IOException
	{
		Server  server = new Server();
		server.init();
	}
}