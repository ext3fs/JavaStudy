import	java.util.Scanner;

public class	main
{
	static double	fibo(int n)
	{
		if(n < 2)
			return	n;
		
		double	a=0,b=1,tmp;

		for(int i=2; i<n; ++i){
			tmp	= a+b;
			a	= b;
			b	= tmp;		
		}

		return	a+b;	
	}

	public static void	main(String[] args)
	{
		Scanner	sc	= new Scanner(System.in);
		int		n	= Integer.parseInt(sc.nextLine());

		System.out.printf("%.0f",fibo(n));
	}
}
