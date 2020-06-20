/*

Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

    Integers in each row are sorted from left to right.
    The first integer of each row is greater than the last integer of the previous row.

Example 1:

Input:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 3
Output: true

*/
class Solution {
    
    public static int findRowUsingBinSearch(int [][]mat,int st,int end,int key) {
        
        while(st<=end)
        {
           int  mid=st+(end-st)/2;
            if(mat[mid][0]<=key && mat[mid][mat[0].length-1]>=key)
                return mid;
            if(mat[mid][mat[0].length-1]<key)
                st=mid+1;
            else
                end=mid-1;
        }
        return -1;
        
        
    }    
    public static boolean checkColUsingBinSearch(int [][] mat,int rowToSearch,int l,int r,int key) {
        
        while(l<=r)
        {
            int mid=l+(r-l)/2;
            if(mat[rowToSearch][mid]==key)
                return true;
            if(mat[rowToSearch][mid] > key)
                r=r-1;
            else
                l=l+1;
        }
        return false;
        
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        
        if(matrix.length==0 || matrix[0].length==0)return false;
        int r=matrix.length;
        int c=matrix[0].length;
        
        int targetRow=findRowUsingBinSearch(matrix,0,r-1,target);
        if(targetRow==-1) return false;
        return checkColUsingBinSearch(matrix,targetRow,0,c-1,target);
        
        
    }
}
