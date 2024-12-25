package com.bankapplication.controller;

import com.bankapplication.dto.request.RequestAccountDto;
import com.bankapplication.dto.response.ResponseAccountDto;
import com.bankapplication.getapplicationcontext.UserServiceAppContext;
import com.bankapplication.model.Account;
import com.bankapplication.model.Branch;
import com.bankapplication.model.Users;
import com.bankapplication.service.AccountService;
import com.bankapplication.service.BranchService;
import com.bankapplication.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/account")
public class AccountController {

    private static final Logger logger = LoggerFactory.getLogger(AccountController.class);
    private UserServiceAppContext userServiceAppContext;
    private AccountService accountService;
    private BranchService branchService;
    private UserService userService;


    @Autowired
    public AccountController(UserServiceAppContext userServiceAppContext, AccountService accountService, BranchService branchService,UserService userService) {
        this.userServiceAppContext = userServiceAppContext;
        this.accountService = accountService;
        this.branchService = branchService;
        this.userService=userService;
    }

    /**
     * Handles the request to create an account.
     *
     * @param model The model to pass attributes to the view.
     * @return The view name to be rendered.
     */
    @GetMapping("/choose-account-type")
    public String selectAccountType(Model model) {

        // Retrieve the logged-in user's email
        String email = userServiceAppContext.getLoggedInUserEmail();
        logger.info("Logged in user email: {}", email);

        // Retrieve the user by email
        Users users = accountService.getUserByEmail(email);
        logger.info("User logged in with ID: {}", users.getId());

        // Add user details to the model
        populateModelWithUserDetails(model, users);


        List<String> nonExistingAccount = accountService.getNonExistingAccount(users);
        model.addAttribute("nonExistingAccount", nonExistingAccount);

        logger.info("Non-existing account types: {}", nonExistingAccount);

        return "account/account-type";
    }

    /**
     * Populates the model with user details.
     *
     * @param model The model to populate.
     * @param users The user whose details are to be added to the model.
     */
    private void populateModelWithUserDetails(Model model, Users users) {
        model.addAttribute("fname", users.getUserDetails().getFname());
        model.addAttribute("lname", users.getUserDetails().getLname());
    }

    /**
     * Handles the creation of a new account form based on the specified account type.
     *
     * @param model       The model to add attributes to be used in the view.
     * @param accountType The type of account to be created.
     * @param principal   The principal object representing the currently authenticated user.
     * @return The view name for the account creation form.
     */
    @GetMapping("/create-account-form")
    private String createAccountWithType(Model model, @RequestParam(name = "type") String accountType, Principal principal) {
        // Retrieve the email of the currently authenticated user
        String userEmail = principal.getName();

        logger.info("account type is " + accountType);


        // Create a new RequestAccountDto object and set the account type
        RequestAccountDto requestAccountDto = new RequestAccountDto();
        requestAccountDto.setAccountType(accountType);

        // Retrieve the user based on their email
        Users user = accountService.getUserByEmail(userEmail);
        logger.info("user logged in is " + user.getId());

        // Retrieve the user details ID and set it in the RequestAccountDto object
        int userId = user.getUserDetails().getId();
        requestAccountDto.setUserId(userId);

        // Add the RequestAccountDto object to the model
        model.addAttribute("requestAccountForm", requestAccountDto);

        // Retrieve the list of all branches
        List<Branch> branchList = branchService.getAllBranch();
        logger.info("list of all branch with size is " + branchList.size());

        // Add the list of branches to the model
        model.addAttribute("branchlist", branchList);


        // Return the view name for the account creation form
        return "account/account-form";
    }

    /**
     * Handles the creation of a new bank account based on the provided RequestAccountDto.
     *
     * @param requestAccountDto The DTO containing the account creation request data.
     * @param model             The model to add attributes to be used in the view.
     * @param bindingResult     The BindingResult object for validating the request data.
     * @return The view name indicating the outcome of the account creation process.
     */
    @PostMapping("/create-account")
    public String createAccount(@Valid @ModelAttribute("requestAccountForm") RequestAccountDto requestAccountDto, Model model, BindingResult bindingResult) {
        // Check for validation errors in the request data
        if (bindingResult.hasErrors()) {
            logger.error("Error found in user bank account creation. Below is the requestAccountDto received from form:");
            logger.error(requestAccountDto.toString());
            // Log each field error for detailed debugging
            bindingResult.getFieldErrors().forEach(error -> {
                System.out.println(
                        "field" + error.getField() + ",error:" + error.getDefaultMessage()
                );
            });
            // Return the registration page if there are errors
            return "account/account-form";
        }


        logger.info("requestaccountdto is " + requestAccountDto.toString());


        // Save the new account using the account service
        Account account = accountService.saveNewAccount(requestAccountDto);

        logger.info("account created " + account.toString());
        return "account/successfull";
    }

    @GetMapping("/details")
    public String getAccountDetails(@RequestParam("accountNo") String accountNumber, Model model) {
        logger.info("account no is " + accountNumber);
        System.out.println("account no is " + accountNumber);

        ResponseAccountDto responseAccountDto = accountService.getAccountDetailsByAccountNumber(accountNumber);

        logger.info("response account dto " + responseAccountDto.toString());
        System.out.println("response account dto " + responseAccountDto);
        return "";
    }


    @ExceptionHandler(value = RuntimeException.class)
    public String handleRuntimeException(RuntimeException exception, Model model) {
        logger.error("runtime exception "+exception.getMessage());

        model.addAttribute("e", exception.toString());
        model.addAttribute("r", exception.getMessage());

        return "error/error";
    }


    /**
     * Exception handler for global exception
     *
     * @param e
     * @param model
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public String handleException(Exception e, Model model) {
        logger.error("exception occured " + e.getMessage());

        model.addAttribute("e", e.toString());
        model.addAttribute("r", e.getMessage());
        // Handle the exception
        return "error/error";
    }


}
