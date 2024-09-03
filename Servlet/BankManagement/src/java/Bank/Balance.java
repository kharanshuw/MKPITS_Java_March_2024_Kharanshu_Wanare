package Bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Balance {

    Connection connection = null;

    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    public void connectdb() {
	try {
	    Class.forName("com.mysql.cj.jdbc.Driver");
	    connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "root");
	    System.out.println("connection successful");
	} catch (SQLException sqle) {
	    sqle.printStackTrace();
	} catch (Exception e) {
	    e.printStackTrace();
	}

    }

    public double displayBalance(String emailString) {
	
	double balance=0;
	try {
	    preparedStatement=connection.prepareStatement("select * from accountholdermaster where email=?");
preparedStatement.setString(1, emailString);
	  resultSet =  preparedStatement.executeQuery();
	    while (resultSet.next()) {		
		balance=Double.parseDouble(resultSet.getString("balance"));
	    }
	} catch (Exception e) {

	    e.printStackTrace();
	}
	return balance;
    }
}
