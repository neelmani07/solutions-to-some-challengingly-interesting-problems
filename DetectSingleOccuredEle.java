/*
Given a non-empty array of integers, every element appears twice except for one. Find that single one.

Note:

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Example 1:

Input: [2,2,1]
Output: 1

Runtime: 0 ms, faster than 100.00% of Java online submissions for Single Number.
Memory Usage: 40.5 MB, less than 85.93% of Java online submissions for Single Number.

*/
class Solution 
{
    public int singleNumber(int[] nums) 
    {
        int xorRes=0;
        for(int i=0;i<nums.length;i++)
        {
            xorRes=xorRes^nums[i];
        }
        return xorRes;
    }
}
