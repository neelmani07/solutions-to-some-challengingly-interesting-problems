/*
 * This problem was asked by Yelp.

You are given an array of integers, where each element represents 
the maximum number of steps 
that can be jumped going forward from that element. 
Write a function to return the minimum number of jumps 
you must take in order to get from the start to the end of the array.

For example, given [6, 2, 4, 0, 5, 1, 1, 4, 2, 9], 
you should return 2, as the optimal solution involves jumping from 6 to 5, 
and then from 5 to 9.
 */
package leetcode;
public class MinJump {
	
	public static void main(String[] args) {
		int ar[]=new int[]{6,2,4,0,5,1,1,4,2,9};
		System.out.println(findMinJumpDP(ar,0));
	}
	//recurrsive
	private static int findMinJump(int[] ar,int i) {
		if(i>=ar.length-1)
			return 0;
		int min=999;
		for(int k=ar[i];k>0;k--) {
			int foundNow=findMinJump(ar,i+k)+1;
			if(min>foundNow)
				min=foundNow;
		}
		return min;
	}
	//dp
	private static int findMinJumpDP(int[] ar,int i) {

		int n=ar.length;
		int dp[]=new int[n];
		dp[n-1]=0;int min=999;
		for(int k=n-2;k>=i;k--) {
			for(int j=1;j<=ar[k]&&(k+j)<n;j++) {
				int cur=dp[k+j]+1;
				if(min>cur)
					min=cur;
			}
			dp[k]=min;
			min=999;
		}
		return dp[0];
	}
	
}
