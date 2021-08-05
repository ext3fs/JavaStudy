import	java.util.Map;
import	java.util.HashMap;

public class hash_map
{
	static String solution(String[] participant, String[] completion)
	{
		String	answer	= "dfdf";
		HashMap<String, Integer> hm	= new HashMap<>();

		for(String player : participant)
			hm.put(player, hm.getOrDefault(player,0)+1);		

		for(String player : completion)
			//hm.put(player, hm.get(player)-1);		
			hm.put(player, hm.getOrDefault(player,0)+1);		
		
//		for(String key : hm.keySet())
//			System.out.println(key + " : " + hm.get(key));

	//	for(String key : hm.keySet())
	//		if((hm.get(key) % 2) == 1)	
	//			return	(answer = key);	
	
		for(Map.Entry<String, Integer> elem : hm.entrySet())
			System.out.println(elem.getKey() + " : " + elem.getValue());

//		for(Map.Entry<String, Integer> elem : hm.entrySet())
//			if(elem.getValue() != 0)
//				return	elem.getKey();

		return	(answer);
	}	
	
	public static void main(String[] args)
	{
		String[]	participant	= {"88","1235","12"};
		String[]	completion	= {"123","567"};
		
		System.out.println(solution(participant, completion));
	}
}
