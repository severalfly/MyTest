package com.leon.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWrite
{
	public int in;

	public static void main(String[] args) throws IOException
	{
		FileInputStream fin = new FileInputStream(new File("./readandshow.txt"));
		FileChannel fc = fin.getChannel();
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		fc.read(buffer);
		byte[] b = buffer.array();
		System.out.println(new String(b));
		System.out.println(new String(buffer.array()));
		fin.close();
	}

	public int getIn()
	{
		List<String> s = new ArrayList<>();
		return this.in;
	}

	public void setIn(int in)
	{
		this.in = in;
	}

}
