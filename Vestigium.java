//2020  qualification round  https://codingcompetitions.withgoogle.com/codejam/round/000000000019fd27/000000000020993c
/*
 * Problem:=

Vestigium means "trace" in Latin. In this problem we work with Latin squares and matrix traces.
The trace of a square matrix is the sum of the values on the main diagonal (which runs from the
upper left to the lower right).

An N-by-N square matrix is a Latin square if each cell contains one of 
N different values, and no value is repeated within a row or a column. 
In this problem, we will deal only with "natural Latin squares" in which 
the N values are the integers between 1 and N.

Given a matrix that contains only integers between 1 and N, 
we want to compute its trace and check whether it is a natural Latin square. 
To give some additional information, instead of simply telling us whether the matrix is a natural Latin square or not, 
please compute the number of rows and the number of columns that contain repeated values.

Input

The first line of the input gives the number of test cases, T. 
T test cases follow. 
Each starts with a line containing a single integer N: the size of the matrix to explore. 
Then, N lines follow. The i-th of these lines contains N integers Mi,1, Mi,2 ..., Mi,N. 
Mi,j is the integer in the i-th row and j-th column of the matrix.
Output

For each test case, output one line containing Case #x: k r c, 
where x is the test case number (starting from 1), 
k is the trace of the matrix, 
r is the number of rows of the matrix that contain repeated elements, and 
c is the number of columns of the matrix that contain repeated elements. 
 */
package CodeJam;
import java.util.*;

public class Vestigium {
	
	public static String giveTrace(int caseNo)
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		HashSet<Integer> checkDup=new HashSet<Integer>();
		int mat[][]=new int[n][n];int trace=0;
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				mat[i][j]=sc.nextInt();
				if(i==j)trace+=mat[i][j];
			}
		}
		//checking for duplicates rows
		int dupR=0;
		for(int row=0,col=0;row<n;row++)
		{
			checkDup.clear();
			for(col=0;col<n;col++)
			{
				if(checkDup.contains(mat[row][col]))
				{
					dupR++;break;
			    }
				checkDup.add(mat[row][col]);
			}			
		}
		//for checking duplicates columns
		int dupC=0;
		for(int col=0,row;col<n;col++)
		{
			checkDup.clear();
			for(row=0;row<n;row++)
			{
				if(checkDup.contains(mat[row][col]))
				{
					dupC++;break;
			    }
				checkDup.add(mat[row][col]);
			}
		}
		String res="Case #"+caseNo+": "+trace+" "+dupR+" "+dupC;
		return res;
		
	}
	public static void main(String s[])
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		String []ans=new String[n];
		
		for(int i=0;i<n;i++)
		{
			ans[i]=giveTrace(i);
		}
		for(int i=0;i<n;i++)
		{
			System.out.println(ans[i]);
		}
	}

}
