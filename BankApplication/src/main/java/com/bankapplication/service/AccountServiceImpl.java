package com.bankapplication.service;

import com.bankapplication.dto.request.RequestAccountDto;
import com.bankapplication.dto.response.ResponseAccountDto;
import com.bankapplication.exceptionhandler.AccoutNotExist;
import com.bankapplication.exceptionhandler.BranchNotFountException;
import com.bankapplication.exceptionhandler.InsufficientBalanceException;
import com.bankapplication.exceptionhandler.UserNotFoundException;
import com.bankapplication.model.*;
import com.bankapplication.repository.*;
import org.hibernate.service.spi.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;

@Service
public class AccountServiceImpl implements AccountService {

    private static final Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);
    private UserRepository userRepository;

    private AccountTypeRepository accountTypeRepository;

    private BranchRepository branchRepository;

    private UserDetailsRepository userDetailsRepository;

    private AccountRepository accountRepository;

    private UserServiceImpl userService;
    
    private TransactionService transactionService;

    @Autowired
    public AccountServiceImpl(UserRepository userRepository, AccountTypeRepository accountTypeRepository, BranchRepository branchRepository, UserDetailsRepository userDetailsRepository, AccountRepository accountRepository, UserServiceImpl userService, TransactionService transactionService ) {
        this.userRepository = userRepository;
        this.accountTypeRepository = accountTypeRepository;
        this.branchRepository = branchRepository;
        this.userDetailsRepository = userDetailsRepository;
        this.accountRepository = accountRepository;
        this.userService = userService;
        this.transactionService=transactionService;
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


    /**
     * Save new account details in database
     *
     * @param requestAccountDto
     * @return Account object
     */
    @Transactional
    public Account saveNewAccount(RequestAccountDto requestAccountDto) {
        Account account = new Account();

        logger.info(" saveNewAccount method of AccountServiceImpl class called ");
        logger.info("requestAccountDto recived is " + requestAccountDto.toString());

        String accountType = requestAccountDto.getAccountType();

        int branchId = requestAccountDto.getBranchId();

        BigDecimal initialBalance = requestAccountDto.getInitialBalance();

        int userId = requestAccountDto.getUserId();

        AccountType accountTypeObj = accountTypeRepository.findByType(accountType);


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


        String branchCode = branch.get().getIfscCode();
        String userDetailId = Integer.toString(userId);

        String accountNumber = generateAccountNumber(branchCode.substring(5), userDetailId);


        logger.info("Generated account number inside saveNewAccount method: {}", accountNumber);


        account.setAccountNumber(accountNumber);

        return accountRepository.save(account);

    }

    /**
     * Generates a unique account number based on branch code and user detail ID.
     *
     * @param branchCode   The 6-character branch code.
     * @param userDetailId The user detail ID.
     * @return A unique account number as a string.
     */
    public String generateAccountNumber(String branchCode, String userDetailId) {

        logger.info("Branch code used to generate unique account number: {}", branchCode);
        logger.info("User details ID used to generate bank account number: {}", userDetailId);


        int attemps = 0;

        if (branchCode.length() != 6) {
            logger.error("Branch code length is not equal to 6");
            throw new IllegalArgumentException("Branch code must be exactly 6 characters long.");
        }

        StringBuffer branchCodeStringBuffer = new StringBuffer(branchCode);

        StringBuffer userDetailIdStringBuffer = new StringBuffer(userDetailId);

        //accno variable represents account no 
        StringBuffer accno = new StringBuffer();


        accno = branchCodeStringBuffer.append(userDetailIdStringBuffer);
        logger.info("acc no before adding uniqe no is " + accno);

        int remainingNoOdDigit = 13 - accno.length();

        System.out.println("no of digits needed is " + remainingNoOdDigit);

        int uniqueNo = generateUniqueNo(remainingNoOdDigit);

        //this do while loop will run till accountRepository.existsByAccountNumber method does not return false 
        //false means accno does not present in Account table of database 
        do {
            accno = accno.append(uniqueNo);
            attemps++;
            logger.info("Attempts {}: Generated account number is {}", attemps, accno);
        } while (accountRepository.existsByAccountNumber(accno.toString()));


        return accno.toString();
    }


    /**
     * generateUniqueNo() method generates random unique no
     *
     * @return UNIQUE RANDOM NO
     */
    public int generateUniqueNo(int digit) {
        //random class contains build in methods to generate random numbers
        Random random = new Random();

        if (digit <= 0) {
            logger.error("Exception occurred in generateUniqueNo of AccountServiceImpl class");
            throw new IllegalArgumentException("Number of digits must be positive");
        }
        // Math.pow(10,digit-1) always gives min value exist in this no of digit
        int min = (int) Math.pow(10, digit - 1);
        logger.info("min no from this :" + digit + "is " + min);

        //Math.pow(10,digit)-1 alwasy gives maximum value exist in this no of digit
        int max = (int) Math.pow(10, digit) - 1;
        logger.info("max no from this :" + digit + "is " + max);
        int bound = (max - min) + 1;

        int no = random.nextInt(bound) + min;

        logger.info("Random number generated with given digits {}: {}", digit, no);

        return no;
    }


    /**
     * Retrieves account details by account number.
     *
     * @param accountNo the account number to search for
     * @return the account details as a ResponseAccountDto
     */
    public ResponseAccountDto getAccountDetailsByAccountNumber(String accountNo) {


        try {

            logger.info("Retrieving account details for account number: {}", accountNo);

            // Check if the account number is empty and throw an exception if it is
            if (accountNo == null || accountNo.isEmpty()) {
                throw new RuntimeException("Account number is required");
            }

            logger.debug("Searching for account by account number: {}", accountNo);

            // Use the account repository to find the account by account number
            Account account = accountRepository.findByAccountNumber(accountNo);

            // If account is not found, throw an exception
            if (account == null) {
                logger.error("Account not found for account number: {}", accountNo);

                throw new RuntimeException("Account not found");
            }
            logger.debug("Account found: {}", account);


            logger.debug("Converting account to ResponseAccountDto");

            // Convert the account to a ResponseAccountDto using the user service
            return userService.convertToResponseAccountDto(account);
        } catch (RuntimeException e) {
            // Log the exception and rethrow it
            logger.error("Error retrieving account details", e);
            throw e;
        } catch (Exception e) {
            // Log the exception and throw a RuntimeException
            logger.error("Unexpected error retrieving account details", e);
            throw new RuntimeException("Unexpected error", e);
        }
    }


    /**
     * Deposits money into an account.
     *
     * @param accountNo the account number to deposit money into
     * @param amount    the amount to deposit
     */
    @Transactional
    public void depositMoney(String accountNo, BigDecimal amount) {

        try {
            // Log the incoming account number and amount
            logger.info("Depositing {} into account number: {}", amount, accountNo);

            // Find the account by account number
            logger.debug("Searching for account by account number: {}", accountNo);
            Account account = accountRepository.findByAccountNumber(accountNo);

            // If account is not found, throw an exception
            if (account == null) {
                logger.error("Account not found for account number: {}", accountNo);
                throw new RuntimeException("Account not found");
            }

            // Log the found account
            logger.debug("Found account: {}", account);

            // Add the amount to the account balance
            logger.debug("Adding {} to account balance", amount);
            account.setBalance(account.getBalance().add(amount));

            // Create a new transaction
            Transactions transactions = new Transactions();
            transactions.setAccount(account);
            transactions.setAmount(amount);
            transactions.setTransactionType("Deposit");

            // Save the new transaction
            transactionService.createNewTransaction(transactions);



            // Save the updated account
            logger.debug("Saving updated account");
            accountRepository.save(account);

            // Log the successful deposit
            logger.info("Successfully deposited {} into account number: {}", amount, accountNo);
        } catch (RuntimeException e) {
            // Log the exception and rethrow it
            logger.error("Error depositing money", e);
            throw e;
        } catch (Exception e) {
            // Log the exception and throw a RuntimeException
            logger.error("Unexpected error depositing money", e);
            throw new RuntimeException("Unexpected error", e);
        }


    }

   
    /**
     * Deletes an account by its account number.
     *
     * @param accountNumber the account number of the account to be deleted
     */
    @Transactional
    public void deleteAccountByAccountNumber(String accountNumber) {

        try {
            // Log the received account number
            logger.info("Deleting account with account number: " + accountNumber);

            boolean result = accountRepository.existsByAccountNumber(accountNumber);

            if (result == false) {
                logger.error("Account with this account number does not exist: " + accountNumber);
                throw new AccoutNotExist("Account with this account number does not exist: " + accountNumber);
            }

            Account account = accountRepository.findByAccountNumber(accountNumber);

            // Delete the account from the repository
            accountRepository.delete(account);
            logger.info("Account deleted successfully: " + accountNumber);
        } catch (AccoutNotExist e) {
            logger.error("Account not found: " + accountNumber, e);
            throw e;
        } catch (DataAccessException e) {
            logger.error("Error deleting account: " + accountNumber, e);
            throw new ServiceException("Error deleting account: " + accountNumber, e);
        } catch (Exception e) {
            logger.error("Unexpected error while deleting account: " + accountNumber, e);
            throw new ServiceException("Unexpected error while deleting account: " + accountNumber, e);
        }
    }
    
    
    /**
     * Withdraws money from a specific account.
     * @param accountNo the account number of the account to withdraw from
     * @param amount the amount to withdraw
     */
    @Transactional
    public void withdrawMoney(String accountNo, BigDecimal amount) {

        try {
            // Log the incoming account number and amount
            logger.info("Withdrawing {} from account number: {}", amount, accountNo);

            // Find the account by account number
            logger.debug("Searching for account by account number: {}", accountNo);
            Account account = accountRepository.findByAccountNumber(accountNo);

            // If account is not found, throw an exception
            if (account == null) {
                logger.error("Account not found for account number: {}", accountNo);
                throw new AccoutNotExist("Account not found");
            }

            // Log the found account
            logger.debug("Found account: {}", account);

            // Check if the account balance is sufficient
            if (account.getBalance().compareTo(amount) < 0) {
                logger.error("Insufficient balance for account number: {}", accountNo);
                throw new InsufficientBalanceException("Insufficient balance for account number: " + accountNo);
            }

            // Subtract the amount from the account balance
            logger.debug("Subtracting {} from account balance", amount);
            account.setBalance(account.getBalance().subtract(amount));
            
            // Create a new transaction
            Transactions transactions = new Transactions();
            transactions.setAccount(account);
            transactions.setAmount(amount);
            transactions.setTransactionType("Withdrawal");
            
            // Save the new transaction
            transactionService.createNewTransaction(transactions);

            // Save the updated account
            logger.debug("Saving updated account");
            accountRepository.save(account);

            // Log the successful withdrawal
            logger.info("Successfully withdrew {} from account number: {}", amount, accountNo);
        } catch (RuntimeException e) {
            // Log the exception and rethrow it
            logger.error("Error withdrawing money", e);
            throw e;
        } catch (Exception e) {
            // Log the exception and throw a RuntimeException
            logger.error("Unexpected error withdrawing money", e);
            throw new RuntimeException("Unexpected error", e);
        }
    }
    
    
}
