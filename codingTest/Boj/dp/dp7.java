import	java.io.BufferedReader;
import	java.io.InputStreamReader;
import	java.io.StreamTokenizer;
import	java.util.*;
import	java.util.stream.*;

public class	main
{
	public static void	main(String[] args) throws Exception
	{  
		StreamTokenizer	st	= new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in))); 		
		st.nextToken();
		int	line	= (int)st.nval;
		int	val;
		int[]	a,b,c, tmp;

		a	= new int[2];
		b	= new int[2];
		c	= new int[2];

		st.nextToken(); 
		b[1]	= (int)st.nval;
		
		System.out.println(Arrays.stream(a).boxed().collect(Collectors.toList()));
		System.out.println(Arrays.stream(b).boxed().collect(Collectors.toList()));
		for(int i=1; i<line; ++i)
		{
			st.nextToken();
			val	= (int)st.nval;
		
			c[0]	= val + b[1];
			c[1]	= val + Math.max(a[0], a[1]);
			
			System.out.println(Arrays.stream(c).boxed().collect(Collectors.toList()));
			tmp	= a;	
			a	= b; 
			b	= c;
			c	= tmp;
		}
	
		System.out.println(Math.max(b[0], b[1]));
	}
}
