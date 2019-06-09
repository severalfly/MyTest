package org.ch3.pipeInputOutput;

import java.io.PipedInputStream;

public class ReadData
{
	public void readData(PipedInputStream input)
	{
		try
		{
			System.out.println("read: ");
			byte[] bytes = new byte[20];
			int readLength = input.read(bytes);
			while (readLength != -1)
			{
				String newData = new String(bytes);
				System.out.println(newData);
				readLength = input.read(bytes);
			}
			System.out.println();
			input.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
