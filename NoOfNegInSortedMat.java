
public class NoOfNegInSortedMat {
	static int count=0;
	public static void main(String[] args) {
		int ar[][]=new int[][] {{4,3,2,-1},{3,2,1,-1},{1,1,-1,-2},{-1,-1,-2,-3}};
		System.out.println(findCount(ar));
	}

	private static int findCount(int[][] ar) {
		int count=0;
		int m=ar.length;int n=ar[0].length;
		int r=0,c=m-1;
		while(r<m && c>=0) {
			if(ar[r][c]<0) {
				count+=m-r;
				c--;
			}
			else
				r++;
		}
		return count;
		
	}

	
}
