package ui;

import java.util.Scanner;
import util.InputValidators;
import dao.StudentDAO;
import model.Student;
import util.UserGen;
import java.util.InputMismatchException;
import model.customExceptions.StudentNotCreatedException;

public class AddStudents {
    private Scanner scanner = new Scanner(System.in);

    public void show() {
        while (true) {
            try {
                System.out.println("\n=== Add Student ===");
                System.out.print("enter student name: ");
                String name = scanner.nextLine();
                name = InputValidators.validate(name);
                if (name.equals("err")) {
                    continue;
                }
                System.out.print("enter major: ");
                String major = scanner.nextLine();
                major = InputValidators.validate(major);
                if (major.equals("err")) {
                    continue;
                }
                System.out.print("enter year: ");
                String year = scanner.nextLine();
                year = InputValidators.validate(year);
                if (year.equals("err")) {
                    continue;
                }

                int intyear = Integer.parseInt(year);
                String ID = UserGen.generateShortId();
                Student newStudent = new Student(name, ID, major, intyear);
                StudentDAO.addStudent(newStudent);
                System.out.println("Student Added Successfully!!");

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

            new MainMenu().show();

        }
    }
}