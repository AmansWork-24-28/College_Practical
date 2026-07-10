#include <iostream>
#include <string>
using namespace std;

class Staff
{
protected:
    string name, department;
    int staff_id;

public:
    void accept();
    void display();
};

class teaching : public Staff
{
    string subject;
    int experience;

public:
    void accept1();
    void display1();
};

void Staff::accept()
{
    cout << "\n";
    cout << "Enter Details : " << endl;
    cout << "Name: ";
    cin >> name;
    cout << "Department: ";
    cin >> department;
    cout << "Staff ID: ";
    cin >> staff_id;
}

void Staff::display()
{
    cout << "Name: " << name << endl;
    cout << "Department: " << department << endl;
    cout << "Staff ID: " << staff_id << endl;
}

void teaching::accept1()
{
    accept();

    cout << "Subject: ";
    cin >> subject;
    cout << "Experience (years): ";
    cin >> experience;
}

void teaching::display1()
{
    cout << "\n";
    // cout<<"Details : ";

    display();
    cout << "Subject: " << subject << endl;
    cout << "Experience(years): " << experience << endl;
}

class support
{
    string request;

public:
    void accept2();
    void display2();
};

void support ::accept2()
{
    int choice;
    cout << "\n";
    cout << "SUPPORT : " << endl;
    cout << "Enter 1 for request & 0 for complain : ";
    cin >> choice;
    if (choice == 1)
    {
        cout << "Type Request -" << endl;
        cin >> request;
    }
    else if (choice == 0)
    {
        cout << "THANK YOU" << endl;
    }
}

void support::display2()
{
    cout << "\n";
    cout << "Request :- " << request << endl;
}

int main()
{
    int n;
    cout << "Enter the no of teachers : ";
    cin >> n;

    teaching obj1[n];
    for (int i = 0; i < n; i++)
    {
        obj1[i].accept1();
    }

    for (int i = 0; i < n; i++)
    {
        cout << "\n";
        cout << "Details : ";
        obj1[i].display1();
    }

    support obj2[n];
    for (int i = 0; i < n; i++)
    {
        obj2[i].accept2();
    }
    for (int i = 0; i < n; i++)
    {

        obj2[i].display2();
    }

    return 0;
}