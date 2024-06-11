package jdbctest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbconnection {

      public Connection connection() throws ClassNotFoundException, SQLException {
	  
	  //forName method takes classpath of jdbc driver
        Class.forName(Dbconfig.classname);
//getConnection takes 2 para,1st is url,2nd is user,3rd is password
     Connection connection =  DriverManager.getConnection( Dbconfig.url,
                Dbconfig.user, Dbconfig.password);


    return  connection;
    }
}
