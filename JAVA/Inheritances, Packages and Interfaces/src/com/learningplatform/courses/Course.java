package com.learningplatform.courses;

public class Course {
    private String courseName;

    public Course(String courseName) {
        this.courseName = courseName;
    }

    public void showCourse() {
        System.out.println("Course: " + courseName);
    }
}