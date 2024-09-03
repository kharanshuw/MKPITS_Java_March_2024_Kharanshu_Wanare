package Bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class History {

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

    public ArrayList<Transaction> displayHistory(String emailString) {

	int userid = 0;

	boolean result = false;

	ArrayList<Transaction> arrayList = new ArrayList<Transaction>();
	
	try {

	    preparedStatement = connection.prepareStatement("select * from bank.accountholdermaster where email=? ");
	    preparedStatement.setString(1, emailString);
	    resultSet = preparedStatement.executeQuery();
	    while (resultSet.next()) {
		userid = resultSet.getInt("userid");
		System.out.println("userid found");
	    }

	    preparedStatement = connection.prepareStatement("SELECT * FROM bank.transactions where uid_accno=?");
	    preparedStatement.setInt(1, userid);
	    resultSet = preparedStatement.executeQuery();

	    while (resultSet.next()) {
		System.out.println(resultSet.getString("id"));
		System.out.println(resultSet.getString("date"));
		System.out.println(resultSet.getString("uid_accno"));
		System.out.println(resultSet.getString("amount"));
		System.out.println(resultSet.getString("transaction_type"));
		Transaction transaction =new Transaction();
transaction.setIdString(resultSet.getString("id"));
transaction.setAmountString(resultSet.getString("amount"));
transaction.setDateString(resultSet.getString("date"));
transaction.setTransaction_typeString(resultSet.getString("transaction_type"));
transaction.setUid_accno(resultSet.getString("uid_accno"));
		arrayList.add(transaction);
	    }
	  

	} catch (Exception e) {
	    e.printStackTrace();
	}

return  arrayList;

    }
}
