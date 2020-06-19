/*

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Your algorithm's runtime complexity must be in the order of O(log n).

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4

*/
class Solution {
    public int search(int[] nums, int target) {
        
        int l=0,r=nums.length;
        int pivot=findPivotElement(nums,l,r-1);
        
        if(pivot==-1)
            return binarySearch(nums,l,r-1,target);
        else if(nums[pivot]==target)
            return pivot;
        else if(nums[0]<=target)
            return binarySearch(nums,l,pivot-1,target);
        else
            return binarySearch(nums,pivot+1,r-1,target);
        
    }
    
    
    public int binarySearch(int[] a,int l,int r,int val)
    {
        while(l<=r)
        {
            int mid=(l+r)/2;
            if(a[mid]==val)
                return mid;
            else if(a[mid]>val)
                r=mid-1;
            else
                l=mid+1;
        }
        return -1;
    }
    
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
}
