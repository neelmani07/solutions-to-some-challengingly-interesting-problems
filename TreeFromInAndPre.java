/*Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]

Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7

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
   int pre_index = 0;
   Map<Integer, Integer> map  = new HashMap<>();
   
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int length = preorder.length;
        if(length == 0)
            return null;
        
        for(int i = 0;i<length;i++){
            map.put(inorder[i], i);
        }
        return helper(0, length-1,preorder,inorder);
    }

    public TreeNode helper( int left, int right, int[] pre, int[] in ){
        if(left> right)
            return null;

        int root_num = pre[pre_index];
        pre_index +=1;

        if(left == right){
            return new TreeNode(root_num);
        }

        int index_inOrder = map.get(root_num);

        TreeNode root = new TreeNode(root_num);
        root.left = helper(left, index_inOrder-1,pre,in);
        root.right = helper(index_inOrder+1,right, pre,in);
        return root;
    }
}
