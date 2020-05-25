/*
Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Example:

Input: [0,1,0,3,12]
Output: [1,3,12,0,0]
*/

class Solution
{
    
    public void moveZeroes(int[] nums)
    { 
        int l=nums.length;
        if(l<=1)
            return;
        int left=0;
        int right=0;
        while(left<l-1 && nums[left]!=0)
        {
            left++;
        }
        right=left+1;
        
        while(right<l)
        {
            if(nums[right]!=0)
            {
                int tmp=nums[left];
                nums[left]=nums[right];
                nums[right]=tmp;
                left+=1;
            }
            else 
                right++;
        }
    }
}
