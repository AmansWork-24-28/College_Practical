#include <iostream>
#include <fstream>
#include <string>
#include <iostream>

using namespace std;
class Inventory
{
    string name;
    int itemId;
    float quantity;
    double price;

public:
    void accept();
    void display();
};

void Inventory ::accept()
{
    cout << "Enter item name: ";
    cin >> name;
    cout << "Enter itemId: ";
    cin >> itemId;
    cout << "Enter quantity: ";
    cin >> quantity;
    cout << "Enter price(in rs.): ";
    cin >> price;
}
void Inventory ::display()
{
    cout << "Item Name: " << name << endl;
    cout << "Item Id: " << itemId << endl;
    cout << "Item Quantity: " << quantity << endl;
    cout << "Item Price: Rs." << price << endl;
}

int main()
{
    int n;
    cout << "Enter number of Items : ";
    cin >> n;
    cout << "\n";
    ofstream file_obj;
    Inventory obj[n];
    for (int i = 0; i < n; i++)
    {
        cout << "Enter details of item no." << i + 1 << ": " << endl;
        obj[i].accept();
        file_obj.open("Input.txt");
        file_obj.write((char *)&obj, sizeof(obj));
        file_obj.close();
        cout << "\n";
    }
    cout << "------------------------------------------------------------------\n";
    for (int i = 0; i < n; i++)
    {

        ifstream file_obj2;
        file_obj2.open("Input.txt");
        file_obj2.read((char *)&obj, sizeof(obj));
        cout << "Details of item no." << i + 1 << ": " << endl;
        obj[i].display();
        cout << "\n";
        file_obj2.close();
    }
    return 0;
}