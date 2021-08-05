import	java.util.Arrays;
import	java.util.HashSet;
import	java.util.LinkedList;

public class	main
{
	LinkedList<Character>	q;
	HashSet<Integer>		hs;
	char[]					tmp_ar;

	boolean	isPrime(int val){
		if(val == 1)
			return	false;
	
		if(val == 2 || val == 3)	
			return	true;
		
		val	%= 6;
		
		if(val == 1 || val == 5)
			return	true;

		return	false;
	}

	int	process(int size, int depth, int cnt){
		int	val, ret = 0;
	
		for(int	i = size -depth -1; i<cnt; ++i){
			tmp_ar[depth]	= q.poll();

			if(depth == 0){
				val	= Integer.parseInt(String.valueOf(tmp_ar,0,size));
				
				if( hs.add(val) && isPrime(val) )
					ret	 += 1;

				System.out.println(val);
			} 
			else
				ret	+= process(size, depth-1, cnt);
				
			q.add(tmp_ar[depth]);
		}		

		return	ret;
	}
			

	public int solution(String numbers){
		char[]	ar	= numbers.toCharArray();
		int		cnt	= ar.length;
		int						answer	= 0;
		
		tmp_ar	= new char[cnt];
		hs		= new HashSet<>();	
		q		= new LinkedList<>(); 

		for(char c : ar)
			q.add(c);

		for(int size=1; size<=cnt; ++size)
			answer	+= process(size, size -1, cnt);		
		
		return	answer;
	}
	
	public static void main(String[] args) 
	{
		String	ar	= "1234";
		main	m	= new main();
			
		System.out.println(m.solution(ar));
	}
}
