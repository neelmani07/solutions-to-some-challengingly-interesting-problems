package leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
//program to find the longest path from root to each vertices in terms values not length.
//-ve value are also there which can reduce the paths values.
public class GoogleMockTest {
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("enter no of vertices");
		int n=sc.nextInt();
		int gp[][]=new int[n][n];
		System.out.println("enter no of paths");
		int noP=sc.nextInt();
		for(int i=0;i<noP;i++) {
			int src=sc.nextInt();
			int dest=sc.nextInt();
			gp[src-1][dest-1]=gp[dest-1][src-1]=1;
		}
		System.out.println("enter the values of nodes");
		int val[]=new int[n];
		for(int i=0;i<n;i++)
			val[i]=sc.nextInt();
		int parent[]=new int[n];
		int ans[]=new int[n];
		Arrays.fill(ans, -99);;
		find(gp,val,parent,ans);
	}

	private static void find(int[][] gp, int[] val, int[] parent, int[] ans) {
		ans[0]=val[0];parent[0]=0;
		for(int i=0;i<gp.length;i++) {
			for(int j=0;j<gp[0].length;j++) {
				if(gp[i][j]==1 && parent[i]!=j) {
					if(val[i]<0) {
						ans[j]=(ans[i]+val[i]+val[j])>ans[i]?(ans[i]+val[i]+val[j]):ans[i];
						parent[j]=i;
					}
					else {
						ans[j]=(ans[i]+val[j])>ans[i]?(ans[i]+val[j]):ans[i];
						parent[j]=i;
					}
				}
			}
		}
		for(int i=0;i<ans.length;i++)
			System.out.println(ans[i]+" ");
	}
}