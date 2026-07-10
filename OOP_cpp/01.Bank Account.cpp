#include <iostream>
#include <string>
using namespace std;

class Bank_Account {
private:
    string customerName;
    string accountType;
    int accountNumber;
    float balance;

public:
    Bank_Account(string name, string type, int accNum, float initialBalance) {
        customerName = name;
        accountType = type;
        accountNumber = accNum;
        balance = initialBalance;
    }
    
        void withdraw(float amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            cout << "RsRs" << amount << " withdraw successfully." << endl;
        } else {
            cout << "Insufficient balance or invalid amount!" << endl;
        }
    }

    void deposit(float amount) {
        if (amount > 0) {
            balance += amount;
            cout << "Rs." << amount << " deposited successfully." << endl;
        } else {
            cout << "Invalid deposit amount!" << endl;
        }
    }

    void displayDetails() {
        cout << "\n--- Account Details ---" << endl;
        cout << "Customer Name: " << customerName << endl;
        cout << "Account Type: " << accountType << endl;
        cout << "Account Number: " << accountNumber << endl;
        cout << "Available Balance: Rs." << balance << endl;
    }
};

int main() {
    string name, type;
    int accNumber;
    float initialBalance;

    cout << "Enter Customer Name: ";
    cin>>name;

    cout << "Enter Account Type (Savings/Current): ";
    cin>>type;

    cout << "Enter Account Number: ";
    cin >> accNumber;

    cout << "Enter Initial Balance: Rs.";
    cin >> initialBalance;

    Bank_Account customer(name, type, accNumber, initialBalance);

    int choice = 0;
    double amount;

    while (choice != 4) {
        cout << "\n--- Bank Details ---" << endl;
        cout << "1. Deposit Amount" << endl;
        cout << "2. Withdraw Amount" << endl;
        cout << "3. Display Account Details" << endl;
        cout << "4. Exit" << endl;
        cout << "Enter your choice: ";
        cin >> choice;

        if (choice == 1) {
            cout << "Enter amount to deposit: Rs.";
            cin >> amount;
            customer.deposit(amount);
        } else if (choice == 2) {
            cout << "Enter amount to withdraw: Rs.";
            cin >> amount;
            customer.withdraw(amount);
        } else if (choice == 3) {
            customer.displayDetails();
        } else if (choice == 4) {
            cout << "Thank you for using our banking system!" << endl;
        } else {
            cout << "Invalid choice. Please try again." << endl;
        }
    }

    return 0; }