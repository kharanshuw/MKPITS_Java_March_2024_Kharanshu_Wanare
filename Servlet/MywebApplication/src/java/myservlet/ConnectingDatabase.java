/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package myservlet;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.sql.*;

/**
 *
 * @author Kharanshu
 */
public class ConnectingDatabase extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occur
     */
    public static String myclassname = "com.mysql.cj.jdbc.Driver";
    public static String url = "jdbc:mysql://localhost:3306/sakila";
    public static String url1 = "jdbc:mysql://localhost:3306/student";
    public static String user = "root";
    public static String password = "root";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

	String accountnoString = request.getParameter("AccountNO");

	String addresssString = request.getParameter("address");

	String city = request.getParameter("city");

	String myname = request.getParameter("myname");

	String balance = request.getParameter("balance");

	PrintWriter printWriter = response.getWriter();

	printWriter.println(accountnoString);
	printWriter.println(city);
	printWriter.println(myname);
	printWriter.println(balance);

	printWriter.println(addresssString);

	printWriter.print("<html><body>");
	printWriter.print("<table>");
	printWriter.print("<tr>");
	printWriter.print("<td>");
	printWriter.print("<h3>Details Entered</h3><br/>");
	printWriter.print("</td>");
	printWriter.print("<td>");

	printWriter.print("Full Name: " + myname + "<br/>");
	printWriter.print("</td>");
	printWriter.print("<td>");

	printWriter.print("city: " + city + "<br/>");
	printWriter.print("</td>");
	printWriter.print("<td>");

	printWriter.print("balance: " + balance + "<br/>");
	printWriter.print("</td>");
	printWriter.print("<td>");

	printWriter.print("accountno: " + accountnoString + "<br/>");
	printWriter.print("</td>");
	printWriter.print("<td>");

	printWriter.print("address " + addresssString + "<br/>");
	printWriter.print("</td>");

	printWriter.print("<tr>");

	printWriter.print("</table>");
	printWriter.print("</body></html>");

	try {
	    Class.forName("com.mysql.cj.jdbc.Driver");
	    Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");
	    // Connection connection=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
	    System.out.println("connection successful");
	    Statement statement = connection.createStatement();
	    ResultSet resultSet = statement.executeQuery("SELECT * FROM student.account");
	    ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
	    int count = resultSetMetaData.getColumnCount();

	    for (int i = 1; i <= count; i++) {
		System.out.print(resultSetMetaData.getColumnName(i) + " ");
	    }

	    while (resultSet.next()) {
		for (int i = 1; i <= count; i++) {
		    System.out.print(resultSet.getString(i) + " ");
		}
		System.out.println();
	    }

	    PreparedStatement preparedStatement = connection.prepareStatement("insert into account(Account_No,address,balance,city,name) values(?,?,?,?,?)");

	    int accountnoInteger = Integer.parseInt(accountnoString);
	    double balancedouble = Double.parseDouble(balance);

	    preparedStatement.setInt(1, accountnoInteger);
	    preparedStatement.setString(2, addresssString);
	    preparedStatement.setDouble(3, balancedouble);

	    preparedStatement.setString(4, city);
	    preparedStatement.setString(5, myname);

	    int i = preparedStatement.executeUpdate();
	    System.out.println("insert successful" + i);

	    connection.close();
	} catch (Exception e) {
	    System.out.println("exception occured" + " " + e);
	}
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	processRequest(req, resp);
    }

}
