//Christopher Masferrer
//1266556
//Assignment 3

import java.util.Scanner;

public class OrderCalculator
{

   public static void main( String[] args )
   {
   
      Scanner input = new Scanner(System.in);
   
      double product1 = 2.98;
      double product2 = 4.50;
      double product3 = 9.98;
      double product4 = 4.49;
      double product5 = 6.87;
      double productNum;
      double quantity;
      double total = 0;
      
      System.out.println("This program will ask the user to enter a product number ");
      System.out.println("and how many were sold. It will then give you the amount ");
      System.out.println("of money that was made.\n");
      System.out.println("Enter a number between 1 - 5: ");
      productNum = input.nextDouble();
      System.out.println("Enter the number of sales: ");
      quantity = input.nextDouble();
      
      if( productNum == 1 )
        total = quantity * product1;
      else
          if( productNum == 2 )
            total = quantity * product2;
          else
              if( productNum == 3 )
                total = quantity * product3;
              else
                  if( productNum == 4 )
                    total = quantity * product4;
                  else
                      if( productNum == 5 )
                        total = quantity * product5;
                      else
                          System.out.print("ERROR: Number not in range of 1-5!");
      
      System.out.printf("The sales amount is $%,.2f%n", total);
      
   }
}