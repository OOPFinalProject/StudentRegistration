package model;
import java.util.ArrayList;
import abstracts.Person;
import model.customExceptions.CourseLimitException;

public class Student extends Person {
    private String studentId;
    private String major;
    private int year;
    private ArrayList<String> courses;
    private int coursesTaken=0;

    public Student(String name, String studentId, String major, int year) {
        super(name);
        this.studentId = studentId;
        this.major = major;
        this.year = year;

    }
    public String getName(){
        return this.name;
    }
    public String getStudentId(){
        return this.studentId;
    }
     public String getMajor(){
        return this.major;
    }
     public int getYear(){
        return this.year;
    }

    public void enroll(String courseId) {
        if (coursesTaken < 5) {
            courses.add(courseId);
            coursesTaken++;
        } else {
            try{
                throw new CourseLimitException("Student is already enrolled in 5 courses");
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
    }


}