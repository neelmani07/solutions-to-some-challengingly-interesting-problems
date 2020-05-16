/*Given a binary tree, find the length of the longest path where each node in the path has the same value. This path may or may not pass through the root.

The length of path between two nodes is represented by the number of edges between them.

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
    int res = Integer.MIN_VALUE;
    public int longestUnivaluePath(TreeNode root) {
        if(root==null)
            return 0;
        getlongvalue(root,root.val);
        return res;
    }

    public int getlongvalue(TreeNode node,int value){
        if(node == null)
            return 0;
        int leftpath = getlongvalue(node.left,node.val);
        int rightpath = getlongvalue(node.right,node.val);
        res = Math.max(res,leftpath+rightpath);
        if(node.val==value)
            return 1+Math.max(leftpath,rightpath);
        return 0;
    }
}
