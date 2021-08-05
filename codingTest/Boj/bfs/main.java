import	java.util.LinkedList;
import	java.util.Scanner;

public class main
{
	static class	Info{
		int	i,j,broken,turn;
		Info(int a, int b, int c, int d){
			i = a; j = b; broken = c; turn = d;
		}
	}
	
	static boolean[][]		map;
	static boolean[][][]	visit;
	static LinkedList<Info>	q;
	static int				row,col;

	static void	q_in(int i, int j, int broken, int turn)
	{
		if(i<0 || i>=row || j<0 || j>=col)
			return;

		if(map[i][j]){	
			if(broken == 1)
				return;
			broken	= 1;
		}

		if(visit[broken][i][j])
			return;

		q.offer(new Info(i,j,broken,turn));
		visit[broken][i][j]	= true; 

		if(broken == 0)
			visit[1][i][j]	= true; 
	}

	public static void main(String[] args)
	{
		Scanner		sc = new Scanner(System.in);
		String[]	st = sc.nextLine().split(" ");
		String 		str;
		Info 		info;
		
		row		= Integer.parseInt(st[0]);	
		col		= Integer.parseInt(st[1]);	
		map		= new boolean[row][col];
		visit	= new boolean[2][row][col];
		q		= new LinkedList<>();
		
		for(int i=0; i<row; ++i){
			str	= sc.nextLine();
			for(int j=0; j<col; ++j)
				if(str.charAt(j) == '1')
					map[i][j]	= true;
		}
	
		q.offer(new Info(0,0,0,1));
		visit[0][0][0]	= visit[1][0][0] = true;			

		while(!q.isEmpty()){
			info	= q.poll();

			if(info.i==row-1 && info.j==col-1){
				System.out.println(info.turn);
				return;
			}

			q_in(info.i-1, info.j, info.broken, info.turn+1);
			q_in(info.i+1, info.j, info.broken, info.turn+1);
			q_in(info.i, info.j-1, info.broken, info.turn+1);
			q_in(info.i, info.j+1, info.broken, info.turn+1);
		}

		System.out.println("-1");
	}
}
