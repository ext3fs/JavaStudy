
public class	main 
{
	void	show(int[] ar, int k)
	{
		for(int i=0; i<k; i++)
			System.out.print(ar[i] + " ");
		System.out.println();
	}

	void	swap(int[] ar, int i, int j)
	{
		int temp = ar[i];
	
		ar[i]	= ar[j];
		ar[j]	= temp;

	}	

	int	permutation(int[] ar, int depth, int cnt, int size)
	{
		int	ret	= 0;

		if(depth == size){
			show(ar, size);
			return 1;
		}

		for(int i=depth; i<cnt; ++i){
			swap(ar, depth, i);
			System.out.println("swap1 : " + depth + " "+ i);	
			
			ret += permutation(ar, depth+1, cnt, size);
			
			swap(ar, depth, i);
			System.out.println("swap2 : " + depth + " "+ i);	
		}

		return	ret;
	}	

	public static void main(String[] args) 
	{
		int[]	ar	= {1,2,3};
		main	m	= new main();

		System.out.println("cnt = " + m.permutation(ar,0,3,3));	
	}
}
