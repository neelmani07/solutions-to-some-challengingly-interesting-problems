/**Given a binary search tree, return a balanced binary search tree with the same node values.

A binary search tree is balanced if and only if the depth of the two subtrees of every node never differ by more than 1.

If there is more than one answer, return any of them.

 




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
    
    ArrayList<TreeNode> list=new ArrayList<TreeNode>();
    
    public void getSortedNodes(TreeNode root) {
        
        if(root==null) return;
        getSortedNodes(root.left);
        list.add(root);
        getSortedNodes(root.right);
        
    }
    public TreeNode getTree(int st,int end) {
        
        if(st>end) return null;
        
        int mid=(st+end)/2;
        TreeNode left=getTree(st,mid-1);
        TreeNode right=getTree(mid+1,end);
        
        TreeNode root=list.get(mid);
        root.left=left;
        root.right=right;
        
        return root;
        
    }
    public TreeNode balanceBST(TreeNode root) {
        
       
        getSortedNodes(root);
        return getTree(0,list.size()-1);

        
    }
}

