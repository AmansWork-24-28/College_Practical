//

#include <iostream>
using namespace std;

template <class T>

// bubble sort
void sortArray(T arr[], int n) {
    for (int i = 0; i < n - 1; i++) {
        // Last i elements are already in place
        for (int j = 0; j < n - i - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                // Swap arr[j] and arr[j + 1]
                T temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
    }
}

template <class T>
void displayArray(T arr[], int n) {
    for (int i = 0; i < n; i++)
        cout << arr[i] << " ";
    cout << endl;
}

int main() {
    int choice;
    cout << "Choose data type:\n1. Integer\n2. Float\n3. Character\nEnter choice: ";
    cin >> choice;
    int n;
    cout << "Enter number of elements: ";
    cin >> n;
    
    if (choice == 1) {
        int arr[20];
        cout << "Enter " << n << " integer elements: ";
        for (int i = 0; i < n; i++)
            cin >> arr[i];
        sortArray(arr, n);
        cout << "Sorted array (Integers): ";
        displayArray(arr, n);
    }
    else if (choice == 2) {
        float arr[20];
        cout << "Enter " << n << " float elements: ";
        for (int i = 0; i < n; i++)
            cin >> arr[i];
        sortArray(arr, n);
        cout << "Sorted array (Floats): ";
        displayArray(arr, n);
    }
    else if (choice == 3) {
        char arr[20];
        cout << "Enter " << n << " characters: ";
        for (int i = 0; i < n; i++)
            cin >> arr[i];
        sortArray(arr, n);
        cout << "Sorted array (Characters): ";
        displayArray(arr, n);
    }
    else {
        cout << "Invalid choice!" << endl;
    }
    return 0;
}