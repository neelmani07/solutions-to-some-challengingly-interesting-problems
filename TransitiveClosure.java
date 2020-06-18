/*
 * This problem was asked by Microsoft.

The transitive closure of a graph is a measure of which vertices are reachable from other vertices. It can be represented as a matrix M, where M[i][j] == 1 if there is a path between vertices i and j, and otherwise 0.

For example, suppose we are given the following graph in adjacency list form:

graph = [
    [0, 1, 3],
    [1, 2],
    [2],
    [3]
]

The transitive closure of this graph would be:

[1, 1, 1, 1]
[0, 1, 1, 0]
[0, 0, 1, 0]
[0, 0, 0, 1]

Given a graph, find its transitive closure.
 */
import java.util.*;

public class TransitiveClosure {
	
	static int sZ=0;
	public static void setUpMat(int [][]matrix,ArrayList<ArrayList<Integer>> graph) 
	{
		for(int i=0;i<graph.size();i++)
		{
			List<Integer> nodesConect=graph.get(i);
			for(int k=0;k<nodesConect.size();k++)
				matrix[nodesConect.get(0)][nodesConect.get(k)]=1;
			
		}
	}
	public static boolean findTransitiveClosure(int matrix[][],int i,int j)
	{
		if(matrix[i][j]==1)
			return true;
		for(int k=0;k<sZ;k++)
		{
			if(k!=i && matrix[i][k]==1)
			return findTransitiveClosure(matrix,k,j);	
		}
		return false;
	}
	public static void prin(int matrix[][])
	{
		// displaying graph
				for(int i=0;i<matrix.length;i++)
				{	
					for(int j=0;j<matrix.length;j++)
						System.out.print(matrix[i][j]);
					System.out.println();
				}
	}
	public static void main(String s[])
	{
		//getting input
		ArrayList<ArrayList<Integer>> graph=new ArrayList<ArrayList<Integer>>();
		graph.add(new ArrayList(Arrays.asList(0,1,3)));
		graph.add(new ArrayList(Arrays.asList(1, 2)));
		graph.add(new ArrayList(Arrays.asList(2)));
		graph.add(new ArrayList(Arrays.asList(3)));
		sZ=graph.size();
		
		//setting up matrix
		int matrix[][]=new int[sZ][sZ];
		setUpMat(matrix,graph);
		prin(matrix);
		
		//setting up transitive closure
		
		for(int i=0;i<matrix.length;i++)
		{	
			for(int j=0;j<matrix.length;j++)
			{
				if(matrix[i][j]==0 && findTransitiveClosure(matrix,i,j))
					matrix[i][j]=1;
			}
		}
		System.out.println();
		
		prin(matrix);
		
		
	}
	

}
