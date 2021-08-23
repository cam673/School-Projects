//Christopher Masferrer
//011894127
//CECS 424

import java.util.*;
import java.util.function.Predicate;
public class TakeWhileGenerator<T> implements Iterable<T>
{
   private List<T> takeW = new ArrayList<T>();
   
   public TakeWhileGenerator(Predicate<T> pred, Iterable<T> coll)
   {
      takeWhile(pred, coll);
   }
   
   public void takeWhile(Predicate<T> pred, Iterable<T> coll)
   {
      ArrayList<T> results = new ArrayList<T>();
      Iterator<T> iter = coll.iterator();
      boolean verify = true;
      while(verify == true)
      {
         if(iter.hasNext())
         {
            T r = iter.next();
            if(pred.test(r))
            {
               results.add(r);
            }
            else
            {
               verify = false;
            }
         }
         else
         {
            verify = false;
         }
      }
      takeW = results;
   }
   
   @Override
   public Iterator<T> iterator()
   {
      return takeW.iterator();
   }
   
}