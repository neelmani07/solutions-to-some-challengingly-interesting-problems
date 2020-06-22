/*
Given an input string, reverse the string word by word.

 

Example 1:

Input: "the sky is blue"
Output: "blue is sky the"

Example 2:

Input: "  hello world!  "
Output: "world! hello"
Explanation: Your reversed string should not contain leading or trailing spaces.

Example 3:

Input: "a good   example"
Output: "example good a"
Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.

 */
 
 class Solution {
    public String reverseWords(String s) {
        s.trim();s=s+" ";
        StringBuilder ans=new StringBuilder();
        StringBuilder temp=new StringBuilder();
        StringBuilder word=new StringBuilder();
        for(int i=0;i<s.length();i++)
        {
        	
        	char ch=s.charAt(i);
        	if(ch!=' ')
        	{	
        		word.append(ch);
        	}
        	else
        	{	int k=i;
                while(k<s.length() && s.charAt(k)==' ')
                    k++;
                i=k-1;
             
                word.append(' ');
        		temp=ans;ans=new StringBuilder();
        		ans=word.append(temp);
        		word=new StringBuilder();
        	}
        		
        }
        
        String anser=ans.toString();
        return anser.trim();
        
        
    }
}
