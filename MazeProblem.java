/*
 * This problem was asked by Google.

You are given an M by N matrix consisting of booleans that represents a board. 
Each True boolean represents a wall. Each False boolean represents a tile you can walk on.

Given this matrix, a start coordinate, and an end coordinate, 
return the minimum number of steps required to reach the end coordinate from the start. 
If there is no possible path, then return null. You can move up, left, down, and right. 
You cannot move through walls. You cannot wrap around the edges of the board.

For example, given the following board:

[[f, f, f, f],
[t, t, f, t],
[f, f, f, f],
[f, f, f, f]]
and start = (3, 0) (bottom left) and end = (0, 0) (top left), 
the minimum number of steps required to reach the end is 7, 
since we would need to go through (1, 2) because there is a wall everywhere else on the second row.
 */
public class MazeProblem {
	public static void main(String[] args) {
		int maze[][]=new int[][] {{0, 0, 0, 0},{1, 1, 0, 1}, {0, 0, 0, 0},{0, 0, 0, 0}};
		System.out.println(findMinPaths(maze,3,0,0,0));
	}

	private static int findMinPaths(int[][] maze, int srci, int srcj, int desi, int desj) {
		if(srci==maze.length || srcj==maze.length || srci<0 || srcj<0 || maze[srci][srcj]==1)
			return 99;
		if(srci==desi && srcj==desj)
			return 1;
		maze[srci][srcj]=1;
		int up=findMinPaths(maze,srci-1,srcj,desi,desj);
		int down=findMinPaths(maze,srci+1,srcj,desi,desj);
		int left=findMinPaths(maze, srci, srcj-1, desi, desj);
		int right=findMinPaths(maze,srci,srcj+1,desi,desj);
		maze[srci][srcj]=0;
		return 1+Math.min(Math.min(Math.min(up,down),left),right);
	}
}
