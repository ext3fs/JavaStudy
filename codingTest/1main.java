//import	java.util.Arrays;


public	class	main 
{
	final	int	RIGHT	= 0;
	final	int	DOWN	= 1;
	final	int	LEFT	= 2;
	

	public int find_rec(int[][] v, int x, int y)
	{
		int	dir	= RIGHT;
		int	area	= 1;
		int	i	= x;
		int	j	= y;


		while((i<v.length) && (j<v[i].length))
		{
			if( v[i][j] == 1 )
			{
				switch(dir)
				{
					case	RIGHT:
						++j;
						dir	= DOWN;
						continue;			
					case	DOWN:	
						++i;
						dir	= LEFT;
						continue;			
					case	LEFT:	
						--j;
						dir	= RIGHT;
						continue;			
				}
				
			}
			
			break;
		}

		return	area;	
	}

	public static void main(String[] args) 
	{
		int[][] v	= {{0,1,1,1},{1,1,1,1},{1,1,1,1},{0,0,1,0}};
		int	ans	= 0;		
		main	mai	= new main();


		for(int i=0; i<v.length; i++)
		{
			for(int j=0; j<v[i].length; j++)
			{
				mai.find_rec(v, i, j);				
			}
		}		

		System.out.println(ans);
	}
}
