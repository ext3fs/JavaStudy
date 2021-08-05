import	java.util.Scanner;

public class	main
{
	public static void	main(String[] args)
	{  
		Scanner	sc	= new Scanner(System.in);
		int	n		= Integer.parseInt(sc.nextLine());
		int	a=2, b=3, sum=0;
					
		if(n < 4)
			System.out.println(n);
			
		for(int i=4; i<=n; ++i){
			sum	= (a+b)%15746;
			a	= b;
			b	= sum;	
		}

		System.out.println(sum);
	}
}
