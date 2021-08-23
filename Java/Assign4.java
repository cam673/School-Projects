//Christopher Masferrer
//1266556
//Assignment 4

import java.util.Scanner;

public class Assign4
{

 File file;
 Scanner inputFile;
 
 string socialSecurity;
 string lNamefName;
 double regHours;
 double otHours;
 double rate;
 double grossPay;
 double federalTax = .18;
 double stateTax = .05;
 double fica = .0751;
 double netPay;
 double grossPayGT = 0;
 double federalTaxGT = 0;
 double stateTaxGT = 0;
 double ficaGT = 0;
 double netPayGT = 0;

   public void main( String[] args )
   {
     houseKeeping();
     
     while(EOF != lNamefName)
     {
       process();
     }
     
     wrapUp();
   }
   
   void houseKeeping()
   {
     Scanner infile = new Scanner("WU_hourly_file.txt");
     reportFile = new PrintWriter("WU_payroll_report.txt");
     System.out.println("Wexler U. Payroll Register");
     System.out.println("");
     readRecord();
   }
   
   void process()
   {
     grossPay = regHours + otHours;
     federalTax = grossPay * federalTax;
     stateTax = grossPay * federalTax;
     fica = grossPay * fica;
     netPay = grossPay - federalTax - stateTax;
     
     grossPayGT = grossPayGT + grossPay;
     federalTaxGT = federalTaxGT + federalTax;
     stateTaxGT = stateTaxGT + stateTax;
     ficaGT = ficaGT + fica;
     netPayGT = netPayGT + netPay;
     
     System.out.printf(12.2f, socialSecurity);
     System.out.printf(20.2f, lNamefName);
     System.out.printf(17.2f, grossPay);
     System.out.printf(13.2f, federalTax);
     System.out.printf(12.2f, stateTax);
     System.out.printf(11.2f, fica);
     System.out.printf(14.2f, netPay);
     System.out.println();
     
     readRecord();
   }
   
   void wrapUp()
   {
     System.out.printf(32.f, "Grand Totals");
     System.out.printf($, 18.2f, grossPayGT);
     System.out.printf($, 13.2f, federalTaxGT);
     System.out.printf($, 12.2f, stateTaxGT);
     System.out.printf($, 11.2f, ficaGT);
     System.out.printf($, 14.2f, netPayGT);
     
     infile.close();
     infile = null;
     System.gc();
   }
   
   void readRecord()
   {
     socialSecurity = infile.nextString();
     lNamefName = infile.nextString();
     regHours = infile.nextDouble();
     otHours = infile.nextDouble();
     rate = infile.nextDouble();
   }
   
}