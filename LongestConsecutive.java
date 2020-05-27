/*
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

Your algorithm should run in O(n) complexity.

Example:

Input: [100, 4, 200, 1, 3, 2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.

*/

class Solution//from gfg
{
    public int longestConsecutive(int[] arr)
    {
        int n=arr.length;
        HashSet<Integer> S = new HashSet<Integer>(); 
        int ans = 0; 
        for (int i=0; i<n; ++i) 
            S.add(arr[i]); 
 
        for (int i=0; i<n; ++i) 
        { 

            if (!S.contains(arr[i]-1)) 
            { 
                int j = arr[i]; 
                while (S.contains(j)) 
                    j++; 
  
                if (ans<j-arr[i]) 
                    ans = j-arr[i]; 
            } 
        } 
        return ans; 
        
        
    }
}
//not working for -ve nums
 /* public int longestConsecutive(int[] arr)
    {
 	if(nums.length==0)
            return 0;
        if(nums.length==1)
            return 1;
        int max=0;
        for(int i=0;i<nums.length;i++)
        {
            max=max>nums[i]?max:nums[i];
        }
        int ans[]=new int[max+1];
        for(int i=0;i<nums.length;i++)
        {
            ans[nums[i]]++;
        }
        
        
        int localM=0;int gMax=0;
        for(int i=0;i<ans.length;i++)
        {
            if(ans[i]!=0)
            {
                localM++;
            }
            else
            {
                gMax=gMax>localM?gMax:localM;
                localM=0;
                
            }
        }
        return Math.max(gMax,localM);
        */
