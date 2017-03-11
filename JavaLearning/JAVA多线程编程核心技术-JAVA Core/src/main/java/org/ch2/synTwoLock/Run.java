package org.ch2.synTwoLock;

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

		CThread c = new CThread(serivce);
		c.setName("C");
		c.start();
	}
	/**线程名称： A 在 1489216191567 进入printA
	线程名称： C 在 1489216191567 进入printC
	线程名称： A 在 1489216194581 离开printA
	线程名称： C 在 1489216194581 离开printC
	线程名称： B 在 1489216194581 进入printB
	线程名称： B 在 1489216194581 离开printB
	*/
	// 可以看出AB对象是同步的，与C 是不同步，原因就是：
	// 静态方法拥有的锁为类的，还静态方法拥有的锁为对象的，
	// 这样，这个例子中就有两个锁了
	// synchonized 静态方法与 synchonized(Class.class) 性质相同，都是对
	// 类的同步
}
