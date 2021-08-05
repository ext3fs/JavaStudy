import	java.util.LinkedList;

public class	main
{

	public int[]	solution(int[] progresses, int[] speeds)
	{
		int		cnt	= progresses.length;
		int[]	ans	= new int[cnt];
		int		day, max_day=0, ans_idx=0;

		for(int i=0; i<cnt; ++i)
		{
			day	= ((100 - progresses[i])%speeds[i] > 0)? 1:0;		
			day	+= (100 - progresses[i])/speeds[i];		

			if(day > max_day)
			{
				ans[ans_idx]	= :q
			}
		}


		int[]	answer	={};
		return	answer;		
	}
	
	public static void main(String[] args) 
	{
		int[]	progresses	= {7,7,7,7,7};
		int[]	speeds		= {7,7,7,7,7};
		main	m			= new main();
		
		for(int	i : m.solution(progresses, speeds))
			System.out.println(i);
	}
}
