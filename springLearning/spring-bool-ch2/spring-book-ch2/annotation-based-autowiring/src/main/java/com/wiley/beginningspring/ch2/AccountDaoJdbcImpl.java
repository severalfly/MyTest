package com.wiley.beginningspring.ch2;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class AccountDaoJdbcImpl implements AccountDao {

	@Override
	public void insert(Account account) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Account account) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(List<Account> accounts) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(long accountId) {
		// TODO Auto-generated method stub

	}

	@Override
	public Account find(long accountId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Account> find(List<Long> accountIds) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Account> find(String ownerName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Account> find(boolean locked) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
