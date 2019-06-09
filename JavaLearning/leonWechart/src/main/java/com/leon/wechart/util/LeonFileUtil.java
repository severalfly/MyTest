package com.leon.wechart.util;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LeonFileUtil
{
	private static Logger logger = LoggerFactory.getLogger(LeonFileUtil.class);

	/**
	 * 关闭流
	 * @param closes 
	 * @throws IOException
	 */
	public static void closeStream(Closeable... closes)
	{
		for (Closeable clo : closes)
		{
			if (clo != null)
			{
				try
				{
					clo.close();
				}
				catch (Exception e)
				{
					logger.error("", e);
				}
			}
		}
	}

	/**
	 * 从输入流中读取字节
	 * @param inStream 输入流
	 * @param k 缓冲区初始大小 K
	 */
	public static byte[] input2byte(InputStream inStream, int k) throws IOException
	{
		ByteBuffer buffer = ByteBuffer.allocate(k * 1024);
		// 逐个字节读取
		int bt = inStream.read();
		while (bt != -1)
		{
			if (!buffer.hasRemaining())
			{
				// 没有空间则要进行再创建，每次扩充一倍
				ByteBuffer createBuffer = ByteBuffer.allocate(buffer.capacity() * 2);
				// 先将原缓冲区指针指到开始的位置
				buffer.rewind();
				// 拷贝到新的缓冲区
				createBuffer.put(buffer);
				buffer = createBuffer;
			}
			buffer.put((byte) bt);
			bt = inStream.read();
		}

		// 反转将多余的空间设置成无用
		buffer.flip();
		byte[] bs = new byte[buffer.limit()];
		System.arraycopy(buffer.array(), 0, bs, 0, buffer.limit());

		return bs;
	}

}
