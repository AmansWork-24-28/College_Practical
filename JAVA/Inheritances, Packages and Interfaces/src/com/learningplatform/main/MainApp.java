package com.learningplatform.main;

import java.util.Scanner;
import com.learningplatform.users.*;

public class MainApp {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=== Online Learning Platform ===");

        System.out.println("Enter your name:");
        String name = sc.nextLine();

        System.out.println("Enter your ID:");
        int id = sc.nextInt();

        System.out.println("Select Role:");
        System.out.println("1. Student");
        System.out.println("2. Instructor");
        System.out.println("3. Admin");

        int choice = sc.nextInt();

        User user = null;

        switch (choice) {
            case 1:
                user = new Student(name, id);
                break;
            case 2:
                user = new Instructor(name, id);
                break;
            case 3:
                user = new Admin(name, id);
                break;
            default:
                System.out.println("Invalid choice");
                System.exit(0);
        }

        System.out.println("\n--- User Info ---");
        user.displayInfo();
        user.role();


        user.performAction(sc);

        sc.close();
    }
}