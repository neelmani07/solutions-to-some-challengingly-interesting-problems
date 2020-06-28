/*
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example:

Given the sorted array: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5


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
class Solution {
    
    public TreeNode makeBst(int a[],int st,int end)
    {
        if(st>end)return null;
        int mid=st+(end-st)/2;
        TreeNode root=new TreeNode(a[mid]);
        root.left=makeBst(a,st,mid-1);
        root.right=makeBst(a,mid+1,end);
        return root;
        
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length==0)return null;
        
        return makeBst(nums,0,nums.length-1);
        
    }
}
