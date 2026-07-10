
#include <iostream>
#include <string>

using namespace std;

void depthFirstSearch(int currentNode, int currentDepth, int totalPages, int adjacency[20][20], string webPages[], int visitedNodes[]) {
    visitedNodes[currentNode] = 1;

    cout << "Level " << currentDepth << ": " << webPages[currentNode] << endl;

    for (int idx = 0; idx < totalPages; idx++) {
        if (adjacency[currentNode][idx] == 1 && visitedNodes[idx] == 0) {
            depthFirstSearch(idx, currentDepth + 1, totalPages, adjacency, webPages, visitedNodes);
        }
    }
}

void runDepthFirstSearch(int startIdx, int totalPages, int adjacency[20][20], string webPages[]) {
    int visitedNodes[20] = {0};

    cout << "\nIndexed (Visited) Web Pages in DFS Order:\n";

    depthFirstSearch(startIdx, 0, totalPages, adjacency, webPages, visitedNodes);
}

int main() {
    int totalWebPages;
    cout << "Enter total number of web pages: ";
    cin >> totalWebPages;

    string webPages[20];
    cout << "Enter names of web pages (e.g., Home, About, Contact):\n";
    for (int i = 0; i < totalWebPages; i++) cin >> webPages[i];

    int adjacency[20][20];
    cout << "Enter link adjacency matrix (1 if link exists, 0 otherwise):\n";
    for (int r = 0; r < totalWebPages; r++)
        for (int c = 0; c < totalWebPages; c++)
            cin >> adjacency[r][c];

    string startPage;
    cout << "Enter starting page name: ";
    cin >> startPage;

    int startIndex = -1;
    int pos = 0;
    while (pos < totalWebPages) {
        if (webPages[pos] == startPage) {
            startIndex = pos;
            break;
        }
        pos++;
    }

    if (startIndex == -1) {
        cout << "Starting page not found!" << endl;
        return 0;
    }

    runDepthFirstSearch(startIndex, totalWebPages, adjacency, webPages);

    return 0;
}