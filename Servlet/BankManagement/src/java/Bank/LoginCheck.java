package Bank;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

public class LoginCheck {

    Connection connection = null;

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

    public boolean verifyLogin(AccountHolderMaster accountHolderMaster) {
	boolean result = false;

	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	try {
	    preparedStatement = connection.prepareStatement("select * from bank.accountholdermaster where email=? and password=?");
	    preparedStatement.setString(1, accountHolderMaster.getEmailString());
	    preparedStatement.setString(2, accountHolderMaster.getPasswordString());
	    resultSet = preparedStatement.executeQuery();

	    while (resultSet.next()) {
		if (resultSet.getString("email").isEmpty() || resultSet.getString("password").isEmpty()) {
		    System.out.println("email or password is empty");
		} else if (resultSet.getString("email").equals(accountHolderMaster.getEmailString()) && resultSet.getString("password").equals(accountHolderMaster.getPasswordString())) {
		    result = true;
		}
	    }

	} catch (Exception e) {
	    System.out.println(e);
	    e.printStackTrace();
	}
	return result;
    }
}
