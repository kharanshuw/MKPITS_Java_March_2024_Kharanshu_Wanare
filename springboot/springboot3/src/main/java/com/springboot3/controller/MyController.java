package com.springboot3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot3.Model.Account;

@RestController
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class MyController {
	
	Account account1;
	Account account2;
	Account account3;

	/*
	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

*/
	
	public MyController() {
		super();
		
	}

	@Autowired
	public MyController(@Qualifier("savingAccount") Account account,@Qualifier("savingAccount") Account account2,@Qualifier("savingAccount") Account account3) {
		super();
		this.account1 = account;
		this.account2=account2;
		this.account3=account3;
		
	}
	
	@GetMapping("/getdetails1")
	public String getDetails1() {
		return this.account1.getDetails();
	}
	

	@GetMapping("/getdetails2")
	public String getDetails2() {
		return this.account2.getDetails();
	}
	
	@GetMapping("/getdetails3")
	public String getDetails3() {
		return this.account3.getDetails();
	}
	
	
	@GetMapping("/")
	public String test() {
		return "hello";
	}

}
