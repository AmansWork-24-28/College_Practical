package JAVA;

import java.util.*;

// Base Class
class Expense {
    private String date;
    private double amount;
    private String category;

    public Expense(String date, double amount, String category) {
        this.date = date;
        this.amount = amount;
        this.category = category;
    }

    public String getDate() { return date; }
    public double getAmount() { return amount; }
    public String getCategory() { return category; }
    public String getMonth() { return date.substring(0, 7); }

    @Override
    public String toString() {
        return "Date: " + date + " | Amount: Rs." + amount + " | Category: " + category;
    }
}

// 1. INHERITANCE: PersonalExpense Subclass
class PersonalExpense extends Expense {
    public PersonalExpense(String date, double amount, String category) {
        super(date, amount, category); // Calls the base class constructor
    }

    @Override
    public String toString() {
        return "[Personal] " + super.toString();
    }
}

// 1. INHERITANCE: BusinessExpense Subclass (Adds a tax-deductible feature)
class BusinessExpense extends Expense {
    private double taxDeductionRate; // unique to business expenses

    public BusinessExpense(String date, double amount, String category, double taxDeductionRate) {
        super(date, amount, category);
        this.taxDeductionRate = taxDeductionRate;
    }

    public double getTaxSaved() {
        return getAmount() * (taxDeductionRate / 100);
    }

    @Override
    public String toString() {
        return "[Business] " + super.toString() + " | Tax Saved: Rs." + getTaxSaved();
    }
}

class ExpenseManager {
    // 2. POLYMORPHISM: This list stores both Personal and Business expenses seamlessly
    private ArrayList<Expense> expenses = new ArrayList<>();

    public void addExpense(Expense expense) {
        expenses.add(expense);
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
            // Polymorphism in action: Java automatically invokes the correct subclass toString()
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
            categoryTotal.put(e.getCategory(), categoryTotal.getOrDefault(e.getCategory(), 0.0) + e.getAmount());
            monthTotal.put(e.getMonth(), monthTotal.getOrDefault(e.getMonth(), 0.0) + e.getAmount());
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
class InheritanceAndPolymorphism {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ExpenseManager manager = new ExpenseManager();
        int choice;

        do {
            System.out.println("\n===== EXPENSE TRACKER ======");
            System.out.println("1. Add Personal Expense");
            System.out.println("2. Add Business Expense");
            System.out.println("3. Delete Expense");
            System.out.println("4. View Expenses");
            System.out.println("5. Generate Report");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine(); 

            // Common inputs for options 1 and 2
            if (choice == 1 || choice == 2) {
                System.out.print("Enter Date (YYYY-MM-DD): ");
                String date = sc.nextLine();

                System.out.print("Enter Amount: ");
                double amount = sc.nextDouble();
                sc.nextLine();

                System.out.print("Enter Category: ");
                String category = sc.nextLine();

                if (choice == 1) {
                    manager.addExpense(new PersonalExpense(date, amount, category));
                } else {
                    System.out.print("Enter Tax Deduction Rate (%): ");
                    double taxRate = sc.nextDouble();
                    manager.addExpense(new BusinessExpense(date, amount, category, taxRate));
                }
            } else {
                switch (choice) {
                    case 3:
                        manager.viewExpenses();
                        System.out.print("Enter ID to delete: ");
                        int id = sc.nextInt();
                        manager.deleteExpense(id);
                        break;
                    case 4:
                        manager.viewExpenses();
                        break;
                    case 5:
                        manager.generateReport();
                        break;
                    case 6:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice!");
                }
            }
        } while (choice != 6);

        sc.close();
    }
}