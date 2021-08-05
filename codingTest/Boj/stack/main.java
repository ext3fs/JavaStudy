import	java.io.*;
import	java.util.*;

public class	main
{
	public static void	main(String[] args)
	{
		StringBuilder	sb	= new StringBuilder();	
		BufferedReader	br	= new BufferedReader(new InputStreamReader(System.in)); 		
		
		String[]	strArr	= br.lines().toArray(String[]::new);	

		for(String str : strArr)
			System.out.println(str);

	}
}
