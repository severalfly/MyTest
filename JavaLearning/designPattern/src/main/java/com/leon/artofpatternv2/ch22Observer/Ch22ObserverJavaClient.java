package com.leon.artofpatternv2.ch22Observer;

import com.alibaba.fastjson.JSONObject;

import java.util.Observable;
import java.util.Observer;

/**
 * 使用JAVA 本身的观察者模式实现
 */
public class Ch22ObserverJavaClient
{
	public static void main(String[] args)
	{
		ConcreteAlly observable = new ConcreteAlly(); // new 一个红绿灯
		observable.addObserver(new PlayerJava("a")); // 司机 a 观察红绿灯
		observable.addObserver(new PlayerJava("b")); // 司机 b 观察红绿灯
		observable.change(); // 红绿灯状态变化了

	}
}

/**
 * 观察者类，汽车司机
 */
class PlayerJava implements Observer
{
	private String name;

	public PlayerJava(String name)
	{
		this.name = name;
	}

	@Override
	public void update(Observable o, Object arg)
	{
		System.out.println(this.getClass().getSimpleName() + "  " + this.name + " 收到通知 " + JSONObject.toJSONString(arg));
	}
}

/**
 * 目标类，红绿灯
 */
class ConcreteAlly extends Observable
{
	public void change()
	{
		setChanged();
		this.notifyObservers(1);
	}
}
