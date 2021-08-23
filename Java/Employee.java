//Christopher Masferrer
//1266556
//Assignment 7

public class Employee
{
   private String firstName;
   private String lastName;
   private String employeeNumber;
   
   //initialize string argument
   public Employee( String name )
   {
      firstName = name;
      lastName = name;
      employeeNumber = name;
   } 
   
   //set first name
   public void setFirstName( String name )
   {
      firstName = name; // store first name
   }
   
   //retrieve first name
   public String getFirstName()
   {
      return firstName;
   }
   
   //set last name
   public void setLastName( String name )
   {
      lastName = name; // store last name
   }
   
   //retrieve last name
   public String getLastName()
   {
      return lastName;
   }
   
   //set employee number
   public void setEmployeeNumber( String name )
   {
      employeeNumber = name;
   }
   
   //retrieve employee number
   public String getEmployeeNumber()
   {
      return employeeNumber;
   }
}