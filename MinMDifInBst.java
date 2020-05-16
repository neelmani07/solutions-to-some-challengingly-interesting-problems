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
    int minM=999;
    ArrayList<Integer> l=new ArrayList<Integer>();
    
    public void Inorder(TreeNode node)
    {
       if (node == null) 
            return; 
  
       
        Inorder(node.left); 
  

        l.add(node.val);
  
       
        Inorder(node.right); 
        
        
        
    }
    public int minDiffInBST(TreeNode root)
    {
        if(root == null)
            return 0;
        Inorder(root);
        for (int i = 0; i < l.size()-1; i++)  
             minM=Math.min(minM,l.get(i+1)-l.get(i));
        return minM;
               
    }
}
