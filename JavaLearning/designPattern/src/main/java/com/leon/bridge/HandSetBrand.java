package com.leon.bridge;

public abstract class HandSetBrand
{
	protected HandsetSoft soft;

	public HandSetBrand(HandsetSoft soft)
	{
		super();
		this.soft = soft;
	}

	public abstract void running();

	public HandsetSoft getSoft()
	{
		return soft;
	}

	public void setSoft(HandsetSoft soft)
	{
		this.soft = soft;
	}

}
