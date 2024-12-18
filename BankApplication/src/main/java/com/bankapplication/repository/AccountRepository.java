package com.bankapplication.repository;

import com.bankapplication.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AccountRepository extends JpaRepository<Account,Integer> {
    
    @Query("select case when count(a) > 0 then true else false end from Account a where a.accountNumber = :accountNumber ")
   public boolean existsByAccountNumber(@Param("accountNumber") String accountno);
    
}
