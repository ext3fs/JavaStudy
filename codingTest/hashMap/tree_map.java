import	java.util.Map;
import	java.util.TreeMap;

public	class	tree_map
{
	public	static	boolean	solution(String[] phone_book)
	{
		boolean	answer	= true;
		TreeMap<String, Integer>	tm	= new TreeMap<>();
		String	sub_key;
		int		len, sub_len;


		for(String key : phone_book)
			tm.put(key, 0);	

		for(String key : tm.keySet())
			System.out.println(key + " : " + tm.higherKey(key));
	
		
		for(String key : tm.keySet())
		{
			len	= key.length();
			System.out.println(key + " : " + tm.higherKey(key));
		
			sub_key	= tm.higherKey(key);

			while(sub_key != null)	
			{
				sub_len	= sub_key.length();

				if(len >= sub_len)
				{
					System.out.println(len + "dd" + sub_key.length());
					break;
				}
			
				if(key.equals(sub_key.substring(0, len)))
					return	(false);
					
				sub_key	= tm.higherKey(sub_key);
			}
		}
		
		return	(answer);
	}


	public	static	void	main(String[] args)
	{
		String[]	phone_book	= {"12","32","53333","13","1435"};
	

		System.out.println(solution(phone_book));
	}
}
