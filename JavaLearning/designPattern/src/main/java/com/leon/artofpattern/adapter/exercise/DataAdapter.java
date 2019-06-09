package com.leon.artofpattern.adapter.exercise;

public class DataAdapter implements DataEncrypt
{
	private InnerEncrypt innerEncrypt;

	public DataAdapter()
	{
		this.innerEncrypt = new InnerEncrypt();
	}
	@Override
	public String mdSelf(String data)
	{
		return this.innerEncrypt.innerEncrypt(data);
	}

}
