#include <iostream>
using namespace std;

class TaskNode {
public:
    string name;
    int prio;
    int execTime;
    TaskNode *nextTask;

    TaskNode(string n, int p, int e) {
        name = n;
        prio = p;
        execTime = e;
        nextTask = NULL;
    }

    void show() {
        cout << "Task Name: " << name
             << ", Priority: " << prio
             << ", Execution Time: " << execTime << endl;
    }
};

int main() {
    int totalTasks;
    TaskNode *head = NULL;
    TaskNode *newNode = NULL, *current, *previous;
    string taskName;
    int priority, time;

    cout << "Enter No. of Tasks: ";
    cin >> totalTasks;

    for (int i = 0; i < totalTasks; i++) {
    cout << "Enter Task Name : ";
    cin >> taskName;
    cout << "Enter Priority : ";
    cin >> priority;
    cout << "Enter Execution Time : ";
    cin >> time;

    cout << endl;  

    newNode = new TaskNode(taskName, priority, time);

    if (head == NULL || priority > head->prio) {
        newNode->nextTask = head;
        head = newNode;
    } else {
        current = head;
        while (current != NULL && current->prio >= priority) {
            previous = current;
            current = current->nextTask;
        }
        previous->nextTask = newNode;
        newNode->nextTask = current;
    }
}


    current = head;
    while (current != NULL) {
        current->show();
        current = current->nextTask;
    }

    return 0;
}