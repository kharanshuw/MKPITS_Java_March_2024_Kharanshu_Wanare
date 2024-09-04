package dbconnect;

import java.sql.*;

public class Dbconnect {

   public static Connection connection = null;

    public static Connection dbconnection() {
	try {
	    Class.forName("com.mysql.cj.jdbc.Driver");
	    connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "root");
	    System.out.println("connection successful");
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return connection;
    }
}
