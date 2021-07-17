//Christopher Masferrer
//011894127
//CECS 424 - 01 Spring 2020

using System;
using System.Collections.Generic;
using System.Linq;

class Generics
{
  class Person
  {
      public String name { get; set; }
      public int age { get; set; }
  }
  static void Main() 
  {
      //Create a list of floating point numbers and print out the list
      List<double> numbers = new List<double>() {645.32, 37.40, 76.30, 5.40, -34.23, 1.11, -34.94, 23.37, 635.46, -876.22, 467.73, 62.26};
      Console.WriteLine("Here is a list of numbers: ");
      for(int i = 0; i < numbers.Count; i++)
      {
          Console.Write(numbers[i] + " ");
      }
      
      //sort the list of numbers and then print out the sorted list
      numbers = numbers.OrderBy(i => i).ToList();
      Console.WriteLine("\n\nHere is a sorted list of numbers: ");
      for(int i = 0; i < numbers.Count; i++)
      {
          Console.Write(numbers[i] + " ");
      }
      
      //create a list of people and print out the list
      List<Person> people = new List<Person>(){
          new Person() { name = "Hal", age = 20 }, new Person() { name = "Susann", age = 31 }, new Person() { name = "Dwight", age = 19 },
          new Person() { name = "Kassandra", age = 21}, new Person() { name = "Lawrence", age = 25}, new Person() { name = "Cindy", age = 22}, 
          new Person() { name = "Cory", age = 27}, new Person() { name = "Mac", age = 19}, new Person() { name = "Romana", age = 27}, 
          new Person() {name = "Doretha", age = 32}, new Person() {name = "Danna", age = 20}, new Person() {name = "Zara", age = 23}, 
          new Person() {name = "Rosalyn", age = 26}, new Person() {name = "Risa", age = 24}, new Person() {name = "Benny", age = 28}, 
          new Person() {name = "Juan", age = 33}, new Person() {name = "Natalie", age = 25}
      };
      
      Console.WriteLine("\n\nHere is a list of people: ");
      foreach(Person p in people)
      {
          Console.WriteLine("Name: " + p.name + ", Age: " + p.age);
      }
      
      //sort the list of people alphabetically and then print out the sorted list
      List<Person> peopleName = people.OrderBy(p => p.name).ToList();
      Console.WriteLine("\nHere is a list of people sorted alphabetically: ");
      foreach(Person p in peopleName)
      {
          Console.WriteLine("Name: " + p.name + ", Age: " + p.age);
      }
      
      //sort the list of people descending by age, alphabetically if the same age
      //then print out the sorted list
      List<Person> peopleAge = people.OrderByDescending(p => p.age).ThenBy(p => p.name).ToList();
      Console.WriteLine("\nHere is a list of people sorted by age: ");
      foreach(Person p in peopleAge)
      {
          Console.WriteLine("Name: " + p.name + ", Age: " + p.age);
      }
  }
}