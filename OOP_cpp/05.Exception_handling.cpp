#include <iostream>
using namespace std;
class division
{
    float a, b;

public:
    void display();
    void accept();
};
void division::accept()
{
    cout << "Enter first num:";
    cin >> a;
    cout << "\nEnter second num:";
    cin >> b;
}
void division::display()
{
    try
    {
        if (b == 0)
        {
            throw "Div by zero not possible";
        }
        else
        {
            cout << "Result : " << a / b << endl;
        }
    }
    catch (const char *i)
    {
        cout << i << endl;
        cout << "Enter a non-zero value: ";
        cin >> b;
        if (b != 0)
        {
            cout << "Result after correction: " << a / b << endl;
        }
        else
        {
            cout << "Still zero, division not possible" << endl;
        }
    }
}
int main()
{
    division A;
    A.accept();
    A.display();
    return 0;
}