import	java.io.*;
import	java.util.*;

public class	main
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader		br	= new BufferedReader(new InputStreamReader(System.in));		
		int					cnt	= Integer.parseInt(br.readLine());
		StringTokenizer		st	= new StringTokenizer(br.readLine());
		HashSet<String>		set	= new HashSet<>();
		StringBuilder		sb	= new StringBuilder();
		
		for(int i=0; i<cnt; ++i)
			set.add(st.nextToken());
		
		cnt	= Integer.parseInt(br.readLine());
		st	= new StringTokenizer(br.readLine());
		
		for(int i=0; i<cnt; ++i)
			sb.append(set.contains(st.nextToken())? 1:0).append("\n");
		
		System.out.print(sb.toString());
	}
}
