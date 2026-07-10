package JAVA;

import java.util.*;

class student {
    String rolln;
    String name;
    int marks;
    String grade;

    public student(String rolln, String name, int marks, String grade) {
        this.rolln = rolln;
        this.name = name;
        this.marks = marks;
        this.grade = grade;
    }

    public String toString() {
        return "Roll no.: " + rolln + " | " + "Name: " + name + " | " + "Marks: " + marks + " | " + "Grade: " + grade
                + " | ";
    }
}

class save {

    ArrayList<student> information = new ArrayList<>();

    public void addInfo(String rolln, String name, int marks, String grade) {
        information.add(new student(rolln, name, marks, grade));
    }

    public void displayData() {
        System.out.println("-----------Students Information : -------------");
        for (int i = 0; i < information.size(); i++) {
            System.out.println((i + 1) + " : " + information.get(i));
        }
    }

    public void deleteData(int idx) {
        if (idx >= 0 && idx < information.size()) {
            information.remove(idx);
            System.out.println("Student record deleted successfully");
        }
    }

    public void searchData(int bysearch, String query) {
        int gradeno = 1;
        int nameno = 2;

        if (bysearch == gradeno) {
            System.out.println("\n--- Results for Grade: " + query + " ---");
            for (int i = 0; i < information.size(); i++) {
                if (information.get(i).grade.equalsIgnoreCase(query)) {
                    System.out.println(information.get(i));
                }
            }
        }

        if (bysearch == nameno) {
            System.out.println("\n--- Results for Name: " + query + " ---");
            for (int i = 0; i < information.size(); i++) {
                // Changed from .grade to .name here
                if (information.get(i).name.equalsIgnoreCase(query)) {
                    System.out.println(information.get(i));
                }
            }
        }
    }

    public void modifyData(int idx, Scanner sc) {
        if (idx >= 0 && idx < information.size()) {
            student s = information.get(idx);

            System.out.println("\nWhat do you want to modify?");
            System.out.println("Type 1 for Roll No");
            System.out.println("Type 2 for Name");
            System.out.println("Type 3 for Marks");
            System.out.println("Type 4 for Grade");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter new Roll No: ");
                    s.rolln = sc.nextLine();
                    break;

                case 2:
                    System.out.print("Enter new Name: ");
                    s.name = sc.nextLine();
                    break;

                case 3:
                    System.out.print("Enter new Marks: ");
                    s.marks = sc.nextInt();
                    break;

                case 4:
                    System.out.print("Enter new Grade: ");
                    s.grade = sc.next();
                    break;

                default:
                    System.out.println("Invalid choice!");
                    return;
            }

            System.out.println("Student record updated successfully");

        } else {
            System.out.println("Invalid index!");
        }
    }

    public void saveToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (student s : information) {
                writer.println(s.rolln + "," + s.name + "," + s.marks + "," + s.grade);
            }
        } catch (IOException e) {
            System.out.println("Error writing to file.");
        }
    }

    public void loadFromFile() {
        File file = new File(fileName);
        if (!file.exists())
            return;

        try (Scanner reader = new Scanner(file)) {
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    information.add(new student(parts[0], parts[1], Integer.parseInt(parts[2]), parts[3]));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("No existing data found.");
        }
    }
}

class FileHandling {
    public static void main(String[] args) {
        System.out.println("\n---------- STUDENT MANAGEMENT SYSTEM ----------");
        int option;

        save s = new save();

        do {
            System.out.println("\nEnter the operation to perform : ");
            System.out.println("1. Add");
            System.out.println("2. display");
            System.out.println("3. delete");
            System.out.println("4. Search");
            System.out.println("5. Modify");
            System.out.println("6. Exit");
            System.out.println("");

            Scanner sc = new Scanner(System.in);
            System.out.print("Enter your choice : ");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Enter student details : ");
                    System.out.print("Roll no : ");
                    sc.nextLine();
                    String r = sc.nextLine();
                    System.out.print("Name : ");
                    String n = sc.nextLine();
                    System.out.print("Marks : ");
                    int m = sc.nextInt();
                    System.out.print("Grade : ");
                    String g = sc.next();
                    s.addInfo(r, n, m, g);
                    break;

                case 2:
                    s.displayData();
                    break;

                case 3:
                    System.out.print("Enter index at which record to be deleted : ");
                    int idx = sc.nextInt();
                    s.deleteData(idx);
                    break;

                case 4:
                    System.out.println("\nSearch by:");
                    System.out.println("Type 1 for Grade");
                    System.out.println("Type 2 for Name");
                    System.out.print("Enter choice: ");
                    int type = sc.nextInt();
                    sc.nextLine(); // consume newline

                    if (type == 1) {
                        System.out.print("Enter Grade (e.g. A): ");
                        String gSearch = sc.next();
                        s.searchData(1, gSearch);
                    } else if (type == 2) {
                        System.out.print("Enter Name: ");
                        String nSearch = sc.nextLine();
                        s.searchData(2, nSearch);
                    } else {
                        System.out.println("Invalid search type!");
                    }
                    break;

                case 5:
                    System.out.print("Enter index to modify : ");
                    int midx = sc.nextInt() - 1; // fix index
                    s.modifyData(midx, sc);
                    break;

                case 6:
                    System.out.print("----------EXIT----------");
                    break;
            }
        } while (option != 6);
    }
}
