package dao;

import model.User;
import dbconnect.DBconnect;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    private String INSERT_USER = "insert into users(name,email,country) values(?,?,?)";
    private String select_all_userString = "select * from users";

    private String select_user_by_id = "select * from users where id=?";

    private String delete_user_by_id = "delete from users where id=?";

    private String update_user_by_id = "update users set name=?, email=?,country=? where id=?";

    Connection connection = null;

    public boolean insertuser(User user) {

	boolean result = false;
	try {
	    DBconnect dbconnect = new DBconnect();

	    connection = dbconnect.dbconnect();

	    PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER);

	    preparedStatement.setString(1, user.getNameString());
	    preparedStatement.setString(2, user.getEmailString());
	    preparedStatement.setString(3, user.getCountryString());
	    System.out.println(preparedStatement);
	    int i = preparedStatement.executeUpdate();
	    System.out.println("insert successfull affected rows are" + i);
	    result = true;
	} catch (Exception e) {
	    System.out.println("exception" + e);
	}

	return result;
    }

    public User selectUser(int id) {
	User user = null;

	try {
	    DBconnect dbconnect = new DBconnect();

	    connection = dbconnect.dbconnect();

	    PreparedStatement preparedStatement = connection.prepareStatement(select_user_by_id);

	    preparedStatement.setInt(1, id);
	    System.out.println(preparedStatement);

	    ResultSet resultSet = preparedStatement.executeQuery();

	    while (resultSet.next()) {
		String nameString = resultSet.getString("name");
		String emailString = resultSet.getString("email");
		String countryString = resultSet.getString("country");

		user = new User();
		user.setId(id);
		user.setCountryString(countryString);
		user.setEmailString(emailString);
		user.setNameString(nameString);
	    }

	} catch (Exception e) {
	    e.printStackTrace();
	}

	return user;
    }

    /*this method return list of all user present in database*/
    public List<User> allUsers() {
	List<User> list = new ArrayList<>();

	try {
	    DBconnect dbconnect = new DBconnect();

	    connection = dbconnect.dbconnect();

	    PreparedStatement preparedStatement = connection.prepareStatement(select_all_userString);

	    System.out.println(preparedStatement);

	    ResultSet resultSet = preparedStatement.executeQuery();

	    while (resultSet.next()) {
		int id = resultSet.getInt("id");
		String nameString = resultSet.getString("name");
		String countryString = resultSet.getString("country");
		String emailString = resultSet.getString("email");

		User newUser = new User();

		newUser.setId(id);
		newUser.setCountryString(countryString);
		newUser.setEmailString(emailString);
		newUser.setNameString(nameString);

		list.add(newUser);
	    }

	} catch (Exception e) {
	    e.printStackTrace();
	}

	return list;
    }

    public boolean updateuser(User user) {

	boolean result = false;
	PreparedStatement preparedStatement = null;
	try {

	    DBconnect dbconnect = new DBconnect();

	    connection = dbconnect.dbconnect();

	    preparedStatement = connection.prepareStatement(update_user_by_id);

	    preparedStatement.setString(1, user.getNameString());

	    preparedStatement.setString(2, user.getEmailString());

	    preparedStatement.setString(3, user.getCountryString());

	    preparedStatement.setInt(4, user.getId());

	    int i = preparedStatement.executeUpdate();

	    if (i > 0) {
		result = true;
	    }

	} catch (Exception e) {
	    e.printStackTrace();
	} finally {
	    
	    try {
		if (preparedStatement != null) {
		    preparedStatement.close();
		}
		
		if (connection != null) {
		    connection.close();
		}

	    } catch (Exception e) {
		e.printStackTrace();
	    }
	    return result;
	}
    }

    public boolean deleteUser(int id) {
	boolean result = false;
	try {
	    DBconnect dbconnect = new DBconnect();

	    connection = dbconnect.dbconnect();

	    PreparedStatement preparedStatement = connection.prepareStatement(delete_user_by_id);

	    preparedStatement.setInt(1, id);

	    int i = preparedStatement.executeUpdate();

	    if (i > 0) {
		result = true;
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}

	return result;
    }

    private void printSQLException(SQLException ex) {
	for (Throwable e : ex) {
	    if (e instanceof SQLException) {
		e.printStackTrace(System.err);
		System.err.println("SQLState: " + ((SQLException) e).getSQLState());
		System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
		System.err.println("Message: " + e.getMessage());
		Throwable t = ex.getCause();
		while (t != null) {
		    System.out.println("Cause: " + t);
		    t = t.getCause();
		}
	    }
	}

    }

}
