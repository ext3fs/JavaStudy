import	java.util.Scanner;
import	java.util.PriorityQueue;

public class	main 
{
	static	int[][]	map;
	static	int[][]	visit;

	static int bfs(int i, int j)
	{
		if(map[i][j] == 0 || visit[i][j] > 0)	
			return	0;

		visit[i][j]	= 1;
		return	bfs(i,j-1) + bfs(i,j+1) + bfs(i-1,j) + bfs(i+1,j) + 1;
	}
				
	public static void	main(String[] args) 
	{
		Scanner	sc		= new Scanner(System.in);
		int		line	= Integer.parseInt(sc.nextLine());
		
		map		= new int[line+2][line+2];		
		visit	= new int[line+2][line+2];		

		String	str;	
		int		i,j;		

		for(i=1; i<=line; ++i){
			str	= sc.nextLine();	
		
			for(j=1; j<=line; ++j)
				map[i][j]	= str.charAt(j-1) - 48;			
		}

		/*
		for(int i=0; i<line+2; ++i){
			for(int j=0; j<line+2; ++j)
				System.out.print(map[i][j] + " ");
			System.out.println();
		}
		*/
		
		PriorityQueue<Integer>	q	= new PriorityQueue<>();	
		int	ret;	
	
		for(i=1; i<=line; ++i){
			for( j=1; j<=line; ++j){
				if( (ret = bfs(i,j)) > 0)	
					q.offer(ret);	
			}
		}
		
		StringBuilder	sb	= new StringBuilder();
		ret	= q.size();
		sb.append(ret).append("\n");
		
		for(i=0; i<ret; ++i)
			sb.append(q.poll()).append("\n");

		System.out.print(sb.toString());
	}
}
