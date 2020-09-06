package Graphs;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class TopoSort {
	public static void main(String[] args) {
		int gp[][]=new int[][] {{0,0,1,0,0,0,0},{0,0,1,1,0,0,0},{0,0,0,0,1,0,0},
							{0,0,0,0,0,1,0},{0,0,0,0,0,1,0},{0,0,0,0,0,0,1},{0,0,0,0,0,0,0}};
		Stack<Integer> stk = new Stack<Integer>();
		Set<Integer> set=new HashSet<Integer>();
		for(int n=0;n<gp.length;n++) {
			if(!set.contains(n)) {
				set.add(n);
				topSort(gp,stk,set,n);
			}
		}
		while(!stk.empty())
			System.out.print(stk.pop()+"->");
	}

	private static void topSort(int[][] gp, Stack<Integer> stk, Set<Integer> set,int i) {
		if(i>=gp.length)
			return;
		for(int j=0;j<gp[0].length;j++) {
			if(gp[i][j]==1 && !set.contains(j)) {
				set.add(j);
				topSort(gp,stk,set,j);
					
			}
		}
		stk.add(i);
	}

	
}
