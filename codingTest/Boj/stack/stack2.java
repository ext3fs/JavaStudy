import	java.io.*;
import	java.util.*;

public class	main
{
	public static void	main(String[] args) throws Exception
	{
		Stack<Integer>	stk	= new Stack<>();
		StreamTokenizer	st	= new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		int				k, val, sum=0;

		st.nextToken();	k	= (int)st.nval;
	
		for(int i=0; i<k; ++i)
		{
			st.nextToken(); val	= (int)st.nval;	
			
			if(val == 0)
				stk.pop();
			else
				stk.push(val);
		}

		while(!stk.isEmpty())
			sum	+= stk.pop();

		System.out.println(sum);
	}
}
