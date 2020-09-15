
public class SearchInSortedMat {
	public static void main(String[] args) {
	
		int ar[][]=new int [][] {{9,6,3,-2},{8,4,2,-4},{7,3,1,-6},{6,2,0,-8}};
		System.out.println(findKey(ar,10));
	}

	private static boolean findKey(int[][] ar, int key) {
		int m=ar.length;int n=ar[0].length;
		int r=0,c=m-1;
		while(r<m && c>=0) {
			if(ar[r][c]==key) {
				return true;
			}
			else if(ar[r][c]<key)
				c--;
			else
				r++;
		}
		return false;
	}
	

}
