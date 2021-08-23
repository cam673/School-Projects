//Christopher Masferrer
//1266556
//Assignment 5
#include <iostream>
#include <iomanip>
#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <cmath>
#include <math.h>
using namespace std;

int menuInput;
char userInput;

void speed()
{
    double v;
    double a;
    double t;
    double speed;
    
    while(userInput != 'N')
    {
        std::cout << "\nThe formula for speed is: (speed = v + at)\n";
        std::cout << "v = velocity\n";
        std::cout << "a = acceleration\n";
        std::cout << "t = seconds\n";
        std::cout << "\nEnter the folowing information: \n";
        std::cout << "v = ";
        std::cin >> v;
        while(v <= 0)
        {
            std::cout << "\nYou can only use positive numbers!!!\n";
            std::cin >> v;
            
        }
        std::cout << "\na = ";
        std::cin >> a;
        while(a <= 0)
        {
            std::cout << "\nYou can only use positive numbers!!!\n";
            std::cin >> a;
        }
        std::cout << "\nt = ";
        std::cin >> t;
        while(t <= 0)
        {
            std::cout << "\nYou can only use positive numbers!!!\n";
            std::cin >> t;
        }
    
        speed = v + a * t;
    
        std::cout << "\nThe solution is " << speed << ".\n";
        std::cout << "\nWould you like to continue? (Y or N)\n";
        std::cin >> userInput;
        
        if(userInput != 'Y' && userInput != 'N')
        {
            std::cout << "\nPlease select: (Y or N) only.\n";
            std::cin >> userInput;
        }
        
        if(userInput == 'Y')
        {
           void speed();
        }
    }
}

void distance()
{
    double distance;
    double a;
    double t;
    
    while(userInput != 'N')
    {
        std::cout << "\nThe formula for distance is: (distance = at^2/2)\n";
        std::cout << "a = acceleration\n";
        std::cout << "t = seconds\n";
        std::cout << "\nEnter the following information: \n";
        std::cout << "a = ";
        std::cin >> a;
        while(a <= 0)
        {
            std::cout << "\nYou can only use positive numbers!!!\n";
            std::cin >> a;
        }
        std::cout << "\nt = ";
        std::cin >> t;
        while(t <= 0)
        {
            std::cout << "\nYou can only use positive numbers!!!\n";
            std::cin >> t;
        }
        
        distance = a * pow(t,2) / 2;
        
        std::cout << "\nThe solution is " << distance << ".\n";
        std::cout << "\nWould you like to continue? (Y or N)\n";
        std::cin >> userInput;
        
        if(userInput != 'Y' && userInput != 'N')
        {
            std::cout << "\nPlease select: (Y or N) only.\n";
            std::cin >> userInput;
        }
        if(userInput == 'Y')
        {
            void distance();
        }
    }
}

void barVolume()
{
    double barVolume;
    double l;
    double w;
    double h;
    
    while(userInput != 'N')
    {
        std::cout << "\nThe formula for bar volume is: (bar volume = l * w * h)\n";
        std::cout << "l = length\n";
        std::cout << "w = width\n";
        std::cout << "h = height\n";
        std::cout << "\nEnter the following information: \n";
        std::cout << "l = ";
        std::cin >> l;
        while(l <= 0)
        {
            std::cout << "\nYou can only use positive numbers!!!\n";
            std::cin >> l;
        }
        std::cout << "\nw = ";
        std::cin >> w;
        while(w <= 0)
        {
            std::cout << "\nYou can only use positive numbers!!!\n";
            std::cin >> w;
        }
        std::cout << "\nh = ";
        std::cin >> h;
        while(h <= 0)
        {
            std::cout << "\nYou can only use positive numbers!!!\n";
            std::cin >> h;
        }
        
        barVolume = l * w * h;
        
        std::cout << "\nThe solution is " << barVolume << ".\n";
        std::cout << "\nWould you like to continue? (Y or N)";
        std::cin >> userInput;
        if(userInput != 'Y' && userInput != 'N')
        {
            std::cout << "\nPlease select: (Y or N) only.\n";
            std::cin >> userInput;
        }
        if(userInput == 'Y')
        {
            void barVolume();
        }
    }
}

