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
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet(name = "WithdrawServlet", urlPatterns = {"/WithdrawServlet"})
public class WithdrawServlet extends HttpServlet {

   protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    PrintWriter printWriter = null;
    double balance = 0;
    response.setContentType("text/html");
    try {
        printWriter = response.getWriter();

        String useramountString = request.getParameter("amount");

        System.out.println("useramount: " + useramountString);

        int amount = Integer.parseInt(useramountString);

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "root");
        System.out.println("Connection successful");

        PreparedStatement pre = connection.prepareStatement("select * from bank.accountholdermaster where email=? ");

        HttpSession httpSession = request.getSession(true);

        String emailString = httpSession.getAttribute("email").toString();

        pre.setString(1, emailString);

        ResultSet resultSet = pre.executeQuery();

        while (resultSet.next()) {
            String emailString1 = resultSet.getString("email");
            String userid = resultSet.getString("userid");
            balance = resultSet.getDouble("balance");
            System.out.println("Email: " + emailString1);
            System.out.println("User ID: " + userid);
            System.out.println("Balance: " + balance);
        }

        if (amount < 0) {
            System.out.println("Invalid withdrawal amount.");
        } else if (amount > balance) {
            System.out.println("Insufficient funds.");
        } else {
            // Withdraw the amount
            balance -= amount;
            PreparedStatement preparedStatement = connection.prepareStatement("update accountholdermaster set balance=? where email=?");
            preparedStatement.setString(2, emailString);
            preparedStatement.setDouble(1, balance);
            preparedStatement.executeUpdate(); // Execute the update
            System.out.println("Amount withdrawn successfully.");
        }

        double newbalance = balancecheck(emailString);
        System.out.println("New balance: " + newbalance);

        if (newbalance > 0) {
            response.sendRedirect("successful.html");
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
}

public double balancecheck(String emailString) {
    double balance = 0;
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "root");
        System.out.println("Connection successful");
        PreparedStatement preparedStatement = connection.prepareStatement("select * from accountholdermaster where email=?");
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
