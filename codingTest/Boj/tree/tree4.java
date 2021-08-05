import	java.io.*;
import	java.util.*;

public class	main
{
	static Node[]			node;
	static StringBuilder	sb;

	static class	Node{
		String	str;
		int		left, right;
	}		

	static void dfs(int idx, int order)
	{
		if(idx < 0)
			return;

		switch(order){
			case 0: 
				sb.append(node[idx].str);
				dfs(node[idx].left, order);
				dfs(node[idx].right, order);
				break;
			case 1: 
				dfs(node[idx].left, order);
				sb.append(node[idx].str);
				dfs(node[idx].right, order);
				break;
			default:
				dfs(node[idx].left, order);
				dfs(node[idx].right, order);
				sb.append(node[idx].str);
		}
	}
	
	public static void main(String[] args) throws Exception
	{
		StreamTokenizer	st	= new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));		
		st.nextToken(); int	n	= (int)st.nval;
		node	= new Node[n];
		sb		= new StringBuilder(); 
		int	a,b,c;

		for(int i=0; i<n; ++i)
			node[i]	= new Node(); 
		
		for(int i=0; i<n; ++i){
			st.nextToken();	a	= st.sval.charAt(0) - 'A';
			node[a].str		= st.sval;								
			b	= (st.nextToken() == st.TT_WORD) ? st.sval.charAt(0) - 'A' : -1;
			c	= (st.nextToken() == st.TT_WORD) ? st.sval.charAt(0) - 'A' : -1;
			node[a].left	= b;		
			node[a].right	= c;
		}

		dfs(0, 0); sb.append("\n");
		dfs(0, 1); sb.append("\n");
		dfs(0, 2); sb.append("\n");
		System.out.print(sb.toString());
	}
}
