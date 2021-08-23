//Christopher Masferrer
//1266556
//Assignment 6

#include <iostream>
#include <iomanip>
#include <fstream>
#include <string>
using namespace std;

int test_1;
int test_2;
int test_3;
int test_4;
string studentName;
string studentNameList[25];
char studentGrade;
char testGrades[25];
double testScores[25][4];
double studentAverage;
double classAverage;
int studentTotal = 0;
int totalScores;

void wrapUp()
{
    classAverage = totalScores / studentTotal;
    
    std::cout << "\nClass Average";
    cout.width(20);
    std::cout << classAverage;
    
}

void process()
{
    
    studentAverage = (test_1 + test_2 + test_3 + test_4) / 4;   // Calculate student average score
    
    if(studentAverage >= 90)  //Student Grade
    {
        studentGrade = 'A';
    }
    else
        if(studentAverage >= 80 && studentAverage <= 89)
        {
            studentGrade = 'B';
        }
    else
        if(studentAverage >= 70 && studentAverage <= 79)
        {
            studentGrade = 'C';
        }
    else
        if(studentAverage >= 60 && studentAverage <= 69)
        {
            studentGrade = 'D';
        }
    else
        if(studentAverage <= 59)
        {
            studentGrade = 'F';
        }
    
    totalScores = totalScores + studentAverage;
    studentTotal = studentTotal + 1;
    
    std::cout << std::setw(17) << studentName;
    std::cout << std::setw(13) << studentAverage;
    cout.width(29);
    std::cout << studentGrade << "\n";

}

void houseKeeping()
{
    ifstream inFile;
    inFile.open("classData.txt");     //Input for test scores and student names
    ofstream outFile;
    outFile.open("Grade Book.txt");   //Name of output file
    
    std::cout << std::setw(43) << "Grade Book\n" ;    //Headings
    std::cout << std::setw(1) << "\nName";
    std::cout << std::setw(39) << "Average Score";
    std::cout << std::setw(29) << "Grade\n";
    
    while(inFile.eof() == false)
    {
        inFile >> test_1;     //Read record
        inFile >> test_2;
        inFile >> test_3;
        inFile >> test_4;
        getline(inFile, studentName);
        
        process();
    }
    
    wrapUp();
    
    inFile.close();
    outFile.close();
}



int main ()
{
    houseKeeping();
    
    return 0;
}

