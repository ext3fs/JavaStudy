import	java.io.BufferedReader;
import	java.io.InputStreamReader;
import	java.io.StreamTokenizer;
import	java.util.ArrayList;

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
		int	a,b,c;

		for(int i=1; i<=n; ++i)
			node[i]	= new ArrayList<>();

		for(int i=1; i<n; ++i){
			st.nextToken();	a	= (int)st.nval;
			st.nextToken();	b	= (int)st.nval;
			st.nextToken();	c	= (int)st.nval;
			node[a].add(new Edge(b,c));
			node[b].add(new Edge(a,c));
		}
			
		dfs(1, 0, 0);
		dfs(leaf, 0, 0);
		System.out.println(max);
	}
}
