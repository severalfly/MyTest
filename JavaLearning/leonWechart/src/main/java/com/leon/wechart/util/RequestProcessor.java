package com.leon.wechart.util;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.nio.ByteBuffer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * HTTP/HTTPS请求处理类
 * 
 */
public class RequestProcessor
{

	private static Logger logger = LoggerFactory.getLogger(RequestProcessor.class);


	/**
	 * 从请求中读取数据并以字符串形式反回
	 * 
	 * @param conn
	 *            连接
	 * @param charset
	 *            编码
	 * @return 数据
	 * @throws Exception
	 */
	public static String readStringContent(HttpURLConnection conn, String charset) throws Exception
	{
		InputStream input = conn.getInputStream();
		String str = readStringContent(input, charset);
		input.close();
		conn.disconnect();
		return str;
	}

	public static String readStringContent(InputStream input, String charset) throws Exception
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(input, charset));
		String line = null;
		StringBuffer sb = new StringBuffer();
		while ((line = reader.readLine()) != null)
		{
			sb.append(line).append("\r\n");
		}
		if (reader != null)
		{
			reader.close();
		}
		return sb.toString();
	}

	/**
	 * 从请求中读取数据并以字节形式反回
	 * 
	 * @param conn
	 *            连接
	 * @param charset
	 *            编码
	 * @return 数据
	 * @throws Exception
	 */
	public static ByteArrayInputStream readStreamContent(HttpURLConnection conn, String charset) throws Exception
	{
		InputStream input = conn.getInputStream();
		ByteBuffer buffer = ByteBuffer.allocate(4 * 1024);
		// 逐个字节读取
		int bt = input.read();
		while (bt != -1)
		{
			// 如果此缓冲区还有空间则往后添加
			if (buffer.hasRemaining())
			{
				buffer.put((byte) bt);
			}
			else
			{
				// 没有空间则要进行再创建，每次扩充一倍
				ByteBuffer createBuffer = ByteBuffer.allocate(buffer.capacity() * 2);
				// 先将原缓冲区指针指到开始的位置
				buffer.rewind();
				// 拷贝到新的缓冲区
				createBuffer.put(buffer);
				buffer = createBuffer;
			}
			bt = input.read();
		}
		if (conn != null)
		{
			conn.disconnect();
		}
		// 反转将多余的空间设置成无用
		buffer.flip();
		byte[] bs = new byte[buffer.limit()];
		System.arraycopy(buffer.array(), 0, bs, 0, buffer.limit());
		// 创建一个输入流
		ByteArrayInputStream byteInputStream = new ByteArrayInputStream(bs);
		return byteInputStream;
	}

}
