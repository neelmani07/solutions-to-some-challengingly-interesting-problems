/*
 * This problem was asked by Amazon.

Given a pivot x, and a list lst, partition the list into three parts.

    The first part contains all elements in lst that are less than x
    The second part contains all elements in lst that are equal to x
    The third part contains all elements in lst that are larger than x

Ordering within a part can be arbitrary.

For example, given x = 10 and lst = [9, 12, 3, 5, 14, 10, 10],
 one partition may be [9, 3, 5, 10, 10, 12, 14].
 */

public class PivotPartition {

	public static void doPartition(int p,int []ar)
	{
		int bPoin=0;int ePoin=ar.length-1;int i=0;
		while(ePoin>i)
		{
			if(ar[i]>p)
			{
				int temp=ar[ePoin];
				ar[ePoin]=ar[i];
				ar[i]=temp;
				ePoin--;
			}
			else if(ar[i]==p)
			{
				i++;
				
			}
			else
			{	//System.out.print(" "+bPoin);
				int temp=ar[bPoin];
				ar[bPoin]=ar[i];
				ar[i]=temp;
				bPoin++;i++;
			}
		}
		
		for(int j=0;j<ar.length;j++)
			System.out.print(" "+ar[j]);
	}
	public static void main(String s[])
	{
		int list[]=new int[] {9, 12, 3, 5, 14, 10, 10};
		int pivot=10;
		doPartition(pivot,list);
	}
}
