import java.lang.*;
import java.util.*;
class CocatenatedWords
{
    static int max,min; // Maintain min and max lenght of words
    static HashSet<String> set;
    public static List<String> findAllConcatenatedWordsInADict(String[] words)
    {
        set = new HashSet<String>();
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        for(String s: words)
        {
            if(s.equals(""))
                continue;
            set.add(s);
            if(s.length()<min)
            {
                min = s.length();
            }
            if(s.length()>max)
            {
                max = s.length();
            }
        }
        List<String> result = new ArrayList<String>();
        for(String s:words)
        {
		// Verify elitibility only if length is atleast sum of two words
            if(s.length()>=min*2 && eligible(s))
            {
                result.add(s);
            }
        }
        return result;
    }
    
    static boolean eligible(String s)
    {
        for(int i=min;i<=max && i<s.length();i++)
        {
            if(set.contains(s.substring(0,i)) && (set.contains(s.substring(i)) || eligible(s.substring(i))))
            {
                return true;
            }
        }
        return false;
    }
    public static void main(String a[])
    {
    	String words[]={"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"};
    	List<String> answer= findAllConcatenatedWordsInADict(words);
    	for (String s:answer)
    	{
    		System.out.println(s);
    	}
    }
    
}

