import	java.io.*;
import	java.util.*;

public class	main
{
	static Node[]			node;
	static int[]			inOrder, postOrder;
	static StringBuilder	sb;

	static class	Ar{
		int	start, end, ret;
		
		Ar(int x, int y){
			start	= x;
			end		= y;
		}
	}

	static class	Node{
		int	inOrderIdx;
		Ar	fullAr, leftAr, rightAr;
	}	
	
	static void dfs(int idx)
	{
		sb.append(idx).append(" ");
			
		if(node[idx].leftAr.ret != 0)
			dfs(node[idx].leftAr.ret);
		
		if(node[idx].rightAr.ret != 0)
			dfs(node[idx].rightAr.ret);
	}
	
	static void div(int root)
	{
		Ar	ar			= node[root].fullAr;
		int	root_idx	= node[root].inOrderIdx;
		
		ar.ret				= root;
		node[root].leftAr	= new Ar(ar.start, root_idx-1);
		node[root].rightAr	= new Ar(root_idx+1, ar.end);

		for(int i=ar.start; i<root_idx; ++i)
			node[inOrder[i]].fullAr	= node[root].leftAr;
		
		for(int i=root_idx+1; i<=ar.end; ++i)
			node[inOrder[i]].fullAr	= node[root].rightAr;
	}

	public static void main(String[] args) throws Exception
	{
		BufferedReader		br			= new BufferedReader(new InputStreamReader(System.in));		
		int					n			= Integer.parseInt(br.readLine());
		StringTokenizer		st1			= new StringTokenizer(br.readLine());
		StringTokenizer		st2			= new StringTokenizer(br.readLine());

		node		= new Node[n+1];
		inOrder		= new int[n+1];
		postOrder	= new int[n+1];
		sb			= new StringBuilder();
		
		for(int i=1; i<=n; ++i){
			node[i]			= new Node(); 
			inOrder[i]		= Integer.parseInt(st1.nextToken());
			postOrder[i]	= Integer.parseInt(st2.nextToken());
		}
			
		for(int i=1; i<=n; ++i)
			node[inOrder[i]].inOrderIdx = i;

		node[postOrder[n]].fullAr	= new Ar(1,n);

		for(int i=n; i>0; --i)
			div(postOrder[i]);

		dfs(postOrder[n]);
		System.out.println(sb.toString());
	}
}
