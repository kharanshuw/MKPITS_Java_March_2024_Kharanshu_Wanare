package com.bankapplication.controller;

import com.bankapplication.dto.ResponseDto;
import com.bankapplication.dto.response.ResponseAccountDto;
import com.bankapplication.getapplicationcontext.UserServiceAppContext;
import com.bankapplication.service.AccountService;
import com.bankapplication.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/manager")
public class ManagerController {

    private static final Logger logger = LoggerFactory.getLogger(ManagerController.class);
    private UserServiceAppContext userServiceAppContext;
    private UserService userService;
    private AccountService accountService;

    @Autowired
    public ManagerController(UserServiceAppContext userServiceAppContext, UserService userService, AccountService accountService) {
        super();
        this.userServiceAppContext = userServiceAppContext;
        this.userService = userService;
        this.accountService = accountService;
    }

    /**
     * Handles the request to display the manager home page. * @param model the
     * model to pass attributes to the view
     *
     * @return the view name of the manager home page
     */
    @GetMapping("/home")
    public String getManagerHome(Model model) {
        logger.info("getManagerHome method from ManagerController called successfully");
        try {
            // Return the view name for the manager home page
            return "home/manager/manager-home";
        } catch (Exception e) {
            logger.error("Exception occurred in getManagerHome method of ManagerController: {}", e.getMessage());

            model.addAttribute("e",
                    "Exception occurred in getManagerHome method of ManagerController:" + " " + e.getMessage());

            return "error/error";
        }

    }


    /**
     * Handles GET requests to the /profile endpoint.
     * Retrieves the logged-in manager's profile details and returns the view name.
     *
     * @param model the model to pass attributes to the view
     * @return the view name of the manager's profile page
     */
    @GetMapping("/profile")
    public String getManagerProfile(Model model) {

        logger.info("/manager/profile called successfully");


        // Get the logged-in user's email from the user service app context
        String email = userServiceAppContext.getLoggedInUserEmail();

        // Log the logged-in user's email
        logger.info("logged in user email is " + email.toString());


        // Get the logged-in user's details from the user service
        ResponseDto responseDto = userService.getLoggedInUserDetails(email);


        // Get the user's roles as a list of strings
        ArrayList<String> roleStrings = responseDto.getrolestring();

        // Add the user's roles and details to the model
        model.addAttribute("roles", roleStrings);
        model.addAttribute("user", responseDto);

        return "home/manager/manager-profile-data";
    }


    /**
     * Retrieves a list of accounts waiting for manager approval and adds them to the model.
     *
     * @param model the model to which the accounts will be added
     * @return the name of the view template for displaying the inactive accounts
     */
    @GetMapping("/pending_request")
    public String getAccountsWaitingForManagerApproval(Model model) {

        // Log the start of the method
        logger.info("Executing getAccountsWaitingForManagerApproval...");

        // Retrieve the list of accounts with disabled status
        List<ResponseAccountDto> accounts = accountService.getAccountsWithDisablesStatus();

        // Log the successful retrieval of accounts
        logger.info("Successfully retrieved {} accounts waiting for manager approval", accounts.size());

        // Add the accounts to the model
        model.addAttribute("accounts", accounts);

        return "account/inactive_accounts";
    }


    /**
     * Handles the approval request to enable an account.
     *
     * @param accountNumber the account number to be enabled
     * @param requestType   the type of request
     * @param model         the model to which attributes will be added
     * @return the name of the view template for displaying the success message
     */
    @GetMapping("/approve")
    public String getApproval(@RequestParam("accountno") String accountNumber, @RequestParam("request") String requestType, Model model) {
        // Log the received account number and request type
        logger.info("Received account number: {}", accountNumber);
        logger.info("Received request type: {}", requestType);

        // Enable the account based on the account number
        accountService.enableAccount(accountNumber);

        // Add the account number to the model
        model.addAttribute("accountNo", accountNumber);

        // Log the successful account enabling
        logger.info("Successfully enabled account with account number: {}", accountNumber);

        return "account/account-enabled-successfully";
    }


    /**
     * Handles RuntimeExceptions thrown in the application.
     *
     * @param exception the RuntimeException that was thrown
     * @param model     the model to pass data to the view
     * @return the view name for error handling
     */
    @ExceptionHandler(value = RuntimeException.class)
    public String handleRuntimeException(RuntimeException exception, Model model) {
        logger.error("runtime exception " + exception.getMessage());

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
