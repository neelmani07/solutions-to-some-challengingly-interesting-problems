package CTCI;

public class ContiguousLargestSum {
	
	public static void main(String ag[])
	{
		int ar[]=new int[] {-2,78,-3,-2,54,-10};
		int tempSum=0;int finalSum=0;
		for(int i=0;i<ar.length;i++)
		{
			tempSum+=ar[i];
			if(tempSum<=0)
			{
				
				System.out.println(tempSum);
				tempSum=0;
				
			}
			finalSum=finalSum>tempSum?finalSum:tempSum;
			
		}
		System.out.print(finalSum);
	}

}
