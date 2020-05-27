/*
ou are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

Example 1:

Input: coins = [1, 2, 5], amount = 11
Output: 3 
Explanation: 11 = 5 + 5 + 1

Example 2:

Input: coins = [2], amount = 3
Output: -1

*/
class Solution {
/*    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
         if(amount==0)
            return 0;
        if(amount < coins[0])
            return -1;
       
        int[] dp = new int[amount+1];
        for(int i=0; i<dp.length; i++){
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;
        for(int i=1; i<amount+1; i++){
            for(int coin:coins){
                if((i-coin)<0){
                    break;
                }else if(dp[i-coin] != Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i], dp[i-coin]+1);
                }
            }
        }
        if(dp[amount]==Integer.MAX_VALUE){
            return -1;
        }else{
            return dp[amount];
        }
    }
}*/


 public int coinChange(int[] coins, int V)
    { 
        // table[i] will be storing  
        // the minimum number of coins 
        // required for i value. So  
        // table[V] will have result 
        int table[] = new int[V + 1]; 
        int m=coins.length;
  
        // Base case (If given value V is 0) 
        table[0] = 0; 
  
        // Initialize all table values as Infinite 
        for (int i = 1; i <= V; i++) 
        table[i] = Integer.MAX_VALUE; 
  
        // Compute minimum coins required for all 
        // values from 1 to V 
        for (int i = 1; i <= V; i++) 
        { 
            // Go through all coins smaller than i 
            for (int j = 0; j < m; j++) 
            if (coins[j] <= i) 
            { 
                int sub_res = table[i - coins[j]]; 
                if (sub_res != Integer.MAX_VALUE  
                       && sub_res + 1 < table[i]) 
                       table[i] = sub_res + 1; 
                         
                  
            } 
              
        }
        if(table[V]==Integer.MAX_VALUE){
            return -1;
        }else{
            return table[V];}
       // return ; 
        
 }
}
