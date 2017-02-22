package com.wiley.beginningspring.ch2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class AccountDaoInMemoryImpl implements AccountDao
{
	private Map<Long, Account> accountsMap = new HashMap<Long, Account>();
	{
		Account a1 = new Account();
		a1.setId(1L);
		a1.setOwnerName("John");
		a1.setBalance(10.0);

		Account a2 = new Account();
		a2.setId(2L);
		a2.setOwnerName("Mary");
		a2.setBalance(20.0);

		accountsMap.put(a1.getId(), a1);
		accountsMap.put(a2.getId(), a2);
	}

	public void insert(Account account)
	{
		accountsMap.put(account.getId(), account);
	}

	public Account find(long accountId)
	{
		return accountsMap.get(accountId);
	}

	public void update(Account account)
	{
		// TODO Auto-generated method stub

	}

	public void update(List<Account> accounts)
	{
		// TODO Auto-generated method stub

	}

	public void delete(long accountId)
	{
		// TODO Auto-generated method stub

	}

	public List<Account> find(List<Long> accountIds)
	{
		// TODO Auto-generated method stub
		return null;
	}

	public List<Account> find(String ownerName)
	{
		// TODO Auto-generated method stub
		return null;
	}

	public List<Account> find(boolean locked)
	{
		// TODO Auto-generated method stub
		return null;
	}
}