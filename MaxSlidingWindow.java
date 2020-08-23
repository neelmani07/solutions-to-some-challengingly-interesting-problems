package leetcode;

public class MaxSlidingWindow {

}
//19 ms
/*class Solution {
public int[] maxSlidingWindow(int[] nums, int k) {
    int ans[]=new int[nums.length-k+1];int o=0;
    int lstMInd=-1;int mx=0;
    //finding for 1st k window
    for(int i=0;i<k;i++){
        if(mx<nums[i]){
            mx=nums[i];lstMInd=i;
        }
    }
    ans[o]=mx;o++;
    int st=0;
    for(int i=k;i<nums.length;i++){
        if(nums[i]>mx){
            mx=nums[i];lstMInd=i;
            st++;
            ans[o++]=mx;
            
        }
        else if(st<lstMInd){
            ans[o++]=mx;st++;
        }
        else{int tmp=-99;
            for(int b=st+1;b<=i;b++){
                if(tmp<nums[b])
                   tmp=nums[b];lstMInd=b;
            }
            mx=tmp;ans[o++]=mx;st++;
        }
    }
    return ans;
            
        
}
}*///3ms
class Solution {
public int[] maxSlidingWindow(int[] nums, int k) {
    if(nums == null || nums.length == 0 || k ==0) return null;
    if( k == 1) return nums;
    int[] res = new int[nums.length- k + 1];
    int preMax = findMax(nums,0,k);
    res[0] = preMax;
    for(int i = 1; i < nums.length- k + 1; i++){
        if(preMax == nums[i-1]){
            preMax = findMax(nums,i,i+k);
            
        }else{
            preMax = Math.max(preMax,nums[i+k-1]);
        }
        res[i] = preMax;
    }
    return res;
}

public int findMax(int[] nums, int start, int end){
    int max = 0;
    for(int i = start; i < end; i++){
        max = Math.max(nums[i], max);
    }
    return max;
}
}