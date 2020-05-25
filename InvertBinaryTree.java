/*
Invert a binary tree.

Example:

Input:

     4
   /   \
  2     7
 / \   / \
1   3 6   9

Output:

     4
   /   \
  7     2
 / \   / \
9   6 3   1
*/


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
    public TreeNode invert(TreeNode root)
    {
        if(root==null)
            return null;
        if(root.left == null && root.right == null)
            return root;
        TreeNode left=invert(root.left);
        TreeNode right=invert(root.right);
        
        root.left=right;
        root.right=left;
                
        return root;
        
    }
    public TreeNode invertTree(TreeNode root) 
    {
        return invert(root);
    }
}
