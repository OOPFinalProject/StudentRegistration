package dao;

import java.sql.Connection;
import java.sql.Statement;

public class DatabaseInitializer {
    public static void initialize() {
        try (Connection conn = DBConnection.getConnection(); Statement stmt = conn.createStatement()) {
            String studentsTable = """
                CREATE TABLE IF NOT EXISTS students (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    student_id TEXT UNIQUE,
                    name TEXT,
                    major TEXT,
                    year INTEGER
                );
            """;

            String coursesTable = """
                CREATE TABLE IF NOT EXISTS courses (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    course_id TEXT UNIQUE,
                    course_name TEXT,
                    credit_hours INTEGER
                );
            """;

            String registrationTable = """
                CREATE TABLE IF NOT EXISTS registration (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    student_id TEXT ,
                    course_id TEXT ,
                    FOREIGN KEY (student_id) REFERENCES students(student_id) ON DELETE CASCADE ,
                    FOREIGN KEY (course_id) REFERENCES courses(course_id),
                    UNIQUE (student_id, course_id)

                );
            """;

            stmt.execute(studentsTable);
            stmt.execute(coursesTable);
            stmt.execute(registrationTable);

            System.out.println("✅ Database tables created.");
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
