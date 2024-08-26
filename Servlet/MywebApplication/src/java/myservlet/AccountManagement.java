package myservlet;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import  java.sql.*;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "AccountManagement", urlPatterns = {"/AccountManagement"})
public class AccountManagement extends HttpServlet {
    
    public void  verifyRegister(HttpServletRequest request,HttpServletResponse response){
	String useridString=request.getParameter("userid");
	String passwordString=request.getParameter("password");
	String confirmpasswordString=request.getParameter("confirmpassword");
	String mynameString=request.getParameter("myname");
	String addressString=request.getParameter("address");
	String cityString=request.getParameter("city");
	String balanceString=request.getParameter("balance");
	String phonenoString=request.getParameter("phoneno");
	String emailString=request.getParameter("email");
	
	PrintWriter pw=null;
	try {
	    pw = response.getWriter();
	     Class.forName("com.mysql.cj.jdbc.Driver");
	    Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "root");
	    System.out.println("connection successful");
	    PreparedStatement preparedStatement = connection.prepareStatement("insert into accountholdermaster(password,name,address,city,phone_number,balance,email) values (?,?,?,?,?,?,?) ");
	    
	    
	    preparedStatement.setString(1, passwordString);
	    preparedStatement.setString(2, mynameString);
	    preparedStatement.setString(3, addressString);
	    preparedStatement.setString(4, cityString);
	    preparedStatement.setString(5, (phonenoString));
	    preparedStatement.setDouble(6,Double.parseDouble(balanceString));
	    preparedStatement.setString(7, emailString);
	    
	    int i=preparedStatement.executeUpdate();
	    System.out.println("record affected"+i);
	} 
	catch(Exception e){
	    System.out.println("exception occured:"+e);
	    e.printStackTrace();
	}
	
	pw.print(useridString);
	pw.print(passwordString);
	pw.print(confirmpasswordString);
	pw.print(mynameString);
	pw.print(addressString);
	pw.print(cityString);
	pw.print(balanceString);
    }

    public void VerifyLogin(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException {
	String useridString = request.getParameter("userid");
	String passwordString = request.getParameter("password");

	PrintWriter printWriter = null;
	try {
	    Class.forName("com.mysql.cj.jdbc.Driver");
	    Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "root");
	    System.out.println("connection successful");
	    Statement statement = connection.createStatement();
	    ResultSet resultSet = statement.executeQuery("SELECT * FROM accountholdermaster ");
	    ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
	    int count = resultSetMetaData.getColumnCount();

	} 
	 catch (Exception e) {
	    printWriter.print(e);
	}

    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	response.setContentType("text/html;charset=UTF-8");

	try {
	    //	try (PrintWriter out = response.getWriter()) {
//
//	    out.println("<!DOCTYPE html>");
//	    out.println("<html>");
//	    out.println("<head>");
//	    out.println("<title>Servlet AccountManagement</title>");
//	    out.println("</head>");
//	    out.println("<body>");
//	    out.println("<h1>Servlet AccountManagement at " + request.getContextPath() + "</h1>");
//	    out.println("</body>");
//	    out.println("</html>");
//
//	    
//	}

	    VerifyLogin(request, response);
	    verifyRegister(request, response);
	} catch (ClassNotFoundException ex) {
	    Logger.getLogger(AccountManagement.class.getName()).log(Level.SEVERE, null, ex);
	} catch (SQLException ex) {
	    Logger.getLogger(AccountManagement.class.getName()).log(Level.SEVERE, null, ex);
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
