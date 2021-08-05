import	java.util.Arrays;
import	java.util.stream.Collectors;
import	java.util.Comparator;

public class	main
{
	class	MySort	implements	Comparator<String>
	{
		@Override
		public	int	compare(String a, String b)
		{
			if(a.charAt(0) == b.charAt(0))
			//	return	(Integer.parseInt(a.concat(b)) < Integer.parseInt(b.concat(a)))? 1:-1;		
				return	Integer.parseInt(b.concat(a)) - Integer.parseInt(a.concat(b));		

			return	(a.charAt(0) < b.charAt(0))? 1:-1;
		}
	}

	public String solution(int[] numbers)
	{
		String	answer	= Arrays.stream(numbers)
			.mapToObj(i -> String.valueOf(i)).sorted(new MySort()).collect(Collectors.joining(" "));	

		int	cnt	= 0;

		for(int	i=0; i<answer.length()-1; ++i)
		{
			if(answer.charAt(i) != '0')
				break;
			++cnt;			
		}		

		return	answer.substring(cnt);
	}
	
	public static void main(String[] args) 
	{
		int[]	ar	= {333,33,3,22,332,33335,334};
		main	m	= new main();

		System.out.println(m.solution(ar));
	}
}
