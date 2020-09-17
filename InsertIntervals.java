package leetcode;

import java.util.ArrayList;
import java.util.List;

public class InsertIntervals {
	public static void main(String[] args) {
		int intervals[][] =new int[][] {{1,2},{3,5},{6,7},{8,10},{12,16}};
		int newInterval[] = new int[] {4,6};
		intervals=insert(intervals,newInterval);
		
	}
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        int start = newInterval[0];
        int end = newInterval[1];
        List<int[]> list = new ArrayList<>();
        for (int[]interval : intervals) {
            int curStart = interval[0];
            int curEnd = interval[1];
            if (curEnd < start) {
                list.add(new int[]{curStart, curEnd});
            } else if (curStart > end) {
                list.add(new int[]{start, end});
                start = curStart;
                end = curEnd;
            } else {
                start = Math.min(start, curStart);
                end = Math.max(end, curEnd);
            }  
        }
        list.add(new int[]{start, end});
        int[][] res = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            res[i][0] = list.get(i)[0];
            res[i][1] = list.get(i)[1];
            System.out.println(res[i][0]+","+res[i][1]);
        }
        return res;
    }      
}