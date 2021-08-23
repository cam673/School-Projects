//Christopher Masferrer
//011894127
//CECS 424

import java.util.*;
public class TakeGenerator<T> implements Iterable<T>
{
   private List<T> taker = new ArrayList<T>();
   
   public TakeGenerator(int n, Iterable<T> coll)
   {
      selector(n, coll);
   }
   
   public void selector(int n, Iterable<T> coll)
   {
      ArrayList<T> results = new ArrayList<T>();
      Iterator<T> iter = coll.iterator();
      for(int i = 0; i < n; i++)
      {
        results.add(iter.next());
      }
      taker = results;
   }
   
   @Override
   public Iterator<T> iterator()
   {
      return taker.iterator();
   }
   
}