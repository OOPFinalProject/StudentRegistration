package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Course;
import dao.DBConnection;
import java.util.ArrayList;
import model.customExceptions;

public class CourseDAO {
    public static void addCourse (Course course) throws customExceptions.CourseNotCreatedException  {
        try(Connection conn = DBConnection.getConnection()){
            String sql = "INSERT INTO courses (course_id, course_name, credit_hours) VALUES (?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, course.getCourseId());
            pstmt.setString(2, course.getCourseName());
            pstmt.setInt(3, course.getCreditHours());
            pstmt.executeUpdate();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            throw new customExceptions.CourseNotCreatedException("Error creating the course");
        }
    }
    public static Course getCourse(String courseId) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM courses WHERE course_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, courseId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Course(
                    rs.getString("course_id"),
                    rs.getString("course_name"),
                    rs.getInt("credit_hours")
                );
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static ArrayList<Course> allCourses(){
        ArrayList<Course> courses = new ArrayList<>();
        try(Connection conn = DBConnection.getConnection()){
            String sql = "SELECT * FROM courses";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                courses.add(
                    new Course(
                        rs.getString("course_id"),
                        rs.getString("course_name"),
                        rs.getInt("credit_hours")
                    )
                );
                

            }
        }
        catch(Exception e){
            System.out.print(e);
        };
        return courses;
}
}