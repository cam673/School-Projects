#include <iostream>
#include <iomanip>
#include <fstream>
#include <string>
#include <vector>
using namespace std;

int main()
{
    ifstream inFile;
    inFile.open("data.txt");
    ofstream outFile;
    outFile.open("vector_data.txt");
    
    int studentAccum = 0;
    vector<int> testTaken;
    int testNum = 0;
    int testAccum = 0;
    vector< vector<int> > scores;
    int studentTot;
    int num = 1;
    int scoreTot = 0;
    int scoreAvg;
    char grade;
    int totalA = 0;
    int totalB = 0;
    int totalC = 0;
    int totalD = 0;
    int totalF = 0;
    
    //store input data
    while(inFile.eof() == false)
    {
      inFile >> testNum;
      scores.push_back( vector<int>(testNum) );  
      testTaken.push_back(testNum);   
      testTaken [studentAccum] = testNum; //store tests taken
      
      while(testAccum < testNum) //store student scores
      {
         inFile >> scores[studentAccum][testAccum];
         testAccum = testAccum + 1;
      }
      
      studentAccum = studentAccum + 1;
      
      testAccum = 0;
      
    }
    
    studentTot = studentAccum;
    studentAccum = 0;
    
    outFile << "Number of scores processed: " << studentTot << "\n";
    outFile << "Here are the student records." << "\n";
    
    
    for (int i=0; i < scores.size(); ++i)
    {
      outFile << setw(5) << num;
      for(int j=0; j < scores.at(i).size(); ++j)
      {
         outFile << setw(5) << scores.at(i).at(j);
      }
      num = num + 1;
      outFile << endl;
    }
    
    num = 1;
    
    outFile.close();//close first output
    
    ofstream outFileTwo;//open second output
    outFileTwo.open("student_report.txt");
    
    outFileTwo << "Student Grade Report"<< endl; //second output header
    
    //second output data
    for (int i=0; i < scores.size(); ++i)
    {
      outFileTwo << setw(5) << num; //student number
      for(int j=0; j < scores.at(i).size(); ++j)
      {
         outFileTwo << setw(5) << scores.at(i).at(j); //student scores
         scoreTot = scoreTot + scores.at(i).at(j);
      }
      num = num + 1;
      
      
      scoreAvg = scoreTot/testTaken[i]; //calculate average
      if(testTaken[i] == 5)
      {
         outFileTwo << setw(10) << "Average:" << setw(3) << scoreAvg; //print average
      }
      else
         if(testTaken[i] == 4)
         {
            outFileTwo << setw(15) << "Average:" << setw(3) << scoreAvg; //print average
         }
         else
            if(testTaken[i] == 3)
            {
               outFileTwo << setw(20) << "Average:" << setw(3) << scoreAvg; //print average
            }
            else
               if(testTaken[i] == 2)
               {
                  outFileTwo << setw(25) << "Average:" << setw(3) << scoreAvg; //print average
               }
               else
                  if(testTaken[i] == 1)
                  {
                     outFileTwo << setw(30) << "Average:" << setw(3) << scoreAvg; //print average
                  }
      
       if(scoreAvg >= 90) //determine letter grade
      {
         grade = 'A';
      }
      else
         if(scoreAvg >= 80 && scoreAvg <= 89)
         {
            grade = 'B';
         }
         else
            if(scoreAvg >= 70 && scoreAvg <= 79)
            {
               grade = 'C';
            }
            else
               if(scoreAvg >= 60 && scoreAvg <= 69)
               {
                  grade = 'D';
               }
               else
                  if(scoreAvg <= 59)
                  {
                     grade = 'F';
                  } 
      outFileTwo << setw(10) << "Grade: " << setw(3) << grade << endl; //printGrade
      
      //Grade Accumulator
       if(grade == 'A')
      {
         totalA = totalA + 1;
      }
      else
         if(grade == 'B')
         {
            totalB = totalB + 1;
         }
         else
            if(grade == 'C')
            {
               totalC = totalC + 1;
            }
            else
               if(grade == 'D')
               {
                  totalD = totalD + 1;
               }
               else
                  if(grade == 'F')
                  {
                     totalF = totalF + 1;
                  }
      scoreTot = 0;
      
      outFileTwo << endl;
    }
    
    outFileTwo << "Total A's: " << totalA << "\n";
    outFileTwo << "Total B's: " << totalB << "\n";
    outFileTwo << "Total C's: " << totalC << "\n";
    outFileTwo << "Total D's: " << totalD << "\n";
    outFileTwo << "Total F's: " << totalF << "\n";
    
    outFileTwo.close();
    inFile.close();
    
    return 0;
}

