import	java.util.Scanner;
import	java.util.StringTokenizer;
import	java.util.LinkedList;

public class	main 
{
	class	Info
	{
		int	i, j, turn;
		
		Info(int i, int j, int turn){
			this.i	= i;
			this.j	= j;
			this.turn	= turn;
		}
	}

	int bfs(int[][] map, int row, int col)
	{
		LinkedList<Info>	q	= new LinkedList<>();	
		Info	info;
		
		q.add(new Info(1,1,1));
		
		while(!q.isEmpty()){
			info	= q.poll();
			
			if(map[info.i][info.j] == 0)
				continue;	
			
			if(info.i == row && info.j == col)
				return	info.turn;

			map[info.i][info.j]	= 0;
			
			q.add(new Info(info.i-1, info.j, info.turn+1));	
			q.add(new Info(info.i+1, info.j, info.turn+1));	
			q.add(new Info(info.i, info.j-1, info.turn+1));	
			q.add(new Info(info.i, info.j+1, info.turn+1));	
		}
		return	0;
	}
				
	public static void	main(String[] args)
	{
		main	m	= new main();
		Scanner	sc	= new Scanner(System.in);
		StringTokenizer	st	= new StringTokenizer(sc.nextLine());	
		int	row	= Integer.parseInt(st.nextToken()), col	= Integer.parseInt(st.nextToken());
		int[][]	map	= new int[row+2][col+2];

		String	str;
		int	i, j;
		for(i=0; i<row; ++i){
			str	= sc.nextLine();
			for(j=0; j<col; ++j)
				map[i+1][j+1]	= str.charAt(j) - '0'; 		
		}
/*
		for(i=0; i<row+2; ++i){
			for(j=0; j<col+2; ++j)
				System.out.print(map[i][j] + " ");
			System.out.println();
		}
*/		
		System.out.println(m.bfs(map, row, col));
	}
}
