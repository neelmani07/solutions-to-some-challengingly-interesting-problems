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
class Solution
{
    int sum=0;
    public void recurse(TreeNode root, int L, int R)
    {
        if(root == null)
            return;
        if(root.val <= R && root.val >= L)
            sum+=root.val;
        if(root.right!=null)
            rangeSumBST(root.right,L,R) ;
        if(root.left!=null)
            rangeSumBST(root.left,L,R) ;
    }
    public int rangeSumBST(TreeNode root, int L, int R) 
    {
        recurse(root,L,R);
        return sum;
    }
}
