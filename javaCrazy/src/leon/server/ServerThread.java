package leon.server;
import java.net.*;
import java.io.*;

public class ServerThread extends Thread 
{

	private Socket socket;
	BufferedReader br = null;
	PrintStream ps = null;

	public ServerThread(Socket s)
	{
		this.socket = s;
	}

	@Override
	public void run()
	{
		try
		{
			br = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
			ps = new PrintStream(socket.getOutputStream());
			String line = null;
			while((line = br.readLine()) != null)
			{
				if(line.startsWith(YeekuProtocol.USER_ROUND) && line.endsWith(YeekuProtocol.USER_ROUND))
				{
					String userName = getReaLMsg(line);
					if(Server.clients.containsKey(userName))
					{
						System.out.println("repeat");
						ps.println(YeekuProtocol.NAME_REP);
					}
					else
					{
						System.out.println("success");
						ps.println(YeekuProtocol.LOGIN_SUCCESS);
						Server.clients.put(userName, ps);
					}
				}
				else if (line.startsWith(YeekuProtocol.PRIVATE_ROUND) && line.endsWith(YeekuProtocol.PRIVATE_ROUND))
				{
					String userAndMsg = getReaLMsg(line);
					String user = userAndMsg.split(YeekuProtocol.SPLIT_SIGN)[0];
					String msg = userAndMsg.split(YeekuProtocol.SPLIT_SIGN)[1];
					Server.clients.get(user).println(Server.clients.getKeyByValue(ps) + " sweete say to you: " + msg);
				}
				else
				{
					String msg = getReaLMsg(line);
					for (PrintStream clientPs : Server.clients.valueSet()) {
						clientPs.println(Server.clients.getKeyByValue(ps) + " said: " + msg);
					}
				}
			}
		}
		catch(IOException e)
		{
			Server.clients.removeByValue(ps);
			System.out.println(Server.clients.size());
			try
			{
				if(br != null)
				{
					br.close();
				}
				if(ps != null)
				{
					ps.close();
				}
				if(socket != null)
				{
					socket.close();
				}
			}
			catch(IOException ex)
			{
				ex.printStackTrace();
			}
		}
	}

	public String getReaLMsg(String line)
	{
		return line.substring(YeekuProtocol.PROTOCOL_LEN, line.length() - YeekuProtocol.PROTOCOL_LEN);
	}


	/*private Socket s = null;
	BufferedReader br = null;
	public ServerThread(Socket s) throws Exception
	{
		this.s = s;
		this.br = new BufferedReader(new InputStreamReader(s.getInputStream()));
	}
	@Override
	public void run()
	{
		try
		{
			String content = null;
			while((content = readFromClient()) != null)
			{
				for (Socket s : MyServer.socketList) {
					PrintStream ps = new PrintStream(s.getOutputStream());
					ps.println(content);
				}
			}
		}
		catch(IOException e)
		{

		}
	}

	private String readFromClient()
	{
		try
		{
			return br.readLine();
		}
		catch(IOException e)
		{
			MyServer.socketList.remove(s);
		}
		return null;
	}*/
}