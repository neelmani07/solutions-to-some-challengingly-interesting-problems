/*This problem was asked by Google.

Find the minimum number of coins required to make n cents.

You can use standard American denominations, that is, 1¢, 5¢, 10¢, and 25¢.

For example, given n = 16, return 3 since we can make it with a 10¢, a 5¢, and a 1¢.
*/
public class MinimumCents {
	
	public static int findMinCoins(int n) {
		
		int dp[]=new int[n+1];dp[0]=0;
		if(n>=1)dp[1]=1;
		if(n>=5)dp[5]=1;
		if(n>=10)dp[10]=1;
		
		for(int i=2;i<=n;i++) {
			int val=999;
			if(i>=1)val=1+dp[i-1];
			if(i>=5)val=Math.min(val,1+dp[i-5]);
			if(i>=10)val=Math.min(val,1+dp[i-10]);
			dp[i]=val;
		}
		return dp[n];
	}
	
	public static void main(String[] args) {
		System.out.println(findMinCoins(100));
	}

}
