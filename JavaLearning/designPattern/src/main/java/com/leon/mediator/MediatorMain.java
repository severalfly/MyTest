package com.leon.mediator;

public class MediatorMain
{
	public static void main(String[] args)
	{
		UnitNationsSecurityCouncil unsc = new UnitNationsSecurityCouncil();
		Country c1 = new USA(unsc);
		Country c2 = new Iraq(unsc);

		unsc.setUsa(c1);
		unsc.setIraq(c2);

		c1.declare("开打");
		c2.declare("别打我");

	}
}
