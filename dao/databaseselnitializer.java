package StudentRegistration.dao;

import java.sql.Connection;
import java.sql.Statement;

public class databaseselnitializer {
    public static void intialize(){
        try(Connection conn =DBConnection.getConnection();
        Statement stmt= conn.createStatement()){
            String studentsTable= """
                    CREATE TABLE IF NOT EXISTS students(
                        id INTIGER PRIMARY KEY AUTOINCREMENT,
                        student_id TEXT UNIQUE,
                        name TEXT,
                        major TEXT
                        year INTEGER
                    );
                    """;
            String coursesTable= """
                    CREATE TABLE IF NOT EXISTS courses(
                        id INTEGER PRIMARY KEY AUTOINCREMENT,
                        course_id TEXT UNIQUE,
                        course_name TEXT,
                        credit_hours INTEGER

                
                        
                        
                    )

                    """;
            String registrationTable="""
                    CREATE TABLE IF NOT EXISTS registration(
                        id INTEGER PRIMARY KEY AUTOINCREMENT,
                        student_id TEXT,
                        cousre_id TEXT UNIQUE,
                        FOREIGN KEY (student_id) REFERENCES ON DELETE CASCADE,
                        FOREIGN KEY (course_id) REFERENCES ON courses(course_id)


                    );
                    """;
                    stmt.execute(studentsTable);
                    stmt.execute(coursesTable);
                    stmt.execute(registrationTable); 
                    
                    System.out.println("Database tables created");

                    
                
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
