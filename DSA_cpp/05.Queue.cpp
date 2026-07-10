#include<iostream>
using namespace std;

class cafe {
    int queue[10];
    int rear = -1;
    int front = -1;
    int token = 0;

public:
    int isEmpty() {
        if (front == -1 || front > rear) {
            return 1;  // true
        } else {
            return 0;  // false
        }
    }

    int isFull() {
        if (rear == 9) {
            cout << "Queue is full. Please wait." << endl;
            return 1;  // true
        } else {
            return 0;  // false
        }
    }

    void enqueue() {
        if (!isFull()) {
            if (front == -1) {
                front = 0;
            }
            token++;
            rear++;
            queue[rear] = token;
            cout << "Token no. " << queue[rear] << " registered." << endl;
        }
    }

    int dequeue() {
        if (isEmpty()) {
            cout << "No orders to process!!" << endl;
            return -1;
        }
        if (!isEmpty()) {
            int order = queue[front];
            front++;
            return order;
        }
       
        return -1;
    }
};

int main() {
    cafe c;
    int choice;
    cout << "---AMAN'S CAFE---" << endl;
    cout << "1. Issue Token" << endl;
    cout << "2. Process Order" << endl;
    cout << "3. Exit" << endl;

    while (1) {
        cout << "Enter your choice: ";
        cin >> choice;

        if (choice == 1) {
            c.enqueue();
        }
        else if (choice == 2) {
            int processed = c.dequeue();
            if (processed != -1) {
                cout << "Order no. " << processed << " processed" << endl;
            }
        }
        else if (choice == 3) {
            cout << "Exiting the Coffee Shop...";
            break;
        }
        else {
            cout << "Invalid choice." << endl;
            break;
        }
    }
    return 0;
}