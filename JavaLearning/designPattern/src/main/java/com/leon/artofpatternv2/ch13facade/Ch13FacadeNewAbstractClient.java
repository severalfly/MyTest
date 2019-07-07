package com.leon.artofpatternv2.ch13facade;

import com.leon.util.XMLUtil;

import java.util.Date;

public class Ch13FacadeNewAbstractClient
{
	public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException
	{
		String cls = "com.leon.artofpatternv2.ch13facade.EncryptFacade";

		Class c = Class.forName(cls);
		AbstractEncryptFacade encryptFacade = (AbstractEncryptFacade) c.newInstance();;
		encryptFacade.fileEncrypt("srcFileName", "destFileName");
	}
}

abstract class AbstractEncryptFacade
{
	public abstract void fileEncrypt(String srcFileName, String destFileName);
}

class NewEncryptFacade extends AbstractEncryptFacade
{
	private FileReader fileReader;
	private NewCipherMachine cipherMachine;
	private FileWriter fileWriter;

	public NewEncryptFacade()
	{
		this.fileReader = new FileReader();
		this.cipherMachine = new NewCipherMachine();
		this.fileWriter = new FileWriter();
	}

	public void fileEncrypt(String srcFileName, String destFileName)
	{
		String read = this.fileReader.read(srcFileName);
		String encrpyt = this.cipherMachine.encrpyt(read);
		this.fileWriter.write(encrpyt, destFileName);

	}
}

//class FileReader
//{
//	public String read(String fileName)
//	{
//		System.out.println(this.getClass().getSimpleName() + " is reading file " + fileName);
//		return new Date().toString();
//	}
//}

class NewCipherMachine
{
	public String encrpyt(String plainText)
	{
		System.out.println(this.getClass().getSimpleName() + " is encrpyting text: " + plainText);
		return "enc-" + plainText;
	}
}

//class FileWriter
//{
//	public void write(String encrpytStr, String destFileName)
//	{
//		System.out.println(this.getClass().getSimpleName() + " is saving encrpytStr: " + encrpytStr + " to  " + destFileName);
//
//	}
//}
