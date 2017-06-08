package com.leon.artofpattern.facade;

// 外观类
public class EncryptFacade
{
	private FileReader reader;
	private CipherMachine cipher;
	private FileWriter writer;

	public EncryptFacade()
	{
		this.reader = new FileReader();
		this.cipher = new CipherMachine();
		this.writer = new FileWriter();
	}

	public void fileEncrypt(String srcFileName, String desFileName)
	{
		String plainText = this.reader.read(srcFileName);
		String encryptStr = this.cipher.encrypt(plainText);
		this.writer.write(encryptStr, desFileName);
	}

}
