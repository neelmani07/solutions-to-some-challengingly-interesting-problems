class HouseRobbery 
{
    
    public int rob(int[] nums)
    {
        if(nums.length == 0)
            return 0;
        if(nums.length==1)
            return nums[0];
        if(nums.length==2)
            return nums[0]>nums[1]?nums[0]:nums[1];
        int ans[]=new int[nums.length];
        ans[nums.length-1]=nums[nums.length-1];
        ans[nums.length-2]=nums[nums.length-2];
        
        for(int i=nums.length-3;i>=0;i--)
        {
            if(nums[i]+ans[i+2]>nums[i]+ans[i+1]-nums[i+1])
            {
                ans[i]=nums[i]+ans[i+2];
            }
            else
            {
                ans[i]=nums[i]+ans[i+1]-nums[i+1];
            }
        }
        
        return ans[0]>ans[1]?ans[0]:ans[1];
    }
    
}
//a little space efficient
/*
class Solution 
{
    
    public int rob(int[] nums)
    {
        if(nums.length == 0)
            return 0;
        if(nums.length==1)
            return nums[0];
        if(nums.length==2)
            return nums[0]>nums[1]?nums[0]:nums[1];
       
        int a=nums[nums.length-2];
        int b=nums[nums.length-1];
        int c=0;
        for(int i=nums.length-3;i>=0;i--)
        {
            if(nums[i]+b>nums[i]+a-nums[i+1])
            {
                c=nums[i]+b;
            }
            else
            {
                c=nums[i]+a-nums[i+1];
            }
            b=a;a=c;
        }
        
        return a>b?a:b;
    }
    
}

*/

