import	java.util.Collections;
import	java.util.Map;
import	java.util.HashMap;
import	java.util.TreeMap;

public	class	main
{
	public	static	int[]	solution(String[] genres, int[] plays)
	{
		HashMap<String, Integer>					hm1	= new HashMap<>();
		HashMap<String,	TreeMap<Integer, Integer>>	hm2	= new HashMap<>();
		TreeMap<Integer, Integer>					sub_tm;
		TreeMap<Integer, String>	tm	= new TreeMap<>(Collections.reverseOrder());	

		for(int i=0, count=plays.length; i<count; ++i)
		{
			hm1.put(genres[i], hm1.getOrDefault(genres[i], 0) + plays[i]);
			
			if( (sub_tm = hm2.get(genres[i])) == null)
			{
				sub_tm	= new TreeMap<>();
				hm2.put(genres[i], sub_tm);
			}
			sub_tm.put(i, plays[i]);  			
		}
	
		for(Map.Entry<String, Integer> record : hm1.entrySet())
			tm.put(record.getValue(), record.getKey());
				
		int[]	ans	= new int[hm1.size()*2];
		int[]	max	= new int[2];
		int[]	idx	= new int[2];
		int		size, value, count=0;
		
		for(Map.Entry<Integer, String> record : tm.entrySet())
		{
			max[0]	= 0;
		 	max[1]	= 0;		
			sub_tm	= hm2.get(record.getValue());
		
			for(Map.Entry<Integer, Integer> elem : sub_tm.entrySet())
			{

				System.out.println("tree  " + elem.getKey() + " : " + elem.getValue());
				value	= elem.getValue();
									
				if(value > max[0])
				{	
					max[1]	= max[0];
					idx[1]	= idx[0];
					max[0]	= value;
					idx[0]	= elem.getKey();
				}
				else if(value > max[1])
				{
					max[1]	= value;
					idx[1]	= elem.getKey();
				}
				
			}

			size 	= (sub_tm.size() > 1)? 2 : 1;
			System.arraycopy(idx, 0, ans, count, size);
			count	+= size;
			System.out.println(size + " : " + count);
		}
		
		int[] answer	= new int[count];
		System.arraycopy(ans, 0, answer, 0, count);

		for(Map.Entry<Integer, String> record : tm.entrySet())
			System.out.println(record.getKey() + " : " + record.getValue());
	
		
		return	(answer);
	}
	
	public static void main(String[] args) 
	{
		String[]	genres	= {"classic","classic","classic","pop"};
		int[]		plays	= {500,  150, 800, 2500};
		int[]		answer;

	
		answer	= solution(genres, plays);

		System.out.print("answer : ");
		for(int i : answer)
			System.out.print(i + " ");
		System.out.println();

	}
}
