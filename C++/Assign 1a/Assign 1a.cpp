//Christopher Masferrer
//1266556
//Assignment 1a


#include <iostream>

int main(int argc, const char * argv[])
{

    // insert code here...
    int max = 1;
    int number = 0;
    int square = 0;
    int cube = 0;
    
    std::cout << "number        square        cube     \n";
    std::cout << "______        ______        _____    \n";
    
    
    while (max <= 10)
    {
        number = max;
        square = max * max;
        cube = max * max * max;
        
        std::cout << number << "             ";
        std::cout << square << "             ";
        std::cout << cube << "\n";
        
        max = max + 1;
    }
    return 0;
}

