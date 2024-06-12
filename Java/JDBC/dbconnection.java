package jdbctest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbconnection {

      public Connection connection() throws ClassNotFoundException, SQLException {
        Class.forName(Dbconfig.classname);

     Connection connection =  DriverManager.getConnection( Dbconfig.url1,
                Dbconfig.user, Dbconfig.password);


    return  connection;
    }
}
