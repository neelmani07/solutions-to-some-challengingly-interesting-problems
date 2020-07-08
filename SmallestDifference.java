package CTCI;

import java.util.Arrays;

public class SmallestDifference {

	public static int findSmallestDiff(int []ar1, int ar2[])
	{
		Arrays.sort(ar1);Arrays.sort(ar2);
		
		int pointR1=0;int pointR2=0;int min=ar2[pointR2]-ar1[pointR1];
		while(pointR1!=ar1.length && pointR2!=ar2.length)
		{
			min=min<Math.abs(ar2[pointR2]-ar1[pointR1])?min:ar2[pointR2]-ar1[pointR1];
			if(ar1[pointR1]<ar2[pointR2])
			{
				pointR1++;
			}
			else
				pointR2++;
		}
		return Math.abs(min);
		
	}
	public static void main(String arg[])
	{
		int ar1[]=new int[] {1,3,15,11,2};    //1,2,3,11,15
		int ar2[]=new int[] {23,127,235,19,81};//8,19,23,127,235
		
		System.out.print(findSmallestDiff(ar1,ar2));
		
		
	}
}
