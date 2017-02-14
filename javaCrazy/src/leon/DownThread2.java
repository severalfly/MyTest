package leon;
import java.io.*;
import java.net.*;
public class DownThread2 extends Thread
{
	private final int BUF_LEN = 32;
	private long start;
	private long end;
	private InputStream is;
	private RandomAccessFile raf;

	public DownThread2(long start, long end, InputStream is, RandomAccessFile raf)
	{
		System.out.println(start + "--->" + end);
		this.start = start;
		this.end = end;
		this.is = is;
		this.raf = raf;
	}

	public void run()
	{
		try
		{
			is.skip(start);
			raf.seek(start);
			byte[] buff = new byte[BUF_LEN];
			long contentLen = end - start;
			long times = contentLen/ BUF_LEN + 4;
			int hasRead = 0;
			for (int i = 0; i < times; i++) {
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
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}

}
class MutilDown2
{
	public static void main(String[] args) {
		final int DOWN_THREAD_NUM = 4;
		final String OUT_FILE_NAME = "down.jpg";
		InputStream[] isArr = new InputStream[DOWN_THREAD_NUM];
		RandomAccessFile[] outArr = new RandomAccessFile[DOWN_THREAD_NUM];
		try
		{
			URL url = new URL("http://photo.l99.com/bigger/13/1360207321993_g7zy37.jpg");
			isArr[0] = url.openStream();
			long fileLen = getFileLength(url);
			System.out.println("the length of this file is: " + fileLen);
			outArr[0] =  new RandomAccessFile(OUT_FILE_NAME, "rw");
				// create a empty file with the length of the remote file
			for (int i = 0; i < fileLen; i++) {
				outArr[0].write(0);
			}
			long numPerThread = fileLen / DOWN_THREAD_NUM;
			long left = fileLen % DOWN_THREAD_NUM;
			for(int i = 0; i < DOWN_THREAD_NUM; i ++)
			{
				if(i != 0)
				{
					isArr[i] = url.openStream();
					outArr[i] = new RandomAccessFile(OUT_FILE_NAME,"rw");
				}
				if(i == DOWN_THREAD_NUM -1 )
				{
					new DownThread2(i * numPerThread , (i+1) * numPerThread + left, isArr[i], outArr[i]).start();
				}
				else
				{
					new DownThread2(i * numPerThread , (i+1) * numPerThread, isArr[i], outArr[i]).start();
				}
			}
		}	

		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static long getFileLength(URL url) throws Exception
	{
		long length = 0;
		URLConnection con = url.openConnection();
		long size = con.getContentLength();
		length = size;
		return length;
	}
}