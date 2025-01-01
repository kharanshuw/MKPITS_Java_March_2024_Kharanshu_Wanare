package com.bankapplication.repository;

import com.bankapplication.model.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface  TransactionRepository extends JpaRepository<Transactions, Integer> {
    
    @Query("select t from Transactions t where t.account.accountNumber = :accountNumber")
    public List<Transactions> findTransactionsByAccountNumber(@Param("accountNumber") String accountNumber);
}
