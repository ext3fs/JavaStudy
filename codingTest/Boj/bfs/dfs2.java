import	java.util.Scanner;
import	java.util.HashSet;
import	java.util.ArrayList;
import	java.util.LinkedList;

public class	main 
{
	static ArrayList<HashSet<Integer>>	map	= new ArrayList<>();
	static boolean[]	visit;
	
	static int bfs(int idx)
	{
		LinkedList<Integer>	q	= new LinkedList<>();
		int	cnt	= 0;

		visit[idx]	= true;
		q.offer(idx);
		
		while(!q.isEmpty())
		{
			for(int i : map.get(q.poll()))
			{
				if(!visit[i]){
					visit[i]	= true;
					++cnt;
					q.offer(i);
				}
			}	
		}
		
		return	cnt;
	}
				
	public static void	main(String[] args) 
	{
		Scanner	sc		= new Scanner(System.in);
		int		cnt		= sc.nextInt();	
		int		line	= sc.nextInt();
		
		for(int i=0; i<=cnt; ++i)
			map.add(new HashSet<>());
		visit	= new boolean[cnt+1];

		int		x, y;
		for(int i=0; i<line; ++i){
			x	= sc.nextInt();	
			y	= sc.nextInt();	
			map.get(x).add(y);	
			map.get(y).add(x);	
		}

		int	idx = 0;
		for(HashSet<Integer> set : map)
			System.out.println(idx++ + "->" + set);
		
		System.out.println(bfs(1));	
	}
}
