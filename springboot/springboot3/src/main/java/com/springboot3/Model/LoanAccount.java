package com.springboot3.Model;




public class LoanAccount implements Account {

	@Override
	public String getDetails() {
		return "loan account";
	}
	
	LoanAccount(){
		System.out.println("loan account");
	}

}
