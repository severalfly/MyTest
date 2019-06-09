package leon;
public class FirstThread extends Thread
{
	private int i;
	@Override
	public void run()
	{
		for(;i < 10; ++i)
		{
			System.out.println(getName() + " " + i);
		}
	}
	public static void main(String[] args) {
		// new FirstThread.start();
		for (int i = 0; i<10; i++) {
			System.out.println(Thread.currentThread().getName() + " " + i);
			if(i == 2)
			{
				new FirstThread().start();
				new FirstThread().start();
				new FirstThread().start();
				new FirstThread().start();
			}
		}
	}
}