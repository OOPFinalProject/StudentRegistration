package ui;
import ui.MainMenu;
import dao.DatabaseInitializer;

public class Main {
    public static void main(String[] args) {
        System.out.println("****Welcome to StuReg Students Registration and Management System****");
        new MainMenu().show();

        
    }
}