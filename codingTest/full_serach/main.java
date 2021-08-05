import	java.util.stream.IntStream;
import	java.util.stream.Collectors;
import	java.util.Arrays;
import	java.util.HashSet;

public class	main 
{
	public int[] solution(int brown, int red){
		int[]	answer	= {0,0};
		int		i=0, j, a, b, res;
		HashSet<String>	set	= new HashSet<>();
	
		while(true){
			j=0;
			++i;
			while(i >= ++j){
				if(i*j == red){
					while(true){
						a	= i + 2;
						b	= j + 2;
						res	= a*b - red;
						if(!set.add(String.valueOf(a).concat(String.valueOf(b))) 
							|| (res = a*b - red) > brown)
							break;
						if(res == brown){
							answer[0]	= a;
							answer[1]	= b;
							return answer;
						}	
					}
				}
			}
		}
	}

	public static void main(String[] args) 
	{
		main	m	= new main();

		System.out.println("answer = " + Arrays.stream(m.solution(5000,4)).boxed()
												.collect(Collectors.toList()));	
	}
}
