import	java.io.IOException;
import	java.io.BufferedReader;
import	java.io.InputStreamReader;
import	java.util.StringTokenizer;
import	java.util.ArrayList;

public class	main 
{
	static	boolean[][]	map;

	static void dfs(int i, int j)
	{
		map[i][j]	= false;	
		
		if(map[i][j-1])
			dfs(i,j-1);

		if(map[i][j+1])
			dfs(i,j+1);

		if(map[i-1][j])
			dfs(i-1,j);

		if(map[i+1][j])
			dfs(i+1,j);
	}
				
	public static void	main(String[] args) throws IOException 
	{
		BufferedReader	br	= new BufferedReader(new InputStreamReader(System.in));
		StringBuilder	sb	= new StringBuilder();
		StringTokenizer	st;
		int	n	= Integer.parseInt(br.readLine());
		int	row, col, line, i, j, ret;
					
		while(n-- > 0){
			st		= new StringTokenizer(br.readLine());
			row		= Integer.parseInt(st.nextToken());
			col		= Integer.parseInt(st.nextToken());
			line	= Integer.parseInt(st.nextToken());
			map		= new boolean[row+2][col+2];	

			for(i=0; i<line; ++i){
				st	= new StringTokenizer(br.readLine());
				map[Integer.parseInt(st.nextToken())+1][Integer.parseInt(st.nextToken())+1]	= true;
			}	
	
	/*		for(i=0; i<row+2; ++i){
				for(j=0; j<col+2; ++j)
					System.out.print(map[i][j] + " ");
				System.out.println();
			}*/
	
			ret	= 0;	
			for(i=1; i<=row; ++i){
				for(j=1; j<=col; ++j){
					if(map[i][j]){
						dfs(i,j);
						++ret;
					}
				}
			}

			sb.append(ret).append("\n");
		}

		System.out.print(sb.toString());
	}
}
