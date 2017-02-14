package com.wiley.beginningspring.ch2;

import java.util.Map;
import java.util.HashMap;


public class AccountDaoInMemoryImpl implements AccountDao
{
	private Map<Long, Account> accountsMap = new HashMap<Long, Account>();
	{
		Account a1 = new Account();
		a1.setId(1L);
		a1.setOwnerName("john");
		a1.setBalance(10.0);

		Account a2 = new Account();
		a2.setId(2L);
		a2.setOwnerName("Marry");
		a2.setBalance(20.0);

		accountsMap.put(a1.getId(), a1);
		accountsMap.put(a2.getId(), a2);
	}

	@Override
	public void update(Account account)
	{
		accountsMap.put(account.getId(), account);
	}

	@Override
	public Account find(long accountId)
	{
		return accountsMap.get(accountId);
	}
}