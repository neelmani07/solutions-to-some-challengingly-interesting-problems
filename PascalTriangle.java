/*
 * This problem was asked by Stitch Fix.

Pascal's triangle is a triangular array of integers constructed with the following formula:

    The first row consists of the number 1.
    For each subsequent row, each element is the sum of the numbers directly above it, on either side.

For example, here are the first few rows:

    1
   1 1
  1 2 1
 1 3 3 1
1 4 6 4 1

Given an input k, return the kth row of Pascal's triangle.
 */
import java.util.*;
public class PascalTriangle 
{
	
	public static void dispAr(int ar[])
	{
		for(int k=0;k<ar.length;k++)
			System.out.print(ar[k]+",");
		System.out.println();
	}
	
	//space efficient sol.
	public static void formPasTrian(int n)
	{
		int ans[]=new int[n];
		ans[0]=1;
		for(int i=2;i<=n;i++)
		{
			int lastVal=1,curVal=0;
			for(int j=1;j<i-1;j++)
			{
				curVal=ans[j];
				ans[j]=lastVal+curVal;
				lastVal=curVal;
			}
			ans[i-1]=1;
			dispAr(ans);
		}
		ans[n-1]=1;
		
		dispAr(ans);
	}
	public static void main(String a[])
	{
		Scanner sc=new Scanner(System.in);
		//System.out.println("enter the n");
		int n=10;//sc.nextInt();
		formPasTrian(n);
	}
}
