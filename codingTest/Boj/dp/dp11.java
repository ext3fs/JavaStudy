import	java.io.InputStreamReader;
import	java.io.BufferedReader;
import	java.util.StringTokenizer;

public class	main
{	
	public static void	main(String[] args) throws Exception
	{
		BufferedReader	br	= new BufferedReader(new InputStreamReader(System.in));  
		int				n	= Integer.parseInt(br.readLine());
		int[]			max	= new int[n+1];
		StringTokenizer	st	= new StringTokenizer(br.readLine());
		int				i, j, val, cnt=1;
		
		for(i=0; i<n; ++i)
		{
			
			val	= Integer.parseInt(st.nextToken());
			j	= cnt-1;
			System.out.println("cnt="+ cnt + " val=" + val);

			if(max[j] == val)
				continue;

			if(max[j] < val){
				max[cnt++]	= val;
				System.out.println( cnt + " -> cnt ++ max = " + val);
				continue;
			}
				
			for(--j; j>=0; --j)
			{
				if(max[j] == val)
					break;
			
				if(max[j] < val){
					max[j+1]	= val;
					System.out.println( cnt + " -> max = " + val);
					break;
				}
			}			
		}	

		System.out.println(cnt-1);
	}
}
