import java.util.*;
public class NoOfAtom
{
	public void Elements(String formula,int afterB)
	{
		formula+="   ";
		HashMap<String,Integer> count =new HashMap<String,Integer>();
		for(int i=0;i<formula.length()-2;)
		{	
			char ch=formula.charAt(i),chNxt=formula.charAt(i+1);
			System.out.println(ch+" "+chNxt+" "+formula.charAt(i+2)+" "+i);
			if(Character.isUpperCase(ch))
			{
				if(Character.isLowerCase(chNxt))
				{
					System.out.println("chk4");
					if(Character.isDigit(formula.charAt(i+2)))
					{	
						System.out.println("chk5");
						count.put(Character.toString(ch),Integer.parseInt(String.valueOf(formula.charAt(i+2)))*afterB);
						i+=3;
					}
					else if(Character.isUpperCase(formula.charAt(i+2)))
					{	
						System.out.println("chk6");
						count.put(Character.toString(ch),1*afterB);
						i+=2;
					}
				}
				else if(chNxt==' ')
					{
						System.out.println("chk7");
						count.put(Character.toString(ch),1*afterB);
						break;
					}
				else if(chNxt==')')
				{
					System.out.println("chk8");
					count.put(Character.toString(ch),1*afterB);
					break;
					
				}
				else 
				{	System.out.println("chk1");
					if(Character.isDigit(chNxt))
					{
						count.put(Character.toString(ch),Integer.parseInt(String.valueOf(chNxt))*afterB);
						System.out.println("chk2");
						i+=2;
					}
					else if(Character.isUpperCase(formula.charAt(i+1)))
					{
						count.put(Character.toString(ch),1*afterB);
						System.out.println("chk3");
						i+=1;
					}
				
				}
			}
			
			else
			{
				i=i+1;
			}
		}
		System.out.println(count);
	
	}
	public int findAfterB(String formula)
	{
		int i=formula.length()-1;
		for(;i>=0;i--)
		{
			if(formula.charAt(i)==')')
			{
				break;	
			}
		}
		return (i+1);
	}
	public void countOfElements(String formula)
	{	
		//int m=0;
		for(int i=0;i<formula.length();i++)
		{
			if(formula.charAt(i)=='(')
			{	
				int k=findAfterB(formula);
				int n=Integer.parseInt(String.valueOf(formula.charAt(k)));
				Elements(formula.substring(i+1,k),n);
			}
			if(formula.charAt(i)==')')
			{	
				countOfElements(formula.substring(i+2));
			}
		}
	}	
	public static void main(String s[])
	{
		NoOfAtom obj=new NoOfAtom();
		obj.countOfElements("(MgCl2OH)2");
	}
}
