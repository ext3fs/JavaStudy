import	java.io.BufferedReader;
import	java.io.InputStreamReader;

public class	main
{
	public static void	main(String[] args) throws Exception
	{
		BufferedReader	br	= new BufferedReader(new InputStreamReader(System.in));
		int	line	= Integer.parseInt(br.readLine());
		int[][]	ar	= new int[41][2];
		StringBuilder	sb	= new StringBuilder();
		int	i,n;

		ar[0][0]	= 1;
		ar[1][1]	= 1;
	
		for(i=2; i<41; ++i){
			ar[i][0]	= ar[i-1][0] + ar[i-2][0];		
			ar[i][1]	= ar[i-1][1] + ar[i-2][1];		
		}
		
		for(i=0; i<line; ++i){
			n	= Integer.parseInt(br.readLine());
			sb.append(ar[n][0]).append(" ").append(ar[n][1]).append("\n");;		
		}	
	
		System.out.printf(sb.toString());
	}
}
