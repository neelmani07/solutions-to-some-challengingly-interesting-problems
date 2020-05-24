/*
Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.
*/

import java.util.*;
class Solution
{
  
    
    public int countSquares(int[][] M)
    {
        int i,j; 
	int R = M.length;		
	int C = M[0].length;	 
	int S[][] = new int[R][C];	 
	for(i = 0; i < R; i++) 
		S[i][0] = M[i][0]; 
	for(j = 0; j < C; j++) 
		S[0][j] = M[0][j]; 
        
        List<Integer> ar = new ArrayList<Integer>(Collections.nCopies(10, 0));
		
	for(i = 1; i < R; i++) 
	{ 
                for(j = 1; j < C; j++) 
		{ 
			if(M[i][j] == 1) 
                        {
            	                S[i][j] = Math.min(S[i][j-1], 
		 		Math.min(S[i-1][j], S[i-1][j-1])) + 1; 
                 	}
			else
				S[i][j] = 0; 
		} 
	}	 
		
	for(i = 0; i < R; i++) 
	{ 
		for(j = 0; j < C; j++) 
		{
	                if(S[i][j]!=0)
              		{  
               
              	 		if(S[i][j]>1)
                 		{
				       int ind=S[i][j];
				       ar.set(ind,ar.get(ind)+1);	
				       for(int o= S[i][j]-1;o>=1;o--)
				       {
				           ar.set(o,ar.get(o)+1);
				       }
                		 }
				  else
				  {
				         ar.set(1,ar.get(1)+1);
				  }
                   
              		}
		}	
	}	 
		
	int count=0;
       
	for(int ij=0;ij<ar.size();ij++)
        {
        	count+=ar.get(ij);
        }
      return count;
    }
}
