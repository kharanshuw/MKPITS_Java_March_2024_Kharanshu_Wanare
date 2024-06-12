package jdbctest;

import java.sql.*;
import java.util.Iterator;

public class DBOperation {

	public void display(String tablename) throws SQLException, ClassNotFoundException {
		Dbconnection dbconnection = new Dbconnection();
		Connection connection = dbconnection.connection();
		// System.out.println(connection);
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("select * from " + tablename);
		ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
		int count = resultSetMetaData.getColumnCount();
		for (int i = 1; i <= count; i++) {
			System.out.print(resultSetMetaData.getColumnName(i) + " ");
		}
		while (resultSet.next()) {
			for (int i = 1; i <= count; i++) {
				// System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2
				// ) + " " + resultSet.getString(3) + " " + resultSet.getDate(4));
				System.out.print(resultSet.getString(i) + " ");
			}
			System.out.println();
		}
		connection.close();
	}

	public void displaybyid(int actor_id) throws SQLException, ClassNotFoundException {
		Dbconnection dbconnection = new Dbconnection();
		Connection connection = dbconnection.connection();
		// System.out.println(connection);
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("select * from actor where actor_id=" + actor_id);
		while (resultSet.next()) {
			System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3) + " "
					+ resultSet.getDate(4));
		}
		connection.close();
	}

	public void displaydatabyid1(int actorid) throws SQLException, ClassNotFoundException {
		Dbconnection dbconnection = new Dbconnection();
		Connection connection = dbconnection.connection();
		// System.out.println(connection);
		PreparedStatement preparedStatement = connection.prepareStatement("select * from actor where  actor_id=?");
		preparedStatement.setInt(1, actorid);

		ResultSet resultSet = preparedStatement.executeQuery();

		ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
		int count = resultSetMetaData.getColumnCount();
		while (resultSet.next()) {
			for (int i = 1; i <= count; i++) {
				System.out.print(resultSet.getString(i) + " ");
			}
			System.out.println();
		}
		connection.close();
	}

	public void insertStudentRecord(String rn, String nmString, String adString, String cityString)
			throws ClassNotFoundException, SQLException {
		Dbconnection dbconnection = new Dbconnection();
		Connection connection = dbconnection.connection();
		PreparedStatement preparedStatement = connection.prepareStatement("insert into studentdetails VALUES(?,?,?,?)");
		preparedStatement.setString(1, rn);
		preparedStatement.setString(2, nmString);
		preparedStatement.setString(3, adString);
		preparedStatement.setString(4, cityString);

		int rs = preparedStatement.executeUpdate();
		if (rs == 1) {
			System.out.println("value inserted");
		} else {
			System.out.println("value not inserted");
		}
	}

	public void updateStudentRecords(String rmString, String addressString)
			throws ClassNotFoundException, SQLException {
		Dbconnection dbconnection = new Dbconnection();
		Connection connection = dbconnection.connection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("update studentdetails set address=? where rollno=?");
		preparedStatement.setString(1, addressString);
		preparedStatement.setString(2, rmString);

		int result = preparedStatement.executeUpdate();

		if (result == 1) {
			System.out.println("update successful");
		} else {
			System.out.println("update failed");
		}
	}

	public void deleteStudentRecord(String rollnoString) {
		Dbconnection dbconnection = new Dbconnection();
		try {
			Connection connection = dbconnection.connection();
			PreparedStatement preparedStatement = connection
					.prepareStatement("DELETE FROM student.studentdetails WHERE rollno=?");
			preparedStatement.setString(1, rollnoString);
			int result = preparedStatement.executeUpdate();

			if (result == 1) {
				System.out.println("delete successful");
			} else {
				System.out.println("delete failed");
			}

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void insertStudentRecord1(Student student)
			throws ClassNotFoundException, SQLException {
		Dbconnection dbconnection = new Dbconnection();
		Connection connection = dbconnection.connection();
		PreparedStatement preparedStatement = connection.prepareStatement("insert into studentdetails VALUES(?,?,?,?)");
		preparedStatement.setString(1, student.getRollnoString());
		preparedStatement.setString(2, student.getNameString());
		preparedStatement.setString(3, student.getAddressString());
		preparedStatement.setString(4, student.getCityString());

		int rs = preparedStatement.executeUpdate();
		if (rs == 1) {
			System.out.println("value inserted");
		} else {
			System.out.println("value not inserted");
		}
	}
	
	
}
