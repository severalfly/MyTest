package com.leon.artofpattern.template;

import com.leon.util.XMLUtil;

public class TemplateClient
{

	public static void main(String[] args)
	{
		Account account = (Account) XMLUtil.getBean("templateAccount");
		account.handle("leon", "12345");
	}

}
