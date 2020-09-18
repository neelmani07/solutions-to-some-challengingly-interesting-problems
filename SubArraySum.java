/*
 * This problem was asked by Lyft.

Given a list of integers and a number K, return which contiguous elements of the list sum to K.

For example, if the list is [1, 2, 3, 4, 5] and K is 9, then it should return [2, 3, 4], since 2 + 3 + 4 = 9.
 */
public class SubArraySum {
	public static void main(String[] args) {
		int ar[]=new int[] {1, 2, 3, 4, 5};
		System.out.println(find(ar,9));
	}

	private static boolean find(int[] ar,int s) {
		int cSum=0;int p1=0;
		for(int p2=0;p2<ar.length;p2++) {
			cSum+=ar[p2];
			while(cSum>s && p1<ar.length-1) {
				cSum-=ar[p1];
				p1++;
			}
			if(cSum==s) {
				System.out.println("Index from "+p1+"->"+p2);
				return true;
			}
				
		}
		return cSum==s?true:false;
	}
}
