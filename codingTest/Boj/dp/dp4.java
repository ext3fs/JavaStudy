import	java.io.BufferedReader;
import	java.io.InputStreamReader;

public class	main
{
	public static void	main(String[] args) throws Exception
	{  
		BufferedReader	br	= new BufferedReader(new InputStreamReader(System.in)); 		
		StringBuilder	sb	= new StringBuilder();	
		int	line	= Integer.parseInt(br.readLine());
		int[] ar	= new int[101];
		
		ar[1] = ar[2] = ar[3] = 1;	
		ar[4] =	ar[5] = 2;		

		for(int i=6; i<101; ++i)
			ar[i]	= ar[i-1] + ar[i-5];

		for(int i=0; i<line; ++i)
			sb.append(ar[Integer.parseInt(br.readLine())]).append("\n");
		
		System.out.print(sb.toString());
	}
}
