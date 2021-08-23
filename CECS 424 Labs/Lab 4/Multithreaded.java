import java.util.*;

public class Multithreaded
{
   private static Object lock1 = "lock1", lock2 = "lock2";
   
   public static void run1()
   {
      synchronized(lock1)
      {
         synchronized(lock2)
         {
            System.out.println("Got the locks!");
         }
      }
   }
   
   public static void run2()
   {
      synchronized(lock2)
      {
         synchronized(lock1)
         {
            System.out.println("Got the locks too!");
         }
      }
   }
}