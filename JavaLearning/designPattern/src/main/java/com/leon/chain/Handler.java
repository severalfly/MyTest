package com.leon.chain;

public abstract class Handler
{
	protected Handler successor;

	public Handler getSuccessor()
	{
		return this.successor;
	}

	public void setSuccessor(Handler successor)
	{
		this.successor = successor;
	}

	public abstract void handleRequest(int request);

}
