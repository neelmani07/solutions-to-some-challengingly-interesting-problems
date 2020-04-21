import java.util.*;
class SlidingWindow
{
    public static int[] maxSlidingWindow(int[] nums, int k)
    {
        int ans[]=new int[nums.length-k+1];int n=0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int arr1[], int arr2[]) {
                return arr2[0] - arr1[0];
            }
        });
        
        for(int i=0;i<k;i++)
        {
            pq.add(new int[]{nums[i],i});
        }
        int temp[]=pq.peek();       
        ans[n++]=temp[0];int strtI=0;
        
        for(int i=k;i<nums.length;i++,strtI++)
        {
             pq.add(new int[]{nums[i],i});
             
             int ar[]=pq.peek();
             while(ar[1]<=strtI)
             {
                 pq.remove();
                 ar=pq.peek();
             }
             ans[n++]=ar[0];
             
                 
        }
       
        return ans;
        
    }
    public static void main(String s[])
    {
	int nums[]={1,3,-1,-3,5,3,6,7,3};
	int k=3;
	int[] ans=maxSlidingWindow(nums,k);
	for(int i=0;i<ans.length;i++)
	System.out.print(ans[i]+" ");
	 

    }
}
