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
import java.sql.*;

@WebServlet(name = "DepositServlet", urlPatterns = {"/DepositServlet"})
public class DepositServlet extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	response.setContentType("text/html");
	
	double balance = 0;
	
	String amountString = request.getParameter("amount");
	int amount = Integer.parseInt(amountString);
	int uid = 0;
	try {
	    HttpSession httpSession = request.getSession(true);
	    String emailString = httpSession.getAttribute("email").toString();
	    PrintWriter printWriter = response.getWriter();
	    
	    Class.forName("com.mysql.cj.jdbc.Driver");
	    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "root");
	    System.out.println("connection successful");
	    
	    PreparedStatement pre = connection.prepareStatement("select * from bank.accountholdermaster where email=? ");
	    
	    pre.setString(1, emailString);
	    
	    ResultSet resultSet = pre.executeQuery();
	    
	    while (resultSet.next()) {
		String email = resultSet.getString("email");
		String passwordString = resultSet.getString("password");
		uid=resultSet.getInt("userid");
		System.out.println("email" + email);
		System.out.println("password" + passwordString);
		
		balance = Double.parseDouble(resultSet.getString("balance"));
		System.out.println("original balance " + balance);
	    }
	    
//PreparedStatement preparedStatement2=connection.prepareStatement("select * from bank.transactions where email=?");
//preparedStatement2.setString(1, emailString);
//ResultSet resultSet1=preparedStatement2.executeQuery();
//	    while (resultSet1.next()) {		
//		uid=resultSet1.getInt("uid_accno");
//	    }
	    
	    if (amount <= 0) {
		System.out.println("please enter a valid no");
		return;
		
	    } else {
		balance = balance + amount;
		PreparedStatement preparedStatement = connection.prepareStatement("update  accountholdermaster set balance=? where email=?");
		preparedStatement.setString(2, emailString);
		preparedStatement.setDouble(1, balance);
		preparedStatement.executeUpdate();
		System.out.println("amount deposited sucessfull");
		PreparedStatement preparedStatement1 = connection.prepareStatement("insert into transactions(uid_accno,amount,transaction_type) values(?,?,?)");
		preparedStatement1.setInt(1, uid);
		preparedStatement1.setDouble(2, amount);
		String transaction_type="deposit";
		preparedStatement1.setString(3, transaction_type);
		int i=  preparedStatement1.executeUpdate();
		System.out.println("no of recored affected"+i);
	    }
	    
	    double newbalance = balancecheck(emailString);
	    
	    if (newbalance > 0) {
		response.sendRedirect("successful.html");
	    }
	    
	    System.out.println("new balance " + balance);
	    
	} catch (Exception e) {
	    e.printStackTrace();
	}
	
    }
    
    public double balancecheck(String emailString) {
	double balance = 0;
	try {
	    Class.forName("com.mysql.cj.jdbc.Driver");
	    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "root");
	    System.out.println("connection successful");
	    PreparedStatement preparedStatement = connection.prepareStatement("select * from accountholdermaster  where email=?");
	    preparedStatement.setString(1, emailString);
	    ResultSet resultSet = preparedStatement.executeQuery();
	    while (resultSet.next()) {
		balance = resultSet.getDouble("balance");
	    }
	    
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return balance;
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
