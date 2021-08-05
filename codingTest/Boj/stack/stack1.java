import	java.util.Scanner;
import	java.util.Stack;

public class	main
{
	public static void	main(String[] args) throws Exception
	{
		Scanner	sc	= new Scanner(System.in);
		Stack<String>	stk	= new Stack<>();
		int	line	= Integer.parseInt(sc.nextLine());
		StringBuilder	sb	= new StringBuilder();		
		String[]	str;

		for(int i=0; i<line; ++i){
			str	= sc.nextLine().split(" ");
	
			switch(str[0]){
				case	"empty":
					sb.append(stk.isEmpty() ? "1\n":"0\n");
					break;	
				case	"push":
					stk.push(str[1]);
					break;	
				case	"pop":
					if(stk.isEmpty())
						sb.append("-1\n");
					else
						sb.append(stk.pop()).append("\n");
					break;	
				case	"size":
					sb.append(stk.size()).append("\n");
					break;	
				case	"top":
					if(stk.isEmpty())
						sb.append("-1\n");
					else
						sb.append(stk.peek()).append("\n");
			}	
		}

		System.out.print(sb.toString());
	}
}
