import	java.io.*;
import	java.util.*;

public class	main
{
	static ArrayList<Edge>[]	node;
	static int					max, leaf;	

	static class	Edge{
		int	idx, weight;
		Edge(int a, int b){
			idx		= a;
			weight	= b;
		}
	}		

	static void dfs(int idx, int prev, int diam)
	{
		max	= Math.max(max, diam);
		if(max == diam)
			leaf	= idx;

		for(Edge edge : node[idx]){
			if(edge.idx != prev)
				dfs(edge.idx, idx, edge.weight+diam);
		}
	}
	
	public static void main(String[] args) throws Exception
	{
		StreamTokenizer	st	= new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));		
		st.nextToken(); int	n	= (int)st.nval;
		node	= new ArrayList[n+1]; 
		int	idx, a, b;

		for(int i=0; i<n; ++i){
			st.nextToken(); idx	= (int)st.nval;
			node[idx]	= new ArrayList<>();
		
			while(true){	
				st.nextToken();	a	= (int)st.nval;
				if(a < 0)
					break;
				st.nextToken();	b	= (int)st.nval;
				node[idx].add(new Edge(a, b));
			}
		}
			
		dfs(1, 0, 0);
		dfs(leaf, 0, 0);
		System.out.println(max);
	}
}
