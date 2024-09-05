package dbconnect;

import java.sql.*;

public class DBconnect {



    Connection connection = null;

    public Connection dbconnect() {

	try {
	    Class.forName("com.mysql.cj.jdbc.Driver");
	connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "root");
	    System.out.println("connection successful");

	} catch (Exception e) {
	e.printStackTrace();
	}
	return connection;

    }

}
