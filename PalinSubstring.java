/*
Given a string, your task is to count how many palindromic substrings in this string.

The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.

Example 1:

Input: "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".

 

Example 2:

Input: "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".

*/

class Solution 
{
public int countSubstrings(String s)
{
        int ans = 0;
        int N = s.length();
        
        boolean[][] DP = new boolean[N][N];
        
        for (int step=1;step<=N;step++) 
        {
            for (int i=0;i+step<=N;i++) 
            {
                int j = i + step -1;
                if (step == 1) // for 1st diagonal
                {
                    DP[i][j] = true;
                } 
                else if (step == 2) //for 2nd diagonal
                {
                    if (s.charAt(i) == s.charAt(j)) 
                    {
                        DP[i][j] = true;
                    }
                } 
                else 
                {
                    if (s.charAt(i) == s.charAt(j)) 
                    {
                        DP[i][j] = DP[i+1][j-1];
                    }
                }
                
                if (DP[i][j] == true) 
                {
                    ans++;
                }
            }
        }
        return ans;
    }
}
