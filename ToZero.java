package leetcode;

public class ToZero {
    public static int minOperations(int[] nums, int x) {
        int count=0;
        int left=0;int right=nums.length-1;
        return find(nums,left,right,count,x);
        
    }
    public static int find(int nums[],int l,int r,int c,int x){
        if(x==0)
            return c;
        if(l>r)
            return -1;
        if(nums[l]>x){
            
            x=x-nums[r];
            r=r-1;
        }
        
        else if(nums[r]>x){
           
            x=x-nums[l];
            l=l+1;
        }
        else{
            int dif1=x-nums[l];
            int dif2=x-nums[r];
            if(dif1<dif2){
                
                x=x-nums[l];
                l=l+1;
            }
            else{
                
                x=x-nums[r];
                r=r-1;
            }
        }
        System.out.println(c + " "+ r+" "+l+" "+x);
        return find(nums,l,r,c+1,x);
        
    }
    public static void main(String arg[]) {
    	int arr[]= {8828,9581,49,9818,9974,9869,9991,10000,10000,10000,9999,9993,9904,8819,1231,6309};
    	System.out.println(minOperations(arr,134365));
    }
}