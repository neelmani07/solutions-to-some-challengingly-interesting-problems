/*
Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.

Example 1:

Input: 2
Output: [0,1,1]

Example 2:

Input: 5
Output: [0,1,1,2,1,2]
*/
class CountBit 
{
    
    public int[] countBits(int num)
    {
        if(num==0)
            return new int[]{0};
        if(num==1)
            return new int[]{0,1};
        int ans[]=new int[num+1];
        int k=1;
        ans[0]=0;ans[1]=1;ans[2]=1;
        int last1BitNum=2;
        for(int i=3;i<=num;i++)
        {
            if(i==last1BitNum*2)
            {
                last1BitNum=i;
                ans[i]=1;
            }
            else
                ans[i]=ans[last1BitNum]+ans[i-last1BitNum];
        }
        return ans;
    }
}
