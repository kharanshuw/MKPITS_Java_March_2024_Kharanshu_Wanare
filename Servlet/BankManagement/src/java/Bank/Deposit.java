package Bank;

import jakarta.servlet.http.HttpSession;
import java.sql.*;

public class Deposit {

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

    public boolean depositAmount(String emailString, double amount) {
	boolean result = false;
	double balanceBeforeDeposit = 0;
	double balanceAfterDeposit = 0;
	int userid = 0;
	try {
	    preparedStatement = connection.prepareStatement("select * from bank.accountholdermaster where email=? ");
	    preparedStatement.setString(1, emailString);
	    resultSet = preparedStatement.executeQuery();
	    while (resultSet.next()) {
		balanceBeforeDeposit = resultSet.getDouble("balance");
		userid = resultSet.getInt("userid");
	    }

	    balanceAfterDeposit = balanceBeforeDeposit + amount;

	    preparedStatement = connection.prepareStatement("update  accountholdermaster set balance=? where email=?");
	    preparedStatement.setDouble(1, balanceAfterDeposit);
	    preparedStatement.setString(2, emailString);
	    int i = 0;
	    i = preparedStatement.executeUpdate();

	    System.out.println("amount deposited sucessfull");
	    System.out.println("no of record affected in accountholdermaster is" + i);

	    preparedStatement = connection.prepareStatement("insert into transactions(uid_accno,amount,transaction_type) values(?,?,?)");
	    preparedStatement.setInt(1, userid);
	    preparedStatement.setDouble(2, amount);
	    String transaction_type = "deposit";
	    preparedStatement.setString(3, transaction_type);
	    i = preparedStatement.executeUpdate();
	    System.out.println("no of recored affected in transaction table" + i);

	    result = true;

	} catch (Exception e) {
	    e.printStackTrace();
	}
	return result;
    }

}
