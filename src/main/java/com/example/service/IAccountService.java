package com.example.service;

import java.util.List;

import com.example.model.Account;

public interface IAccountService {
	
	List<Account> getList();
	
	Account getAccountById(Integer id);
	
	Account saveAcount(Account account);
	
}
