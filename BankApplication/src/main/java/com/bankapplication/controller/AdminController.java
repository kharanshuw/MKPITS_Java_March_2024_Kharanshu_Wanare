package com.bankapplication.controller;

import com.bankapplication.dto.ProfileUpdateDto;
import com.bankapplication.dto.ResponseDto;
import com.bankapplication.getapplicationcontext.UserServiceAppContext;
import com.bankapplication.model.Country;
import com.bankapplication.model.User;
import com.bankapplication.service.AdminService;
import com.bankapplication.service.CountryService;
import com.bankapplication.service.UserService;
import com.bankapplication.service.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * AdminController handles all admin-related requests and actions.
 */
@Controller
public class AdminController {

	// This sets up the logger for the AdminController class.
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
// This is a private field for the UserServiceImpl, which likely handles user-related operations.

	private UserService userService;
// This is a private field for UserServiceAppContext, which is a context class managing the session or user context.

	private UserServiceAppContext userServiceAppContext;
// This is a private field for AdminService, which likely handles administrative operations.

	private AdminService adminService;

	private CountryService countryService;

	@Autowired
	public AdminController(UserServiceImpl userService, UserServiceAppContext userServiceAppContext,
			AdminService adminService, CountryService countryService) {
		this.userService = userService;
		this.userServiceAppContext = userServiceAppContext;
		this.adminService = adminService;
		this.countryService = countryService;
	}

	/**
	 * Handles the request to display the admin profile data.
	 *
	 * @param request the HTTP servlet request
	 * @param model   the model to pass attributes to the view
	 * @return the path to the admin profile page template
	 */
	@GetMapping("/admin/profile")
	public String adminProfileData(HttpServletRequest request, Model model) {
		logger.info("admin profile method from admin controller called");
		// Retrieve the email of the logged-in user

		String email = userServiceAppContext.getLoggedInUserEmail();

		logger.info("The user logged in is: {} inside /admin/profile", email);
		// Retrieve the details of the logged-in user

		ResponseDto user = userService.getLoggedInUserDetails(email);

		ArrayList<String> roleList = user.getrolestring();

		model.addAttribute("roles", roleList);

		logger.info("user  received at /admin/profile is" + user.toString());

		// Add the user details to the model

		model.addAttribute("user", user);
		return "home/adminhome/adminprofile";

	}

	/**
	 * This method handles the request to get all users.
	 *
	 * @param model the model to pass attributes to the view
	 * @return the path to the all users page template if users are found, otherwise
	 *         returns an error page
	 */
	@GetMapping("/admin/alluser")
	public String getAllUser(Model model) {

		logger.info("getalluser method from admincontroller class called successfully");
		// Retrieve the list of all users

		List<ResponseDto> responseDtos = userService.findAllUser();
		// Check if the user list is empty

		if (responseDtos.isEmpty()) {
			logger.error("responsdto list is empty in getalluser method of class admincontroller ");
			return "error/error.html";
		} else {

			// Add the user list to the model

			model.addAttribute("users", responseDtos);

			logger.info("data send from /admin/alluser to alluser.html");
			return "home/adminhome/allusers";
		}
	}

	/**
	 * Handles the request to find inactive users.
	 *
	 * @param model the model to pass attributes to the view
	 * @return the path to the approve page template
	 */
	@GetMapping("/admin/pending")
	public String findInactiveUser(Model model) {

		// Retrieve the list of inactive users

		List<ResponseDto> list = userService.findallInactiveUser();
		// Add the list of inactive users to the model

		model.addAttribute("users", list);

		return "home/adminhome/approve";
	}

	/**
	 * Handles the request action based on the provided parameters.
	 *
	 * @param a  the action to perform (accept or reject)
	 * @param id the ID of the user
	 * @return a redirect to the pending page
	 */
	@GetMapping("/admin/request")
	public String requestAction(@RequestParam String a, @RequestParam String id) {

		logger.info("input recived " + a);
		// Check if the action is to accept

		if (a.equals("accept")) {
			// Activate the user based on the ID

			logger.info("accept request");
			adminService.activateUser(a, id);
			return "redirect:/admin/pending";
		} else {

			logger.info("reject request");
			return "redirect:/admin/pending";
		}

	}

	/**
	 * Handles the request to manage roles.
	 *
	 * @param model the model to pass attributes to the view
	 * @return the path to the role management page template if users are found,
	 *         otherwise returns an error page
	 */
	@GetMapping("/admin/rolemanagement")
	public String manageRole(Model model) {
		logger.info("/admin/rolemanagement from admin controller  called successfully");
		// Retrieve the list of all users

		List<ResponseDto> responseDtoList = userService.findAllUser();

		// Check if the user list is empty
		if (responseDtoList.isEmpty()) {
			logger.error("responsdto list is empty in getalluser method of class admincontroller ");
			return "error/error.html";
		} else {

			// Add the user list to the model

			model.addAttribute("users", responseDtoList);
			logger.info("data send from /admin/alluser to alluser.html");
			return "home/adminhome/manager-role";
		}

	}

