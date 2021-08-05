import	java.io.BufferedReader;
import	java.io.InputStreamReader;
import	java.io.StreamTokenizer;

public class	main
{
	public static void	main(String[] args) throws Exception
	{  
		StreamTokenizer	st	= new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in))); 		
		st.nextToken();
		int	line	= (int)st.nval;
		int[]	prev, curr;
		int	i, j, max=0;

		prev	= new int[3];
		st.nextToken(); 
		prev[1]	= (int)st.nval;

		for(i=1; i<line; ++i)
		{
			curr	= new int[i+3];
			
			for(j=1; j<i+2; ++j){
				st.nextToken();
				curr[j]	= (int)st.nval + Math.max(prev[j-1], prev[j]);
			}
		
			prev	= curr;	
		}
	
		for(i=1; i<=line; ++i)
			max	= Math.max(max, prev[i]);
		
		System.out.println(max);
	}
}
