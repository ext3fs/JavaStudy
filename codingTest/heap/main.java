import	java.util.TreeSet;

public class	main
{
	public int[] solution(String[] operations)
	{
		int[]	answer			= new int[2];
		TreeSet<Integer>	ts	= new TreeSet<>((a, b) -> (a >= b)? 1:-1);
		int		value;		

		for(String str : operations)
		{
			value	= Integer.parseInt(str.substring(2));
			
			switch(str.charAt(0))
			{
				case 'I':
					ts.add(value);
					break;	
				case 'D':
					if(value > 0)
						ts.pollLast();
					else
						ts.pollFirst();
			}			
		}
		
		answer[0] = (ts.isEmpty())? 0 : ts.pollLast();  
		answer[1] = (ts.isEmpty())? 0 : ts.pollFirst();  
		return	answer;
	}
	
	public static void main(String[] args) 
	{
		String[]	ar	= {"I 16","D 1"};
		main	m	= new main();
		
		for(int i : m.solution(ar))
			System.out.println(i);
	}
}
