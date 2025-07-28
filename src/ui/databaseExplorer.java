package ui;

import java.util.Scanner;
import dao.StudentDAO;
import dao.CourseDAO;
import java.io.IOException;
import java.util.ArrayList;
import ui.MainMenu;
import model.Student;
import dao.RegistrationDAO;
import util.Logger;
import interfaces.Loggable;
import model.Course;
import java.util.InputMismatchException;

public class databaseExplorer {
    private Scanner scanner = new Scanner(System.in);

    public void show() {

        while (true) {
            System.out.println("\n=== Database Explorer ===");
            System.out.println("1. View All Students");
            System.out.println("2. View Students by Id");
            System.out.println("3. View All Courses");
            System.out.println("4. Delete a Student");
            System.out.println("5. Delete Students by year");
            System.out.println("6. Export into text file ");
            System.out.println("7. Read a text file ");
            System.out.println("0. Back to Main menu ");

            System.out.print("Enter choice: ");
            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "0":
                    new MainMenu().show();
                    break;
                case "1":
                    new AllStudents().show();
                    break;
                case "2":
                    new AllStudents().getstudent();
                    break;
                case "3":
                    new AllCourses().show();
                    break;
                case "4":
                    new AllStudents().deleteStudent();
                    break;
                case "5":
                    new AllStudents().deleteStudentByYear();
                    break;
                case "6":
                    new Exporter().show();
                    break;
                case "7":
                    new Reader().show();
                    break;
                default:
                    System.err.println("invalid input");
                    break;
            }
        }

    }
}

class AllStudents {
    private Scanner scanner = new Scanner(System.in);

    public void show() {
        try {
            ArrayList<Student> students = StudentDAO.allStudents();
            System.out.print("NAME");
            System.out.print("          ");
            System.out.print("YEAR");
            System.out.print("          ");
            System.out.print("MAJOR");
            System.out.println();
            for (int i = 0; i < students.size(); i++) {
                System.out.println(students.get(i).getName() + "   " + students.get(i).getYear() + "  "
                        + students.get(i).getMajor() + "  " + students.get(i).getStudentId());
            }
        } catch (Exception e) {
            System.err.println(e);
        }

    }

    public void getstudent() {
        System.out.print("Enter Student Id: ");
        String id = scanner.nextLine().trim();
        try {
            Student student = StudentDAO.getStudent(id);
            System.out.print("NAME");
            System.out.print("          ");
            System.out.print("YEAR");
            System.out.print("          ");
            System.out.print("MAJOR");
            System.out.println();

            System.out.println(student.getName() + "   " + student.getYear() + "  "
                    + student.getMajor() + "  " + student.getStudentId());
        } catch (InputMismatchException e) {
            System.out.println("Error: Input type does not match. Please enter the correct data type.");
            new MainMenu().show();
        }  catch (IllegalStateException e) {
            System.out.println("Error: Scanner is closed.");
            new MainMenu().show();
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
            new MainMenu().show();
        } 
    }

    public void deleteStudent() {
        System.out.print("Enter Student Id: ");
        String id = scanner.nextLine().trim();
        try {
            StudentDAO.deleteStudent(id);
            System.out.println("Student delted!!");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

    public void deleteStudentByYear() {
        System.out.print("Enter year to delete: ");
        String year = scanner.nextLine().trim();
        try {
            ArrayList<Student> students = StudentDAO.getStudentByYear(year);
            for (Student student : students) {
                StudentDAO.deleteStudent(student.getStudentId());

            }
            System.out.println("Students on year: " + year + " has been deleted!!");

        } catch (InputMismatchException e) {
            System.out.println("Error: Input type does not match. Please enter the correct data type.");
            new MainMenu().show();
        }  catch (IllegalStateException e) {
            System.out.println("Error: Scanner is closed.");
            new MainMenu().show();
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
            new MainMenu().show();
        }
          
    }
}

class AllCourses {
    public void show() {
        try {
            ArrayList<Course> courses = CourseDAO.allCourses();
            System.out.print("NAME");
            System.out.print("          ");
            System.out.print("ID");
            System.out.print("          ");
            System.out.print("Credits");
            System.out.println();
            for (int i = 0; i < courses.size(); i++) {
                System.out.println(courses.get(i).getCourseName() + "   " + courses.get(i).getCourseId() + "  "
                        + courses.get(i).getCreditHours());

            }

        } catch (Exception e) {
            System.err.println(e);
        }

    }

}

class Exporter {
    private Scanner scanner = new Scanner(System.in);

    void show() {
        while (true) {
            System.out.println("1. Export All Students  ");
            System.out.println("2. Export Registrations By Course  ");
            System.out.println("0. Back to Main menu ");
            System.out.print("Enter choice: ");
            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "0":
                    new MainMenu().show();
                    break;
                case "1":
                    exportStud();
                    break;
                
                case "2":
                    exportReg();
                    break;
                

                default:
                    System.err.println("invalid input");
                    break;
            }
        }

    }

    public void exportStud() {
        Loggable logger = new Logger();
        ArrayList<Student> students = StudentDAO.allStudents();
        for (Student student : students) {
            String entry = student.getStudentId() + "|" + student.getName() + "|" + student.getYear() + "|"
                    + student.getMajor();
            try {
                logger.log(entry, "students");
            } catch (IllegalStateException e) {
                System.out.println("Error: Scanner is closed.");
                new MainMenu().show();
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
                new MainMenu().show();
            } 
              
            System.out.println("exported to students.txt");

        }

    }
    public void exportReg(){
        Loggable logger = new Logger();
        System.out.println("0. Back to Main menu ");
        System.out.print("Enter CourseId: ");
        String choice = scanner.nextLine().trim();
        switch (choice) {
            case "0":
                new MainMenu().show();
                break;
            default:
                ArrayList<String> regs = RegistrationDAO.getEnrolledStudents(choice);
                for (int i=0; i<regs.size();i++) {
                    String entry = regs.get(i);
                    try {
                        logger.log(entry, choice+ "-registrations");
                    } catch (IllegalStateException e) {
                        System.out.println("Error: Scanner is closed.");
                        new MainMenu().show();
                    } catch (Exception e) {
                        System.out.println("An unexpected error occurred: " + e.getMessage());
                        new MainMenu().show();
                    } 
                      
                    System.out.println("exported to registrations.txt");
                }
                break;
        }

    }

}

class Reader {
    private Scanner scanner = new Scanner(System.in);

    public void show() {

        System.out.println("=== File Reader ===");
        System.out.print("Enter file name only ('students'): ");
        String fileName = scanner.nextLine().trim();
        try {
            Loggable logger = new Logger();
            logger.read(fileName);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}