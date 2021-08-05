import	java.util.Arrays;

public	class	main 
{
	static	int[][] v	= {{1,2,3,5},{5,6,7,99},{4,3,2,1}};

	static	void	make_max(int row)
	{
		for(int i=0; i<4; i++)
		{
			int	max	= 0;

	
			for(int j=0; j<4; j++)
				if(i != j)
					max = Math.max(max, v[row][i] + v[row-1][j]);
			
			v[row][i] = max;
		}
	}	

	public static void main(String[] args) 
	{
		for(int i=1; i<v.length; i++)		
			make_max(i);	

		for(int j=0; j<4; ++j)
			System.out.print(v[v.length-1][j] + " ");
		System.out.println();

	}
}
