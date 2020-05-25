/*
Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements of [1, n] inclusive that do not appear in this array.

Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.

Example:

Input:
[4,3,2,7,8,2,3,1]

Output:
[5,6]

*/

class Solution
{
    public List<Integer> findDisappearedNumbers(int[] nums) 
    {
        //List<Integer> ans=new Arraylist<Integer>();
        ArrayList<Integer> ans = new ArrayList<Integer>();
        for(int i=0;i<nums.length;i++)
        {
            int elem=nums[i]>0?nums[i]:-1*nums[i];
            if( nums[elem-1] >0)
                nums[elem-1]*=-1;
        }
        for(int i=0;i<nums.length;i++)
        {   System.out.print(nums[i]+" ");
            if(nums[i]>0)
                ans.add(i+1);
        }
        return ans;
    }
}//  can also use two equation way method ..using sum(1 to n)  and product(1 to n)
