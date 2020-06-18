/*Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order, too.

You need to find the shortest such subarray and output its length.

Example 1:

Input: [2, 6, 4, 8, 10, 9, 15]
Output: 5
Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.




class Solution {
    public int findUnsortedSubarray(int[] nums) {
        
        int sorted[]=new int[nums.length];
        for(int i=0;i<nums.length;i++)
            sorted[i]=nums[i];
        Arrays.sort(sorted);
        int left=0,right=0;
        for(left=0;left<nums.length-1 && nums[left]==sorted[left];left++);
        for(right=nums.length-1;right >=0 && nums[right]==sorted[right];right--);
        System.out.println(left +" "+ right);
        if(right <= left)
            return 0;
        return right-left+1;
        
    }
}
*/

class Solution {

    public int findUnsortedSubarray(int[] nums) {
        int low = 0, high = nums.length-1;
        while (low < nums.length-1 &&nums[low] <= nums[low+1]) {
            low++;
        }
        if (low == nums.length-1) {return 0;}
        while (high > 0 && nums[high] >= nums[high-1]) {
            high--;
        }
        int sub_min = 999999, sub_max = -9999;
        for (int i = low; i <= high; ++i) {
            sub_min = Math.min(nums[i], sub_min);
            sub_max = Math.max(nums[i], sub_max);
        }
        while (low > 0 && nums[low-1] > sub_min) {
            low--;
        }
        while (high < nums.length-1 && nums[high+1] < sub_max) {
            high++;
        }
        return high-low+1;
    }
}
