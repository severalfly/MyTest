package com.leon.artofpattern.observer;

public class ConcreteAllyControlCenter extends AllyControlCenter
{

	public ConcreteAllyControlCenter(String allyName)
	{
		this.allyName = allyName;
		System.out.println(this.allyName + " constacted");
		System.out.println("---------------");
	}

	@Override
	public void notifyObserver(String name)
	{
		System.out.println(this.allyName + "紧急通知: 盟友" + name + " has be attacked");
		for (Observer obs : this.players)
		{
			if (!obs.getName().equalsIgnoreCase(name))
			{
				obs.help();
			}
		}
	}

}
