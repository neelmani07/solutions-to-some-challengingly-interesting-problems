/*
 * 
 * This problem was asked by Nest.

Create a basic sentence checker that takes
in a stream of characters and determines
whether they form valid sentences. If a
sentence is valid, the program should print it out.

We can consider a sentence valid if it conforms to the following rules:

The sentence must start with a capital letter,
followed by a lowercase letter or a space.
    
All other characters must be lowercase letters,]
separators (,,;,:) or terminal marks (.,?,!,‽).

There must be a single space between each word.
The sentence must end with a terminal mark immediately following a word.

 */
package leetcode;

public class SentenceChecker {
	
	public static boolean validateSen(String s)
	{
		if(! Character.isUpperCase(s.charAt(0)))return false;
		int i=1;
		for(;i<s.length()-1;i++)
		{	
			char ch=s.charAt(i);
			System.out.println(ch);
			if(Character.isUpperCase(ch))
				return false;
			
			if(ch==' ' && s.charAt(i+1)==' ')
				return false;
			
			if(!Character.isLowerCase(ch) && ch!=' ' && ch!=',' && ch!=':' && ch!=';')
				return false;
			
		}
		if(s.charAt(i)!='.' && s.charAt(i)!='!' && s.charAt(i)!='?')
			return false;
		else if(s.charAt(i-1)==' ')
			return false;
		
		return true;
		
	}
	public static void main(String s[])
	{
		String str="How are you?";
		System.out.println(validateSen(str));
	}

}
