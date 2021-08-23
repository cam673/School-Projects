//Christopher Masferrer
//1266556
//Assignment 3

#include <iostream>
#include <iomanip>
using namespace std;

double packageA = 9.95;
double packageAHours = 2.00;
double packageB = 14.95;
double packageBHours = 1.25;
double packageC = 19.95;
double customerBill;
char customerPackage;
int customerHours;
double totalHours;

void hours ()
{
    if (customerHours > 744)
        cout << "ERROR!!! The number exceeds the amount of hours in a month. Please use another number: " << endl;
        return;
}


int main()
{
    
    cout << "This program will help you calculate the cost of your internet bill based on the package you selected.\n"<< endl;
    cout << "These are the packages that are available:\n" << endl;
    cout << "Package A : $9.95 a month for 10 hour access / Additional hours are $2.00 an hour\n" << endl;
    cout << "Package B : $14.95 a month for 20 hour access / Additional hours are $1.25 an hour\n" << endl;
    cout << "Package C : $19.95 a month for unlimited internet access\n" << endl;
    cout << "\nPlease select a Package (type in the letter of the package only): " << endl;
    cin >> customerPackage;
    
    switch( customerPackage )
    {
        case 'a':    
        case 'A':
            cout << "You have selected Package A.\n" << endl;
            cout << "Select the number of additional hours you plan to use: " << endl;
            cin >> customerHours;
            hours();
            
            totalHours = customerHours * packageAHours;
            customerBill = packageA + totalHours;
            
            cout << "Your bill will cost: " << setw(10) << "$" << fixed << setprecision(2) << showpoint << customerBill << " per month." << endl;
            break;
        
        case 'b':    
        case 'B':
            cout << "You have selected Package B.\n" << endl;
            cout << "Select the number of additional hours you plan to use: " << endl;
            cin >> customerHours;
            hours();
            
            totalHours = customerHours * packageBHours;
            customerBill = packageB + totalHours;
            
            cout << "Your bill will cost: " << setw(10) << "$" << fixed << setprecision(2) << showpoint << customerBill << " per month." << endl;
            break;
        
        case 'c' :    
        case 'C' :
            cout << "You have selected Package C.\n" << endl;
            cout << "Internet access for Package C is unlimited.\n" << endl;
            cout << "Your bill will cost: " << setw(10) << "$" << fixed << setprecision(2) << showpoint << packageC << " per month." << endl;
            break;
        
        case 'q' :    
        case 'Q' :
            cout << "Goodbye!" << endl;
            return 0;
            
        default :
            cout << "Select A, B, or C: " << endl;
    }
    cout << "\nType in Q to exit the program.\n\n" << endl;
     return main();
}

