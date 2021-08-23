//Christopher Masferrer
//1266556
//OOP C++

#include <iostream>
#include <iomanip>
#include <string>
using namespace std;

int main(int argc, const char * argv[])
{
    int array1 [10];
    int array2 [10];
    int array3 [10];
    int count = 0;
    int space1 = 0;
    int space2 = 0;
    int space3 = 0;

    
    while(count < 10)
    {
        array1[count] = rand() % 50 + 50;
        array2[count] = rand() % 50 + 50;
        array3[count] = rand() % 50 + 50;
        
        count = count + 1;
        
    }
    
    while(space1 < 9)
    {
        std::cout << left << std::setw(5);
        std::cout << array1[space1];
        space1 = space1 + 1;
    }
    
    std::cout << "\n";
    
    while(space2 < 9)
    {
        std::cout << left << std::setw(5);
        std::cout << array2[space2];
        space2 = space2 + 1;
    }
    
    std::cout << "\n";
    
    while(space3 < 9)
    {
        std::cout << left << std::setw(5);
        std::cout << array3[space3];
        space3 = space3 + 1;
    }
    
    return 0;
}

