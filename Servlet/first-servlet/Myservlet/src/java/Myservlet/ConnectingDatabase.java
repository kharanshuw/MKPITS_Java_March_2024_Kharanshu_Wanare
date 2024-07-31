package Myservlet;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.sql.*;

public class ConnectingDatabase extends HttpServlet {

    public void displayAll() {
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
            connection.close();
        } catch (Exception e) {
            System.out.println("exception found:" + e);
        }
    }

    public void insertdata(HttpServletRequest request, HttpServletResponse response) {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");
            // Connection connection=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
            System.out.println("connection successful");
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
            System.out.println("exception found:" + e);
        }
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            insertdata(request, response);
        } catch (Exception e) {
            System.out.println("exception occured" + " " + e);
        }
    }

    /*@Override*/
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

}
