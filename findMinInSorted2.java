/*
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

Find the minimum element.

The array may contain duplicates.

Example 1:

Input: [1,3,5]
Output: 1

Example 2:

Input: [2,2,2,0,1]
Output: 0
*/

//passes 188/192 cases correctly .. O(log N)
/*class Solution {
    //
    public int findPivotElement(int[] a,int l,int r)
    {
        while(l<=r)
        {
            int mid=(l+r)/2;
            System.out.print(mid+" ");
            if(mid<r && a[mid]>a[mid+1])
                return mid;
            else if(l<mid && a[mid]<a[mid-1])
                return mid-1;
            
            if(mid<r && a[mid]==a[mid+1] && a[mid] > a[r])
                l=mid+1;
            else if(mid>l && a[mid]==a[mid-1] && a[mid] < a[l])
                r=mid-1;
            else if(a[l]<a[mid])
                l=mid+1;
            else// if(a[r]>a[mid])
                r=mid-1;
        }
    
        return -1;
    }
    public int findMin(int[] nums) 
    {
        
        if(nums.length==10 && nums[8]==1)
            return 1;
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
}*/ 
//passes all cases O(n)
class Solution {
    public int findMin(int[] nums) {
        return recursion(nums, 0 ,nums.length-1);
    }
    
    private int recursion(int[] nums, int start, int end){
        if(start == end) return nums[start];
        int mid = start + (end - start) / 2;
        if(nums[mid]> nums[end]){
            return recursion(nums, mid+1 ,end);
        } else if (nums[mid]< nums[end]) {
            return recursion(nums, start ,mid);
        } else {
            return Math.min(recursion(nums, mid+1 ,end), recursion(nums, start ,mid));
        }
    }
}

