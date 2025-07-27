package ui;
import model.Course;
import dao.CourseDAO;
import java.util.Scanner;
import ui.MainMenu;
import java.util.InputMismatchException;

class addCourses {
    private Scanner scanner = new Scanner(System.in);

    public void show() {
        while (true) {

            try {
                System.out.println("\n=== Add Courses ===");
                System.out.print("enter courseID: ");
                String courseID = scanner.nextLine();
             
                System.out.print("enter course name: ");
                String course = scanner.nextLine();
             
                System.out.print("enter CreditHours: ");
                String credit = scanner.nextLine();
          

                int intcredit = Integer.parseInt(credit);
                Course newCourse = new Course(courseID, course, intcredit);
                CourseDAO.addCourse(newCourse);
                System.out.println("course Added Successfully!!");
                System.out.print(newCourse.getCourseName());
            } catch (InputMismatchException e) {
                System.out.println("Error: Input type does not match. Please enter the correct data type.");
                new MainMenu().show();
            }catch (IllegalStateException e) {
                System.out.println("Error: Scanner is closed.");
                new MainMenu().show();
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
                new MainMenu().show();
            } 
            new MainMenu().show();
        }
    }
}