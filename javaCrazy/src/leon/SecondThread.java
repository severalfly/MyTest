package leon;
public class SecondThread implements Runnable
{
	private int i;
	public void run()
	{
		for (; i< 10; ++i) {
			System.out.println(Thread.currentThread().getName() + " " + i);
		}
	}

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + " " + i);
			if(i==2)
			{
				SecondThread st = new SecondThread();
				new Thread(st).start();
				new Thread(st).start();
			}
		}
	}
}