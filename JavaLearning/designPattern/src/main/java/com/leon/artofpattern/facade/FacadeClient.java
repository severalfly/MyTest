package com.leon.artofpattern.facade;

public class FacadeClient
{
	public static void main(String[] args)
	{
		EncryptFacade ef = new EncryptFacade();
		ef.fileEncrypt("srcFile", "descFile");
	}
}
