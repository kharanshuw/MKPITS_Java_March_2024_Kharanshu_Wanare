package jdbctest;

import java.sql.SQLException;

public class MyjdbcClass {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		DBOperation dbOperation=new DBOperation();
	//	dbOperation.display("actor");
		
				
		System.out.println("*********************");
		
	//	dbOperation.displaybyid(2);
		
		System.out.println("***********************");
	//	dbOperation.displaydatabyid1(2);
		
		//dbOperation.insertStudentRecord("1007", "akash", "abc","banglore");
		
		//dbOperation.deleteStudentRecord("1007");
		
		Student student=new Student("1007", "akash", "abc","banglore");
		dbOperation.insertStudentRecord1(student);
	}
}
