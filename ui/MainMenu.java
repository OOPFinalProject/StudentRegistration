package ui;
import java.util.Scanner;
import ui.addStudents;
import ui.addCourses;
import ui.RegisterStudents;

public class MainMenu{
    private Scanner scanner = new Scanner(System.in);
    public void show(){
        while (true){
            System.out.println("\n=== Main Menu ===");
            System.out.println("1. Add Students");
            System.out.println("2. Add Courses");
            System.out.println("3. Register Courses to Students");
            System.out.println("4. Database Explorer");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            String choice = scanner.nextLine().trim();
            switch (choice){
                case "0":
                    System.out.println("Logging Out");
                    return;
                case "1":
                    new addStudents().show();
                    break;
                case "2":
                    new addCourses().show();
                    break;
                case "3":
                    new RegisterStudents().show();
                    break;

                default:
                    System.out.println("'Invalid Input'");

            }
        }
    }
}
