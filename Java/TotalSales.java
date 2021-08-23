//Christopher Masferrer
//1266556
//Assignment 6

import java.util.Scanner;

public class TotalSales
{

   public static void main( String [] args )
   {
      Scanner infile = new Scanner("assign06.txt");
      int i;
      int j;
      int sales[][] = new int [4][5];
      int salesPersonTotal[] = new int [4];
      int productTotal[] = new int [5];
      int garbage1 = 0;
      int garbage2 = 0;
      
      for(i=0; i < 4; i++)  //initialize array
      {
        for(j=0; j < 5; j++)
        {
          sales[i][j] = 0;
        }
      }
      
      while(garbage1 != -1) //read record
      {
        for(i=0; i < 4; i++)
        {
          for(j=0; j < 5; j++)
          {
            garbage1 = infile.nextInt();   //salesperson number
            garbage2 = infile.nextInt();   //product number
            
            sales[i][j] = sales[i][j] + infile.nextInt();
          }
        } 
       }
       
       for(i=0; i < 4; i++)  //initialize salesperson total array
       {
         salesPersonTotal[i] = 0;
       } 
       
       for(i=0; i < 5; i ++) //initialize product total array
       {
         productTotal[i] = 0;
       }
       
       for(i=0; i < 4; i++)  //calculate salesperson total
       {
         for(j=0; j < 4; j++)
         {
           salesPersonTotal[i] = salesPersonTotal[i] + sales[i][j];
         }
       }
       
       for(j=0; j < 5; j++)  //calculate product total
       {
         for(i=0; i < 4; i ++)
         {
           productTotal[j] = productTotal[j] + sales[i][j];
         }
       }
      
      //print out results
      System.out.println("          1           2          3          4          ");
      System.out.printf("  1      ",10.2f, sales[0][0]);
   }

}