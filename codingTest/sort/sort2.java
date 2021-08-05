import	java.util.Arrays;
import	java.util.stream.IntStream;
import	java.util.stream.Collectors;
import	java.util.List;

public class	main
{
	public int[] solution(int[] answers)
	{
		int[]	ar1		= {1,2,3,4,5};
		int[]	ar2		= {2,1,2,3,2,4,2,5};
		int[]	ar3		= {3,3,1,1,2,2,4,4,5,5};
		
		int[]	score	= new int[3];
		int		cnt		= answers.length;
		
		for(int	i=0; i<cnt; ++i)
		{
			if(answers[i] == ar1[i%5])
				++score[0];
				
			if(answers[i] == ar2[i%8])
				++score[1];

			if(answers[i] == ar3[i%10])
				++score[2];
		}

		int	max	= Math.max(score[0], Math.max(score[1], score[2])); 
		cnt	= 0;	
		
		for(int	i=0; i<3; ++i)
			if(score[i] == max)
				answers[cnt++]	= i+1;
		
		int[]	ans	= new int[cnt];
		System.arraycopy(answers,0,ans,0,cnt);
		return	ans;
	}
	
	public static void main(String[] args) 
	{
		int[]	ar	= {1,2,3,4,5};
		main	m	= new main();
			
		System.out.println(Arrays.stream(m.solution(ar)).boxed().collect(Collectors.toList()));
	}
}
