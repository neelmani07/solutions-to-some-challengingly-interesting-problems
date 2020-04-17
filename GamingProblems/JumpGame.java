/*
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

Example:

Input: [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2.
    Jump 1 step from index 0 to 1, then 3 steps to the last index.	
	
	
*/
import java.util.*;;
import java.io.*;
import java.lang.*;

class JumpGame
{	static int dp[]={0,0,0,0,0};
	static int  input[]={2,3,5,1,1,4};
	public static int jump(int[] nums)
 	{
		int n = nums.length;
		if (n < 2) 
			return 0;

		    // max position one could reach 
		    // starting from index <= i 
		int maxPos = nums[0];
		    // max number of steps one could do
		    // inside this jump
		int maxSteps = nums[0];
		    
		int jumps = 1;
		for (int i = 1; i < n; ++i)
		{
		      // if to reach this point 
		      // one needs one more jump
			if (maxSteps < i) 
			{
				++jumps;
				maxSteps = maxPos;
			}
		        maxPos = Math.max(maxPos, nums[i] + i);
	  	}
	  	return jumps;
	  }
	/*public static int leastPath(int ar[],int indX)
	{	
		if (!(indX<ar.length))
			return 0;
		else if (dp[indX] !=0)
			return dp[indX];
		else
		{
			
			int n=ar[indX];int s=999;
			for(int i=1;i<=n;i++)
			{
				s=Math.min(s,(1+leastPath(ar,indX+i)));
			}
			dp[indX]=s;
			return dp[indX];
			
		}
	}*/
	public static void main(String arg[])
	{
		
		//int  dpR[]={0,0,0,0,0};
		//int l=leastPath(input,0);
		int l2=jump(input);
		//System.out.println("will reach end in "+(l-1)+"jumps.");
		System.out.println("will reach end in "+(l2)+"jumps.");
	} 
}
