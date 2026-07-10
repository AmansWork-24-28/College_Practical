#include <iostream>
#include <string>

using namespace std;

const int MAX_QUEUE_SIZE = 100;

class Queue
{
private:
    int nodesIndex[MAX_QUEUE_SIZE];
    int nodesLevel[MAX_QUEUE_SIZE];

    int capacity;
    int head;
    int tail;
    int size;

public:
    Queue()
    {
        capacity = MAX_QUEUE_SIZE;
        head = 0;
        tail = -1;
        size = 0;
    }

    int is_empty()
    {
        if (size == 0)
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }

    int is_full()
    {
        if (size == capacity)
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }

    void add(int nodeIndex, int nodeLevel)
    {
        if (is_full() == 1)
        {
            cerr << "Error: Queue is full." << endl;
            return;
        }

        tail = (tail + 1) % capacity;

        nodesIndex[tail] = nodeIndex;
        nodesLevel[tail] = nodeLevel;

        size++;
    }

    int frontIndex()
    {
        if (is_empty() == 1)
        {
            cerr << "Error: Queue is empty." << endl;
            return -1;
        }

        return nodesIndex[head];
    }

    int frontLevel()
    {
        if (is_empty() == 1)
        {
            cerr << "Error: Queue is empty." << endl;
            return -1;
        }

        return nodesLevel[head];
    }

    void remove()
    {
        if (is_empty() == 1)
        {
            cerr << "Error: Cannot pop from empty queue." << endl;
            return;
        }

        head = (head + 1) % capacity;
        size--;
    }
};

void breadthFirstSearch(int startIdx, int totalPages, int links[20][20], string webPages[])
{
    int visitedNodes[20] = {0};

    Queue bfsQueue;

    visitedNodes[startIdx] = 1;
    bfsQueue.add(startIdx, 0);

    cout << "\nIndexed (Visited) Web Pages in BFS Order:\n";

    while (bfsQueue.is_empty() == 0)
    {
        int currentNode = bfsQueue.frontIndex();
        int currentDepth = bfsQueue.frontLevel();

        bfsQueue.remove();

        cout << "Level " << currentDepth << ": " << webPages[currentNode] << endl;

        for (int k = 0; k < totalPages; k++)
        {
            if (links[currentNode][k] == 1 && visitedNodes[k] == 0)
            {
                visitedNodes[k] = 1;
                bfsQueue.add(k, currentDepth + 1);
            }
        }
    }
}

int main()
{
    int totalWebPages;

    cout << "Enter total number of web pages: ";
    cin >> totalWebPages;

    string webPages[20];

    cout << "Enter names of web pages (e.g., Home, About, Contact):\n";
    for (int idx = 0; idx < totalWebPages; idx++)
    {
        cin >> webPages[idx];
    }

    int adjacency[20][20];

    cout << "Enter link adjacency matrix (1 if link exists, 0 otherwise):\n";
    for (int r = 0; r < totalWebPages; r++)
    {
        for (int c = 0; c < totalWebPages; c++)
        {
            cin >> adjacency[r][c];
        }
    }

    string startPage;

    cout << "Enter starting page name: ";
    cin >> startPage;

    int startIndex = -1;

    int pos = 0;
    while (pos < totalWebPages)
    {
        if (webPages[pos] == startPage)
        {
            startIndex = pos;
            break;
        }

        pos++;
    }

    if (startIndex == -1)
    {
        cout << "Starting page not found!" << endl;
        return 0;
    }

    breadthFirstSearch(startIndex, totalWebPages, adjacency, webPages);

    return 0;
}

