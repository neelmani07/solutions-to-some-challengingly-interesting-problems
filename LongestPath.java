/*
 * Given a n*n matrix where all numbers are distinct,
 *  find the maximum length path (starting from any cell)
 *   such that all cells along the path are in increasing
 *    order with a difference of 1.

We can move in 4 directions from a given cell (i, j),
i.e., we can move to (i+1, j) or (i, j+1) or (i-1, j) 
or (i, j-1) with the condition that the adjacent cells
have a difference of 1.
*/

package leetcode;

public class LongestPath {
	
	static int findLongestFromACell(int i, int j, int mat[][], int dp[][],int n) 
    { 
        // Base case 
        if (i < 0 || i >= n || j < 0 || j >= n) 
            return 0; 
  
        // If this subproblem is already solved 
        if (dp[i][j] != -1) 
            return dp[i][j]; 
  
        // To store the path lengths in all the four directions 
        int x = Integer.MIN_VALUE, y = Integer.MIN_VALUE, z = Integer.MIN_VALUE, w = Integer.MIN_VALUE; 
        // Since all numbers are unique and in range from 1 to n*n, 
        // there is atmost one possible direction from any cell 
        if (j < n - 1 && ((mat[i][j] < mat[i][j + 1]))) 
            x = dp[i][j] = 1 + findLongestFromACell(i, j + 1, mat, dp,n); 
  
        if (j > 0 && (mat[i][j]  < mat[i][j - 1])) 
            y = dp[i][j] = 1 + findLongestFromACell(i, j - 1, mat, dp,n); 
  
        if (i > 0 && (mat[i][j] < mat[i - 1][j])) 
            z = dp[i][j] = 1 + findLongestFromACell(i - 1, j, mat, dp,n); 
  
        if (i < n - 1 && (mat[i][j] < mat[i + 1][j])) 
            w = dp[i][j] = 1 + findLongestFromACell(i + 1, j, mat, dp,n); 
  
        // If none of the adjacent fours is one greater we will take 1 
        // otherwise we will pick maximum from all the four directions 
        return dp[i][j] = Math.max(x, Math.max(y, Math.max(z, Math.max(w, 1)))); 
    } 
	static void dispPath(int mat[][],int dp[][],int indX,int indY,int n)
	{
		//display path
        while(dp[indX][indY]>1)
        {
        	System.out.print(mat[indX][indY]+" -> ");
        	
        	if(indX+1 <n && dp[indX+1][indY]+1==dp[indX][indY])
        		indX=indX+1;
        	else if(indX-1 >= 0 && dp[indX-1][indY]+1==dp[indX][indY])
        		indX=indX-1;
        	else if(indY+1 <n && dp[indX][indY+1]+1==dp[indX][indY])
        		indY=indY+1;
        	else if(indY-1 >=0 && dp[indX][indY-1]+1==dp[indX][indY])
        		indY=indY-1;
        }
        System.out.println(mat[indX][indY]);
        
	}
	
	static int finLongestOverAll(int mat[][],int n) 
    { 
        // Initialize result 
        int result = 1; int indX=-1,indY=-1;
  
        // Create a lookup table and fill all entries in it as -1 
        int[][] dp = new int[n][n]; 
        for (int i = 0; i < n; i++) 
            for (int j = 0; j < n; j++) 
                dp[i][j] = -1; 
  
        // Compute longest path beginning from all cells 
        for (int i = 0; i < n; i++) 
        { 
            for (int j = 0; j < n; j++) 
            { 
                if (dp[i][j] == -1) 
                    findLongestFromACell(i, j, mat, dp,n); 
  
                // Update result if needed 
                //result = Math.max(result, dp[i][j]); 
                if(result<dp[i][j])
                {
                	result=dp[i][j];
                	indX=i;indY=j;
                }
            } 
        }
        dispPath(mat,dp,indX,indY,n);
        return result;
  
    }
	public static void main(String[] args) 
    { 
        int mat[][] = { { 1, 12, 19 }, 
                        { 4, 9, 28 }, 
                        { 6, 7, 37 } }; 
        System.out.println("Length of the longest path is " + finLongestOverAll(mat,3)); 
    } 

}
