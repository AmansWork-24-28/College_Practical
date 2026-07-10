#include <iostream>
using namespace std;

int main()
{
    float rainfall[3][4];
    float avg = 0;
    float total = 0;
    int c, r;
    for (c = 0; c < 3; c++) {
        cout << "Enter rainfall for city " << (c + 1) << " (4 months):\n";
        for (r = 0; r < 4; r++) {
            cout << "Month " << (r + 1) << ": ";
            cin >> rainfall[c][r];
        }
    }
    cout << "\nRainfall data:\n";
    printf("City\tM1\tM2\tM3\tM4\n");
    for (c = 0; c < 3; c++) {
        cout << "City " << (c + 1) << ":\t";
        for (r = 0; r < 4; r++) {
            cout << rainfall[c][r] << "\t";
        }
        cout << "\n-------------------------------" << endl;
    }
    for (c = 0; c < 3; c++) {
        total = 0;
        for (r = 0; r < 4; r++) {
            total += rainfall[c][r];
        }
        avg = total / 4;
        printf("Total rainfall for City %d: %.2f\n", c + 1, total);
        printf("Average rainfall for City %d: %.2f\n", c + 1, avg);
        cout << "-------------------------------" << endl;
    }

    return 0;
}