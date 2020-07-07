/*Given an unsorted array of integers, find the length of longest increasing subsequence.

Example:

Input: [10,9,2,5,3,7,101,18]
Output: 4 
Explanation: The longest increasing subsequence

is [2,3,7,101], therefore the length is 4. */

//O(n^2) dp  used.
class Solution {
    
    public int findMaxTillNow(int i,int sum[],int []nums){
        int max=0;boolean greaterFound=false;int n=nums.length;
        for(int j=i+1;j<n;j++)
        {
            if(nums[i]<nums[j])
            {
                greaterFound=true;
                max=max>sum[j]?max:sum[j];
            }
        }
        if(greaterFound)
            return 1+max;
        else
            return max;
    }
    public int lengthOfLIS(int[] nums) {
        
        int n=nums.length;
        if(n==0)return 0;
        int sum[]=new int[n];
        sum[n-1]=0;
        for(int i=n-2;i>=0;i--)
        {
            sum[i]=findMaxTillNow(i,sum,nums);
            
        }
        int toReturn=0;
        for(int i=0;i<n;i++)
        {
            //System.out.print(sum[i]+" ");
            toReturn=toReturn>sum[i]?toReturn:sum[i];
        }
        
        //
        return toReturn+1  ;
    }
}


//use of DP and Binary Search  O(nlogn)
/* Arrays.binarySearch()--> returns index of the search key, if it is contained in the array; otherwise, (-(insertion point) – 1). The insertion point is defined as the point at which the key would be inserted into the array: the index of the first element greater than the key, or a.length if all elements in the array are less than the specified key. Note that this guarantees that the return value will be >= 0 if and only if the key is found.*/

public class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int lengthOfDP = 0;
        for (int num : nums) {
            int i = Arrays.binarySearch(dp, 0, lengthOfDP, num);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = num;
            if (i == lengthOfDP) {
                lengthOfDP++;
            }
        }
        return lengthOfDP;
    }
}
