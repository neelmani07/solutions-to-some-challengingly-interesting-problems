/*     day 419
Given a positive integer N, find the smallest number of steps it will 
take to reach 1.

There are two kinds of permitted steps:

You may decrement N to N - 1.
If a * b = N, you may decrement N to the larger of a and b.

For example, given 100, you can reach 1 in five steps with the following route:
	
100 -> 10 -> 9 -> 3 -> 2 -> 1.*/
import java.util.*;
import java.lang.*;


public class PagerDuty 
{
	
	public static int findSuitableFactor(int n)
	{
		int minDif=999;
		int suitableFactor=0;
		for(int i=2;i<=n/2;i++)
		{
			if(n%i==0)
			{
				if(Math.abs((n/i)-i)<minDif)
				{
					minDif=Math.abs((n/i)-i);
					suitableFactor=Math.max(n/i,i);
				}

			}
		}
		if(suitableFactor!=0)
			System.out.println(suitableFactor+" for "+n);
		return (suitableFactor==0)?n-1:suitableFactor;
		
	}
	public static int pagerDuty(int n) 
	{
		if(n==1)return 0;
		if(n==2)return 1;
		int dp[]=new int[n+1];
		dp[0]=0;dp[1]=0;dp[2]=1;
		for(int i=3;i<=n;i++)
		{
			dp[i]=1+Math.min(dp[i-1],dp[findSuitableFactor(i)]);
		}
		
		return dp[n];
	}
	public static void main(String a[])
	{
		int n=200;
		System.out.print("steps to reach from  "+n+" -->1 is "+pagerDuty(n));
	}
	

}
