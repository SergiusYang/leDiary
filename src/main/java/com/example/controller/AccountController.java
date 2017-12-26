package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Account;
import com.example.service.IAccountService;

@RestController
public class AccountController {

	@Autowired
	private IAccountService accountService;
	
	@RequestMapping(value="/index")
	public String test(){
		return "success";
	}
	
	@RequestMapping(value="/api/list",method=RequestMethod.GET)
	public List<Account> getAccountList(){
		return accountService.getList();
	}
	
	@RequestMapping(value="/api/account/{id}",method=RequestMethod.POST)
	public Account getAccountById(@PathVariable("id") Integer id){
		return accountService.getAccountById(id);
	}
	
	@RequestMapping(value="/api/save",method=RequestMethod.POST)
	public Account saveAccount(@RequestBody Account account){
		accountService.saveAcount(account);
		return account;
	}
	
}
