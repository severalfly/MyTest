package com.leon.generics;

public class Gen<T>
{
	private T obj;

	public T getObj()
	{
		return obj;
	}

	public void setObj(T obj)
	{
		this.obj = obj;
	}

	public Gen(T obj)
	{
		super();
		this.obj = obj;
	}//打印类型

	public void showType()
	{
		System.out.println(obj.getClass().getName());
	}
}

