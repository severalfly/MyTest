package com.leon.mediator;

public class UnitNationsSecurityCouncil extends UnitNations
{
	private Country Usa;
	private Country Iraq;

	public Country getUsa()
	{
		return this.Usa;
	}

	public void setUsa(Country usa)
	{
		Usa = usa;
	}

	public Country getIraq()
	{
		return this.Iraq;
	}

	public void setIraq(Country iraq)
	{
		Iraq = iraq;
	}

	@Override
	public void sendMsg(String msg, Country cty)
	{
		if (cty == this.Usa)
		{
			this.Iraq.getmsg(msg);
		}
		else
		{
			this.Usa.getmsg(msg);;
		}
	}

}
