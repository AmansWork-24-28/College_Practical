#include <iostream>
using namespace std;

class employee {
    private:
        static int count;
        string name;
        int emp_id;
        string Dept;
        string date_of_joining;
        int telephone_no;

    public:
        employee(string Name, int id, string Department, string date, int no) {
            cout<<"Parameterized constructor :"<<endl;
            name = Name;
            emp_id = id;
            Dept = Department;
            date_of_joining = date;
            telephone_no = no;
            count++;  
        }
        
        employee() {
            cout<<"Default constructor :"<<endl;
            name = "ab";
            emp_id = 0;
            Dept =  "ad";
            date_of_joining = "jjk";
            telephone_no = 55;
            count++; 
            
        }    
         
        employee( employee& emp) {
            cout<<"Copy constructor :"<<endl;
            name = emp.name;
            emp_id = emp.emp_id;
            Dept = emp.Dept;
            date_of_joining = emp.date_of_joining;
            telephone_no = emp.telephone_no;
            count++;
        }

        static void member() {
            cout<<"---------------------------------------------------------------------";
            cout<<"\n";
            cout << "Total number of employees :- " << count << endl;
            
        }

        void accept();
        void display();
        ~employee();
};

int employee::count = 0;

void employee::accept() {
    string Name, Department, date;
    int id, telephone;

    cout << "1.Name: ";
    cin >> Name;
    cout << "2.emp_id: ";
    cin >> id;
    cout << "3.Department: ";
    cin >> Department;
    cout << "4.Date_of_joining: ";
    cin >> date;
    cout << "5.Telephone no.: ";
    cin >> telephone;
    
    name = Name;
    emp_id = id;
    Dept = Department;
    date_of_joining = date;
    telephone_no = telephone;
}

void employee::display() {
    cout << "\nEmployee Information:" << "\n";
    cout << "Name of the employee: " << name << "\n";
    cout << "emp_id: " << emp_id << "\n";
    cout << "Department: " << Dept << "\n";
    cout << "Date_of_joining: " << date_of_joining << "\n";
    cout << "Telephone no.: " << telephone_no << "\n";
}

employee:: ~employee()
{
    cout<<"I am Destructor "<<endl;
    count--;
}
int main() {
    cout<<"========================================================================";
    cout << "                  WELCOME TO EMPLOYEE INFORMATION SYSTEM" << endl;
    cout<<"========================================================================"<<endl;
    cout<<">Enter Employee Information : "<<endl;
    cout<<"\n";

    employee emp1;
    emp1.accept();  
    emp1.display();  
    cout << "\n";

    employee emp2("Anna", 645, "Accounts", "28/05/2022", 797800461);
    emp2.display();  
    cout << "\n";
    
    employee emp3 = emp1;  
    emp3.display();  
    cout << "\n";
    
    employee *ptr = new employee("Rahul", 112, "acc", "21/08/2003", 789451552);  
    ptr->display();
    
    cout<<"\n";
    employee::member();  
    delete ptr; 
    
    return 0;
}