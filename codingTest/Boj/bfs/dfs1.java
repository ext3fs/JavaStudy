import	java.util.Scanner;
import	java.util.LinkedList;

public class	main 
{
	static void	dfs(int[][] ar, int cnt, int idx, int[] search)
	{
		System.out.print(idx + " ");
		search[idx]	= 1; 

		for(int j=1; j<=cnt; ++j){	
			if(serarch[idx] == 0 && ar[idx][j] == 1)
				dfs(ar, cnt, j, search);
		}
	}

	static void	bfs(int[][] ar, int cnt, int idx, int[] search)
	{
		LinkedList<Integer>	q		= new LinkedList<>();

		System.out.print(idx + " ");
		search[idx]	= 1;
		q.offer(idx);
	
		while(!q.isEmpty()){
			idx	= q.poll();
			for(int j=1; j<=cnt; ++j){
				if(search[j] == 0 && ar[idx][j] == 1){
					System.out.print(j + " ");
					search[j]	= 1;
					q.offer(j);
				}
			}
		}
	}	

	public static void	main(String[] args) 
	{
		int	cnt, line, start;

		Scanner	sc	= new Scanner(System.in);

		cnt		= sc.nextInt();					
		line	= sc.nextInt();					
		start	= sc.nextInt();				
		
		int[][]	ar	= new int[cnt+1][cnt+1];  
		int	a, b;	
	
		for(int i=0; i<line; ++i){
			a	= sc.nextInt();
			b	= sc.nextInt();
			ar[a][b]	= 1;
			ar[b][a]	= 1;
		}
/*		
		for(int i=1; i<=cnt; ++i){
			for(int j=1; j<=cnt; ++j)
				System.out.print(ar[i][j] + " ");
			System.out.println();
		}
*/
		dfs(ar, cnt, start, new int[cnt+1]);
		System.out.println();
		bfs(ar, cnt, start, new int[cnt+1]);
		System.out.println();
	}
}
