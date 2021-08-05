import	java.util.stream.IntStream;
import	java.util.Arrays;
import	java.util.ArrayList;

public class	main 
{
	class	Q_a {
		int[]	question;
		int		strike, ball;	
		Q_a(int val, int s, int b){
			question	= String.valueOf(val).chars().map(i->i-'0').toArray(); 
			strike		= s;
			ball		= b;
		}	

		public	String toString(){
			return	"question : " +question[0]+question[1]+question[2]+ " s = " + strike + " b = "+ ball+"\n";
		}
	}

	boolean	isMatch(int[] value, int[] question, int strike, int ball){
		int	s=0, b=0;
		for(int i=0; i<3; ++i){
			for(int j=0; j<3; ++j){
				if(value[i] == question[j]){
					if(i == j)
						 ++s;
					else
						 ++b;
				}
			}
		}
		return (s == strike && b == ball)? true : false;
	}

	void	swap(int[] ar, int i, int j){
		int	temp	= ar[i];
		ar[i]	= ar[j];
		ar[j]	= temp;
	}

	int	permutation(int[] ar, int cnt, int size, int depth, ArrayList<Q_a> list){
		int	ret	= 0;
		if(depth == size){
			for(Q_a q_a : list)
				if(!isMatch(ar, q_a.question, q_a.strike, q_a.ball))
					return	0;	
			return	1;
		}
		for(int i=depth; i<cnt; ++i){
			swap(ar, depth, i);
			ret	+= permutation(ar, cnt, size, depth+1, list);
			swap(ar, depth, i);	
		}		
		return	ret;
	}	

	public int	solution(int[][] baseball){
		int				cnt		= baseball.length;
		int				answer	= 0;
		int[]			numbers	= IntStream.rangeClosed(1,9).toArray();				
		ArrayList<Q_a>	list	= new ArrayList<>();
		for(int i=0; i<cnt; ++i)
			list.add(new Q_a(baseball[i][0], baseball[i][1], baseball[i][2]));
		System.out.println(list);

		answer	= permutation(numbers, numbers.length, 3, 0, list);	
		return	answer;
	}

	public static void main(String[] args) 
	{
		int[][]	ar	= {{123,1,1},{356,1,0},{327,2,0},{489,0,1}};
		main	m	= new main();

		System.out.println("answer = " + m.solution(ar));	
	}
}
