/*
 * Partition of a set into K subsets with equal sum
 */
package leetcode;

import java.util.Arrays;

public class KSubsetsWithEqualSum {
	public static void main(String[] args) {
		int  nums[] = new int[]{5,1,8,2,3};
		int k = 3;
		System.out.println(findIfPoss(nums,k));
	}

	private static boolean findIfPoss(int[] nums, int k) {
		int tot=0;int count=0;
		for(int i=0;i<nums.length;i++)tot+=nums[i];
		int tar=tot/k;
		for(int bitmsk=1;bitmsk<=(1<<nums.length)-1;bitmsk++) {
			int ind=0;
			int curS=0;
			int tempmsk=bitmsk;
			while(tempmsk!=0) {
				if((tempmsk & 1) ==1) {
					curS+=nums[ind];
				}
				tempmsk=tempmsk>>1;
				ind++;
			}
			if(curS==tar)count++;
		}
		return count==k?true:false;
	}

}
