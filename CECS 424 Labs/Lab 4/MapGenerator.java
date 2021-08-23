//Christopher Masferrer
//011894127
//CECS 424

import java.util.*;
public class MapGenerator<TIn, TOut> implements Iterable<TOut>
{
   private List<TOut> numbers = new ArrayList<TOut>();
   
   public MapGenerator(Transformer<TIn, TOut> fun, Iterable<TIn> coll)
   {
      converter(fun, coll);
   }
   
   public void converter(Transformer<TIn, TOut> fun, Iterable<TIn> coll)
   {
      ArrayList<TOut> results = new ArrayList<TOut>();
      Iterator<TIn> mIter = coll.iterator();
      while(mIter.hasNext())
      {
         results.add(fun.transform(mIter.next()));
      }
      numbers = results;
   }
   
   @Override
   public Iterator<TOut> iterator()
   {
      return numbers.iterator();
   }
}