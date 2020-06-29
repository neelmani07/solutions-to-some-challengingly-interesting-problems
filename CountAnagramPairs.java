/*
 * Two strings are anagrams of each other if the 
 * letters of one string can be rearranged to form 
 * the other string. Given a string, find the number 
 * of pairs of substrings of the string that are anagrams of each other.
 */

package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountAnagramPairs 
{
	public static boolean isAnagram(String s1,String s2)
	{
		 char[] ArrayS1 = s1.toLowerCase().toCharArray();  
         char[] ArrayS2 = s2.toLowerCase().toCharArray();  
         Arrays.sort(ArrayS1);  
         Arrays.sort(ArrayS2); 
         
         return Arrays.equals(ArrayS1, ArrayS2);  
	}
	public static int findNoOfDuplicates(String s)
	{
		Map<Character,Integer> map = new HashMap<Character,Integer>();
		for (int i = 0; i < s.length(); i++) 
		{
		  char c = s.charAt(i);
		  if (map.containsKey(c)) 
		  {
		    int cnt = map.get(c);
		    map.put(c, ++cnt);
		  }
		  else 
		  {
		    map.put(c, 1);
		  }
		}
		int sum = 0;
		for (int f : map.values()) 
		{
			if(f>1)
		    sum ++ ;
		}
		return sum;
		
	}
	public static int countPairs(String str)
	{
		int count=0;
		//countimg duplicates chracters
		count +=findNoOfDuplicates(str);
		
		//now start counting for all length of words from 2 to str.length()-1
		for(int lengthOfWord=2;lengthOfWord<=str.length()-1;lengthOfWord++)
		{
			
			//key here is referred to each word that will be checked with rest of the strmg for anagrams
			for(int strtIndexOfkey=0;(strtIndexOfkey+lengthOfWord)<str.length();strtIndexOfkey++)
			{
				
				String str1=str.substring(strtIndexOfkey, strtIndexOfkey+lengthOfWord);
				//System.out.println(str1);
				for(int checkStIndex=strtIndexOfkey+1;(checkStIndex+lengthOfWord)<str.length()+1;checkStIndex++)
				{
					
					String str2=str.substring(checkStIndex,checkStIndex+lengthOfWord);
					
					if(isAnagram(str1,str2))
					{
						count++;
						System.out.println(str1+" "+str2+" are anagrams");
					}
						
				}
				
			}
		}
		return count;
	}
	
	public static void main(String ar[])
	{
	
		String s="abba";
		String s2="ifailuhkqq";
		String s3="momo";
		System.out.println("anagram pairs count="+(countPairs(s3)));
		
		
	}
	
}
