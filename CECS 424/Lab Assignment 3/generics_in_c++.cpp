//Christopher Masferrer
//011894127
//CECS 424 - 01 Spring 2020

#include <iostream>
#include <algorithm>
using namespace std;

//Create a new person object
struct Person
{
    string name;
    int age;
};

//sort a list of people in alphabetical order
bool alphabetically(Person p1, Person p2)
{
    if(p1.name != p2.name)
        return p1.name < p2.name;
}

//sort a list of people by age and alphabetically
bool ageSort(Person p1, Person p2)
{
    if(p1.age != p2.age)
        return p1.age > p2.age;
    
    if(p1.name != p2.name)
        return p1.name < p2.name;
}

int main()
{
    //Create a list of floating point numbers and print out the list
    double numbers[] = {645.32, 37.40, 76.30, 5.40, -34.23, 1.11, -34.94, 23.37, 635.46, -876.22, 467.73, 62.26}; 
    int numSize = sizeof(numbers)/sizeof(numbers[0]);
    cout << "Here is a list of numbers: " << endl;
    for(int i = 0; i < numSize; i++)
    {
        cout << numbers[i] << " ";
    }
    cout << "\n";
    
    //sort the list of numbers and then print out the sorted list
    sort(numbers, numbers + numSize);
    cout << "\nHere is a sorted list of numbers: " << endl;
    for(int i = 0; i < numSize; i++)
    {
        cout << numbers[i] << " ";
    }
    cout << "\n";
    
    //create a list of people and print out the list
    struct Person people[] = {{"Hal", 20}, {"Susann", 31},  {"Dwight", 19}, {"Kassandra", 21}, {"Lawrence", 25}, {"Cindy", 22}, {"Cory", 27},
{"Mac", 19}, {"Romana", 27}, {"Doretha", 32}, {"Danna", 20}, {"Zara", 23}, {"Rosalyn", 26}, {"Risa", 24}, {"Benny",28}, {"Juan", 33}, {"Natalie", 25}};
    int pplSize = sizeof(people)/sizeof(people[0]);
    cout << "\nHere is a list of people: \n";
    for(int i = 0; i < pplSize; i++)
    {
        cout << "Name: " << people[i].name << ", Age: " << people[i].age << endl;
    }
    
    //sort the list of people alphabetically and then print out the sorted list
    sort(people, people+pplSize, alphabetically);
    cout << "\nHere is a list of people sorted alphabetically: \n";
    for(int i = 0; i < pplSize; i++)
    {
        cout << "Name: " << people[i].name << ", Age: " << people[i].age << endl;
    }
    
    //sort the list of people descending by age, alphabetically if the same age
    //then print out the sorted list
    sort(people, people+pplSize, ageSort);
    cout << "\nHere is a list of people sorted by age: \n";
    for(int i = 0; i < pplSize; i++)
    {
        cout << "Name: " << people[i].name << ", Age: " << people[i].age << endl;
    }

    return 0;
}