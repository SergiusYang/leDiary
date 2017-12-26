package com.example.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Service;

import com.example.model.Account;
import com.example.service.IAccountService;

@Service
public class AccountServiceImpl implements IAccountService{
	
	private ConcurrentHashMap<Integer, Account> accountMap = new ConcurrentHashMap<Integer,Account>();
	
	private AtomicInteger idGenerator = new AtomicInteger(0);

	@Override
	public List<Account> getList() {
		if(accountMap == null){
			return null;
		}else{
			List<Account> result = new ArrayList<Account>();
			result.addAll(accountMap.values());
			return result;
		}
		
	}

	@Override
	public Account getAccountById(Integer id) {
		if(id != null){
			return accountMap.get(id);
		}
		return null;
	}

	@Override
	public Account saveAcount(Account account) {
		account.setId(idGenerator.incrementAndGet());
		accountMap.put(account.getId(),account);
		return account;
	}
	
	

}
