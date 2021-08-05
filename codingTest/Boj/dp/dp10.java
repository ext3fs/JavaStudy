import	java.io.InputStreamReader;
import	java.io.BufferedReader;
import	java.io.StreamTokenizer;

public class	main
{
	public static void	main(String[] args) throws Exception
	{
		StreamTokenizer	st	= new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));  
		st.nextToken();
		int	n	= (int)st.nval;
		int ar[][]	= new int[n+1][2];
		int	i, val, max=0;

		st.nextToken();
		ar[1][1] = (int)st.nval;
		
		for(i=2; i<=n; ++i)
		{
			st.nextToken();
			val	= (int)st.nval;

			//ar[i][1]	= val + Math.max(ar[i-2][0], ar[i-2][1]);
			ar[i][1]	= val + max;
			ar[i][0]	= val + ar[i-1][1];
			max			= Math.max(max, Math.max(ar[i-1][0], ar[i-1][1]));

			System.out.println(i+" : " +val +" -> " +ar[i][0] +" , " +ar[i][1]+" max = "+max);
				
		}	

		System.out.println(Math.max(max, Math.max(ar[n][0], ar[n][1])));					
	}
}
