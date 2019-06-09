package com.leon.artofpattern.chainRespons;

public class PurchaseRequest
{
	private double amount;
	private int number;
	private String purpose;

	public PurchaseRequest(double amount, int number, String purpose)
	{
		super();
		this.amount = amount;
		this.number = number;
		this.purpose = purpose;
	}

	public double getAmount()
	{
		return this.amount;
	}

	public void setAmount(double amount)
	{
		this.amount = amount;
	}

	public int getNumber()
	{
		return this.number;
	}

	public void setNumber(int number)
	{
		this.number = number;
	}

	public String getPurpose()
	{
		return this.purpose;
	}

	public void setPurpose(String purpose)
	{
		this.purpose = purpose;
	}

	@Override
	public String toString()
	{
		StringBuffer sb = new StringBuffer();
		sb.append("采购单");
		sb.append(this.number);
		sb.append(", 金额");
		sb.append(this.amount);
		sb.append("元，采购目的");
		sb.append(this.purpose);
		return sb.toString();
	}

}
