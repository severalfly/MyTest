package com.leon.artofpattern.observer.java;

import java.util.Observable;

public class ContreteObserable extends Observable
{
	// 仅仅一个数据而已，用于标志目标是否变化，也可以用其他任何对象表示
	private String data = "";

	public String getData()
	{
		return this.data;
	}

	public void setData(String data)
	{
		if (!this.data.equalsIgnoreCase(data))
		{
			this.data = data;
			setChanged();
			notifyObservers();
		}
	}

}
