package com.bankapplication.repository;

import com.bankapplication.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Integer> {

    /**
     * this query is responsible for checking whether given acc no is exist or not
     *
     * @param accountno
     * @return
     */
    @Query("select case when count(a) > 0 then true else false end from Account a where a.accountNumber = :accountNumber ")
    public boolean existsByAccountNumber(@Param("accountNumber") String accountno);


    /**
     * this query is responsible for fetching the list of account with given id
     *
     * @param id
     * @return
     */
    @Query("select a from Account a where a.userDetails.id = :id AND a.accountStatus = true ")
    public List<Account> findByUserId(@Param("id") int id);

    @Query("select a from Account a where a.accountNumber = :accountno ")
    public Account findByAccountNumber(@Param("accountno") String accountno);


    @Query("SELECT a FROM Account a WHERE a.accountStatus = :status")
    public List<Account> findAccountByStatusDisabled(@Param("status") Boolean status);

}
