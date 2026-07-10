
// PARKING LOT MANAGEMENT SYSTEM    

#include <iostream>
#include <string>
using namespace std;

// Convert time string to minutes 
int timeToMinutes(string t) {
    int h = (t[0] - '0') * 10 + (t[1] - '0');
    int m = (t[3] - '0') * 10 + (t[4] - '0');
    char ampm = t[6];
    if (ampm == 'P' || ampm == 'p') {
        if (h != 12) {
            h = h + 12;
        }
    } else {
        if (h == 12) {
            h = 0;
        }
    }
    return h * 60 + m;
}

// Convert minutes TO time string 
string minutesToTime(int mins) {
    int h = (mins / 60) % 24;
    int m = mins % 60;
    string ampm = "AM";
    if (h >= 12) {
        ampm = "PM";
    }
    if (h == 0) {
        h = 12;
    } else if (h > 12) {
        h = h - 12;
    }
    string time = "";
    if (h < 10) {
        time = time + "0";
    }
    time = time + to_string(h) + ":";
    if (m < 10) {
        time = time + "0";
    }
    time = time + to_string(m) + ampm;
    return time;
}

class ParkingLot {
    string* slots;
    int* entryTimes;
    string* waiting;
    int capacity;
    int waitCapacity;
    int front;
    int rear;
    float rate;

public:
    ParkingLot(int n, float r) {
        capacity = n;
        rate = r;
        slots = new string[capacity];
        entryTimes = new int[capacity];
        for (int i = 0; i < capacity; i++) {
            slots[i] = "EMPTY";
            entryTimes[i] = 0;
        }
        waitCapacity = capacity * 2;
        waiting = new string[waitCapacity];
        front = 0;
        rear = -1;
    }

    void park(string vehicle, int time) {
        for (int i = 0; i < capacity; i++) {
            if (slots[i] == "EMPTY") {
                slots[i] = vehicle;
                entryTimes[i] = time;
                cout << "\nVehicle " << vehicle << " parked in slot " << i + 1 << endl;
                return;
            }
        }
        if (rear - front + 1 < waitCapacity) {
            rear++;
            waiting[rear % waitCapacity] = vehicle;
            cout << "\nParking full. Vehicle " << vehicle << " added to waiting queue." << endl;
        } else {
            cout << "\nParking and waiting full!" << endl;
        }
    }

    void unpark(string vehicle, int exitTime) {
        for (int i = 0; i < capacity; i++) {
            if (slots[i] == vehicle) {
                int duration = exitTime - entryTimes[i];
                if (duration <= 0) {
                    duration = 60;
                }
                float hours = (float)duration / 60;
                if (hours < 1) {
                    hours = 1;
                }
                float amount = hours * rate;
                cout << "\nVehicle " << vehicle << " unparked from slot " << i + 1 << endl;
                cout << "Entry time: " << minutesToTime(entryTimes[i]) << " | Exit time: " << minutesToTime(exitTime) << endl;
                cout << "Parking hours: " << hours << endl;
                cout << "Amount to pay: Rs " << amount << endl;

                slots[i] = "EMPTY";
                entryTimes[i] = 0;

                if (front <= rear) {
                    string next = waiting[front % waitCapacity];
                    front++;
                    slots[i] = next;
                    entryTimes[i] = exitTime;
                    cout << "Next vehicle " << next << " moved from waiting to slot " << i + 1 << endl;
                }
                return;
            }
        }
        cout << "\nVehicle not found!" << endl;
    }

    void search(string vehicle) {
        for (int i = 0; i < capacity; i++) {
            if (slots[i] == vehicle) {
                cout << "\nVehicle " << vehicle << " found in slot " << i + 1;
                cout << " (Entry time: " << minutesToTime(entryTimes[i]) << ")" << endl;
                return;
            }
        }
        cout << "\nVehicle not found!" << endl;
    }

    void show() {
        cout << "\n--- Parking Status ---" << endl;
        for (int i = 0; i < capacity; i++) {
            cout << "Slot " << i + 1 << ": " << slots[i];
            if (slots[i] != "EMPTY") {
                cout << " (" << minutesToTime(entryTimes[i]) << ")";
            }
            cout << endl;
        }
        cout << "\nWaiting : ";
        if (front > rear) {
            cout << "Empty" << endl;
        } else {
            for (int i = front; i <= rear; i++) {
                cout << waiting[i % waitCapacity] << " ";
            }
            cout << endl;
        }
    }

    ~ParkingLot() {
        delete[] slots;
        delete[] entryTimes;
        delete[] waiting;
    }
};

int main() {
    int n, choice;
    float rate;
    string vehicleNum, timeStr;

    cout << "Enter number of parking slots: ";
    cin >> n;
    cout << "Enter rate per hour: ";
    cin >> rate;

    ParkingLot lot(n, rate);

    do {
        cout << "\n1. Park Vehicle\n2. Unpark Vehicle\n3. Search Vehicle\n4. Show Parking Status\n5. Exit\n";
        cout << "Enter your choice: ";
        cin >> choice;

        if (choice == 1) {
            cout << "Enter vehicle number: ";
            cin >> vehicleNum;
            cout << "Enter entry time (HH:MM AM/PM): ";
            cin.ignore();
            getline(cin, timeStr);
            lot.park(vehicleNum, timeToMinutes(timeStr));
        } else if (choice == 2) {
            cout << "Enter vehicle number: ";
            cin >> vehicleNum;
            cout << "Enter exit time (HH:MM AM/PM): ";
            cin.ignore();
            getline(cin, timeStr);
            lot.unpark(vehicleNum, timeToMinutes(timeStr));
        } else if (choice == 3) {
            cout << "Enter vehicle number: ";
            cin >> vehicleNum;
            lot.search(vehicleNum);
        } else if (choice == 4) {
            lot.show();
        } else if (choice == 5) {
            cout << "Thank you for using the parking system.\n";
        } else {
            cout << "Invalid input, please try again." << endl;
        }
    } while (choice != 5);

    return 0;
}