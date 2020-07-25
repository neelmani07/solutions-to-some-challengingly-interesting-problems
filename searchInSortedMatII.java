package CTCI;

public class searchInSortedMatII {
	public static boolean searchMatrix(int[][]a, int target) {
        int n = a.length;
        if(n==0) return false;
        int m = a[0].length;
        int i=0;
        int j=m-1;
        while(i<n && j>=0)
        {
            if(a[i][j]==target)
            {
                return true;
            }
            else if(target > a[i][j])
                i++;
            else 
                j--;
        }
        return false;
    }

	public static void main(String arg[]) {
		
		int mat[][] =new int[][]{{15,20,40,85},{20,35,80,95},{30,55,95,105},{40,80,100,120}};
		System.out.print("element is present="+searchMatrix(mat,855));
		
	}

}
