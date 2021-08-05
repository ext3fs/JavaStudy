import	java.io.*;
import	java.util.*;

public class	main
{
	int[]						ar;
	int	k, n;

	static int MakeLine(int length)
	{
		int	cnt	= 0;

		for(int i=0; i<k; ++i)
			cnt	+= ar[i]/length;

		return	cnt;							
	}

	public static void main(String[] args) throws Exception
	{
		StreamTokenizer	st	= new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));		
		st.nextToken();	k	= (int)st.nval;
		st.nextToken(); n	= (int)st.nval;
		HashSet<Integer>	set	= new HashSet<>();
		int	cnt, length=0, sum=0;

		ar	= new int[k];
		
		for(int i=0; i<k; ++i){
			st.nextToken();
			ar[i]	= (int)st.nval;
			sum		+= ar[i];
			length	= Math.min(length, ar[i]);		
		}

		if(n > sum){
			System.out.println(0);
			return;
		}
		
		if(n == k){
			System.out.println(length);
			return;
		}	

		set.add(0);	
		set.add(length);	

		while(true){
			length	/= 2;
		
			cnt	= MakeLine(length);
			
			if(cnt >= n)	
		}
		
	}
}
