import	java.io.InputStreamReader;
import	java.io.BufferedReader;
import	java.util.StringTokenizer;

public class	main
{	
	public static void	main(String[] args) throws Exception
	{
		BufferedReader	br	= new BufferedReader(new InputStreamReader(System.in));  
		int				n	= Integer.parseInt(br.readLine());
		int[]			inc	= new int[n+1];
		int[]			dec	= new int[n];
		int[]			com	= new int[n];
		StringTokenizer	st	= new StringTokenizer(br.readLine());
		int				i, j, val, cnt1=1, cnt2=1, cnt3=1;
			
		inc[0] = dec[0] = com[0] = Integer.parseInt(st.nextToken());
		inc[1]	= 1001;

		for(i=1; i<n; ++i)
		{
			val = Integer.parseInt(st.nextToken());
			inc[i+1]	= 1001;
			
			for(j=cnt1-1; j<n; ++j){
				if(val >= com[j]){
					com[j]	= val;
					cnt3	= Math.max(cnt3, j+1);
				//	System.out.println(" j= "+j+" val= "+val+" cnt3= "+cnt3); 
					break; 
				}
			}	

			for(j=0; j<n; ++j){
				if(val <= inc[j]){
					inc[j]	= val;
					cnt1	= Math.max(cnt1, j+1);
				//	System.out.println(" j= "+j+" val= "+val+" cnt1= "+cnt1); 
					com[j]	= val;
					cnt3	= Math.max(cnt3, j+1); 
					break; 
				}
			}	

			for(j=0; j<n; ++j){
				if(val >= dec[j]){
					dec[j]	= val;
					cnt2	= Math.max(cnt2, j+1); 
					break;
				}
			}

			System.out.print("inc = ");	
			for(j=0; j<cnt1; ++j)
				System.out.print(inc[j]+" ");
			System.out.println();	
			
		/*	System.out.print("dec = ");	
			for(j=0; j<cnt2; ++j)
				System.out.print(dec[j]+" ");
			System.out.println();	
			*/
			System.out.print("com = ");	
			for(j=0; j<cnt3; ++j)
				System.out.print(com[j]+" ");
			System.out.println();	
		}		

		System.out.println();	
		System.out.println(cnt1 + "," + cnt2 + "," + cnt3);
	}
}
