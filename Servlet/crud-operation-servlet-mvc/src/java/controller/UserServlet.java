package controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jakarta.servlet.*;

import java.util.*;

import dao.UserDao;

import model.User;

public class UserServlet extends HttpServlet {

    private UserDao userDao;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

	userDao = new UserDao();

	String actionString = request.getServletPath();
	try {

	    switch (actionString) {
		case "/new":
		    shownewform(request, response);
		    break;

		case "/insert":
		    insertUser(request, response);
		    break;

		case "/delete":
		    deleteUser(request, response);
		    break;
		case "/edit":
		    editform(request, response);
		    break;

		case "/update":
		    updateUser(request, response);
		    break;
		default:
		    listUser(request, response);
		    break;
		//     System.out.println("something went wrong please find error");
		//     break;
	    }

	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

    public void listUser(HttpServletRequest request, HttpServletResponse response) {
	try {
	    List<User> list = userDao.allUsers();

	    RequestDispatcher requestDispatcher = request.getRequestDispatcher("user_list.jsp");

	    request.setAttribute("alluser", list);

	    requestDispatcher.forward(request, response);

	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

    public void shownewform(HttpServletRequest request, HttpServletResponse response) {
	try {
	    RequestDispatcher requestDispatcher = request.getRequestDispatcher("user_form.jsp");
	    requestDispatcher.forward(request, response);
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

    public void editform(HttpServletRequest request, HttpServletResponse response) {
	try {
	    int id = Integer.parseInt(request.getParameter("id"));
	    User existingUser = userDao.selectUser(id);
	    
	    RequestDispatcher requestDispatcher = request.getRequestDispatcher("edit_form.jsp");
	    
	    request.setAttribute("e", existingUser);
	    requestDispatcher.forward(request, response);
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

    public void insertUser(HttpServletRequest request, HttpServletResponse response) {
	try {
	    String nameString = request.getParameter("username");
	  
	    String emailString = request.getParameter("email");
	    String countryString = request.getParameter("country");
	    User user = new User(nameString, emailString, countryString);
	    userDao.insertuser(user);
	    response.sendRedirect("list");

	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

    public void updateUser(HttpServletRequest request, HttpServletResponse response) {
	try {
	    int id = Integer.parseInt(request.getParameter("id"));
	    String nameString = request.getParameter("username");
	    String email = request.getParameter("email");
	    String countryString = request.getParameter("country");

	    System.out.println("name:" + nameString);

	    System.out.println("email" + email);

	    System.out.println("country" + countryString);

	    System.out.println("id" + id);
	    
	    
	    User user = new User(id, nameString, email, countryString);

	    boolean result = userDao.updateuser(user);

	    System.out.println("result of update:" + result);
	    response.sendRedirect("list");
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

    public void deleteUser(HttpServletRequest request, HttpServletResponse response) {
	try {
	    int id = Integer.parseInt(request.getParameter("id"));
	    userDao.deleteUser(id);
	    response.sendRedirect("list");
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
	return "Short description";
    }

}
