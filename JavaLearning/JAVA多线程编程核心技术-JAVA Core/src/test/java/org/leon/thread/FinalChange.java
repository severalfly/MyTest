package org.leon.thread;

public class FinalChange
{
	public static void main(String[] args)
	{
		FinalChangeObject obj = new FinalChangeObject();
		obj.setC(1);

		final FinalChangeObject t = obj;
		obj.setC(2);
		System.out.println(t.getC());

		FinalChangeObject obj2 = new FinalChangeObject();
		//		t = obj2;  //  这里就会报错，t 已经初始化引用到obj了，不能再改变其引用
		// 但是：对象的值是可以修改的，如上面的 obj.setC(2);
	}
}

class FinalChangeObject
{
	private int c;

	public int getC()
	{
		return c;
	}

	public void setC(int c)
	{
		this.c = c;
	}

}