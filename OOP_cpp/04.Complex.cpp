#include <iostream>
using namespace std;

class Complex
{
    float real;
    float imag;

public:
    Complex();
    Complex(float a, float b);
    void display();
    Complex add(Complex &c1, Complex &c2);
    Complex multiply(Complex &c1, Complex &c2);

    Complex operator+(Complex c);
    friend Complex operator*(Complex c1, Complex c2);

    friend istream &operator>>(istream &, Complex &);
    friend ostream &operator<<(ostream &, const Complex &);
};

Complex::Complex()
{
    real = 0;
    imag = 0;
}

Complex::Complex(float a, float b)
{
    real = a;
    imag = b;
}

void Complex::display()
{
    cout << real << " + j" << imag << endl;
}

Complex Complex::add(Complex &c1, Complex &c2)
{
    Complex c3;
    c3.real = c1.real + c2.real;
    c3.imag = c1.imag + c2.imag;
    return c3;
}

Complex Complex::multiply(Complex &c1, Complex &c2)
{
    Complex c3;
    c3.real = (c1.real * c2.real) - (c1.imag * c2.imag);
    c3.imag = (c1.real * c2.imag) + (c1.imag * c2.real);
    return c3;
}

// Operator overloading
Complex Complex::operator+(Complex c)
{
    Complex temp;
    temp.real = real + c.real;
    temp.imag = imag + c.imag;
    return temp;
}

Complex operator*(Complex c1, Complex c2)
{
    Complex mul;
    mul.real = (c1.real * c2.real) - (c1.imag * c2.imag);
    mul.imag = (c1.real * c2.imag) + (c1.imag * c2.real);
    return mul;
}

istream &operator>>(istream &in, Complex &obj)
{
    cout << "Enter a(real): ";
    in >> obj.real;
    cout << "Enter b(imaginary): ";
    in >> obj.imag;
    return in;
}

ostream &operator<<(ostream &out, const Complex &obj)
{
    out << obj.real << " + " << obj.imag << "i";
    return out;
}

int main()
{
    float a, b;

    Complex c1, c2, c3, m3;

    // -------- USING NORMAL METHOD --------
    cout << "USING NORMAL METHOD\n";
    cout << "Enter first complex number:\n";
    cout << "Enter a(real): ";
    cin >> a;
    cout << "Enter b(imaginary): ";
    cin >> b;
    c1 = Complex(a, b);
    cout << "no.1 is : ";
    c1.display();
    cout << "\n";

    cout << "Enter second complex number:\n";
    cout << "Enter a(real): ";
    cin >> a;
    cout << "Enter b(imaginary): ";
    cin >> b;
    c2 = Complex(a, b);
    cout << "no.2 is : ";
    c2.display();

    c3 = c3.add(c1, c2);
    cout << "\nSum of the two complex numbers : ";
    c3.display();

    m3 = m3.multiply(c1, c2);
    cout << "Product of the two complex numbers : ";
    m3.display();

    // -------- USING OPERATOR OVERLOADING --------
    cout << "\n\nUSING OPERATOR OVERLOADING\n";
    c3 = c1 + c2;
    m3 = c1 * c2;

    cout << "Sum of the two complex numbers : " << c3 << endl;
    cout << "Product of the two complex numbers : " << m3 << endl;

    return 0;
}