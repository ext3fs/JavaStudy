import	java.util.LinkedList;

public class	main
{
	class	Truck
	{
		int	idx;
		int	enter_sec;

		Truck(int idx, int enter_sec)
		{
			this.idx		= idx;
			this.enter_sec	= enter_sec;
		}
		
		public String	toString()
		{
			return	"idx : " + idx + " enter_sec : " + enter_sec; 
		}
	}

	public int	solution(int bridge_length, int weight, int[] truck_weights)
	{
		int					max_idx		= truck_weights.length -1;
		LinkedList<Truck>	qu			= new LinkedList<>();			
		Truck				truck;

		int	sec			= 1;
		int	enter_idx	= 0;
		int	weight_sum	= truck_weights[0];
			
		qu.add(new Truck(enter_idx, sec));

		while(true)
		{	
			++sec;
			
			System.out.println("sec = " + sec);				
			truck	= qu.peek();

			if((truck != null) && ((truck.enter_sec + bridge_length) == sec))
			{
				if(truck.idx == max_idx)
					return	sec;
				
				System.out.println("poll " + truck);				
				qu.poll();
				weight_sum -= truck_weights[truck.idx];
				System.out.println("poll " + truck);				

			}

			if(enter_idx != max_idx)
			{
				if((weight_sum + truck_weights[enter_idx+1]) <= weight)
				{
					++enter_idx;
					weight_sum	+= truck_weights[enter_idx];
					truck	= new Truck(enter_idx, sec);
					//qu.add(new Truck(enter_idx, sec));
					System.out.println("add " + truck);				
					qu.add(truck);
					System.out.println("add " + truck);				
				}
			}
		}
	}
	
	public static void main(String[] args) 
	{
		int[]	truck	= {7,7,7,7,7};
		main	m			= new main();
		
		System.out.println(m.solution(100, 100, truck));
	}
}
