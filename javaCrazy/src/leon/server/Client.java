package leon.server;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;
public class Client
{
	private static final int SERVER_PORT = 30000;
	private Socket socket;
	private PrintStream ps ;
	private BufferedReader brServer;
	private BufferedReader keyIn;

	public void init()
	{
		try
		{
			keyIn = new BufferedReader(new InputStreamReader(System.in));
			socket = new Socket("127.0.0.1",SERVER_PORT);
			ps = new PrintStream(socket.getOutputStream());
			brServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String tip = "";
			while(true)
			{
				String userName = JOptionPane.showInputDialog(tip + "please input username");
				ps.println(YeekuProtocol.USER_ROUND + userName + YeekuProtocol.USER_ROUND);
				String result = brServer.readLine();
				if(result.equals(YeekuProtocol.NAME_REP))
				{
					tip = "username repeated";
					continue;
				}
				if(result.equals(YeekuProtocol.LOGIN_SUCCESS))
				{
					break;
				}
			}
		}
		catch(UnknownHostException ex)
		{
			System.out.println("cannt find remote server, please comfirm the server is running!!!");
			closeRs();
			System.exit(1);
		}
		catch (IOException e)
		{
			System.out.println("network exception, please relogin!!!");
			closeRs();
			System.exit(1);
		}
		new ClientThread(brServer).start();
	}

	private void readAndSend()
	{
		try
		{
			String line = null;
			while((line = keyIn.readLine()) != null)
			{
				if(line.indexOf(":") > 0 && line.startsWith("//"))
				{
					line = line.substring(2);
					ps.println(YeekuProtocol.PRIVATE_ROUND + line.split(":")[0] + YeekuProtocol.SPLIT_SIGN + line.split(":")[1] + YeekuProtocol.PRIVATE_ROUND);

				}
				else
				{
					ps.println(YeekuProtocol.MSG_ROUND + line + YeekuProtocol.MSG_ROUND);
				}
			}
		}
		catch (IOException e)
		{
			System.out.println("network error, please relogin!!!");
			closeRs();
			System.exit(1);
		}
	}

	private void closeRs()
	{
		try
		{
			if(keyIn != null)
			{
				keyIn.close();
			}
			if(brServer != null)
			{
				brServer.close();
			}
			if(ps != null)
			{
				ps.close();
			}
			if(socket != null)
			{
				keyIn.close();
			}
		}
		catch(IOException ex)
		{
		}
	}

	public static void main(String[] args) {
		Client client = new Client();
		client.init();
		client.readAndSend();
	}



	/*public static void main(String[] args) throws IOException{
		Socket s = new Socket("127.0.0.1", 30000);
		BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
		String line = br.readLine();
		System.out.println("the message come from server: " + line);
		br.close();
		s.close();
	}*/
}