package com.leon.bridge;

public class BridgeMain
{
	public static void main(String[] args)
	{
		HandSetBrand brand = new HandSetBrandM(new HandSetGame());
		brand.running();

		brand.setSoft(new HandSetAddressList());
		brand.running();
	}
}
