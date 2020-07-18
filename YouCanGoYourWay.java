/*
 *  You have just entered the world's easiest maze. You start in the northwest cell of an N by N grid of unit cells, and you must reach the southeast cell. You have only two types of moves available: a unit move to the east, and a unit move to the south. You can move into any cell, but you may not make a move that would cause you to leave the grid.

You are excited to be the first in the world to solve the maze, but then you see footprints. Your rival, Labyrinth Lydia, has already solved the maze before you, using the same rules described above!

As an original thinker, you do not want to reuse any of Lydia's moves. Specifically, if her path includes a unit move from some cell A to some adjacent cell B, your path cannot also include a move from A to B. (However, in that case, it is OK for your path to visit A or visit B, as long as you do not go from A to B.) Please find such a path.

In the following picture, Lydia's path is indicated in blue, and one possible valid path for you is indicated in orange:

https://codingcompetitions.withgoogle.com/codejam/round/0000000000051705/00000000000881da
 */

package CodeJam;

public class YouCanGoYourWay {
	
	public static String findYourWay(String s)
	{
		String res="";
		for(int i=0;i<s.length();i++)
		{
			if(s.charAt(i)=='E')
				res+='S';
			else
				res+='E';
		}
		return res;
	}
	public static void main(String str[])
	{
		System.out.print(findYourWay("EESSSESE"));
	}

}
