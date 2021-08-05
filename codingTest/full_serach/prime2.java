
public class	main
{
	int[]	tb;

	boolean	isPrime(int val)
	{
		if(val < 2)
			return	false;

		for(int	i=2; i*i<=val; ++i)	
		{
			if(val%i == 0)
				return	false;
		}

		return	true;
	}

	boolean	isPrime2(int val)
	{
		if(tb[val] == 0)
			return	true;
		return	false;
	}

	void	mkTable(int max_val)
	{
		tb[0]	= 2;
		tb[1]	= 2;

		for(int i=2; i*i<=max_val; ++i)
		{
		//	System.out.print(i + " : ");
			if(tb[i] == 2)
			{
		//		System.out.println();
					continue;
			}
		
			for(int j=i+i; j<max_val; j+=i)
			{
				tb[j]	= 2;
		//		System.out.print(j+" ");
			}
			
		//	System.out.println();
		}				
	}

	
	public static void main(String[] args) 
	{
		main	m	= new main();
		int	ret	= 0;
		int	max_val	= 50000;
		
		long	start	= System.currentTimeMillis();		
		
//		m.tb	= new int[max_val];
//		m.mkTable(max_val);	

		
		for(int i=0;i<max_val;++i)
			if(m.isPrime(i))
				++ret;

		long	end	= System.currentTimeMillis();		
		
		System.out.println(ret + " time = " + (end - start));
		
	}
}
