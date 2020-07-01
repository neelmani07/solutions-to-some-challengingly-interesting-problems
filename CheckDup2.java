package leetcode;
/*
 * 
 * Given an array of integers and an integer k, 
 * find out whether there are two distinct indices i and j in 
 * the array such that nums[i] = nums[j] and the absolute 
 * difference between i and j is at most k.

Example 1:

Input: nums = [1,2,3,1], k = 3
Output: true

Example 2:

Input: nums = [1,0,1,1], k = 1
Output: true

Example 3:

Input: nums = [1,2,3,1,2,3], k = 2
Output: false


 */
import java.util.HashMap;

public class CheckDup2 {

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        
    	HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            
            if(map.containsKey(nums[i]))
            {
                int diff=Math.abs(map.get(nums[i])-i);
                if(diff<=k)
                    return true;
            }
            map.put(nums[i],i);
            System.out.println(map);
            
        }
        return false;
    }
    public static void main(String a[])
    {
    	int ar[]=new int[] {1,2,3,1,2,3};
    	System.out.println(containsNearbyDuplicate(ar,2));
    }
}