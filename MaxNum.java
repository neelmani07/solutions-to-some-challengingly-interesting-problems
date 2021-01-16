/*
 * You are given an integer n. An array nums of length n + 1 is generated in the following way:

nums[0] = 0
nums[1] = 1
nums[2 * i] = nums[i] when 2 <= 2 * i <= n
nums[2 * i + 1] = nums[i] + nums[i + 1] when 2 <= 2 * i + 1 <= n
Return the maximum integer in the array nums​​​.
 * 
 */
public class MaxNum {
    public int getMaximumGenerated(int n) {
        if(n==0)
            return 0;
        if(n==1)
            return 1;
        int max=0;
        int arr[]=new int[n+1];
        arr[0]=0;arr[1]=1;
        for(int i=2;i<=n;i++){
            if(i%2==0){
                arr[i]=arr[i/2];
                
            }
            else{
                arr[i]=arr[(i-1)/2]+arr[(i+1)/2];
            }
            max=Math.max(max,arr[i]);
        }
        return max;
    }
}