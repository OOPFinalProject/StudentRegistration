package ui;
import java.util.Scanner;
import ui.MainMenu;
import dao.StudentDAO;
import dao.CourseDAO;
import model.Student;
import model.Course;
import java.util.ArrayList;
import service.RegistrationService;
import interfaces.Registrable;
public class RegisterStudents{
        private Scanner scanner = new Scanner(System.in);
    public void show(){
        while(true){
             System.out.println("\n=== Register Courses to Students ===");
            System.out.println("1. Register a student");
            System.out.println("2. Register Multiple Students");
            System.out.println("0. Back");
            System.out.print("enter choice: ");
            String choice = scanner.nextLine().trim();

            switch(choice){
                case "0":
                    new MainMenu().show();
                    break;
                case "1":
                    new UnitRegister().show();
                    break;
                    
                case "2":
                    new MultiRegister().show();
                    break;
                default:
                    System.err.println("invalid input");
                    break;


            }
        }
    }
}
class UnitRegister{
       private Scanner scanner = new Scanner(System.in);
    public void show(){
        while(true){
            System.out.println("\n=== Register Courses to a student ===");
            System.out.print("enter student Id: ");
            
            String id = scanner.nextLine().trim();
            try{

            Student student = StudentDAO.getStudent(id);
            System.out.print("enter Course ID: ");
            String Cid = scanner.nextLine().trim();
            Course course =   CourseDAO.getCourse(Cid);
            if (student !=null &&course != null){

                Registrable reg = new RegistrationService();
                reg.register(id,Cid);
                return;
            }else{
                System.err.println("User or Course Not Found");
            }


            }catch(Exception e){
                System.err.println(e);
            }
           
            



            }
        }

}
class MultiRegister{
       private Scanner scanner = new Scanner(System.in);
    public void show(){
        while(true){
             System.out.println("\n=== Register Courses Multiple students ===");
            System.out.print("enter students year: ");
            
            String year = scanner.nextLine().trim();
            try{

            ArrayList<Student> students = StudentDAO.getStudentByYear(year);
            System.out.print("enter Course ID: ");
            String Cid = scanner.nextLine().trim();
            Course course =   CourseDAO.getCourse(Cid);
            if (students !=null &&course != null){
                Registrable reg = new RegistrationService();
                for(int i=0;i<students.size();i++){
                    String id = students.get(i).getStudentId();
                    reg.register(id,Cid);
                }
                return;
            }else{
                System.err.println("User or Course Not Found");
            }


            }catch(Exception e){
                System.err.println(e);
            }
           
            



            }
        }

}