//Christopher Masferrer
//1266556
//Assignment 9

#include <iostream>
#include <iomanip>
#include <stdlib.h>
using namespace std;

string accountNum;
const int accountTotal = 20;

//customer account information
struct Account
{
   string accountID;
   string name;
   double accountBalance;
};

Account information[accountTotal];

void create1()
{
   static int i = 0;
   
   //account limit reached
   if(i >= 20)
   {
     cout << "\nERROR: Account limit has been reached!\n";
     cout << "Please use the other options or remove an\n";
     cout << "account to start a new one.\n";
     cout << "\nPress ENTER to continue . . . \n";
     cin.get();
     cin.get();
     exit(1);
   }
   
   //account creator
   cout << "\nTo create your account, please enter the";
   cout << "\nfollowing information: \n";
   cout << "Select an account number: ";
   cin >> information[i].accountID;
   cout << "\nEnter your first name: ";
   cin >> information[i].name;
   cout << "\nEnter your recent account balance: ";
   cin >> information[i].accountBalance;
   
   //account successfully created
   cout << "\n\nYour information has been successfully saved.";
   cout << "\nPress Enter to continue . . . ";
   cin.get();
   cin.get();
   i = i + 1;
}

void view1()
{
   int i;
   int j = 20;
   
   //enter account number
   cout << "\nPlease enter your account number: ";
   cin >> accountNum;
   
   //search for account
   for(i = 0; i < 20; i++)
   {
     if (accountNum == information[i].accountID)
     {
        j = i;
     }
   }
   
   //account does not exist
   if( j == 20 )
   {
      cout << "\nERROR: That account does not exist.";
      cout << "\nPlease try again.";
      cout << "\nPress ENTER to continue . . . ";
      cin.get();
      cin.get();
   }
   
   //account overview
   if(j != 20 )
   {
      i = j;
      cout << "\nHello ", information[i].name;
      cout << "\nYour account balance is ", information[i].accountBalance;
      cout << "\nPress ENTER to continue . . . ";
      cin.get();
      cin.get();
   }
}

//main menu
void menu()
{
   int userInput;

   //choice selection
   cout << "\nWhat would you like to do today?\n";
   cout << "\n1. Create a new account";
   cout << "\n2. View account";
   cout << "\n3. Edit account";
   cout << "\n4. Exit.";
   cout << "\nSelect 1, 2, 3 or 4 please.\n";
   cin >> userInput;
   
   //invalid selection
   while(userInput != 1 && userInput != 2 && userInput != 3 && userInput !=4)
   {
      cout << "\nERROR: Invalid number! Please enter 1, 2, 3, or 4.\n";
      cin >> userInput;
   }
   
   //user selection
   if(userInput == 1)
   {
      create1();
      menu();
   }
   else
     if(userInput == 2)
     {
        view1();
        menu();
     }
     else
       if(userInput == 3)
       {
          cout << "\nYou have selected choice 3";
          menu();
       }
       else
         if(userInput == 4)
         {
           cout << "\nOkay. Have a nice day.";
           cout << "\nPress ENTER to exit . . . ";
           cin.get();
           cin.get();
         }
   
}

int main(int argc, const char * argv[])
{
    char answer;
    
    // program description
    cout << "Welcome to the Customer Account Manager program.\n";
    cout << "This program will help you store the information\n";
    cout << "of your account and how much money you had\n";
    cout << "previously before any changes were made.\n";
    cout << "\nPress ENTER to continue . . . ";
    cin.get();
    menu();
    
    return 0;
}
