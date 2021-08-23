//Christopher Masferrer
//1266556
//Assignment 2a

import java.util.Scanner;

   public class CalculateCommission
   {
   
      public static void main( String[] args )
      {
      
         Scanner input = new Scanner( System.in );
         
         int sales;
         double commission = 0;
         double total;
         double commissionMult;
         
         System.out.print( "This program will calculate a salespersons commission for the week\n");
         System.out.print( "\nEnter Sales for the week: ");
         sales = input.nextInt();
         
         if( sales <= 1000 )
           commission = 0;
         else
             if( sales > 1000 && sales <= 2500 )
               commission = 0.02;
             else
                 if( sales > 2500 && sales <= 5000 )
                   commission = 0.03;
                 else
                     if( sales > 5000 && sales <= 7500 )
                       commission = 0.04;
                     else
                         if( sales >7500 )
                           commission = 0.05;
                         else
                             System.out.print( "You cannot enter a negative number.");
                             
         commissionMult = sales * commission;
         total = sales + commissionMult;
         
         System.out.printf( "The salesperson commission for this week is %d\n", total);
         }
   }