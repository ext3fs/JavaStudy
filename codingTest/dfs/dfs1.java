import	java.util.Arrays;
import	java.util.stream.Collectors;

public class	main 
{
	int	dfs(int[] ar, int target, int size, int depth, int sum)
	{
		if(depth == size){
			if(sum == target)
				return	1;
			return	0;
		}

		return	dfs(ar,target,size,depth+1,sum+ar[depth]) + dfs(ar,target,size,depth+1,sum-ar[depth]);
	}

	public int solution(int[] numbers, int target)
	{
		return	dfs(numbers, target, numbers.length, 0, 0);
	}

	public static void main(String[] args) 
	{
		int[]	ar	= {1,1,1,1,1};
		main	m	= new main();

		System.out.println("answer = " + m.solution(ar, 3));	
	}
}
