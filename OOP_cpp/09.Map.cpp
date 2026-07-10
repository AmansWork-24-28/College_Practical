#include <iostream>
#include <map>
#include <string>
using namespace std;
int main()
{
typedef map <int,string> mapType;
mapType prnMap;
prnMap.insert(pair<int, string>(1087, "Kartik"));
prnMap.insert(pair<int, string>(1064, "Aman"));
prnMap.insert(pair<int, string>(1095, "Yash Bhure"));
prnMap.insert(pair<int, string>(1124, "Yash Adhav"));
prnMap.insert(pair<int, string>(1063, "Suraj"));
prnMap.insert(pair<int, string>(1066, "OmD"));

mapType::iterator iter;
cout << "---------- Student PRN Database ----------\n";
cout << "\nSize of prnMap: " << prnMap.size() << "\n";
for (iter = prnMap.begin(); iter != prnMap.end(); iter++) {
        cout << iter->first << ": " << iter->second << "\n";
    }
int PRN;
    cout << "\nEnter PRN of the student: ";
    cin >> PRN;
    iter = prnMap.find(PRN);
    if (iter != prnMap.end()) {
        cout << PRN << "'s name is " << iter->second;
    } else {
        cout << "No. " << PRN << " is not in the map.\n";
    }
    cout<<"\n";
    prnMap.clear();
    cout<<"\n";
    cout<<"------ERASED------";
}