package org.ch2.stringAndSyn;

public class Run
{
	public static void main(String[] args)
	{
		Service serivce = new Service();
		AThread a = new AThread(serivce);
		a.setName("A");
		a.start();

		BThread b = new BThread(serivce);
		b.setName("B");
		b.start();
	}

	// String 常量池会保持锁，
	// 从Athread && BThread 代码可以看出，两个线程拥有相同锁，所以会造成B 不能执行

}
