//Christopher Masferrer
//1266556


#include <iostream>

int main(int argc, const char * argv[])
{
    
    int number1 = 0;
    int number2 = 0;
    int sum;
    int difference;
    int product;
    int quotient;
    int integerRemainder;
    double average;
    
    std::cout << "Input 2 integers when prompted and I will print their sum";
    std::cout << ", difference, product, quotient, remainder, and average.\n";
    
    std::cout << "\n #1: ";
    std::cin >> number1;
    
    std::cout << " #2: ";
    std::cin >> number2;
    
    sum = number1 + number2;
    difference = number1 - number2;
    product = number1 * number2;
    quotient = number1/number2;
    integerRemainder = number1 % number2;
    average = sum / (float)2;
    
    std::cout << "\nThe numbers are " << number1 << " and " << number2 << ". \n";
    std::cout << "\nSum:        " << sum << "\n";
    std::cout << "Difference: " << difference << "\n";
    std::cout << "Product:    " << product << "\n";
    std::cout << "Quotient:   " << quotient << "\n";
    std::cout << "Remainder:  " << integerRemainder << "\n";
    std::cout << "Average:    " << average << "\n";
    
    return 0;
}

