//Christopher Masferrer
//1266556
//Assignment 7

public class HourlyEmployee extends Employee
{
   private double hourlyRate;
   private double shiftDays;
   private double shiftSwings;
   private double shiftMids;
   
   //initialize double
   public HourlyEmployee( double num )
   {
      hourlyRate = num;
      shiftDays = num;
      shiftSwings = num;
      shiftMids = num;
   }
   
   //set hourly rate
   public void setHourlyRate( double num )
   {
      hourlyRate = num; //store hourly rate
   }
   
   //retrieve hourly rate
   public double getHourlyRate()
   {
      return hourlyRate;
   }
   
   //set shift days
   public void setShiftDays( double num )
   {
      shiftDays = num; //store shift days
   }
   
   //retrieve shift days
   public double getShiftDays()
   {
      return shiftDays;
   }
   
   //set shift swings
   public void setShiftSwings( double num )
   {
      shiftSwings = num; //store shift swings
   }
   
   //retrieve shift swings
   public double getShiftSwings()
   {
      return shiftSwings;
   }
   
   //set shift mids
   public void setShiftMids( double num )
   {
      shiftMids = num; //store shift swings
   }
   
   //retrieve shift mids
   public double getShiftMids()
   {
      return shiftMids;
   }
}