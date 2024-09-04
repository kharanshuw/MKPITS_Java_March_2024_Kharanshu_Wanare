package controller;

import java.io.IOException;
import java.io.PrintWriter;
import dbconnect.Dbconnect;
import java.sql.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Register extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	String firstname = request.getParameter("firstname");
	String lastname = request.getParameter("lastname");
	String date = request.getParameter("date");
	String email1 = request.getParameter("email1");
	String phone = request.getParameter("address");
	String city = request.getParameter("city");
	String state = request.getParameter("state");
	String zipcode = request.getParameter("zipcode");
	String password = request.getParameter("password");
	String confirmPassword = request.getParameter("confirmPassword");

	System.out.println("firstname:" + firstname);
	System.out.println("lastname:" + lastname);
	System.out.println("date:" + date);
	System.out.println("email:" + email1);
	System.out.println("phoneno:" + phone);
	System.out.println("city:" + city);
	System.out.println("state:" + state);
	System.out.println("state:" + zipcode);
	System.out.println("state:" + password);
	System.out.println("state:" + confirmPassword);

	Connection connection = Dbconnect.dbconnection();
	System.out.println("connection :"+connection);
	
	

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
	return "Short description";
    }// </editor-fold>

}
