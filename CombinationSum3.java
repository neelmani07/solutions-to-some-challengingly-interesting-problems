/*
 * Find all valid combinations of k numbers that sum up to n such that the following conditions are true:

Only numbers 1 through 9 are used.
Each number is used at most once.
Return a list of all possible valid combinations. 
The list must not contain the same combination twice, 
and the combinations may be returned in any order.
 */
package leetcode;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {

	public static void main(String[] args) {
		List<List<Integer>> ans=combinationSum3(3,9);
		System.out.println(ans);
	}

	public static List<List<Integer>> combinationSum3(int k, int n) {
	    List<List<Integer>> ans = new ArrayList<>();
	    combination(ans, new ArrayList<Integer>(), k, 1, n);
	    return ans;
	}

	private static void combination(List<List<Integer>> ans, List<Integer> comb, int k,  int start, int n) {
		if (comb.size() == k && n == 0) {
			List<Integer> li = new ArrayList<Integer>(comb);
			ans.add(li);
			return;
		}
		//for (int i = start; i <= 9; i++) {
		int i=start;
		if(i<=9) {
			comb.add(i);
			combination(ans, comb, k, i+1, n-i);
			comb.remove(comb.size() - 1);
			combination(ans, comb, k, i+1, n);
		}
	}
	
}
