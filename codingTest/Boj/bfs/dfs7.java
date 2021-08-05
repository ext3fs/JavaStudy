import	java.io.*;
import	java.util.*;

public class	main 
{
	static class	Info
	{
		int	k,i,j,turn;
		
		Info(int a, int b, int c, int d){
			k		= a; 
			i		= b; 
			j		= c; 
			turn	= d;	
		}
	}
				
	public static void	main(String[] args) throws IOException
	{
		BufferedReader		br	= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer		st	= new StringTokenizer(br.readLine());
		int					col	= Integer.parseInt(st.nextToken());	
		int					row	= Integer.parseInt(st.nextToken());	
		int					hgt	= Integer.parseInt(st.nextToken());	
		int[][][]			map	= new int[hgt+2][row+2][col+2];	
		LinkedList<Info>	q	= new LinkedList<>();	
		
		int	k,i,j,val,cnt0=0;
		String	str;

		for(k=0; k<hgt; ++k){
			for(i=0; i<row; ++i){
				st	= new StringTokenizer(br.readLine());
				
				for(j=0; j<col; ++j){
					val	= Integer.parseInt(st.nextToken());
					map[k+1][i+1][j+1]	= val+1;				
					
					if(val > 0)
						q.add(new Info(k+1, i+1, j+1, 0));	
					else if(val == 0)
						++cnt0;
				}	
			}
		}

		Info	info;	

		while(!q.isEmpty()){
			info	= q.poll();
			
			if(map[info.k][info.i][info.j] == 0)
				continue;

			if(map[info.k][info.i][info.j] == 1)
				--cnt0;

			if(cnt0 == 0){
				System.out.println(info.turn);
				return;
			}

			map[info.k][info.i][info.j]	= 0;	

			q.add(new Info(info.k, info.i-1, info.j, info.turn+1));				
			q.add(new Info(info.k, info.i+1, info.j, info.turn+1));				
			q.add(new Info(info.k, info.i, info.j-1, info.turn+1));				
			q.add(new Info(info.k, info.i, info.j+1, info.turn+1));				
			q.add(new Info(info.k-1, info.i, info.j, info.turn+1));				
			q.add(new Info(info.k+1, info.i, info.j, info.turn+1));					
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
