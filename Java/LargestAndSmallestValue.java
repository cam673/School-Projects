//Christopher Masferrer
//1266556
//Assignment 2b

import java.util.Scanner;

   public class LargestAndSmallestValue
   {
   
      public static void main( String[] args )
      {
      
         Scanner input = new Scanner( System.in );
         
         int counter = 0;
         int number;
         int largest;
         int smallest;
         
         System.out.print( "Enter 10 integers and I will print out the largest number ");
         System.out.print( "and the smallest number.\n");
         number = input.nextInt();
         
         largest = number;
         smallest = number;
         
         while (counter <= 10)
         {
           
           if( number > largest )
             largest = number;
           
           if( number < smallest )
             smallest = number;
           
           counter = counter + 1;
           
           if( counter <= 9)
             number = input.nextInt();
             
          }
          
          System.out.printf ("The largest number entered is %d\n", largest);
          System.out.printf ("The smallest number entered is %d\n", smallest);
          
      }
  }