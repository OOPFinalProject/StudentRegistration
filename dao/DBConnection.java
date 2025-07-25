package StudentRegistration.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private static final String URL="jdbc:sqlite:students.db";
    public static Connection getConnection() throws Exception{
        return DriverManager.getConnection(URL);
    }

    
}
