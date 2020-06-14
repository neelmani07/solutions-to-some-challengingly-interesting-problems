/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
/*    using inoreder from left direction.
class Solution {
    
    int ar[]=new int[101];
    int k=0;
    
    public void inOrderExtract(TreeNode root) {
        if(root == null)
            return;
        inOrderExtract(root.left);
        ar[k++]=root.val;
        inOrderExtract(root.right);
        
    }
    public void inOrderPut(TreeNode root) {
        if(root == null)
            return;
        inOrderPut(root.left);
        root.val=ar[k++];
        inOrderPut(root.right);
        
    }
    public TreeNode bstToGst(TreeNode root) {
        
        inOrderExtract(root);
        for(int j=98;j>=0;j--)
            ar[j]=ar[j]+ar[j+1];
        k=0;
        inOrderPut(root);
        return root;
    }
}
*/
//  sol 2:   using inoreder from right direction
class Solution {
    int sum =0;
    public TreeNode bstToGst(TreeNode root) {
        
        if(root == null)
            return null;
        bstToGst(root.right);
        sum = sum + root.val;
        root.val = sum;
        bstToGst(root.left);
    return root;
    }
}
