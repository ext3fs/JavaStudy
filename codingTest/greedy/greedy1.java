import	java.util.HashSet;

public class	main 
{
	class	Result{
		int	dist;
		int	idx;
	}

	void	right_dist(int idx, int[] ar, int cnt, Result res)
	{
		for(int i=idx; i<cnt; ++i){	
			if(ar[i] != 0){
				res.dist	= i -idx;
				res.idx		= i;
				return;
			}	
		}

		for(int i=0; i<idx; ++i){	
			if(ar[i] != 0){
				res.dist	= cnt -idx +i;
				res.idx		= i;
				return;
			}
		}

		res.dist	= 0;
		return;	
	}

	void	left_dist(int idx, int[] ar, int cnt, Result res)
	{
		for(int i=idx; i>=0; --i){	
			if(ar[i] != 0){
				res.dist	= idx -i;
				res.idx		= i;
				return;
			}
		}

		for(int i=cnt-1; i>idx; --i){	
			if(ar[i] != 0){
				res.dist	= idx + cnt -i;
				res.idx		= i;
				return;
			}
		}

		res.dist	= 0;
		return;	
	}


	public int solution(String name)
	{
		char[]	ch		= name.toCharArray();
		int		cnt		= ch.length;
		int[]	ar		= new int[cnt];		
		char	mid		= ('Z'-'A')/2 + 'A';

		for(int	i=0; i<cnt; ++i){
			if(ch[i] > mid)
				ar[i]	= 'Z' - ch[i] +1;
			else
				ar[i]	= ch[i] - 'A' ;
		}
		
		int	curr_idx	= 0;
		int	answer		= ar[0];	
		ar[curr_idx]	= 0;
		Result	right	= new Result();
		Result	left	= new Result();

		while(true){
			right_dist(curr_idx, ar, cnt, right);	
			left_dist(curr_idx, ar, cnt, left);	

			if(right.dist == 0)
				return	answer;

			if(right.dist > left.dist){
				curr_idx	= left.idx;
				answer	+= ar[curr_idx] + left.dist;
			}	
			else{
				curr_idx	= right.idx;
				answer		+= ar[curr_idx] + right.dist;
			}
			ar[curr_idx]	= 0;
		}
	}

	public static void main(String[] args) 
	{
		String	ar	= "ABABAAAAAAABA";
		main	m	= new main();

		System.out.println("answer = " + m.solution(ar));	
	}
}
