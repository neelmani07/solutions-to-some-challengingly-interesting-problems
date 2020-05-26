/*
Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Example:

Input:  [1,2,3,4]
Output: [24,12,8,6]

Constraint: It's guaranteed that the product of the elements of any prefix or suffix of the array (including the whole array) fits in a 32 bit integer.

Note: Please solve it without division and in O(n).

Follow up:
Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)

*/

class Solution
{
    
    //basic idea is  ar[i]= product of elements left to it  *  product of elements right to it
    public int[] productExceptSelf(int[] nums)
    {
        int[] res = new int[nums.length];
        res[0] = 1;
        int runningProduct = nums[0];
        //first pass to get product from left
        
        for(int i = 1; i < nums.length; i++)
        {
            res[i] = runningProduct;
            runningProduct *= nums[i];
        }
        //[1,2,3,4] ->>  becomes [1,1,2,6]
        // we have array such that res[i]=product of elements left to it     
        
        //to get [1,1,2,6] -> [24,12,8,6] second pass updates from right to left
        
        runningProduct = nums[nums.length - 1];
        for(int i = res.length - 2; i >= 0; i--)
        {
            res[i] *= runningProduct;
            runningProduct *= nums[i];
        }
        return res;
    }
}
