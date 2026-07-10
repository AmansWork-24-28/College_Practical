package com.learningplatform.users;

public class Admin extends User {

    public Admin(String name, int id) {
        super(name, id);
    }

    @Override
    public void role() {
        System.out.println("I am an Admin");
    }

    public void manageUsers() {
        System.out.println("Managing users...");
    }

    @Override
    public void performAction(java.util.Scanner sc) {
        manageUsers();
    }
}