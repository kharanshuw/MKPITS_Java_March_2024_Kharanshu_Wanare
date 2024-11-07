package com.springboot3.Model;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class SavingAccount implements Account{
	

	@Override
	public String getDetails() {
		// TODO Auto-generated method stub
		return "this is saving account";
	}
	
	
	SavingAccount(){
		System.out.println("saving consttructor");
	}
	
	
}
