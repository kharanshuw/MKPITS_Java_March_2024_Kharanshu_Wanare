package com.bankapplication.controller;

import com.bankapplication.dto.ResponseDto;
import com.bankapplication.getapplicationcontext.UserServiceAppContext;
import com.bankapplication.model.User;
import com.bankapplication.service.AdminService;
import com.bankapplication.service.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    private UserServiceImpl userService;

    private UserServiceAppContext userServiceAppContext;
    
    private AdminService adminService;

    @Autowired
    public AdminController(UserServiceImpl userService, UserServiceAppContext userServiceAppContext,AdminService adminService) {
        this.userService = userService;
        this.userServiceAppContext = userServiceAppContext;
        this.adminService=adminService;
    }


    @GetMapping("/admin/profile")
    public String adminProfileData(HttpServletRequest request, Model model) {
        logger.info("admin profile method from admin controller called");

        String email = userServiceAppContext.getLoggedInUserEmail();

        logger.info("The user logged in is: {} inside /admin/profile", email);


        ResponseDto user = userService.getLoggedInUserDetails(email);

        logger.info("user  received at /admin/profile is"+user.toString());

        System.out.println("user recived at /admin/profile is"+user.toString());

        logger.info("Admin profile invoked");
        model.addAttribute("user", user);
        return "home/adminhome/adminprofile";


    }
    
    
    @GetMapping("/admin/alluser")
    public String getAllUser(Model model) {
    	
    	System.out.println("getalluser method from admincontroller class called successfully");
    	
    	List<ResponseDto> responseDtos = userService.findAllUser();
    	
    	if (responseDtos.isEmpty()) {
			System.out.println("responsdto list is empty in getalluser method of class admincontroller ");
			logger.error("responsdto list is empty in getalluser method of class admincontroller ");
			return "error/error.html";
		}
    	
    	else {
    		model.addAttribute("users", responseDtos);

            System.out.println("data send from /admin/alluser to alluser.html");
    		
    		logger.info("data send from /admin/alluser to alluser.html");
    		
    		
    		
    		return "home/adminhome/allusers";
		}
	}
    
    @GetMapping("/admin/pending")
    public String findInactiveUser(Model model )
    {
        List<ResponseDto> list= userService.findallInactiveUser();
        
        model.addAttribute("users",list);
        
        return  "home/adminhome/approve";
    }
    
    @GetMapping("/admin/request")
    public String requestAction(@RequestParam String a,@RequestParam String id){
        System.out.println("input recived "+a);
        
        if (a.equals("accept")){

            System.out.println("accept request");
            adminService.activateUser(a,id);
            return "redirect:/admin/pending" ;
        }
        else {
            System.out.println("reject request ");
           return "redirect:/admin/pending" ;
        }
   
    }
    


}
