import java.util.Scanner;

public class MMTWarehouses {
	public static void main(String[] args) {
		int graph[][]=new int[10][10];
		fillGraph(graph);
		System.out.println(findMin(graph));
	}
	public static int count=0;
	private static int findMin(int [][]g) {
		int warehouses[]=new int[g.length];
		for(int i=0;i<g.length;i++) {
			if(hasNoNeighbourWithWareHouse(g,i,warehouses)){
				count++;warehouses[i]=1;
				setNeighboursWithWarehouses(g,i,warehouses);
			}
		}
		return count;
	}

	private static void setNeighboursWithWarehouses(int[][] g, int src, int[] warehouses) {
		for(int i=0;i<g.length;i++) {
			if(g[src][i]==1 ) {
				warehouses[i]=1;
			}			
		}		
	}

	private static boolean hasNoNeighbourWithWareHouse(int[][] g, int src, int[] warehouses) {
		int c=0;
		for(int i=0;i<g.length;i++) {
			if(g[src][i]==1 && warehouses[i]==1)
				c++;
		}
		return c==0?true:false;
	}

	private static void fillGraph(int [][]g) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		for(int ent=1;ent<=n;ent++) {
			int s=sc.nextInt();
			int d=sc.nextInt();
			g[s-1][d-1]=g[d-1][s-1]=1;
		}
		
	}

}
