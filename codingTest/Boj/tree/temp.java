import	java.io.*;
import	java.util.*;

public class	main
{
	static Node[]			node;
	static StringBuilder	sb;

	static class	Node{
		LinkedList<Integer>		parent_q, left, right;
		Node(){
			left	= new LinkedList<>();	
			right	= new LinkedList<>();	
		}
	}	
	
	static void dfs(int idx)
	{
		sb.append(idx).append(" ");
			
		if(!node[idx].left.isEmpty())
			dfs(node[idx].left.peek());
		
		if(!node[idx].right.isEmpty())
			dfs(node[idx].right.peek());
	}

	static void div(int root)
	{
		int	e;
		LinkedList<Integer>	q	= node[root].parent_q;

		while((e = q.poll()) != root){
			node[root].left.offer(e);
			node[e].parent_q	= node[root].left;	
		}
		
		while(!q.isEmpty()){
			e = q.poll();
			node[root].right.offer(e);
			node[e].parent_q	= node[root].right;	
		}
		q.offer(root);	
	}
	
	public static void main(String[] args) throws Exception
	{
		LinkedList<Integer>	in_order	= new LinkedList<>();
		Stack<Integer>		post_order	= new Stack<>();
		BufferedReader		br			= new BufferedReader(new InputStreamReader(System.in));		
		int					n			= Integer.parseInt(br.readLine());
		StringTokenizer		st1			= new StringTokenizer(br.readLine());
		StringTokenizer		st2			= new StringTokenizer(br.readLine());

		node	= new Node[n+1];
		sb		= new StringBuilder();

		for(int i=1; i<=n; ++i){
			node[i]	= new Node(); 
			in_order.offer(Integer.parseInt(st1.nextToken()));
			post_order.push(Integer.parseInt(st2.nextToken()));
		}
		
		node[post_order.peek()].parent_q	= in_order;

		while(!post_order.isEmpty())
			div(post_order.pop());	
/*
		for(int i=1; i<=n; ++i)
		{
			sb.append("idx=").append(i).append("\n");

			while(!node[i].q[0].isEmpty())
				sb.append(node[i].q[0].poll()).append(" ");
			sb.append("\n");
			
			while(!node[i].q[1].isEmpty())
				sb.append(node[i].q[1].poll()).append(" ");
			sb.append("\n");
		}
*/		

		dfs(in_order.peek());
		System.out.println(sb.toString());
	}
}
