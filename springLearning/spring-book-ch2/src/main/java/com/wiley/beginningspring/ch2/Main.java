package com.wiley.beginningspring.ch2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main
{
	public static void main(String[] args)
	{
		//		//		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Ch2BeanConfiguration.class);
		//		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("/com/wiley/beginningspring/ch2/ch2-beans.xml");
		//		AccountService accountService = applicationContext.getBean("accountService", AccountService.class);
		//		
		//		System.out.println("Before money transfre");
		//		System.out.println("Account 1 balance: " + accountService.getAccount(1).getBalance());
		//		System.out.println("Account 2 balance: " + accountService.getAccount(2).getBalance());
		//		
		//		accountService.transferMoney(1, 2, 5.0);
		//		
		//		System.out.println("After money transfre");
		//		System.out.println("Account 1 balance: " + accountService.getAccount(1).getBalance());
		//		System.out.println("Account 2 balance: " + accountService.getAccount(2).getBalance());
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Configuration2.class, Configuration1.class);
		Foo foo = applicationContext.getBean(Foo.class);
		System.out.println(foo.getName());
	}
}
