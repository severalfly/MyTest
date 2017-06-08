package com.leon.artofpattern.facade.exercise;

public class ExerciseFacade
{
	private AddressManager address;
	private SmsManager sms;

	public ExerciseFacade()
	{
		this.address = new AddressManager("lu");
		this.sms = new SmsManager("huo");
	}

	public void copy()
	{
		this.address.copy();
		this.sms.copy();
	}
}
