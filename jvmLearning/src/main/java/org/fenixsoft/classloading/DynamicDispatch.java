package org.fenixsoft.classloading;


public class DynamicDispatch
{
	static abstract class Human
	{
		protected abstract void sayHello();
	}

	static class Man extends Human
	{
		@Override
		protected void sayHello()
		{
			System.out.println("man say hello!");
		}
	}

	static class Woman extends Human
	{
		@Override
		protected void sayHello()
		{
			System.out.println("woman say hello!");
		}
	}

	/**
	 * 动态调用的好例子，可查看javap -verbose 看出区别
	 * @param args [description]
	 */
	public static void main(String[] args) {
		Human man = new Man();
		Human woman = new Woman();
		man.sayHello();
		woman.sayHello();
		man = new Woman();
		man.sayHello();
	}

}