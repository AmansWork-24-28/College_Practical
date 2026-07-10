#include <iostream>
using namespace std;

int main() {
    int id, i, n, request;
    int hash_func;
   
    cout << "Enter server count n: ";
    cin >> n;
   
    int server[n];
    for(i = 0; i < n; i++) {
        server[i] = i;  
    }
    cout << "Number of servers is: " << n << endl;
    cout<<"\n";
    cout << "Do you want to make a request? Enter 1 for yes, 0 for no: ";
    cin >> request;
   
    while(request == 1) {
        cout << "Enter client id: ";
        cin >> id;
       
        hash_func = id % n;
       
        for(i = 0; i < n; i++) {
            if(hash_func == server[i]) {
                cout << "Client id: " << id << " is forwarded to server no. " << server[i] << endl;
            }
        }
       
        cout<<"\n";
        cout << "Do you want to make another request? Enter 1 for yes, 0 for no: ";
        cin >> request;
    }
   
    cout << "No more requests" << endl;
    return 0;}