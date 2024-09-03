package Bank;

import java.sql.*;
import java.sql.Connection;

public class DisplayUserDetails {

    Connection connection = null;
    PreparedStatement preparedStatement = null;

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

    public String displayResultSet(AccountHolderMaster accountHolderMaster) {
	ResultSet resultSet = null;
	try {
	    preparedStatement = connection.prepareStatement("select * from bank.accountholdermaster");
	    resultSet = preparedStatement.executeQuery();
	    while (resultSet.next()) {
		String emailString = resultSet.getString("email");
		String useridString = resultSet.getString("userid");
		String nameString = resultSet.getString("name");
		String cityString = resultSet.getString("balance");

		accountHolderMaster.setEmailString(emailString);
		accountHolderMaster.setUserid(Integer.parseInt(useridString));
		accountHolderMaster.setName(nameString);
		accountHolderMaster.setCity(cityString);
		return "successful";
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}

	return "failed";

    }

}
