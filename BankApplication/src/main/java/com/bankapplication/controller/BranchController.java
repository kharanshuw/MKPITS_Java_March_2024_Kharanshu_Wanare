package com.bankapplication.controller;

import com.bankapplication.getapplicationcontext.UserServiceAppContext;
import com.bankapplication.model.Branch;
import com.bankapplication.service.AdminService;
import com.bankapplication.service.BranchService;
import com.bankapplication.service.CountryService;
import com.bankapplication.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(method = RequestMethod.GET, value = "/branch")
public class BranchController {
    private static final Logger logger = LoggerFactory.getLogger(BranchController.class);
    private UserService userService;

    private UserServiceAppContext userServiceAppContext;

    private AdminService adminService;

    private CountryService countryService;

    private BranchService branchService;

    @Autowired
    public BranchController(UserService userService, UserServiceAppContext userServiceAppContext, AdminService adminService, CountryService countryService, BranchService branchService) {
        this.userService = userService;
        this.userServiceAppContext = userServiceAppContext;
        this.adminService = adminService;
        this.countryService = countryService;
        this.branchService = branchService;
    }

    /**
     * Handles the request to display all branches.
     *
     * @param model the model to pass attributes to the view
     * @return the view name of the branches list page
     */
    @GetMapping("/allbranch")
    public String getAllBranch(Model model) {
        try {
            // Retrieve all branches
            List<Branch> branchList = branchService.getAllBranch();

            // Add the branch list to the model with an appropriate attribute name
            model.addAttribute("branches", branchList);

            logger.info("Successfully retrieved and added {} branches", branchList.size());

            // Return the view name to render the branches list
            return "branch-list";

        } catch (Exception e) {
            // Log the exception with a meaningful message
            logger.error("Exception occurred while retrieving branches: {}", e.getMessage());

            // Add an error message to the model
            model.addAttribute("errorMessage", "An error occurred while retrieving branch data. Please try again later.");

            // Return the error view name
            return "error/error";
        }
    }


}
