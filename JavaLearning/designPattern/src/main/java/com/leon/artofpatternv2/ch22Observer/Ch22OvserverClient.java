package com.leon.artofpatternv2.ch22Observer;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class Ch22OvserverClient
{
	public static void main(String[] args)
	{
		ConcreteAllyControlCenter center = new ConcreteAllyControlCenter("金庸群侠传");

		Observer p1 = new Player("杨过");
		center.join(p1);
		Observer p2 = new Player("令狐冲");
		center.join(p2);
		Observer p3 = new Player("张无忌");
		center.join(p3);
		Observer p4 = new Player("段誉");
		center.join(p4);

		p2.beAttacked(center);
	}
}

/**
 * 抽象观察类
 */
interface Observer
{
	public String getName();

	public void setName(String name);

	public void help();

	// 声明遭受攻击的方法
	public void beAttacked(AllControlCenter center);
}

class Player implements Observer
{
	private String name;

	public Player(String name)
	{
		this.name = name;
	}

	@Override
	public String getName()
	{
		return this.name;
	}

	@Override
	public void setName(String name)
	{
		this.name = name;
	}

	@Override
	public void help()
	{
		System.out.println("坚持住，" + this.name + "来救你！");
	}

	@Override
	public void beAttacked(AllControlCenter center)
	{
		System.out.println(this.name + "被攻击!");
		center.notifyObserver(this.name);

	}
}

@Setter
@Getter
abstract class AllControlCenter
{
	protected String allyName;
	protected List<Observer> players = new ArrayList<>();

	public void join(Observer obs)
	{
		System.out.println(obs.getName() + " 加入 " + this.allyName + " 战队！");
		this.players.add(obs);
	}

	public void quit(Observer obs)
	{
		System.out.println(obs.getName() + " 退出 " + this.allyName + " 战队！");
	}

	public abstract void notifyObserver(String name);
}

class ConcreteAllyControlCenter extends AllControlCenter
{
	public ConcreteAllyControlCenter(String allyName)
	{
		System.out.println(allyName + "战队组建成功!");
		System.out.println("-------");
		this.allyName = allyName;
	}

	@Override
	public void notifyObserver(String name)
	{
		System.out.println(this.allyName + "战队紧急通知，盟友" + name + "遭受敌人攻击！");
		for (Observer obs : players)
		{
			if(!obs.getName().equalsIgnoreCase(name))
			obs.help();
		}
	}
}


