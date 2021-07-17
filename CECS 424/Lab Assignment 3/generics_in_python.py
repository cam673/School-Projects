#Christopher Masferrer
#011894127
#CECS 424 - 01 Spring 2020
import operator

class Person:
    def __init__(self, name, age):
        self.name = name
        self.age = age
    def __str__(self):
        return "Name: %s, Age: %s" % (self.name, self.age)

def main():
    #Create a list of floating point numbers and print out the list
    numbers =  [645.32, 37.40, 76.30, 5.40, -34.23, 1.11, -34.94, 23.37, 635.46, -876.22, 467.73, 62.26]
    sizeNum = len(numbers)
    print("Here is a list of numbers: ")
    for sizeNum in numbers:
        print(sizeNum, end=' ')
    
    #sort the list of numbers and then print out the sorted list
    print("\n\nHere is a sorted list of numbers: ")
    numbers.sort()
    for sizeNum in numbers:
        print(sizeNum, end=' ')
    
    #create a list of people and print out the list
    people = [
        Person('Hal', 20), Person('Susann', 31), Person('Dwight', 19), Person('Kassandra', 21), 
        Person('Lawrence', 25), Person('Cindy', 22), Person('Cory', 27), Person('Mac', 19), 
        Person('Romana', 27), Person('Doretha', 32), Person('Danna', 20), Person('Zara', 23), 
        Person('Rosalyn', 26), Person('Risa', 24), Person('Benny',28), Person('Juan', 33), 
        Person('Natalie', 25),
    ]
    print("\n\nHere is a list of people: ")
    pplSize = len(people)
    for pplSize in people:
        print(str(pplSize))
    
    #sort the list of people alphabetically and then print out the sorted list
    people.sort(key=operator.attrgetter('name'))
    print("\n\nHere is a list of people sorted alphabetically: ")
    for pplSize in people:
        print(str(pplSize))
    
    #sort the list of people descending by age, alphabetically if the same age
    #then print out the sorted list
    people.sort(key=operator.attrgetter('age'), reverse=True)
    print("\n\nHere is a list of people sorted by age: ")
    for pplSize in people:
        print(str(pplSize))
    
main()