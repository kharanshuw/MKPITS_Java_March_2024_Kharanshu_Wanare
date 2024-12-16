package com.bankapplication.service;

import com.bankapplication.dto.request.RequestAccountDto;
import com.bankapplication.exceptionhandler.BranchNotFountException;
import com.bankapplication.exceptionhandler.UserNotFoundException;
import com.bankapplication.model.*;
import com.bankapplication.repository.AccountTypeRepository;
import com.bankapplication.repository.BranchRepository;
import com.bankapplication.repository.UserDetailsRepository;
import com.bankapplication.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class AccountServiceImpl implements AccountService {

    private static final Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);
    private UserRepository userRepository;

    private AccountTypeRepository accountTypeRepository;

    private BranchRepository branchRepository;

    private UserDetailsRepository userDetailsRepository;

    @Autowired
    public AccountServiceImpl(UserRepository userRepository, AccountTypeRepository accountTypeRepository, BranchRepository branchRepository, UserDetailsRepository userDetailsRepository) {
        this.userRepository = userRepository;
        this.accountTypeRepository = accountTypeRepository;
        this.branchRepository = branchRepository;
        this.userDetailsRepository = userDetailsRepository;
    }


    @Override
    public Users getUserByEmail(String email) {
        Users users = null;
        try {
            users = userRepository.findUserByEmail(email);
            logger.info("User found with email: {}", email);
        } catch (Exception e) {
            logger.error("Error retrieving user by email: {}", email, e);
            System.out.println(e.getMessage());
        }
        return users;
    }

    /**
     * Finds the account types that the user has not yet opened.
     *
     * @param users The user for whom to find the non-existing account types.
     * @return A list of account types that the user has not opened.
     */
    public List<String> getNonExistingAccount(Users users) {
        logger.info("Starting to find non-existing account types for user ID: {}", users.getId());
        // List to hold the types of non existing accounts
        List<String> nonExistingAccount = new ArrayList<>();
        try {

            // Retrieve the set of existing accounts for the user
            Set<Account> existingAccountSet = users.getUserDetails().getAccount();


            // List to hold the types of existing accounts
            List<String> existingAccount = new ArrayList<>();

            // Retrieve all possible account types from the repository
            List<AccountType> allAccountType = accountTypeRepository.findAll();

            List<String> allAccountTypesName = new ArrayList<>();

            // Collect the names of all possible account types
            for (AccountType accountType : allAccountType) {
                allAccountTypesName.add(accountType.getType());
            }

            logger.info("Total number of account types available: {}", allAccountTypesName.size());

            // Log all available account types
            for (String accountTypeName : allAccountTypesName) {
                logger.debug("Available account type: {}", accountTypeName);
            }

            // Collect the names of existing account types for the user
            for (Account account : existingAccountSet) {
                existingAccount.add(account.getAccountType().getType());
            }
            logger.info("Total number of existing accounts for user ID {}: {}", users.getId(), existingAccount.size());

            // Log all existing account types
            for (String accountType : existingAccount) {
                logger.debug("Existing account type for user: {}", accountType);
            }

            // Find and return the non-existing account types
            nonExistingAccount = findElementsInList1ButNotInList2(allAccountTypesName, existingAccount);

        } catch (Exception e) {
            logger.error("An error occurred while finding non-existing account types for user ID {}: {}", users.getId(), e.getMessage());
            throw new RuntimeException(e);
        }


        logger.info("Non-existing account types for user ID {}: {}", users.getId(), nonExistingAccount);
        logger.info("Total number of non-existing account types: {}", nonExistingAccount.size());

        return nonExistingAccount;
    }


    /**
     * Finds elements that are present in list1 but not in list2.
     *
     * @param list1 The first list (source list).
     * @param list2 The second list (comparison list).
     * @return A list of elements present in list1 but not in list2.
     */
    public List<String> findElementsInList1ButNotInList2(List<String> list1, List<String> list2) {
        List<String> resultList = new ArrayList<>(list1);
        resultList.removeAll(list2);
        return resultList;
    }


    public Account saveNewAccount(RequestAccountDto requestAccountDto) {
        Account account = new Account();

        logger.info(" saveNewAccount method of AccountServiceImpl class called ");
        logger.info("requestAccountDto recived is " + requestAccountDto.toString());

        String accountType = requestAccountDto.getAccountType();

        int branchId = requestAccountDto.getBranchId();

        double initialBalance = requestAccountDto.getInitialBalance();

        int userId = requestAccountDto.getUserId();

        AccountType accountTypeObj = accountTypeRepository.findByType(accountType);

        System.out.println(accountTypeObj.toString());

        //this if checks whether accounttype object find by accountTypeRepository.findByType(accountType) method is null or not  
        if (accountTypeObj == null) {
            //if account type is not exist then we have to create new accounttype 
            logger.info("account type with " + accountType + "is null ");
            accountTypeObj = new AccountType();
            accountTypeObj.setType(accountType);
            accountTypeObj = accountTypeRepository.save(accountTypeObj);
            logger.info("account type whose type is " + accountType + "has been added successfully ");
        }


        account.setAccountType(accountTypeObj);
        logger.info("account type is succesfully added ");

        Optional<Branch> branch = branchRepository.findById(branchId);

        if (branch.isEmpty()) {
            logger.error("branch with given id is not exist branchid is " + branchId);
            throw new BranchNotFountException("branch with given id is not found id is " + branchId);
        }


        account.setBranch(branch.get());
        logger.info("branch successfully added in account ");

        account.setBalance(initialBalance);
        logger.info("initial balance is successfully added");

        account.setIfscCode(branch.get().getIfscCode());
        logger.info("ifsc code is successfully added ");

        Optional<UserDetails> userDetailsOptional = userDetailsRepository.findById(userId);

        if (userDetailsOptional.isEmpty()) {
            logger.error("userdetails with given id not exist:" + userId);

            throw new UserNotFoundException("userdetails with given id not exist:" + userId);
        }

        account.setUserDetails(userDetailsOptional.get());
        logger.info("userdetail object added successfully in account");

        return account;
    }

}
