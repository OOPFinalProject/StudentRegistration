package service;
import model.Student;
import model.Course;
import interfaces.Registrable;
import dao.RegistrationDAO;
import dao.StudentDAO;
import dao.CourseDAO;
import java.util.ArrayList;
import model.customExceptions;
public class RegistrationService implements Registrable {

    @Override
    public  void register(String studentId, String courseId){
        int credSum = 0;
        ArrayList<String> courses = RegistrationDAO.getEnrolledCourses(studentId);
        for(String id : courses) {
                Course course = CourseDAO.getCourse(id);
                credSum += course.getCreditHours();
        }
        if(courses.contains(courseId)){
            try {
                 throw new customExceptions.AlreadyRegisteredException("already registered");
            }catch (Exception e){


            }
        }
        if (credSum <15){

            try{
                RegistrationDAO.register(studentId,courseId);
                System.out.println("Student Registered!!!");
            }catch(customExceptions.AlreadyRegisteredException e){
                e.getMessage();
            }
        }else{
            try{
                throw new customExceptions.CourseLimitException("Credit hours reached limits!!");
            }catch(Exception e){
                e.getMessage();
            }
        }

    }


}