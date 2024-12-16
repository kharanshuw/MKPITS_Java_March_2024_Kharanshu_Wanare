package com.bankapplication.controller;

import com.bankapplication.dto.request.RequestAccountDto;
import com.bankapplication.getapplicationcontext.UserServiceAppContext;
import com.bankapplication.model.Branch;
import com.bankapplication.model.Users;
import com.bankapplication.service.AccountService;
import com.bankapplication.service.AccountServiceImpl;
import com.bankapplication.service.BranchService;
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

    private UserServiceAppContext userServiceAppContext;

    private AccountService accountService;
    
    private BranchService branchService;

    private static final Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);


    @Autowired
    public AccountController(UserServiceAppContext userServiceAppContext, AccountService accountService,BranchService branchService) {
        this.userServiceAppContext = userServiceAppContext;
        this.accountService = accountService;
        this.branchService=branchService;
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
    
    @GetMapping("/create-account-form")
    private String createAccountWithType(Model model, @RequestParam(name = "type") String accountType, Principal principal)
    {
        String  userEmail = principal.getName();
        
        logger.info("account type is "+accountType);

        RequestAccountDto requestAccountDto = new RequestAccountDto();
        requestAccountDto.setAccountType(accountType);
        
        Users user=accountService.getUserByEmail(userEmail);
        logger.info("user logged in is "+user.getId());
        int userId = user.getUserDetails().getId();
        
        requestAccountDto.setUserId(userId);
        
        model.addAttribute("requestAccountForm",requestAccountDto);

        List<Branch> branchList=branchService.getAllBranch();
        
        logger.info("list of all branch with size is "+branchList.size());
        
        model.addAttribute("branchlist",branchList);
        
        return  "account/account-form";
    }

    
    @PostMapping("/create-account")
    public String createAccount(@Valid @ModelAttribute("requestAccountForm") RequestAccountDto requestAccountDto , Model model , BindingResult bindingResult){
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
        logger.info("requestaccountdto is "+requestAccountDto.toString());
        
        accountService.saveNewAccount(requestAccountDto);
        
        
        return "account/successfull";
    }
    
    //Handling exception using exception handler 
    @ExceptionHandler(value = Exception.class)
    public String handleException(Exception e, Model model) {
        logger.error("exception occured " + e.getMessage());

        model.addAttribute("e", e.toString());
        model.addAttribute("r", e.getMessage());
        // Handle the exception
        return "error/error";
    }
    

}
