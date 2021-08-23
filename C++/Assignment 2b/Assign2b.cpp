//Christopher Masferrer
//1266556
//Assignment 2b


#include <iostream>
#include <iomanip>
#include <locale>
#include <sstream>
#include <string>
#include "formatNumber.h"

using namespace std;

int main(int argc, const char * argv[])
{

    string movie;
    double adultTickets = 12;
    double childTickets = 6;
    int adultTicketsSold;
    int childTicketsSold;
    double grossProfit;
    double netProfit;
    double distributorProfit;
    
    std::cout << "Movie Name: ";
    std::cin >> movie;
    getline(cin, movie);
    std::cout << "Adult Attended: ";
    std::cin >> adultTicketsSold;
    std::cout << "Child Attended: ";
    std::cin >> childTicketsSold;
    
    std::cout << std::setprecision(2) << std::fixed;
    grossProfit = adultTickets * adultTicketsSold + childTickets * childTicketsSold;
    netProfit = grossProfit * .2;
    distributorProfit = grossProfit - netProfit;
    
    std::cout << "\nMovie Name: " << setw(20) << movie;
    std::cout << "\nAdult Tickets Sold: " << setw(17) << adultTicketsSold;
    std::cout << "\nChild Tickets Sold: " << setw(17) << childTicketsSold;
    std::cout << "\nGross Box Office Profit: " << setw(7) << "$" << formatNumber(grossProfit);
    std::cout << "\nNet Box Office Profit: " << setw(9) << "$" << formatNumber(netProfit);
    std::cout << "\nAmount Paid to Distributor: " << setw(4) << "$" << formatNumber(distributorProfit);
    std::cout << "\n";
    
    return 0;
}

