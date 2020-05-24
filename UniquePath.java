/*
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?

*/

class Solution 
{
    public int uniquePaths(int m, int n) 
    {
        int ar[][]=new int[n][m];
        
        for(int j=0; j<n; j++) ar[j][0] = 1; // first row filled with 1
        for(int i=0; i<m; i++) ar[0][i] = 1; // first column filled with 1
        
        for(int r=1;r<n;r++)
        {
            for(int c=1;c<m;c++)
            {
              
                {   //System.out.print(r+" "+c);
                    ar[r][c]=ar[r-1][c]+ar[r][c-1];
                }
            }
        }
        return ar[n-1][m-1];
        
    }
}

