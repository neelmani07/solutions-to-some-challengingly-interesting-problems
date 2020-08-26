 i[
 [P/S
 =[P
 ZXC'?
 [/mport java.util.Hashtable;
import java.util.Map.Entry;
import java.util.Set;
import java.util.*;
import java.lang.*;
class KthMostFrequent 
{
    public static List<Integer> topKFrequent(int[] nums, int k)
    {
        List<Integer> list = new ArrayList<Integer>();
        
		//comparator that will sort acording to the number of occurences
        PriorityQueue<int[]> maxHeap = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int arr1[], int arr2[]) {
                return arr2[1] - arr1[1];
            }
        });
        
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
    
        for(int i=0;i<nums.length;i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1); //O(1)
        }
        
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            maxHeap.add(new int[]{entry.getKey(), entry.getValue()});  
        } 
        
        while(k > 0) {
            int arr[] = maxHeap.poll();
            list.add(arr[0]);
            k--;
        }
        
        //System.out.println(list);
        
        return list;
        




    }
    public static void main(String s[])
    {
    	int n[]={1,1,1,1,1,2,2,3,3,3,7,7,7,7,7,7,7,8,8,8,8};
    	System.out.println(topKFrequent(n,2));
    }
}
/*
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        
        List<Integer> list = new ArrayList<Integer>();
        
		//comparator that will sort acording to the number of occurences
        PriorityQueue<int[]> maxHeap = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int arr1[], int arr2[]) {
                return arr2[1] - arr1[1];
            }
        });
        
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
    
        for(int i=0;i<nums.length;i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1); //O(1)
        }
        
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            maxHeap.add(new int[]{entry.getKey(), entry.getValue()});  
        } 
        
        while(k > 0) {
            int arr[] = maxHeap.poll();
            list.add(arr[0]);
            k--;
        }
        
        //System.out.println(list);
        
        return list;
        
    }
}

*/
