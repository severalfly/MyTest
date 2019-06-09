package org.ch3.pipeInputOutput;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class Runn
{
	public static void main(String[] args)
	{
		try
		{
			WriteData write = new WriteData();
			ReadData read = new ReadData();

			PipedInputStream input = new PipedInputStream();
			PipedOutputStream out = new PipedOutputStream();
			out.connect(input);

			ThreadRead threadRead = new ThreadRead(read, input);
			threadRead.start();

			Thread.sleep(2000);

			ThreadWrite threadWrite = new ThreadWrite(write, out);
			threadWrite.start();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
