import	java.util.Scanner;
import	java.util.LinkedList;
import	java.util.HashSet;

public class	main 
{
	static class	Info
	{
		int	x,turn;
		
		Info(int a, int b){
			x		= a; 
			turn	= b;	
		}
	}
				
	public static void	main(String[] args) throws Exception
	{
		Scanner				sc	= new Scanner(System.in);
		int					x	= sc.nextInt();	
		int					end	= sc.nextInt();	
		LinkedList<Info>	q	= new LinkedList<>();
		HashSet<Integer>	set	= new HashSet<>();
		Info				info;	
		
		q.add(new Info(x, 0));
		
		while(!q.isEmpty()){
			info	= q.poll();
			
			if(info.x == end){
				System.out.println(info.turn);
				return;
			}
			
			if(!set.add(info.x))
				continue;
	
			if(info.x < end)	
				q.add(new Info(info.x*2, info.turn+1));
			q.add(new Info(info.x+1, info.turn+1));
			q.add(new Info(info.x-1, info.turn+1));
		}
	}
}
