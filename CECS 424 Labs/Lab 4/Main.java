//Christopher Masferrer
//011894127
//CECS 424
import java.util.*;
import java.lang.Math;

public class Main
{
   public static void main(String [] args)
   {
      //Printing numbers from 1 - 1000
      
      System.out.println("printing numbers 1 - 1000");
      for(Double i : new RangeGenerator(1, 1000, 1))
      {
         System.out.print(i + " ");
      }
      
      //creating arraylist containing 1 - 1000
      ArrayList<Double> test = new ArrayList<Double>();
      for(Double i : new RangeGenerator(1, 1000, 1))
      {
         test.add(i);
      }
      
      //printing sequence
      System.out.println("\nSequence");
      for(Double i : new TakeWhileGenerator<Double>(
         i -> i < 5, new SkipGenerator<Double>(
            2, new MapGenerator<Double, Double>(
               (i) -> Math.sqrt(i), new FilterGenerator<Double>(
                  (i) -> i % 2 == 1, new RangeGenerator(1, 1000, 1))))))
      {
         System.out.println(i);
      }
      
   }
}