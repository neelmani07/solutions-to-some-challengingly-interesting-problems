class SalesProfit1 
{
    public static int maxProfit(int[] prices)
    {
            int lmin=0;int profit=0;int fprofit=0;
            for(int i=0;i<prices.length;i++)
            {
             
                int j=i+1;
                while(j<prices.length)
                {
                    if(prices[i] <prices[j] && prices[j]>prices[j-1] && prices[j] >prices[j+1])
                    {
                        profit=Math.max(profit,prices[j]-prices[i]);
                        //System.out.println(profit);
                    }
                    j++;
                }
                
                fprofit=Math.max(fprofit,profit);
            }
            return fprofit;
            
    }
    public static void main(String s[])
    {
    	int[] t=new int[]{7,1,5,3,6,4};
    	System.out.println(maxProfit(t));
    }
}
