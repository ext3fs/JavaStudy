import	java.util.LinkedList;

public class	main
{
	class	Paper
	{
		int		priority;
		boolean	ans;

		Paper(int priority, boolean ans)
		{
			this.priority	= priority;
			this.ans		= ans;
		}
	}

	int	getMaxPriority(int[] priority_cnt, int max_priority)
	{
		--priority_cnt[max_priority];

		for(int i = max_priority; i>0; --i)
			if(priority_cnt[i] > 0)
				return	i;		
		
		return	max_priority;
	}

	public int	solution(int[] priorities, int location)
	{
		int					answer			= 1;	
		int					max_priority	= 0;
		int					cnt				= 0;
		int[]				priority_cnt	= new int[10];	
		LinkedList<Paper>	qu				= new LinkedList<>();	

		for(int priority : priorities)	
		{
			if(priority > max_priority)
				max_priority	= priority;   
			
			++priority_cnt[priority];	
						
			qu.add(new Paper(priority, (cnt++ == location)? true : false));	
		}

		Paper	pa;

		while(true)
		{
			pa	= qu.poll();

			if(pa.priority == max_priority)
			{
				if(pa.ans)
					return	answer;

				max_priority	= getMaxPriority(priority_cnt, max_priority);
				++answer;
				continue;
			}	

			qu.add(pa);
		}
	
		//return	answer;
	}
	
	public static void main(String[] args) 
	{
		int[]	priorites	= {1,1,9,1,1,1};
		main	m			= new main();
		
		System.out.println(m.solution(priorites, 0));
	}
}
