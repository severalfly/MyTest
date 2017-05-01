package com.leon.memento.first;

public class MementoFirstMain
{
	/**
	 * 将所有保存任务放在了Memento 类中
	 * 项目中可以放在内存或者用文件保存下来
	 * @param args
	 */
	public static void main(String[] args)
	{
		Orginator o = new Orginator();
		o.setState("on");
		o.show();

		Caretaker c = new Caretaker();
		c.setMemento(o.createMemento());
		o.setState("off");
		o.show();

		o.setMemento(c.getMemento());
		o.show();
	}
}
