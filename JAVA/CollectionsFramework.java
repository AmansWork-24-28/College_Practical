package JAVA;
import java.util.*;

class Expense {
    String date;
    double amount;
    String category;

    public Expense(String date, double amount, String category) {
        this.date = date;
        this.amount = amount;
        this.category = category;
    }

    public String getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

    public String getCategory() {
        return category;
    }

    public String getMonth() {
        return date.substring(0, 7);
    }

    public String toString() {
        return "Date: " + date + " | Amount: Rs." + amount + " | Category: " + category;
    }
}

class ExpenseManager {
    private ArrayList<Expense> expenses = new ArrayList<>();

    public void addExpense(String date, double amount, String category) {
        expenses.add(new Expense(date, amount, category));
        System.out.println("Expense added with ID: " + expenses.size());
    }

    public void deleteExpense(int id) {
        if (id > 0 && id <= expenses.size()) {
            expenses.remove(id - 1);
            System.out.println("Expense deleted successfully!");
        } else {
            System.out.println("Error: Invalid expense ID");
        }
    }

    public void viewExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses recorded.");
            return;
        }

        for (int i = 0; i < expenses.size(); i++) {
            System.out.println("ID " + (i + 1) + " -> " + expenses.get(i));
        }
    }

    public void generateReport() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses to generate report.");
            return;
        }

        HashMap<String, Double> categoryTotal = new HashMap<>();
        HashMap<String, Double> monthTotal = new HashMap<>();

        double totalExpense = 0;

        for (Expense e : expenses) {
            totalExpense += e.getAmount();

            categoryTotal.put(e.getCategory(),
                    categoryTotal.getOrDefault(e.getCategory(), 0.0) + e.getAmount());

            monthTotal.put(e.getMonth(),
                    monthTotal.getOrDefault(e.getMonth(), 0.0) + e.getAmount());
        }

        System.out.println("\n===== EXPENSE SUMMARY REPORT =====");
        System.out.println("Total Expenses: Rs." + totalExpense);

        System.out.println("\nExpenses by Category:");
        for (String category : categoryTotal.keySet()) {
            System.out.println(category + ": Rs." + categoryTotal.get(category));
        }

        System.out.println("\nExpenses by Month:");
        for (String month : monthTotal.keySet()) {
            System.out.println(month + ": Rs." + monthTotal.get(month));
        }

        System.out.println("===================================");
    }
}

public class CollectionsFramework {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ExpenseManager manager = new ExpenseManager();

        int choice;

        do {
            System.out.println("\n===== EXPENSE TRACKER ======");
            System.out.println("1. Add Expense");
            System.out.println("2. Delete Expene");
            System.out.println("3. View Expenses");
            System.out.println("4. Generate Report");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Date (YYYY-MM-DD): ");
                    String date = sc.nextLine();

                    System.out.print("Enter Amount: ");
                    double amount = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Enter Category: ");
                    String category = sc.nextLine();

                    manager.addExpense(date, amount, category);
                    break;

                case 2:
                    manager.viewExpenses();
                    System.out.print("Enter ID to delete: ");
                    int id = sc.nextInt();
                    manager.deleteExpense(id);
                    break;

                case 3:
                    manager.viewExpenses();
                    break;

                case 4:
                    manager.generateReport();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}
