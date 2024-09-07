
package myservlet;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import  java.sql.*;


@WebServlet(name = "BalanceServlet", urlPatterns = {"/BalanceServlet"})
public class BalanceServlet extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	    try {
	    
		HttpSession session=request.getSession();
  String emailString = session.getAttribute("email").toString();
	
	    String useridString = null;
	    String nameString = null;
	    double balance = 0;
	    Class.forName("com.mysql.cj.jdbc.Driver");
	    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "root");
	    System.out.println("connection successful");

	    PreparedStatement pre = connection.prepareStatement("select * from bank.accountholdermaster where email=? ");

	    pre.setString(1, emailString);

	    ResultSet resultSet = pre.executeQuery();

	    while (resultSet.next()) {
		String email = resultSet.getString("email");
		String passwordString = resultSet.getString("password");
		System.out.println("email" + email);
		balance = Double.parseDouble(resultSet.getString("balance"));
		System.out.println(" balance " + balance);
		useridString = resultSet.getString("userid");
		nameString = resultSet.getString("name");

	    }


	} catch (Exception e) {
	e.printStackTrace();
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
