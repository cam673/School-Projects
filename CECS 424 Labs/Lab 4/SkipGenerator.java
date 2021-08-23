//Christopher Masferrer
//011894127
//CECS 424

import java.util.*;
public class SkipGenerator<T> implements Iterable<T>
{
   private List<T> skipper = new ArrayList<T>();
   
   public SkipGenerator(int skip, Iterable<T> coll)
   {
      skipElements(skip, coll);
   }
   
   public void skipElements(int skip, Iterable<T> coll)
   {
      ArrayList<T> results = new ArrayList<T>();
      Iterator<T> iter = coll.iterator();
      for(int i = 0; i < skip; i++)
      {
         iter.next();
      }
      while(iter.hasNext())
      {
         results.add(iter.next());
      }
      skipper = results;
   }
   
   @Override
   public Iterator<T> iterator()
   {
      return skipper.iterator();
   }
}