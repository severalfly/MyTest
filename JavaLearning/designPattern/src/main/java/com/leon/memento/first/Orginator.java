package com.leon.memento.first;

public class Orginator
{
	private String state;

	public String getState()
	{
		return state;
	}

	public void setState(String state)
	{
		this.state = state;
	}

	public Memento createMemento()
	{
		return new Memento(this.state);
	}

	public void setMemento(Memento memento)
	{
		this.state = memento.getState();
	}

	public void show()
	{
		System.out.println("State=" + this.state);
	}
}
