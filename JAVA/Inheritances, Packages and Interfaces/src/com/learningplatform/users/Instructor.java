package com.learningplatform.users;

public class Instructor extends User {

    public Instructor(String name, int id) {
        super(name, id);
    }

    @Override
    public void role() {
        System.out.println("I am an Instructor");
    }

    public void createCourse(String courseName) {
        System.out.println("Course created: " + courseName);
    }

    @Override
    public void performAction(java.util.Scanner sc) {
        sc.nextLine();
        System.out.println("Enter course:");
        String course = sc.nextLine();

        createCourse(course);
    }
}