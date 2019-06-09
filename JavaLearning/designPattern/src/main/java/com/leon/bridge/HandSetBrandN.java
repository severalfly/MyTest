package com.leon.bridge;

public class HandSetBrandN extends HandSetBrand
{

	public HandSetBrandN(HandsetSoft soft)
	{
		super(soft);
	}

	@Override
	public void running()
	{
		this.soft.running();
	}

}
