/*
Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

inorder = [9,3,15,20,7]
postorder = [9,15,7,20,3]

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
    
     
       /*int pre_index = 0;
       Map<Integer, Integer> map  = new HashMap<>();
    
        public TreeNode buildTree(int[] inorder, int[] preorder) 
        {
            pre_index=preorder.length-1;
            int length = inorder.length;
            if(length == 0)
                return null;

            for(int i = 0;i<length;i++){
                map.put(inorder[i], i);
            }
            return helper(0, length-1,inorder,preorder);
        }

        public TreeNode helper( int left, int right, int[] in, int[] pre )
        {
            if(left> right)
                return null;

            int root_num = pre[pre_index];
            pre_index -=1;
            System.out.println(pre_index+" "+root_num);

            if(left == right){
                return new TreeNode(root_num);
            }

            int index_inOrder = map.get(root_num);

            TreeNode root = new TreeNode(root_num);
            root.right = helper(index_inOrder+1,right,in,pre);
            root.left = helper(left,index_inOrder-1,in,pre);
            return root;
        }*/
    
    public TreeNode buildTreeHelper(int[] inorder, int[] postorder, int in_start, int in_end, int post_start, int post_end) {
        if (in_start > in_end)
            return null;
        
        TreeNode root = new TreeNode(postorder[post_end]);

        if (in_start < in_end) {
            int cnt=0;
            while (cnt<in_end && inorder[in_end-cnt] != postorder[post_end]) cnt++;

            root.left = buildTreeHelper(inorder, postorder, 
                                        in_start, in_end - cnt - 1, 
                                        post_start, post_end - cnt - 1);
            root.right = buildTreeHelper(inorder, 
                                         postorder, in_end - cnt +1, 
                                         in_end, post_end - cnt, post_end - 1);
        }
        
        return root;
    }
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTreeHelper(inorder, postorder, 0, inorder.length-1, 0, postorder.length-1);
    }

        
    
}


