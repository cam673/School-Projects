//Christopher Masferrer
//1266556
//Assignment 2a

#include <iostream>
#include <iomanip>
#include <locale>
#include <sstream>
#include "formatNumber.h"

int main(int argc, const char * argv[])
{
    double ClassA = 15;
    double ClassB = 12;
    double ClassC = 9;
    double ClassA_Tickets;
    double ClassB_Tickets;
    double ClassC_Tickets;
    double TotClassA;
    double TotClassB;
    double TotClassC;
    double TotSales;
    
    std::cout << "How many tickets for each class of seats were sold? \n";
    std::cout << "\nClass A: ";
    std::cin >> ClassA_Tickets;
    std::cout << "Class B: ";
    std::cin >> ClassB_Tickets;
    std::cout << "Class C: ";
    std::cin >> ClassC_Tickets;
    
    std::cout << std::setprecision(2) << std::fixed;
    TotClassA = ClassA * ClassA_Tickets;
    TotClassB = ClassB * ClassB_Tickets;
    TotClassC = ClassC * ClassC_Tickets;
    TotSales = TotClassA + TotClassB + TotClassC;
    
    std::cout << "\nTotal for Class A tickets: " << formatNumber(TotClassA);
    std::cout << "\nTotal for Class B tickets: " << formatNumber(TotClassB);
    std::cout << "\nTotal for Class C tickets: " << formatNumber(TotClassC);
    std::cout << "\n___________________________";
    std::cout << "\nTotal Ticket Sales: " << formatNumber(TotSales);
    std::cout << "\n";
    return 0;
}

