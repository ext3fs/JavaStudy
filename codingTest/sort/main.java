import	java.util.Arrays;
import	java.util.HashSet;
import	java.util.stream.Collectors;

public class	main
{
	public int solution(String numbers)
	{
		char[]				ar		= numbers.toCharArray();
		int					cnt		= ar.length;
		char[]				tmp_ar	= new char[cnt];
		HashSet<Integer>	hs		= new HashSet<>();	
		int					idx;

		for(char c : ar)
			System.out.print(c);
		System.out.println();

		for(int size=1; size<=cnt; ++size)
		{
			idx		= 0;
			
			for(int i=0; i<cnt; ++i)
			{
				tmp_ar[idx++]	= ar[i];
					
				if(idx == size)
				{
					hs.add(Integer.parseInt(String.valueOf(tmp_ar,0,size)));
					System.out.println(String.valueOf(tmp_ar)); 
					break;
				}
			}
		}
		

		int	answer	= 0;
		return	answer;
	}
	
	public static void main(String[] args) 
	{
		String	ar	= "173";
		main	m	= new main();
			
		System.out.println(m.solution(ar));
	}
}
