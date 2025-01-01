package com.bankapplication.service;

import com.bankapplication.dto.response.ResponseTransactionDto;
import com.bankapplication.model.Transactions;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TransactionService {
    
    public void createNewTransaction(Transactions transactions);

    public List<ResponseTransactionDto> getTransactionHistory(String accountNo);
}
