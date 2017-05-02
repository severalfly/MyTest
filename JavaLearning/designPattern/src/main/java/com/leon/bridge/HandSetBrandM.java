package com.leon.bridge;

public class HandSetBrandM extends HandSetBrand
{

	public HandSetBrandM(HandsetSoft soft)
	{
		super(soft);
	}

	@Override
	public void running()
	{
		this.soft.running();
	}

}
