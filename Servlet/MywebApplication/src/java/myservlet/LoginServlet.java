package myservlet;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.sql.*;

@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	response.setContentType("text/html;charset=UTF-8");
	String emailString = request.getParameter("email");
	String passwordString = request.getParameter("password");

	int flag = 0;
	
	

	try {
	    Class.forName("com.mysql.cj.jdbc.Driver");
	    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "root");
	    System.out.println("connection successful");
	    PreparedStatement pre = connection.prepareStatement("select * from bank.accountholdermaster where email=? and password=? ");
	    pre.setString(1, emailString);
	    pre.setString(2, passwordString);

	    String emailString1 = null;
	    String passwordString1 = null;
	    ResultSet resultSet = pre.executeQuery();
	    while (resultSet.next()) {
		emailString1 = resultSet.getString("email");
		passwordString1 = resultSet.getString("password");
		
		System.out.println(emailString1);
		System.out.println(passwordString1);
		
	    }

	    if (emailString.equals(emailString1) && passwordString.equals(passwordString1)) {
		flag = 1;
		System.out.println("email and password match");
	    } else {
		System.out.println("email or password does not match");
	    }
	    connection.close();
	} catch (Exception e) {
	    System.out.println("exception found ");
	    e.printStackTrace();
	}

	if (flag == 1) {
	    HttpSession httpSession = request.getSession();
	    httpSession.setAttribute("email", emailString);
	    response.sendRedirect("home.html");
	}
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
