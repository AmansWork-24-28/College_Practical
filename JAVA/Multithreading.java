package JAVA;

import java.util.*;

class Order {
    int id;
    String item;

    Order(int id, String item) {
        this.id = id;
        this.item = item;
    }
}

class Customer extends Thread {
    List<Order> list;
    String name;

    Customer(String name, List<Order> list) {
        this.name = name;
        this.list = list;
    }

    public void run() {
        for (Order o : list) {
            System.out.println(name + " delivering Order " + o.id + ": " + o.item);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {}

            System.out.println(name + " delivered Order " + o.id);
        }
    }
}

public class Multithreading {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Order> l1 = new ArrayList<>();
        List<Order> l2 = new ArrayList<>();
        List<Order> l3 = new ArrayList<>();

        int choice;
        int id = 1;

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Add Order to Suraj");
            System.out.println("2. Add Order to Om");
            System.out.println("3. Add Order to Aman");
            System.out.println("4. Start Delivery");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter food item: ");
                    l1.add(new Order(id++, sc.nextLine()));
                    break;

                case 2:
                    System.out.print("Enter food item: ");
                    l2.add(new Order(id++, sc.nextLine()));
                    break;

                case 3:
                    System.out.print("Enter food item: ");
                    l3.add(new Order(id++, sc.nextLine()));
                    break;

                case 4:
                    Customer c1 = new Customer("Suraj", l1);
                    Customer c2 = new Customer("Om", l2);
                    Customer c3 = new Customer("Aman", l3);

                    c1.start();
                    c2.start();
                    c3.start();

                    try {
                        c1.join();
                        c2.join();
                        c3.join();
                    } catch (Exception e) {}

                    break; 

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 5);

        sc.close();
    }
}



