import	java.util.HashSet;

public class	main 
{
	int fibo(int n)
	{
		if(n < 2)
			return	n;

		return	fibo(n-1)*n;	
	}

	public static void main(String[] args) 
	{
		main	m	= new main();

		System.out.println("answer = " + m.fibo(3));	
	}
}
