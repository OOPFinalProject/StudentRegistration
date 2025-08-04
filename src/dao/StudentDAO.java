package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Student;
import model.customExceptions;
import dao.DBConnection;
import java.util.ArrayList;

public class StudentDAO {
     public static void deleteStudent(String studentId) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "DELETE FROM students WHERE student_id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, studentId);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.getMessage();
        }
    }
    public static void addStudent(Student student) throws customExceptions.StudentNotCreatedException   {
        try(Connection conn = DBConnection.getConnection()){
            String sql = "INSERT INTO students (student_id, name, major, year) VALUES (?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, student.getStudentId());
            pstmt.setString(2, student.getName());
            pstmt.setString(3, student.getMajor());
            pstmt.setString(4, String.valueOf(student.getYear()));
            pstmt.executeUpdate();
        }
        catch(Exception e){
            throw new customExceptions.StudentNotCreatedException("Could not ccreate student instance");
        }
    }
    public static Student getStudent(String studentId) {
        try(Connection conn = DBConnection.getConnection()){
            String sql = "SELECT * FROM students WHERE student_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, studentId);
            ResultSet rs = pstmt.executeQuery();
           if (rs.next()) {
                 return new Student(rs.getString("name"),rs.getString("student_id"),rs.getString("major"),rs.getInt("year"));
            }

            return null;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
       }   
            return null;
    }
public static ArrayList<Student> allStudents() {
    ArrayList<Student> students = new ArrayList<>();
    try (Connection conn = DBConnection.getConnection()) {
        String sql = "SELECT * FROM students";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            students.add(new Student(
                rs.getString("name"),
                rs.getString("student_id"),
                rs.getString("major"),
                rs.getInt("year")
            ));
        }
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
    return students;
}



public static ArrayList<Student> getStudentByYear(String year) {
        ArrayList<Student> students = new ArrayList<>();
        try(Connection conn = DBConnection.getConnection()){
            String sql = "SELECT * FROM students WHERE year = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, year);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
            students.add(new Student(
                rs.getString("name"),
                rs.getString("student_id"),
                rs.getString("major"),
                rs.getInt("year")
            ));
            }

        }
        catch(Exception e){
            System.out.println(e.getMessage());
       }   
            return students;
    }
}