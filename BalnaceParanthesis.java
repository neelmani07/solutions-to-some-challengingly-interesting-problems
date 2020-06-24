/*
 * This problem was asked by Facebook.

Given a string of parentheses, find the
balanced string that can be produced from
it using the minimum number of insertions
and deletions. If there are multiple
solutions, return any of them.

For example, given "(()",
you could return "(())". 
Given "))()(", you could return "()()()()".
 */
public class BalnaceParanthesis 
{
	public static void balancePar(String s)
	{
		int countOpen=0;
		StringBuilder ans=new StringBuilder();
		for(int i=0;i<s.length();i++)
		{
	
			char ch=s.charAt(i);
			System.out.println(ch);
			if(ch=='(')
			{
				countOpen++;
				System.out.println("check1");
			}
			else if(ch==')')
			{
				if(countOpen==0)
				{
					ans.append('(');
					ans.append(ch);
					System.out.println("chk2");
				}
				else
				{
					countOpen--;
					ans.append('(');
					ans.append(ch);
					System.out.println("chk3");
				}
				
			}
			
			
		}
		//left over open paranthsis
		if(countOpen>0)
		{
			while(countOpen!=0)
			{
				ans.append('(');
				ans.append(')');
				countOpen--;
			}
		}
		System.out.println(ans);
	}
	public static void main(String a[])
	{
		String s="))()()))";
		balancePar(s);
	}
	
}
