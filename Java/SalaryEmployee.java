//Christopher Masferrer
//1266556
//Assignment 7

public class SalaryEmployee extends Employee
{
   private double yearlySalary;
   
   //initialize double
   public SalaryEmployee( double num )
   {
      yearlySalary = num;
   }
   
   //set yearly salary
   public void setYearlySalary( double num )
   {
      yearlySalary = num; //store yearly salary
   }
   
   //retrieve yearly salary
   public double getYearlySalary()
   {
      return yearlySalary;
   }
}