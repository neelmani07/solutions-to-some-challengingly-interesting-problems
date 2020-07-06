/*
A chef has collected data on the satisfaction level of his n dishes. Chef can cook any dish in 1 unit of time.

Like-time coefficient of a dish is defined as the time taken to cook that dish including previous dishes multiplied by its satisfaction level  i.e.  time[i]*satisfaction[i]

Return the maximum sum of Like-time coefficient that the chef can obtain after dishes preparation.

Dishes can be prepared in any order and the chef can discard some dishes to get this maximum value.

 

Example 1:

Input: satisfaction = [-1,-8,0,5,-9]
Output: 14
Explanation: After Removing the second and last dish, the maximum total Like-time coefficient will be equal to (-1*1 + 0*2 + 5*3 = 14). Each dish is prepared in one unit of time.
*/
class Solution {
    
    public int maxSatisfaction(int[] satisfaction) 
    {
        if(satisfaction.length==0)return 0;
        Arrays.sort(satisfaction);
        int n = satisfaction.length;
        int Cumulative_sum = 0; // From back
        int ans = 0;
        int cur = 0;
        for(int i = n-1;i>=0;i--)
        {
            cur += Cumulative_sum + satisfaction[i];
            Cumulative_sum += satisfaction[i];
            
            ans = Math.max(ans,cur);
        }
        
        return ans;
        
    }
}
