import java.util.*;

public class Playground
{
   public static void main(String [] args)
   {
      Multithreaded one = new Multithreaded();
      Multithreaded two = new Multithreaded();
      one.run1();
      one.run2();
      two.run2();
   }
}