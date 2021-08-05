import	java.util.LinkedList;

public class	main 
{

	public int solution(int n, int[][] computers)
	{
		int	answer	= 0;
		int	i	= 0;
		LinkedList<Integer> q	= new LinkedList<>();
		int	size;
	
		for(int j=0; j<computers[i].length; ++j)
		{
			if(computers[i][j] == 1)
			{
				q.offer(j);
				continue;
			}
				
			size	= q.size();
			while( size-- > 0)
			{
				i	= q.poll();
			}
				
		}

		return	answer;
	}

	public static void main(String[] args) 
	{
		int[]	ar	= {{1,1,0},{1,1,1},{0,1,1}};
		main	m	= new main();

		System.out.println("answer = " + m.solution(3, ar));	
	}
}
