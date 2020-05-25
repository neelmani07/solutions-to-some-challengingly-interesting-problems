/*
Given a collection of intervals, merge all overlapping intervals.

Example 1:

Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].

Example 2:

Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
*/
class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length <= 1) return intervals;
        
        Arrays.sort(intervals, (arr1, arr2) -> Integer.compare(arr1[0], arr2[0]));
        
        ArrayList<int[]> res = new ArrayList();
        int[] current = null;
        
        for(int[] next : intervals){
            if(current == null || current[1] < next[0]){
                res.add(next);
                current = next;
            }else{
                current[1] = Math.max(current[1], next[1]);
            }
        }
        
        return res.toArray(new int[0][]);
    }
}

