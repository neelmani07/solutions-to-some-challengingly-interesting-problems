/*
 * This problem was asked by Facebook.

Given a circular array, compute its maximum subarray sum in O(n) time.
 A subarray can be empty, and in this case the sum is 0.

For example, given [8, -1, 3, 4], return 15 as we choose the numbers 3, 4, and 8 
where the 8 is obtained from wrapping around.

Given [-4, 5, 1, 0], return 6 as we choose the numbers 5 and 1.
 */
public class MaxSubArrayInCircuAr {
	public static void main(String[] args) {
		int ar[]=new int[] {8, -1,-9, 4};
		System.out.println(find(ar));
	}

	private static int find(int[] ar) {
		int Gmax=-1;
		int maxTillHere=0;int limit=0;
		for(int i=0;limit<2*ar.length;i=(++i%ar.length)){
			maxTillHere+=ar[i];
			if(maxTillHere<=0)
				maxTillHere=0;
			Gmax=Gmax>maxTillHere?Gmax:maxTillHere;
			limit++;
		}
		return Gmax;
	}
}
