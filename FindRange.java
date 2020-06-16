/*
Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].
*/

class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0) {
            return new int[] {-1, -1};
        }
        if(nums.length == 1) {
            if(nums[0] == target) {
                return new int[] {0, 0};
            } 
            return new int[] {-1, -1};
        }
        
        //binary search implementation
        int start=0, end = nums.length-1;
        int mid = 0;
        
        while(start<=end) {
            mid = (start+end) / 2;
           
            if(nums[mid] > target) end = mid -1;
            else if(nums[mid] < target) start = mid +1;
            else {
                int left = mid-1; //to store the left margin of the target
                while(left>= 0 && nums[left] == nums[mid]) left--;
                int right = mid+1; //to store the right margin of target
                while(right<nums.length && nums[right] == nums[mid]) right++;
                return new int[] {left+1, right-1};
            }
        }
        
        return new int[] {-1, -1};
    }
}
