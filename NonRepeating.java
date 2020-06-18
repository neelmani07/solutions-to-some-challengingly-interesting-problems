

/*
 * This problem was asked by Facebook.

Given an array of integers in which two elements appear exactly once and all other elements appear exactly twice, find the two elements that appear only once.

For example, given the array [2, 4, 6, 8, 10, 2, 6, 10], return 4 and 8. The order does not matter.

Follow-up: Can you do this in linear time and constant space?
 */
public class NonRepeating 
{
	public static void findDistinctTwo(int ar[])
	{
		int xor=0;
		for(int i=0;i<ar.length;i++)
		{
			xor=xor^ar[i];
		}
		
		int set_bit_no = xor & ~(xor-1);
		xor=0;int xor2=0;
		for(int i=0;i<ar.length;i++)
		{
			if((ar[i] & set_bit_no )>0)
			{
				xor=xor^ar[i];
			}
			else
			{
				xor2=xor2^ar[i];
				
			}
				
		}
		
		System.out.println("two distinct no:-"+xor+"and "+xor2);
		
		
	}
	public static void main(String s[])
	{
		int ar[]=new int[]{2, 4, 6, 8, 10, 2, 6, 10};
		findDistinctTwo(ar);
		
	}
}
