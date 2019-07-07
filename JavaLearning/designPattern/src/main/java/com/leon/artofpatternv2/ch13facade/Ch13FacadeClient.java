package com.leon.artofpatternv2.ch13facade;

import java.util.Date;

public class Ch13FacadeClient
{
	public static void main(String[] args)
	{
		EncryptFacade encryptFacade = new EncryptFacade();
		encryptFacade.fileEncrypt("srcFileName", "destFileName");
	}
}

class EncryptFacade
{
	private FileReader fileReader;
	private CipherMachine cipherMachine;
	private FileWriter fileWriter;

	public EncryptFacade()
	{
		this.fileReader = new FileReader();
		this.cipherMachine = new CipherMachine();
		this.fileWriter = new FileWriter();
	}

	public void fileEncrypt(String srcFileName, String destFileName)
	{
		String read = this.fileReader.read(srcFileName);
		String encrpyt = this.cipherMachine.encrpyt(read);
		this.fileWriter.write(encrpyt, destFileName);

	}
}

class FileReader
{
	public String read(String fileName)
	{
		System.out.println(this.getClass().getSimpleName() + " is reading file " + fileName);
		return new Date().toString();
	}
}

class CipherMachine
{
	public String encrpyt(String plainText)
	{
		System.out.println(this.getClass().getSimpleName() + " is encrpyting text: " + plainText);
		return "enc-" + plainText;
	}
}

class FileWriter
{
	public void write(String encrpytStr, String destFileName)
	{
		System.out.println(this.getClass().getSimpleName() + " is saving encrpytStr: " + encrpytStr + " to  " + destFileName);

	}
}
