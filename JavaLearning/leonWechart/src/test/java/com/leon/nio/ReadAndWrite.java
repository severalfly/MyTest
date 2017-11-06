package com.leon.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ReadAndWrite
{
	public static void main(String[] args) throws IOException
	{
		FileInputStream fin = new FileInputStream(new File("./readandshow.txt"));
		FileChannel fc = fin.getChannel();
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		fc.read(buffer);
		System.out.println(new String(buffer.array()));
		fin.close();
	}
}
