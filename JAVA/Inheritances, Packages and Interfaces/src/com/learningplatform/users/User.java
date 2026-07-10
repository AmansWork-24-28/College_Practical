package com.learningplatform.users;

public abstract class User {
    protected String name;
    protected int id;

    public User(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public void displayInfo() {
        System.out.println("Name: " + name + ", ID: " + id);
    }

    public abstract void role(); // abstract method
    public abstract void performAction(java.util.Scanner sc);
}