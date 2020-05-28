/*
Given an unsorted integer array, find the smallest missing positive integer.

Example 1:

Input: [1,2,0]
Output: 3

Example 2:

Input: [3,4,-1,1]
Output: 2

*/

class Solution {
    public int firstMissingPositive(int[] nums) {
        if(nums.length==1)
            return nums[0]==1?2:1;
        boolean contains = false;
        boolean lastElement = false;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==1)
                contains=true;
            if(nums[i]==nums.length)
                lastElement=true;
            if(nums[i]>=nums.length || nums[i]<=0)
                nums[i]=1;
        }
        if(!contains)
            return 1;
        for(int i=0;i<nums.length;i++)
        {
            int index = Math.abs(nums[i]);
            nums[index]=-Math.abs(nums[index]);
        }
        for(int i=1;i<nums.length;i++){
            if(nums[i]>0)
                return i;
        }
        return lastElement==false?nums.length:nums.length+1;
    }
}
