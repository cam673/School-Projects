//Christopher Masferrer
//011894127
//CECS 424

import java.util.*;
public class RangeGenerator implements Iterable<Double>
{
   private List<Double> coll = new ArrayList<Double>();
   
   public RangeGenerator(int start, int end, int incr)
   {
      range(start, end, incr);
   }
   
   public void range(int s, int e, int inner)
   {
      ArrayList<Double> r = new ArrayList<Double>();
      for(double i = s; i <= e; i += inner)
      {
         r.add(i);
      }
      coll = r;
   }
   
   @Override
   public Iterator<Double> iterator()
   {
      return coll.iterator();
   }
   
}