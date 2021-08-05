import	java.util.PriorityQueue;

public class	main
{
	class	Delivery
	{
		int	date;
		int	supply;
		
		Delivery(int date, int supply)
		{
			this.date	= date;
			this.supply	= supply;
		}

		@Override
		public	String	toString()
		{
			return	" date : " + date + " supply : " + supply;
		}
	}

	public int solution(int stock, int[] dates, int[] supplies, int k)
	{
		int	answer	= 0;
		PriorityQueue<Delivery>	pq	
			= new PriorityQueue<>(cnt, (Delivery a, Delivery b) -> (a.date >= b.date)? 1:-1);
		int	need	= k -stock -1;
		
		for(int i=0; i<dates.length; ++i)
			pq.add(new Delivery(dates[i], supplies[i]));

		for(int	i=0; i<k; ++i)
		{
			Delivery	delivery	= pq.pop();	

			if( stock < pq.peek().date )
		}


	//	for(int i=0; i<cnt; ++i)
	//		System.out.println(pq.poll());	
	
		return	answer;		
	}
	
	public static void main(String[] args) 
	{
		int[]	ar1	= {4,10,15};
		int[]	ar2	= {20,5,10};
		main	m	= new main();
		
		System.out.println(m.solution(4,ar1,ar2,30));
	}
}
