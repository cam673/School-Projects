
public class MemoizedCutRod {
	
	//memoizedCutRod function from book, with an extra int array to store the rod lengths for max value
	public int memoizedCutRod(int p[], int n, int s[])
	{
		//check if the array s is the right size
		if (s.length != n + 1)
		{
			System.out.println("Input array s must have a length of input n + 1");
			return -1;
		}
		
		//check if the value can be calculated using p
		if (n >= p.length)
		{
			System.out.println("n must be < p.length");
			return -1;
		}
					
		int[] r = new int[n+1];
		
		for (int i = 0; i <= n; i++)
		{
			r[i] = Integer.MIN_VALUE;
			s[i] = 0;
		}
		
		return memoizedCutRodAux(p, n, r, s);	
	}
	
	//memoizedCutRodAux function from the book that also stores the rod lengths that produce the max value
	private int memoizedCutRodAux(int p[], int n, int r[], int s[])
	{
		if (r[n] >= 0)
				return r[n];
		
		int q;
		
		if (n == 0)
			q = 0;
		else
		{
			q = Integer.MIN_VALUE;
			int t;
			for (int i = 1; i <= n; i++)
			{
				t =  p[i] + memoizedCutRodAux(p, n - i, r, s);
				//if t is greater than q, store t in q and the length i in s[n]
				if (t > q)
				{
					q = t;
					s[n] = i;
				}
			}
		}
		
		r[n] = q;
		return q;
	}
	
	//lengthsUsed returns a string that consists of the different length cuts used to obtain the max value of a rod	
	public String lengthsUsed(int n, int s[])
	{
		if (n - s[n] == 0)
			return " " + Integer.toString(s[n]);
		else
			return " " + s[n] + lengthsUsed(n - s[n], s);
	}

}
