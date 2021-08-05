import	java.util.TreeSet;

public class	main
{
	class	Data
	{
		int		val;

		Data(int val)
		{
			this.val	= val;
		}
	}

	public int[] solution(String[] operations)
	{
		int[]	answer		= new int[2];
		TreeSet<Data>	ts	= new TreeSet<Data>((Data a, Data b) -> (a.val >= b.val)? 1:-1);
		int		value;		

		for(String str : operations)
		{
			value	= Integer.parseInt(str.substring(1));
			
			switch(str.charAt(0))
			{
				case 'I':
					ts.add(new Data(value));
					break;	
				case 'D':
					if(value > 0)
						ts.pollLast();
					else
						ts.pollFirst();
			}			
		}
		
		answer[0] = (ts.isEmpty())? 0 : ts.pollLast().val;  
		answer[1] = (ts.isEmpty())? 0 : ts.pollFirst().val;  
		return	answer;
	}
	
	public static void main(String[] args) 
	{
		String[]	ar	= {"I16","D1"};
		main	m	= new main();
		
		for(int i : m.solution(ar))
			System.out.println(i);
	}
}
