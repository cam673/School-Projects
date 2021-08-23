//Christopher Masferrer
//011894127
//CECS 424

import java.util.*;
import java.util.function.Predicate;
public class FilterGenerator<T> implements Iterable<T>
{
   private List<T> filter = new ArrayList<T>();
   
   public FilterGenerator(Predicate<T> pred, Iterable<T> coll)
   {
      filterOut(pred, coll);
   }
   
   public void filterOut(Predicate<T> pred, Iterable<T> coll)
   {
      ArrayList<T> results = new ArrayList<T>();
      Iterator<T> iter = coll.iterator();
      while(iter.hasNext())
      {
         T r = iter.next();
         if(pred.test(r))
         {
            results.add(r);
         }
      }
      filter = results;
   }
   
   @Override
   public Iterator<T> iterator()
   {
      return filter.iterator();
   }
   
}