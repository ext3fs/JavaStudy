import	java.util.Map;
import	java.util.TreeMap;
import	java.util.HashMap;

public	class	tree_map
{
	public	static	boolean	solution(String[] phone_book)
	{
		boolean	answer	= true;
		HashMap<Integer, TreeMap<String, Integer>>	hm	= new HashMap<>();
		TreeMap<String, Integer>					tm;
		int	key;

		for(String s : phone_book)
		{
			key	= s.charAt(0) - '0';	
		/*	
			if(!hm.containsKey(key))
			{		
				tm	= new TreeMap<>();
				hm.put(key, tm);
			}
			else
				tm	= hm.get(key);
*/
			tm	= hm.getOrDefault(key, hm.put(key, new TreeMap<String, Integer>()));
		
			tm.put(s, s.length());	
			
		}
		
		for(Map.Entry<Integer, TreeMap<String, Integer>> elem : hm.entrySet())
		{
			System.out.println(elem.getKey());
		
			for(Map.Entry<String, Integer> tm_elem : elem.getValue().entrySet())
				System.out.println("	" + tm_elem.getKey() + " : " + tm_elem.getValue());
				
		}
	
		return	(answer);
	}


	public	static	void	main(String[] args)
	{
		String[]	phone_book	= {"12","123","1235","13","1335","567","88","844"};
	

		System.out.println(solution(phone_book));
	}
}
