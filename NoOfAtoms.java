import java.util.*;
public class NoOfAtoms
{
	public void countOfElements(String formula)
	{
		HashMap<String,Integer> count =new HashMap<String,Integer>();
		for(int i=0;i<formula.length();i++)
		{
			char ch=formula.charAt(i),chNxt=formula.charAt(i+1);
			if(Character.isUpperCase(ch))
			{
				if(Character.isDigit(chNxt))
				{
					count.put(Character.toString(ch),Integer.parseInt(String.valueOf(chNxt)));
				}
				else if(Character.isUpperCase(formula.charAt(i+1)))
				{
					count.put(Character.toString(ch),1);
				}
				i+=1;
			}
			if(Character.isUpperCase(ch) && Character.isLowerCase(chNxt))
			{
				if(Character.isDigit(formula.charAt(i+2)))
				{
					count.put(Character.toString(ch),Integer.parseInt(String.valueOf(formula.charAt(i+2))));
				}
				else if(Character.isUpperCase(formula.charAt(i+2)))
				{
					count.put(Character.toString(ch),1);
				}
				i+=2;
				
			}
		}
		System.out.println(count);
	}
	public static void main(String s[])
	{
		NoOfAtoms obj=new NoOfAtoms();
		obj.countOfElements("MgCl2");
	}
}