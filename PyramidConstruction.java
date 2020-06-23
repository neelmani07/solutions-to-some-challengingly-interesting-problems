/*
 * This problem was asked by Uber.

You have N stones in a row, and would like 
to create from them a pyramid. This pyramid 
should be constructed such that the height of
 each stone increases by one until reaching the
  tallest stone, after which the heights decrease
   by one. In addition, the start and end stones
    of the pyramid should each be one stone high.

You can change the height of any stone by paying 
a cost of 1 unit to lower its height by 1, as
 many times as necessary. Given this information,
  determine the lowest cost method to produce this pyramid.

For example, given the stones [1, 1, 3, 3, 2, 1],
the optimal solution is to pay 2 to create [0, 1, 2, 3, 2, 1].
 */
public class PyramidConstruction 
{
    public static int minCost(int[] stones) {
        int n = stones.length;
        int[] left = new int[n], right = new int[n];
        left[0] = 1;
        for(int i = 1; i < n; i++) {
            left[i] = Math.min(left[i - 1] + 1, stones[i]);
        }
        right[n - 1] = 1;
        for(int i = n - 2; i >= 0; i--) {
            right[i] = Math.min(right[i + 1] + 1, stones[i]);
        }
        
        int maxHeight = 0, centerIdx = -1;
        for(int i = 0; i < n; i++) {
            int currHeight = Math.min(left[i], right[i]);
            if(currHeight > maxHeight) {
                maxHeight = currHeight;
                centerIdx = i;
            }
        }
        return getCost(stones, maxHeight, centerIdx);
    }
    private static int getCost(int[] stones, int maxHeight, int centerIdx) {
        int cost = 0, h = maxHeight;
        for(int i = centerIdx; i >=0; i--) {
            if(h > stones[i]) {
                return -1;
            }
            cost += stones[i] - h;
            if(h > 0) {
                h--;
            }
        }
        h = maxHeight - 1;
        for(int i = centerIdx + 1; i < stones.length; i++) {
            if(h > stones[i]) {
                return -1;
            }
            cost += stones[i] - h;
            if(h > 0) {
                h--;
            }
        }
        return cost;
    }
    public static void main(String[] args) {
        int[] stones = {1, 1, 3, 3, 2, 1};
        System.out.println(minCost(stones));
    }
	
}
