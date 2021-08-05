import	java.util.Calendar;

public	class	string_buffer
{
	public	String	test()
	{
		Calendar		cal	= Calendar.getInstance();
		StringBuffer	sb	= new StringBuffer();	

		sb.append(cal.get(Calendar.YEAR));

		String	s	= sb.toString();

		System.out.println(s);
		
		return	(s);
	}

	public	static	void	main(String[] args)
	{
		string_buffer	str	= new string_buffer();

		String	s1	= "dfdfdf";
		String	s2	= "dfdfdfffff";

		System.out.println(s2.startsWith(s1));
	/*	
		Integer	ii	= 3;

		if(ii.equals(3))
			System.out.println("equal");
		else
			System.out.println("not equal");
*/
		//System.out.println(str.test());
	}
}
