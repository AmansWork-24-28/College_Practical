package JAVA;

class Student {
    // 1. Encapsulated fields (private)
    private int studentId;
    private String name;
    private double[] marks = new double[5];

    // Setters (using standard camelCase)
    public void setId(int id) {
        this.studentId = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMarks(double[] mark) {
        // Safe copy to avoid array length mismatch issues
        for (int i = 0; i < marks.length && i < mark.length; i++) {
            this.marks[i] = mark[i];
        }
    }

    // 2. True Getters (They return the value instead of printing it)
    public int getId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public double[] getMarks() {
        return marks;
    }

    // 3. Calculation and Presentation logic
    public double calculateAverage() {
        double sum = 0;
        for (double mark : marks) {
            sum += mark;
        }
        return sum / marks.length;
    }

    public void displayProfile() {
        System.out.println("Student ID      : " + studentId);
        System.out.println("Name            : " + name);
        System.out.print("Marks Obtained  : ");
        for (int i = 0; i < marks.length; i++) {
            System.out.print(marks[i] + (i < marks.length - 1 ? ", " : ""));
        }
        System.out.println();

        double avg = calculateAverage();
        System.out.println("Average/Perc    : " + avg + "%");
    }

    public void displayResult() {
        double percentage = calculateAverage();
        System.out.print("Result          : ");
        if (percentage > 50) {
            System.out.println("Congratulations! You are promoted.");
        } else {
            System.out.println("Better luck next time.");
        }
    }
}

public class Encapsulation {
    public static void main(String[] args) {
        Student s = new Student();
        s.setName("Aman");
        s.setId(64);

        double[] m = { 90, 99, 100, 95, 89 };
        s.setMarks(m);

        // Displaying everything cleanly
        s.displayProfile();
        s.displayResult();
    }
}