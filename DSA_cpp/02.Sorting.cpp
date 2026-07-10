#include <iostream>
using namespace std;
int main()
{
    /*Organizing Cards in a Hand:
    Application: When playing card games, players often use an approach similar to insertion sort to organize their cards. They pick one card at a time and insert it into the correct position in their hand, maintaining a sorted sequence. Write a program that demonstrates how to organize (sort) cards in a hand using insertion sort */
    int i, j;
    int temp;
    int n, a, b, k;
    cout << "Consider A=1 ,K=13 ,Q=12 ,J=11" << endl;
    cout << "\n";
    cout << "No. of cards in your hand : ";
    cin >> n;
    int arr[n];
    cout << "Enter " << n << " card values : ";
    // input card no. :-
    for (int i = 0; i < n; i++)
    {
        cin >> arr[i];
    }
    cout << "\n";
    cout << "Sequence before starting : ";
    for (int i = 0; i < n; i++)
    {
        cout << arr[i] << " ";
    }
    cout << endl;
    for (int pass = 1; pass < n; pass++)
    {
        temp = arr[pass];
        j = pass - 1;
        while (j >= 0 && arr[j] > temp)
        {
            arr[j + 1] = arr[j];
            j--;
        }
        arr[j + 1] = temp;
    }
    cout << "\n";
    cout << "Sorted Sequence: ";
    for (int i = 0; i < n; i++)
    {
        cout << arr[i] << " ";
    }
    cout << endl;
    return 0;
}