	/**
	 * This method handles the request to navigate to the add role page for an
	 * existing user.
	 *
	 * @param a     a parameter indicating the action to perform
	 * @param id    the ID of the user
	 * @param model the model to pass attributes to the view
	 * @return the path to the add role page template if adding a role, otherwise
	 *         redirects to the role list page
	 */
	@GetMapping("/admin/addrolepage")
	public String addRolepage(@RequestParam String a, @RequestParam String id, Model model) {

		logger.info("/admin/addrolepage from admin controller  called successfully");
		// Check if the action is to add a role

		if (a.equals("addrole")) {
			logger.info("add role request recieved");

			// Retrieve the current roles of the user

			List<String> roleList = adminService.findRole(id);

			// Add the current roles and user ID to the mode
			model.addAttribute("rolelist", roleList);
			model.addAttribute("id", id);

			// Retrieve roles not assigned to the user and add to the model

			List<String> unassignedroleList = adminService.findUnassignedRoles(id);
			model.addAttribute("unassignedroleList", unassignedroleList);
			return "home/adminhome/addrole";
		} else {
			// If the action is not to add a role, log and redirect to the role list page

			logger.info("no changes in role list");
			return "redirect:/admin/getrolelist";
		}

	}

	/**
	 * Handles HTTP GET requests to display the role removal page. Mapped to the
	 * "/admin/removerolepage" URL.
	 *
	 * @param a     The action to be performed, typically "remove" to indicate role
	 *              removal.
	 * @param id    The ID of the user whose roles are being managed.
	 * @param model The Model object to pass data to the view.
	 * @return The view name to be rendered.
	 */
	@GetMapping("/admin/removerolepage")
	public String removeRolepage(@RequestParam String a, @RequestParam String id, Model model) {
		logger.info(" /admin/removerolepage from admin controller  called successfully");

		// Log the received parameters for debugging purposes.
		logger.info(String.format("Received action and id: %s %s", a, id));

// Check if the action is "remove".
		if (a.equals("remove")) {
			logger.info("Remove request received at /admin/removepage in admincontroller");

			// Retrieve the current roles of the user

			List<String> roles = adminService.findRole(id);

			// Add the roles and user ID to the model to pass to the view.
			model.addAttribute("roles", roles);

			model.addAttribute("uid", id);

			return "home/adminhome/removerole";

		} else {
			logger.info("no change in role list of user ");

			// Redirect to the role list page if the action is not "remove".
			return "redirect:/admin/getrolelist";
		}

	}

	/**
	 * Handles the request to add a role to a user.
	 *
	 * @param msg      the message parameter
	 * @param userid   the ID of the user
	 * @param rolename the name of the role to add
	 * @return a redirect to the role management page
	 */
	@GetMapping("/admin/addrole")
	public String addRole(@RequestParam String msg, @RequestParam String userid, @RequestParam String rolename) {
		logger.info("msg userid and rolename recived from addrole.html in addrole method of admincontroller is "
				+ msg.toString() + " " + userid.toString() + " " + rolename.toString());
		// Call the service method to add the role to the user

		String response = adminService.addRoleToUser(rolename, userid);

		logger.info("response from adminservie.addroletouser method is " + response.toString());

		// Redirect to the role management page

		return "redirect:/admin/rolemanagement";
	}

	/**
	 * Handles HTTP GET requests to remove a role from a user. Mapped to the
	 * "/admin/removerole" URL.
	 *
	 * @param msg      A message received from the client, typically for logging or
	 *                 display purposes.
	 * @param userid   The ID of the user from whom the role is to be removed.
	 * @param rolename The name of the role to be removed from the user.
	 * @return A redirect to the role management page.
	 */
	@GetMapping("/admin/removerole")
	public String removeRole(@RequestParam String msg, @RequestParam String userid, @RequestParam String rolename) {
		logger.info("msg userid and rolename recived from addrole.html in addrole method of admincontroller is "
				+ msg.toString() + " " + userid.toString() + " " + rolename.toString());

		// Call the service method to remove the role to the user
		// This method should handle the business logic for role removal.
		String response = adminService.removeRoleFromUser(rolename, userid);

		System.out.println(
				"response recived from adminService.removeRoleFromUser(rolename,userid) is : " + response.toString());
		// Redirect the user to the role management page after the operation is
		// complete.
		return "redirect:/admin/rolemanagement";
	}

	@GetMapping("/admin/home")
	public String getAdminHome() {
		return "home/adminhome/adminhome";
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

	/**
	 * Handles HTTP GET requests to the /user/update endpoint.
	 * 
	 * This method is responsible for preparing the data required for updating a
	 * user's profile. Returns the name of the view (home/userhome/updateprofile)
	 * that will be rendered.
	 *
	 * @param model the model object used to pass data to the view
	 * @return the name of the view to be rendered for updating the user's profile
	 */
	@GetMapping("/admin/update")
	public String updateProfiledata(Model model) {

		// Retrieve the list of all countries using the country service
		List<Country> countries = countryService.getAllCountries();

		// Add the list of countries to the model
		model.addAttribute("countries", countries);

		// Get the email of the currently logged-in user from the user service context
		String emailString = userServiceAppContext.getLoggedInUserEmail();
		// Retrieve the User object based on the logged-in user's email

		User user = userService.getUserByEmail(emailString);
		// Convert the User object to a ProfileUpdateDto object using the user service

		ProfileUpdateDto profileUpdateDto = userService.convertToProfileUpdate(user);
		// Add the ProfileUpdateDto to the model

		model.addAttribute("profileUpdateDto", profileUpdateDto);
		// Return the view name for updating the profile

		return "home/adminhome/updateprofile";

	}
	
	
	@PostMapping("/admin/processupdate")
	public String processUpdate(@ModelAttribute("profileUpdateDto") ProfileUpdateDto profileUpdateDto ) {
		
		System.out.println(profileUpdateDto);
		
		
		return null;
	}

}
