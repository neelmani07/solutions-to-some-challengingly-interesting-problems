/*
 Given a string s, find the longest palindromic subsequence's length in s. You may assume that the maximum length of s is 1000.

Example 1:
Input:

"bbbab"

Output:

4

*/

class Solution
{
    public int longestPalindromeSubseq(String s)
    {
        
        char[] str =s.toCharArray();
        int n = s.length(); 
        int i, j, cl; 
        int L[][] = new int[n][n];  

        for (i = 0; i < n; i++) 
             L[i][i] = 1; 
     
        for (cl=2; cl<=n; cl++) 
        { 
            for (i=0; i<n-cl+1; i++) 
            { 
                j = i+cl-1; 
                if (str[i] == str[j] && cl == 2) 
                   L[i][j] = 2; 
                else if (str[i] == str[j]) 
                   L[i][j] = L[i+1][j-1] + 2; 
                else
                   L[i][j] =Math.max(L[i][j-1], L[i+1][j]); 
              
            } 
    
        } 
        return L[0][L.length-1];
     
 
    }
}
