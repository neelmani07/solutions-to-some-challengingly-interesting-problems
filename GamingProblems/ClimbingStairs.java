/*You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Note: Given n will be a positive integer.

Example 1:

Input: 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
*/
class ClimbingStairs 
{
    public int climbStairs(int n)
    {
        if(n==1)
            return 1;
        if(n==2)
            return 2;
        
        int a=0,b=0,c=0;
        //int ans[]=new int[n];
        a=1;b=2;
        for(int i=2;i<n;i++)
        {
            c=a+b;
            a=b;
            b=c;
        }
        return c;
    }
}
