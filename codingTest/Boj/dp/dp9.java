import	java.util.Scanner;

public class	main
{
	public static void	main(String[] args)
	{  
		int		size	= Integer.parseInt(new Scanner(System.in).nextLine());
		int[][]	ar	= new int[size+1][10];
		int		i, j, sum=0;	

		for(i=1; i<10; ++i)
			ar[1][i]	= 1;

		for(i=2; i<=size; ++i)
		{
			ar[i][1]	= ar[i-1][0];
			ar[i][8]	= ar[i-1][9];
			
			for(j=1; j<9; ++j){
				ar[i][j-1]	= (ar[i][j-1] + ar[i-1][j])%1000000000;
				ar[i][j+1]	= (ar[i][j+1] + ar[i-1][j])%1000000000;
			}
		}

		for(j=1; j<=size; ++j)
		{	
			sum = 0;
			for(i=0; i<10; ++i)
				sum	= (sum + ar[j][i])%1000000000;
		
			System.out.println(j + " -> "+ sum);
		}	
	}
}
