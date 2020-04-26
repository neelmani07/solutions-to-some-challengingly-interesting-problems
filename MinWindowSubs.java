import java.util.*;
public class MinWindowSubs
{
	public void wordsFill(String s,List<Character> wL)
	{
		for(int i=0;i<s.length();i++)
		{
			wL.add(s.charAt(i));
		}
	}
	public void minWindow(String s, String t)
    {
		int pointR1=0,pointR2=0;
		List<Character> wordLetters=new ArrayList<Character>(); 
		List<String> ans=new ArrayList<String>();
		List<Integer> nextInd=new ArrayList<Integer>();int next=0;int tp=0;
		wordsFill(t,wordLetters);
		
		while(tp!=s.length())
		{
			if(wordLetters.contains(s.charAt(tp)))
			{	
				if(tp!=0 )
					nextInd.add(tp);
			}
			tp++;
		}
		
		while(pointR2!=s.length())
		{
			if(wordLetters.contains(s.charAt(pointR2)))
			{	
				wordLetters.remove(new Character(s.charAt(pointR2)));
				if(wordLetters.isEmpty())
				{	
					wordsFill(t,wordLetters);
					ans.add(s.substring(pointR1+1, pointR2+1));
					pointR2=pointR1=nextInd.get(next)-1;next++;
				}
				
			}
			
			pointR2++;
				
		}
		
		int minL=ans.get(0).length();int minI=0;
		for(int i=1;i<ans.size();i++)
		{
			if(minL>ans.get(i).length())
				{
					minL=ans.get(i).length();
					minI=i;
				}
		}
		System.out.println(ans.get(minI));
	    
    }
	public static void main(String a[])
	{
		String str = "ADOBECODEBANC";
		String t = "ABC";
		MinWindowSubs ob=new MinWindowSubs();
		ob.minWindow(str,t);
		
	}
}
