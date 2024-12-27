package com.bankapplication.service;

import com.bankapplication.dto.request.RequestAccountDto;
import com.bankapplication.dto.response.ResponseAccountDto;
import com.bankapplication.model.Account;
import com.bankapplication.model.Users;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface AccountService {

    public Users getUserByEmail(String email);

    public List<String> getNonExistingAccount(Users users);

    public Account saveNewAccount(RequestAccountDto requestAccountDto);

    public ResponseAccountDto getAccountDetailsByAccountNumber(String accountNo);

    public void deleteAccountByAccountNumber(String accountNumber );

}
