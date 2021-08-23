//Christopher Masferrer
//1266556
//Assignment 7

#include <iostream>
#include <iomanip>
#include <fstream>
using namespace std;


int main(int argc, const char * argv[])
{
    int mini,temp;
    int number;
    int student;
    int studentNumber;
    int scores;
    int scoreCalc;
    int * num1 = new int [student];
    int * num2 = new int [scores];
    
    ifstream inFile;
    inFile.open("scores.txt");
    
    std::cout << "Please enter the number of students you would like to see the results of.\n";
    std::cin >> number;
    
    while( number < 5 || number > 1000)      //Incorrect number used
    {
        std::cout << "\nERROR: That number cannot be used!";
        std::cout << "\nPlease enter a number within the ranges of 5 - 1000\n";
        std::cin >> number;
    }
    
    number = student;
    number = scores;
    
    for(int i = 0; i < number; i++)     //Array input
    {
        inFile >> studentNumber;
        num1[i] = studentNumber;
        inFile >> scoreCalc;
        num2[i] = scoreCalc;
        i = i + 1;
    }
    
    for(int r1 = 0;r1 < 4;r1++)   //Selection Sort, arranging Student numbers in ascending order
    {
        mini = r1;
        for(int r2 = r1 + 1; r2 < 5; r2++)
            if(num1[r2] < num1[mini])
                
                mini = r2;
        
        if(mini != r1)
        {
            temp = num1[r1];
            num1[r1] = num1[mini];
            num1[mini] = temp;
        }
    }
        
        cout << "The Students numbers are: " << endl; //Printing student names
        for(int q = 0; q < number; q++)
        {
            std::cout << num1[q];
            std::cout << student;
            std::cout << endl;
        }
        
    delete[]num1;         //Array delete
    delete[]num2;
    
    inFile.close();
    
    return 0;
}

