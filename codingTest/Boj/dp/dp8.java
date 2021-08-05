import	java.util.Scanner;

public class	main
{
	public static void	main(String[] args)
	{  
		Scanner	sc	= new Scanner(System.in);	
		int		n	= Integer.parseInt(sc.nextLine());
		int[]	ar	= new int[n+1];

		for(int i=2; i<=n; ++i)
		{
			if(i%3 == 0)
				ar[i]	= Math.min(ar[i/3], ar[i-1]) +1;
			else if(i%2 == 0)
				ar[i]	= Math.min(ar[i/2], ar[i-1]) +1;
			else
				ar[i]	= ar[i-1] +1;	
		}

		for(int i=1; i<=n; ++i)
			System.out.println(i + " : " + ar[i]);
		
		System.out.println(ar[n]);
	}
}
