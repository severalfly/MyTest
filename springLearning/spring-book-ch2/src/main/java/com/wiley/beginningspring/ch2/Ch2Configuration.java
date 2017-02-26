package com.wiley.beginningspring.ch2;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Ch2Configuration
{
	@Bean
	public AccountDao accountDaoJdbc()
	{
		AccountDaoJdbcImpl bean = new AccountDaoJdbcImpl();
		return bean;
	}

	@Bean(autowire = Autowire.BY_NAME)
	public AccountService accountService()
	{
		AccountServiceImpl bean = new AccountServiceImpl();
		return bean;
	}
}
