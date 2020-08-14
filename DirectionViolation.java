import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * This problem was asked by Uber.

A rule looks like this:

A NE B

This means this means point A is located northeast of point B.

A SW C

means that point A is southwest of C.

Given a list of rules, check if the sum of the rules validate. For example:

A N B
B NE C
C N A

does not validate, since A cannot be both north and south of C
 */
public class DirectionViolation {
	
	public static void main(String[] args) {
		int North_SouthGraph[][] =new int[3][3];
		int East_WestGraph[][] =new int[3][3];
		System.out.println(checkForViolation(North_SouthGraph,East_WestGraph));
		
	}

	private static boolean checkForViolation(int[][] north_SouthGraph, int[][] east_WestGraph) {
		Scanner sc=new Scanner(System.in);
		for(int i=0;i<3;i++) {
			int n1=sc.nextInt();
			String direct=sc.next();
			int n2=sc.nextInt();
			
			if(direct.equals("N")|| direct.equals("S")) {
				addInNorthMap(north_SouthGraph,n1,direct,n2);
			}
			else if(direct.equals("W") || direct.equals("E") ) {
				addInEastMap(east_WestGraph,n1,direct,n2);
			}
			else {
				addInNorthMap(north_SouthGraph,n1,direct,n2);
				addInEastMap(east_WestGraph,n1,direct,n2);
			}
		}
		List<Integer> white= new ArrayList<Integer>();
		List<Integer> black= new ArrayList<Integer>();
		List<Integer> grey= new ArrayList<Integer>();
		white.add(1);white.add(2);
		grey.add(0);
		if(hasCycles(north_SouthGraph,0,white,black,grey)||hasCycles(east_WestGraph,0,white,black,grey)) {
			return true;
		}
		return false;
	}

	private static boolean hasCycles(int[][] east_WestGraph,int u,List<Integer> white,List<Integer> black,List<Integer>grey) {
		for(int v=0;v<east_WestGraph.length;v++) {
			
			if(east_WestGraph[u][v]==1) {
				if(grey.contains(v))return true;
				white.remove((new Integer(v)));
				grey.add(v);
				return hasCycles(east_WestGraph,v,white,black,grey);
			}
		}
		grey.remove((new Integer(u)));
		black.add(u);
		return false;
	}

	private static void addInEastMap(int[][] east_WestGraph, int n1, String direct, int n2) {
		if(direct.equals("E") || direct.equals("NE") || direct.equals("SE"))
			east_WestGraph[n1][n2]=1;
		else
			east_WestGraph[n2][n1]=1;
		
		
	}

	private static void addInNorthMap(int[][] north_SouthGraph, int n1, String direct, int n2) {
		if(direct.equals("N") || direct.equals("NE") || direct.equals("NW"))
			north_SouthGraph[n1][n2]=1;
		else
			north_SouthGraph[n2][n1]=1;
		
	}

}
