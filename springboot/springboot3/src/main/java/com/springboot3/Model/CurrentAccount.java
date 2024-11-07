package com.springboot3.Model;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class CurrentAccount implements Account {

	@Override
	public String getDetails() {
		return "current account";
	}

	public CurrentAccount() {
		System.out.println("currentaccount constructor");
	}
}
