package com.learningplatform.users;

import com.learningplatform.interfaces.*;

public class Student extends User implements ProgressTrackable, Certifiable {

    private int progress;

    public Student(String name, int id) {
        super(name, id); // constructor chaining
    }

    @Override
    public void role() {
        System.out.println("I am a Student");
    }

    // Feature: Course Enrollment
    public void enrollCourse(String courseName) {
        System.out.println(name + " enrolled in " + courseName);
    }

    // Interface method
    public void trackProgress(int progress) {
        this.progress = progress;
        System.out.println("Progress: " + progress + "%");
    }

    // Interface method
    public void generateCertificate() {
        if (progress >= 100)
            System.out.println("Certificate Generated!");
        else
            System.out.println("Complete course first.");
    }

    @Override
    public void performAction(java.util.Scanner sc) {
        sc.nextLine();
        System.out.println("Enter course:");
        String course = sc.nextLine();

        enrollCourse(course);

        System.out.println("Enter progress:");
        int progress = sc.nextInt();

        trackProgress(progress);
        generateCertificate();
    }
}