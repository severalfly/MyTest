package leon;
import java.net.*;
import java.io.*;
public class MultiDown 
{
	public static void main(String[] args)
	{
		final int DOWN_THREAD_NUM = 4;
		final String OUT_FILE_NAME = "down.jpg";
		InputStream[] isArr = new InputStream[DOWN_THREAD_NUM];
		RandomAccessFile[] outArr = new RandomAccessFile[DOWN_THREAD_NUM];
		try
		{
			URL url = new URL("http://www.guan5.com/uploads/allimg/140814/17171_140814171439_1.jpg");
			isArr[0] = url.openStream();
			long fileLen = getFileLength(url);
			System.out.println("the length of remote file is: " + fileLen);
			outArr[0] = new RandomAccessFile(OUT_FILE_NAME, "rw");
			for (int i = 0; i< fileLen; i++) {
				outArr[0].write(0);
			}
			long numPerThread = fileLen / DOWN_THREAD_NUM;
			long left = fileLen % DOWN_THREAD_NUM;
			for (int i = 0; i< DOWN_THREAD_NUM; i ++) {
				if(i != 0)
				{
					isArr[i] = url.openStream();
					outArr[i] = new RandomAccessFile(OUT_FILE_NAME, "rw");
				}
				if(i == DOWN_THREAD_NUM -1)
				{
					new DownThread(i * numPerThread, (i + 1) * numPerThread + left, isArr[i], outArr[i]).start();
				}
				else
				{
					new DownThread(i * numPerThread, (i + 1) * numPerThread, isArr[i] , outArr[i]).start();
				}
			}


		}
		catch (Exception e)
		{	
			e.printStackTrace();
		}	
		finally
		{

		}
	}


	public static long getFileLength(URL url) throws Exception
	{
		long length = 0;
		URLConnection conn = url.openConnection();

		long size = conn.getContentLength();
		length = size;
		return length;
	}
}
class DownThread extends Thread
{
	private final int BUFF_LEN = 32;
	private long start ;
	private long end;
	private InputStream is;
	private RandomAccessFile raf;

	public DownThread(long start, long end, InputStream is, RandomAccessFile raf)
	{
		System.out.println(start + "--->" + end);
		this.start = start;
		this.end = end;
		this.is = is;
		this.raf = raf;
	}
	@Override
	public void run()
	{
		try
		{
			is.skip(start);
			raf.seek(start);
			byte[] buff = new byte[BUFF_LEN];
			long contentLen = start - end;
			long times = contentLen / BUFF_LEN + 4;
			int hasRead = 0;
			for (int i=0; i < times; i ++) {
				hasRead = is.read(buff);
				if(hasRead < 0)
				{
					break;
				}
				raf.write(buff, 0, hasRead);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(is != null)
				{
					is.close();
				}
				if(raf != null)
				{
					raf.close();
				}
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}
	}
}