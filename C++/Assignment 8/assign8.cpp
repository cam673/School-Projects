//Christopher Masferrer
//1266556
//Assignment 8

#include <iostream>
#include <iomanip>
#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
using namespace std;

string password;
int userInput;

void verification()
{
    password.size();
    if( password.size() < 6)
    {
        std::cout << "\nERROR: The password should be at least six characters long\n";
    }
    
    if(password.size() < 6)
    {
        std::cout << "\nPlease enter another password: ";
        std::cin >> password;
        verification();
    }
}

void start()
{
    //prompt user for password
    std::cout << "\nPlease enter a password for verification: ";
    std::cin >> password;
    verification();
}

int main()
{
    //description of program
    std::cout << "This program will help verify if your password \n";
    std::cout << "meets the following criteria: \n";
    std::cout << "   The password should be at least six characters long\n";
    std::cout << "   The password should contain at least one uppercase letter and one lower case letter\n";
    std::cout << "   The password should contain at least one digit\n";
    std::cout << "\nPress ENTER to continue . . . ";
    cin.get();
    start();
    
    std::cout << "\nPassword successfully verified.";
    std::cout << "\nHave a nice day!";
    std::cout << "\nPress ENTER to exit . . .";
    cin.ignore();
    cin.ignore();
    
    return 0;
}

