import	java.util.Stack;

public class	main
{
	public class	Tower
	{
		int	idx;
		int	height;

		Tower(int idx, int height)
		{
			this.idx	= idx;
			this.height	= height;
		}	
	}	

	public int[] solution(int[] heights)
	{
		int				cnt		= heights.length;
		int[]			answer	= new int[cnt];			
		Stack<Tower>	stack	= new Stack<>();
		Tower			tower;

		for(int i=0; i<cnt; ++i)
		{
			while(!stack.empty())
			{
				tower	= stack.peek();

				if(tower.height > heights[i])
				{
					answer[i]	= tower.idx;
					break;
				}

				stack.pop();	
			}

			stack.push(new Tower(i+1, heights[i]));
		}
			
		return	answer;
	}
	
	public static void main(String[] args) 
	{
		int[]	heights	= {1,5,3,6,7,6,5};
		int[]	answer;
		main	m		= new main();
		
		answer	= m.solution(heights);		

		for(int elem : answer)
			System.out.print(elem + " ");
		System.out.println();
	}
}
