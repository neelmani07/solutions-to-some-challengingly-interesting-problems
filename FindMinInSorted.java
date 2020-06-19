/*
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

Find the minimum element.

You may assume no duplicate exists in the array.

Example 1:

Input: [3,4,5,1,2] 
Output: 1


*/

class Solution {
    
    public int findPivotElement(int[] a,int l,int r)
    {
        while(l<=r)
        {
            int mid=(l+r)/2;
            
            if(mid<r && a[mid]>a[mid+1])
                return mid;
            else if(l<mid && a[mid]<a[mid-1])
                return mid-1;
            
            if(a[l]<a[mid])
                l=mid+1;
            else
                r=mid-1;
        }
    
        return -1;
    }
    public int findMin(int[] nums) {
        
        if(nums.length==0)
            return 0;
        if(nums.length==1)
            return nums[0];
        int pivotInd=findPivotElement(nums,0,nums.length-1);
        if(pivotInd==-1)
            return nums[0];
        else
            return nums[pivotInd+1];
        
    }
}
