//Christopher Masferrer
//011894127
//CECS 424 - 01 Spring 2020

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

//Create a new person object
typedef struct
{
    char name[50];
    int age;
}Person;

//compare float values
int compareDouble(const void *a, const void *b)
{
    if (*(double*)a > *(double*)b)
        return 1;
    else if (*(double*)a < *(double*)b)
        return -1;
    else
        return 0;
}

//compare names
int compareNames(const void *a, const void *b)
{
    const Person *p1 = a;
    const Person *p2 = b;
    return strcmp(p1->name, p2->name);
}

//compare by age then names
int compareAge(const void *a, const void *b)
{
    const Person *p1 = a;
    const Person *p2 = b;
    return p2->age - p1->age;
}

int main()
{
    //Create a list of floating point numbers and print out the list
    double numbers[] = {645.32, 37.40, 76.30, 5.40, -34.23, 1.11, -34.94, 23.37, 635.46, -876.22, 467.73, 62.26}; 
    int numSize = sizeof(numbers)/sizeof(numbers[0]);
    printf("Here is a list of numbers: \n");
    for(int i = 0; i < numSize; i++)
    {
        printf("%f ", numbers[i]);
    }
    
    //sort the list of numbers and then print out the sorted list
    qsort(numbers, numSize, sizeof(double), compareDouble);
    printf("\nHere is a sorted list of numbers: \n");
    for(int i = 0; i < numSize; i++)
    {
        printf("%f ", numbers[i]);
    }
    
    //create a list of people and print out the list
    Person people[] = {{"Hal", 20}, {"Susann", 31},  {"Dwight", 19}, {"Kassandra", 21}, {"Lawrence", 25}, {"Cindy", 22}, {"Cory", 27},
{"Mac", 19}, {"Romana", 27}, {"Doretha", 32}, {"Danna", 20}, {"Zara", 23}, {"Rosalyn", 26}, {"Risa", 24}, {"Benny", 28}, {"Juan", 33}, {"Natalie", 25}};
    int pplSize = sizeof(people) / sizeof(Person);
    printf("\nHere is a list of people: \n");
    for(int i = 0; i < pplSize; i++)
    {
        printf("Name: %s, Age: %d \n", people[i].name, people[i].age);
    }
    
    //sort the list of people alphabetically and then print out the sorted list
    qsort(people, pplSize, sizeof(Person), compareNames);
    printf("\nHere is a list of people sorted alphabetically: \n");
    for(int i = 0; i < pplSize; i++)
    {
        printf("Name: %s, Age: %d \n", people[i].name, people[i].age);
    }
    
    //sort the list of people descending by age, alphabetically if the same age
    //the print out the sorted list
    qsort(people, pplSize, sizeof(Person), compareAge);
    printf("\nHere is a list of people sorted alphabetically: \n");
    for(int i = 0; i < pplSize; i++)
    {
        printf("Name: %s, Age: %d \n", people[i].name, people[i].age);
    }

    return 0;
}