void sphereVolume()
{
    double sphereVolume;
    double r;
    const double π = 3.1415926535897;
    
    while(userInput != 'N')
    {
        std::cout << "\nThe formula for sphere volume is: (sphere volume = 4π(r^3)/3)\n";
        std::cout << "r = radius\n";
        std::cout << "\nEnter the following information: \n";
        std::cout << "r = ";
        std::cin >> r;
        while(r <= 0)
        {
            std::cout << "\nYou can only use positive numbers!!!\n";
            std::cin >> r;
        }
        
        sphereVolume = 4 * π * pow(r,3) / 3;
        
        std::cout << "\nThe solution is " << sphereVolume << ".\n";
        std::cout << "\nWould you like to continue? (Y or N)";
        std::cin >> userInput;
        if(userInput != 'Y' && userInput != 'N')
        {
            std::cout << "\nPlease select: (Y or N) only.\n";
            std::cin >> userInput;
        }
        if(userInput == 'Y')
        {
            void sphereVolume();
        }
    }
}

void cylinderVolume()
{
    double cylinderVolume;
    double r;
    double h;
    const double π = 3.1415926535897;
    
    while(userInput != 'N')
    {
        std::cout << "\nThe formula for cylinder volume is: (cylinder volume = π(r^2)/h)\n";
        std::cout << "r = radius\n";
        std::cout << "h = height\n";
        std::cout << "\nEnter the following information: \n";
        std::cout << "r = ";
        std::cin >> r;
        while(r <= 0)
        {
            std::cout << "\nYou can only use positive numbers!!!\n";
            std::cin >> r;
        }
        std::cout << "\nh = ";
        std::cin >> h;
        while(h <= 0)
        {
            std::cout << "\nYou can only use positive numbers!!!\n";
            std::cin >> h;
        }
        
        cylinderVolume = π * pow(r,2) / h;
        
        std::cout << "\nThe solution is " << cylinderVolume << ".\n";
        std::cout << "\nWould you like to continue? (Y or N)";
        std::cin >> userInput;
        if(userInput != 'Y' && userInput != 'N')
        {
            std::cout << "\nPlease select: (Y or N) only.\n";
            std::cin >> userInput;
        }
        if(userInput == 'Y')
        {
            void cylinderVolume();
        }
    }
}

void mainMenu()
{
    std::cout << "\n\nWhich formula would you like to go to?\n";
    std::cout << "1. Speed\n";
    std::cout << "2. Distance\n";
    std::cout << "3. Bar Volume\n";
    std::cout << "4. Sphere Volume\n";
    std::cout << "5. Cylinder Volume\n";
    std::cout << "6. Exit \n";
    std::cout << "\nSelect (1, 2, 3, 4, 5, or 6)\n";
    std::cin >> menuInput;
    std::cin.ignore();
    
    if(menuInput == 1)
    {
        speed();
    }
    else
        if(menuInput == 2)
        {
            distance();
        }
    else
        if(menuInput == 3)
        {
            barVolume();
        }
    else
        if(menuInput == 4)
        {
            sphereVolume();
        }
    else
        if(menuInput == 5)
        {
            cylinderVolume();
        }
    else
        if(menuInput == 6)
        {
            std::cout << "\nGoodbye!\n";
            std::cout << "Press ENTER to Exit.\n";
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

int main()
{
    std::cout << "Welcome to the Physics Calculator!\n";
    std::cout << "This program will help you solve equations related to \n";
    std::cout << "Physics. You will be taken to a main menu where you can \n";
    std::cout << "decide which formula to go to.\n";
    std::cout << "\nPress ENTER to continue . . . \n";
    cin.get();
    
    mainMenu();
    
    if(menuInput == 6)
    {
      return 0;
    }
    
    if(userInput == 'N')
    {
        userInput = 'a';
        mainMenu();
    }
    
}

