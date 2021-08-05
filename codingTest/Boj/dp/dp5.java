import	java.io.BufferedReader;
import	java.io.InputStreamReader;
import	java.util.StringTokenizer;
import	java.util.Arrays;

public class	main
{
	public static void	main(String[] args) throws Exception
	{  
		BufferedReader	br	= new BufferedReader(new InputStreamReader(System.in)); 		
		StringTokenizer	st;
		int	line	= Integer.parseInt(br.readLine());
		int[][] ar	= new int[line+1][3];
		int	a,b,c;		

		for(int i=1; i<=line; ++i)
		{
			st	= new StringTokenizer(br.readLine());
			a	= Integer.parseInt(st.nextToken());
			b	= Integer.parseInt(st.nextToken());
			c	= Integer.parseInt(st.nextToken());
			
			ar[i][0]	= Math.min(ar[i-1][1]+a, ar[i-1][2]+a);		
			ar[i][1]	= Math.min(ar[i-1][0]+b, ar[i-1][2]+b);		
			ar[i][2]	= Math.min(ar[i-1][0]+c, ar[i-1][1]+c);		
		}
		
		Arrays.sort(ar[line]);
		System.out.println(ar[line][0]);
	}
}
