package Bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Withdraw {

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

    public boolean withdrawAmount(String emailString, double amount) {
	boolean result = false;
	double balanceBeforeWithdraw = 0;
	double balanceAfterWithdraw = 0;

	int userid = 0;

	try {
	    preparedStatement = connection.prepareStatement("select * from bank.accountholdermaster where email=? ");
	    preparedStatement.setString(1, emailString);

	    resultSet = preparedStatement.executeQuery();

	    while (resultSet.next()) {
		balanceBeforeWithdraw = resultSet.getDouble("balance");
		userid = resultSet.getInt("userid");
	    }

	    if (balanceBeforeWithdraw <= 0) {
		System.out.println("balance is less than 0");
		return false;
	    }

	    if (balanceBeforeWithdraw < amount) {
		System.out.println("balance is less than withdraw amount");
		return false;
	    } else {
		balanceAfterWithdraw = balanceBeforeWithdraw - amount;

		preparedStatement = connection.prepareStatement("update  accountholdermaster set balance=? where email=?");
		preparedStatement.setDouble(1, balanceAfterWithdraw);
		preparedStatement.setString(2, emailString);
		int i = 0;
		i = preparedStatement.executeUpdate();

		System.out.println("amount withdrawn sucessfull");
		System.out.println("no of record affected in accountholdermaster is" + i);

		preparedStatement = connection.prepareStatement("insert into transactions(uid_accno,amount,transaction_type) values(?,?,?)");
		preparedStatement.setInt(1, userid);
		preparedStatement.setDouble(2, amount);
		String transaction_type = "withdraw";
		preparedStatement.setString(3, transaction_type);
		i = preparedStatement.executeUpdate();
		System.out.println("no of recored affected in transaction table" + i);

		result = true;
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}

	return result;

    }

}
