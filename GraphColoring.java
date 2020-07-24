import java.util.Scanner;

public class GraphColoring {
	
	public static void fillMat(int mat[][]) {
		int v=mat.length;
		Scanner sc=new Scanner (System.in);
		for(int i=0;i<v;i++) {
			for(int j=0;j<v;j++) {
				mat[i][j]=sc.nextInt();
			}
		}
	}
	public static boolean noNeighbourHasSameColor(int n,int col,int [][]mat,int colors[]) {
		
		for(int v=0;v<mat.length;v++) {
			if(mat[n][v]==1 && colors[v]==col)
				return false;
		}
		return true;
		
	}
	public static void dispColors(int colors[]) {
		for(int i=0;i<colors.length;i++) {
			switch(colors[i]) {
			case 1:System.out.print("Red ");
					break;
			case 2:System.out.print("Blue ");
					break;
			case 3:System.out.print("Gree ");
					break;
			case 4:System.out.print("Yellow ");
					break;
			}
		}
		System.out.println();
	}
	public static void colorTheGraph(int mat[][],int colors[],int noOfCol,int curV) {
		
		int v=mat.length;
		for(int col=1;col<=noOfCol;col++) {
			if(noNeighbourHasSameColor(curV,col,mat,colors))
			{
				colors[curV]=col;
				if(curV==v-1) {
					dispColors(colors);
					return;
				}
				colorTheGraph(mat,colors,noOfCol,curV+1);
			}
				
		}
		
		
	}
	public static void main(String a[])
	{
		Scanner sc=new Scanner (System.in);
		System.out.println("enter the no of vertice");
		int v=sc.nextInt();
		int mt[][]=new int[v][v];
		fillMat(mt);
		int colors[]=new int[v];
		colorTheGraph(mt,colors,4,0);
		for(int i=0;i<v;i++)
			System.out.print(colors[i]+" ");
	}

}
/*
 * {0, 1, 1, 1},
        {1, 0, 1, 0},
        {1, 1, 0, 1},
        {1, 0, 1, 0}*/
