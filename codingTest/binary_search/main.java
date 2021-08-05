import	java.util.Queue;
import	java.util.LinkedList;

public class	main 
{
	public int solution(int[] budgets, int M){
		Queue<Integer>	q	= new LinkedList<>();
		int	ans	= M/budgets.length;
		int	val, cnt, aver, max=0;

		for(int i : budgets){
			if(i > max)
				max	= i;

			if(i > ans){
				q.offer(i - ans);
				M	-= ans; 
			}
			else
				M	-= i;	
		}	

			
		System.out.println("size="+q.size()+" ans = "+ans);
		
		while((cnt = q.size()) > 0 && (aver = M/cnt) > 0){
			while(cnt-- > 0){
				if((val	= q.poll()) > aver){
					q.offer(val);
					M	-= aver;	
				}
				else
					M	-= val;
			}
			ans	+= aver;
			
		System.out.println("size="+q.size()+" ans = "+ans);
		}	
		return	ans > max ? max : ans;	
	}

	public static void main(String[] args) 
	{
		int[]	ar	= {1,2,3};
		main	m	= new main();

		System.out.println("answer = " + m.solution(ar, 4));	
	}
}
