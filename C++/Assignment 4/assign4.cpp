//Christopher Masferrer
//1266556
//Assignment 4

#include <iostream>
#include <iomanip>
#include <stdio.h>
#include <stdlib.h>
#include <time.h>
using namespace std;

int menuInput;
int num1;
int num2;
int correctAnswer;
int userAnswer;
const string answerCorrect[4] = {"Very Good!\n", "Nice Work!\n", "Excelent!\n", "Keep up the good work!\n"};
const string answerIncorrect[4] = {"No. Please try again.\n", "Sorry. Thats not it.\n", "No. Don't give up.\n", "Not yet. Keep trying.\n"};


void numGenerator()
{
    num1 = rand() %10 + 1;
    num2 = rand() %10 + 1;
}

void addition()
{
    while( userAnswer != 999)
    {
    numGenerator();
    correctAnswer = num1 + num2;
    std::cout << "\n" << num1;
    std::cout << " and " << num2;
    std::cout << " EQUALS: \n";
    std::cin >> userAnswer;
    if(userAnswer == correctAnswer)
    {
        std::cout << answerCorrect [ rand() %4 ];
        addition();
    }
    else
        if(userAnswer != correctAnswer)
        {
            std::cout << answerIncorrect [ rand() %4 ];
            addition();
        }
    }
}

void subtraction()
{
    while( userAnswer != 999)
    {
    numGenerator();
    if(num2 >num1)
    {
        numGenerator();
    }
    correctAnswer = num1 - num2;
    std::cout << "\n" << num1;
    std::cout << " and " << num2;
    std::cout << " EQUALS: \n";
    std::cin >> userAnswer;
    if(userAnswer == correctAnswer)
    {
        std::cout << answerCorrect [ rand() %4 ];
        subtraction();
    }
    else
        if(userAnswer != correctAnswer)
        {
            std::cout << answerIncorrect [ rand() %4 ];
            subtraction();
        }
    }
}

void multiplication()
{
    while (userAnswer != 999)
    {
    numGenerator();
    correctAnswer = num1 * num2;
    std::cout << "\n" << num1;
    std::cout << " and " << num2;
    std::cout << " EQUALS: \n";
    std::cin >> userAnswer;
    if(userAnswer == correctAnswer)
    {
        std::cout << answerCorrect [ rand() %4 ];
        multiplication();
    }
    else
        if(userAnswer != correctAnswer)
        {
            std::cout << answerIncorrect [ rand() %4 ];
            multiplication();
        }
    }
}

void mainMenu()
{
    std::cout << "\n\nWhat would you like to do?\n";
    std::cout << "1. Addition \n";
    std::cout << "2. Subtraction \n";
    std::cout << "3. Multiplication \n";
    std::cout << "4. Exit \n";
    std::cout << "\nSelect (1, 2, 3, or 4)\n";
    std::cin >> menuInput;
    std::cin.ignore();
    
    if(menuInput == 1)
    {
        addition();
    }
    else
        if(menuInput == 2)
        {
            subtraction();
        }
    else
        if(menuInput == 3)
        {
            multiplication();
        }
    else
        if(menuInput == 4)
        {
            std::cout << "\nGoodbye";
            std::cout << "\nPress Enter to Exit.\n";
            cin.get();
        }
    else
    {
        std::cout << "\nINVALID NUMBER!!!\n";
        std::cout << "Press ENTER to return to menu.\n";
        cin.get();
        mainMenu();
    }
    
}

int main(int argc, const char * argv[])
{
    srand(num1);
    srand(num2);
    std::cout << "This program will test your knowledge of \n";
    std::cout << "addition, subtraction, and multiplication. \n";
    std::cout << "When you are ready you will be taken to a \n";
    std::cout << "menu that will ask what type of math problems \n";
    std::cout << "you want to do.\n";
    std::cout << "\nIf you need to exit the program while you \n";
    std::cout << "are solving problems, just press 999 and it \n";
    std::cout << "will take you back to the menu where you can \n";
    std::cout << "continue working on different math problems \n";
    std::cout << "or quit the program.\n";
    std::cout << "\nPress ENTER to continue . . .\n";
    cin.ignore();
    
    mainMenu();
    
    if(menuInput == 4)
    {
       return 0;
    }
    while(userAnswer == 999)
    {
        userAnswer = 0;
        mainMenu();
    }
    
}

