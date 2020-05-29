/*
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

    The left subtree of a node contains only nodes with keys less than the node's key.
    The right subtree of a node contains only nodes with keys greater than the node's key.
    Both the left and right subtrees must also be binary search trees.

 

Example 1:

    2
   / \
  1   3

Input: [2,1,3]
Output: true

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
    public boolean isValidBST(TreeNode root) 
    {
        return isBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean isBST(TreeNode node, long min, long max)
    {
        if(node == null) return true;
        
        if(node.val >= max || node.val <= min) return false;
        
        return isBST(node.left, min, node.val) && isBST(node.right, node.val, max);
        
        
    }
}
