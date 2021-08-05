import	java.util.function.Consumer;
import	java.util.Comparator;
import	java.util.ArrayList;
import	java.util.Collections;
import	java.util.Arrays;

public	class	main
{
	public static void main(String[] args) 
	{
		ArrayList<Integer>	list	= new ArrayList<>(Arrays.asList(0,1,3,2,4,5));
		
		Consumer<String> 	print	= v -> System.out.println(v);
		Comparator<Integer>	comp	= (a,b) -> b - a;
		
		System.out.println(list);
		Collections.sort(list);
		System.out.println(list);
		Collections.sort(list, comp);
		System.out.println(list);
	}
}
