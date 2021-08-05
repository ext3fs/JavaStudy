import	java.util.Scanner;
import	java.util.StringTokenizer;
import	java.util.LinkedList;
import	java.util.Arrays;

public class	main 
{
	static	class	Info
	{
		int	i,j,turn;
		
		Info(int a, int b, int c){
			i		= a; 
			j		= b; 
			turn	= c;	
		}
	}
				
	public static void	main(String[] args)
	{
		Scanner				sc	= new Scanner(System.in);
		StringTokenizer		st	= new StringTokenizer(sc.nextLine());
		int					col	= Integer.parseInt(st.nextToken());	
		int					row	= Integer.parseInt(st.nextToken());	
		int[][]				map	= new int[row+2][col+2];	
		LinkedList<Info>	q	= new LinkedList<>();	
		
		int	i, j, val, cnt0 = 0;
		String	str;
		for(i=0; i<row; ++i){
			st	= new StringTokenizer(sc.nextLine());
			
			for(j=0; j<col; ++j){
				val				= Integer.parseInt(st.nextToken());
				map[i+1][j+1]	= val;				
			
				if(val > 0)
					q.add(new Info(i+1, j+1, 0));	
				else if(val == 0)
					++cnt0;
			}	
		}
		
		Arrays.fill(map[0], -1);
		Arrays.fill(map[row+1], -1);

		for(i=0; i<row+2; ++i){
			map[i][0]		=	-1;
			map[i][col+1]	=	-1;
		} 

		Info	info;	
		while(!q.isEmpty())
		{
			info	= q.poll();
			
			if(map[info.i][info.j] < 0)
				continue;

			if(map[info.i][info.j] == 0)
				--cnt0;

			if(cnt0 == 0){
				System.out.println(info.turn);
				return;
			}

			map[info.i][info.j]	= -1;	

			q.add(new Info(info.i-1, info.j, info.turn+1));				
			q.add(new Info(info.i+1, info.j, info.turn+1));				
			q.add(new Info(info.i, info.j-1, info.turn+1));				
			q.add(new Info(info.i, info.j+1, info.turn+1));				
		}
		
/*
		for(i=0; i<row+2; ++i){
			for(j=0; j<col+2; ++j)
				System.out.print(map[i][j] + " ");
			System.out.println();
		}
*/
		System.out.println(-1);
	}
}
