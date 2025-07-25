package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Student;
import model.customExceptions;
import dao.DBConnection;
import java.util.ArrayList;
import model.Course;

public class RegistrationDAO {
    public static void register(String studentId,String courseId) throws customExceptions.AlreadyRegisteredException {
        try(Connection conn = DBConnection.getConnection()){
            String sql = "INSERT INTO registration (student_id, course_id) VALUES (?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, studentId);
            pstmt.setString(2, courseId);
            pstmt.executeUpdate();
        }
        catch(Exception e){
            throw new customExceptions.AlreadyRegisteredException("could not register, mayme this student has already registered");

        }
    }
    
   //get a list of courses enrolled by the student,
public static ArrayList getEnrolledCourses(String studentId) {
    ArrayList courses = new ArrayList<>();
    try (Connection conn = DBConnection.getConnection()) {
        String sql = "SELECT * FROM registration WHERE student_id = ? ";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, studentId);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            courses.add(rs.getString("course_id"));
        }
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
    return courses;
}


// student who are enrolled in a specific course returnns list of student ids
public static ArrayList getEnrolledStudents(String courseId) {
    ArrayList students = new ArrayList<>();
    try (Connection conn = DBConnection.getConnection()) {
        String sql = "SELECT * FROM registration WHERE course_id = ? ";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, courseId);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            students.add(rs.getString("student_id"));
        }
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
    return students;
}


}