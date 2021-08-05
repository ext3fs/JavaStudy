import	java.util.PriorityQueue;

public class	main
{
	class	Job
	{
		int		req_sec;
		int		run_sec;
		int		finish_sec;

		Job(int req_sec, int run_sec)
		{
			this.req_sec	= req_sec;
			this.run_sec	= run_sec;
		}
	}

	public int solution(int[][] jobs)
	{
		int	answer	= 0;
		int	cnt		= jobs.length;
		PriorityQueue<Job>	req_q	
				= new PriorityQueue<>(cnt, (Job a, Job b) -> (a.req_sec >= b.req_sec)? 1:-1);
		PriorityQueue<Job>	wait_q	
				= new PriorityQueue<>(cnt, (Job a, Job b) -> (a.run_sec >= b.run_sec)? 1:-1);
		int		sec				= -1;
		Job		running_job 	= null;
		Job		req_job			= null;

		for(int i=0; i<cnt; ++i)
			req_q.add(new Job(jobs[i][0], jobs[i][1]));

		req_q.pollFirst();
		while(true)
		{
			++sec;

			while( (req_job = req_q.peek()) != null && req_job.req_sec == sec)
				wait_q.add(req_q.poll());
	
			if(running_job != null && running_job.finish_sec == sec)
			{
				answer	+= running_job.finish_sec - running_job.req_sec;
				if(req_q.isEmpty() && wait_q.isEmpty())
					return	answer/cnt;
				running_job = null; 		
			}
			
			if(running_job == null && !wait_q.isEmpty())
			{
				running_job	= wait_q.poll();
				running_job.finish_sec	= running_job.run_sec + sec;
			}
		}
	}
	
	public static void main(String[] args) 
	{
		int[][]	ar	= {{0,3},{1,9},{2,6}};
		main	m	= new main();
		
		System.out.println(m.solution(ar));
	}
}
