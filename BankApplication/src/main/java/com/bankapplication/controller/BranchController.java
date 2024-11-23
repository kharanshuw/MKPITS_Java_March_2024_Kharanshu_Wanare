package com.bankapplication.controller;

import com.bankapplication.dto.ManagerDto;
import com.bankapplication.dto.ResponseBranchDto;
import com.bankapplication.getapplicationcontext.UserServiceAppContext;
import com.bankapplication.model.Branch;
import com.bankapplication.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    private ManagerService managerService;

    @Autowired
    public BranchController(UserService userService, UserServiceAppContext userServiceAppContext, AdminService adminService, CountryService countryService, BranchService branchService, ManagerService managerService) {
        this.userService = userService;
        this.userServiceAppContext = userServiceAppContext;
        this.adminService = adminService;
        this.countryService = countryService;
        this.branchService = branchService;
        this.managerService = managerService;
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
            return "branch/branch-list";

        } catch (Exception e) {
            // Log the exception with a meaningful message
            logger.error("Exception occurred while retrieving branches: {}", e.getMessage());

            // Add an error message to the model
            model.addAttribute("errorMessage", "An error occurred while retrieving branch data. Please try again later.");

            // Return the error view name
            return "error/error";
        }
    }

    /**
     * Handles the addition of a manager to a branch.
     * This method accepts two request parameters: action identifier `a` and branch ID `id`.
     * It retrieves the branch by the given ID, converts it to a `ResponseBranchDto` object,
     * and populates the model with the branch details and a list of all managers.
     * The method returns the view name for adding a manager to a branch.
     *
     * @param a     the action identifier specifying the type of operation
     * @param id    the ID of the branch to which the manager is to be added
     * @param model the model to which attributes are added for rendering the view
     * @return the name of the view for adding a manager to a branch
     */
    @GetMapping("/addmanager")
    public String addManager(@RequestParam String a, @RequestParam String id, Model model) {

        logger.info("Action: {}", a);
        logger.info("Branch ID: {}", id);

        try {
            int branchId = Integer.parseInt(id);

            // Retrieve the branch by ID
            Branch branch = branchService.getBranchById(branchId);
            logger.info("Branch found: {}", branch.getBranchName());

            // Convert branch to ResponseBranchDto
            ResponseBranchDto responseBranchDto = branchService.branchToResponseDto(branch);
            logger.info("branch converted to responsebranchdto object "+responseBranchDto.toString());
            model.addAttribute("dto", responseBranchDto);

            // Retrieve all managers
            List<ManagerDto> managerDtos = managerService.getAllManagers();
            model.addAttribute("managers", managerDtos);

            return "branch/add-branch-manager";
        } catch (NumberFormatException e) {
            logger.error("Invalid branch ID format: {}", id, e);
            model.addAttribute("e", "Invalid branch ID format.");
            return "error/error";
        } catch (Exception e) {
            logger.error("Exception occurred while processing addManager: {}", e.getMessage(), e);
            model.addAttribute("error", "An error occurred while processing your request.");
            return "error/error";
        }
    }

    @GetMapping("/removemanager")
    public String removeManager(@RequestParam String a, @RequestParam String id) {
        logger.info("action is " + a);
        logger.info("branch id is " + id);
        return "";
    }

    @PostMapping("/processaddmanager")
    public String processAddManager(@Valid @ModelAttribute("dto") ResponseBranchDto responseBranchDto, BindingResult bindingResult) {
        // Check for validation errors in the request data
        if (bindingResult.hasErrors()) {
            logger.error("Error found in adduser. Below is the RequestDto received from form:");
            logger.error(responseBranchDto.toString());
            // Log each field error for detailed debugging
            bindingResult.getFieldErrors().forEach(error -> {
                System.out.println(
                        "field" + error.getField() + ",error:" + error.getDefaultMessage()
                );
            });
            // Return the registration page if there are errors
            return "branch/add-branch-manager";
        }

        System.out.println("recived responseBranchdto is "+responseBranchDto.toString());
        return "";
    }


    /**
     * This method handles all exceptions that are not explicitly caught elsewhere
     * in the application. It is annotated with @ExceptionHandler to indicate that
     * it should be invoked when an Exception is thrown.
     */
    @ExceptionHandler(Exception.class)
    public String handleException(Exception exception, Model model) {
        logger.error("exception occured");
        logger.error(exception.toString());
        model.addAttribute("e", exception.getMessage());
        model.addAttribute("r", HttpStatus.BAD_REQUEST);
        return "error/error";
    }
}
