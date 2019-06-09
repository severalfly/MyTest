package leon;
import java.net.*;
import java.io.*;

public class Client
{
	public static void main(String[] args) throws IOException{
		Socket socket = new Socket("127.0.0.1", 30000);
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		String line = br.readLine();
		System.out.println("message from the server: " + line);
		br.close();
		socket.close();
	}
}