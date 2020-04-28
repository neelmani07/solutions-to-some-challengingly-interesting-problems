class MinCostClimbingStairs
{
    public int minCostClimbingStairs(int[] cost)
    {
        int f[]=new int[cost.length];
        f[0]=cost[0];f[1]=cost[1];
        
        for(int i=2;i<cost.length;i++)
        {
            f[i]=Math.min(cost[i]+f[i-1],cost[i]+f[i-2]);
            
        }
        return Math.min(f[cost.length-1],f[cost.length-2]);
    }
}
/* On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).

Once you pay the cost, you can either climb one or two steps. You need to find minimum cost to reach the top of the floor, and you can either start from the step with index 0, or the step with index 1.

*/
