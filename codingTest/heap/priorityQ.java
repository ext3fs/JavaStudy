import	java.util.PriorityQueue;

public class	main
{
	public int solution(int[] scoville, int k){
		int	answer	= 0;
		PriorityQueue<Integer> sort_q	= new PriorityQueue<>();
		PriorityQueue<Integer> pq		= new PriorityQueue<>();
	
		for(int i : scoville)
			sort_q.add(i);
	
		pq.add(sort_q.poll());	
	
		if(sort_q.size() > 1)
			pq.add(sort_q.poll());
	
		while(!sort_q.isEmpty())
		{
			pq.add(sort_q.poll());
		
			if(pq.peek() >= k)
				break;
		
			pq.add(pq.poll() + pq.poll()*2);
			++answer;
		}
	
		while(pq.size() > 1)
		{
			if(pq.peek() >= k)
				break;
			pq.add(pq.poll() + pq.poll()*2);
			++answer;		
		}
		return	(pq.peek() < k)? -1 : answer;		
	}
	
	public static void main(String[] args) 
	{
		int[]	ar	= {1,2,3,9,10,12};
		main	m	= new main();
		
		System.out.println(m.solution(ar, 7));
	}
}
