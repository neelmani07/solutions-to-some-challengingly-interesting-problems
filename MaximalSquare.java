/*

Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

Example:

Input: 

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0

Output: 4

*/
class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix.length==0 || matrix[0].length==0)
            return 0;
         int ans = 0;
         int[][] dp = new int[matrix.length][matrix[0].length];
         for(int i=0;i<matrix.length;i++)
            for(int j=0;j<matrix[0].length;j++)
            {
                if(matrix[i][j]=='1'){
                   dp[i][j]=1;
                   if(i > 0 && j > 0)
                      dp[i][j]=1+Math.min(Math.min(dp[i][j-1],dp[i-1][j]),dp[i-1][j-1]);
                }
                ans = Math.max(ans,dp[i][j]);
            }
         return ans*ans;
    }
}
