/*This problem was asked by Amazon.

A tree is symmetric if its data and shape remain unchanged when it is reflected about the root node. 
The following tree is an example:

        4
      / | \
    3   5   3
  /           \
9              9

Given a k-ary tree, determine whether it is symmetric.*/
import java.util.ArrayList;
public class SymmetricTree 
{
    class TreeNode 
    {
        private int data;
        ArrayList<TreeNode> children;
       
        public TreeNode(int data) 
        {
            this.data = data;
            children = new ArrayList();
        }
    }
	    
	    private TreeNode root;
	     
	     
	     
	    public void createSampleTree() 
	    {
	         TreeNode n1 = new TreeNode(1);
	         
	         TreeNode n20 = new TreeNode(2);
	         TreeNode n21 = new TreeNode(2);
	         
	         TreeNode n3 = new TreeNode(3);
	         
	         TreeNode n50 = new TreeNode(5);
	         TreeNode n51 = new TreeNode(5);
	         
	         TreeNode n60 = new TreeNode(6);
	         TreeNode n61 = new TreeNode(6);

	         TreeNode n70 = new TreeNode(7);
	         TreeNode n71 = new TreeNode(7);
	
	         root = n1;
	         
	         root.children.add(n20);
	         root.children.add(n3);
             root.children.add(n21);
	         
	         n20.children.add(n50);
	         n20.children.add(n60);
	         
	         n21.children.add(n61);
	         n21.children.add(n51);
	
	         n3.children.add(n70);
	    }
	    
	    
	    public boolean checkSymmetry(TreeNode root1, TreeNode root2)
	    {
	        if (root1 == null && root2 == null)
	        {
	            return true;
	        }
	        else if (root1 == null || root2 == null)
	        {
	            return false;
	        }
	        else if (root1.data == root2.data)
	        {
	            int i = 0, j = root2.children.size() - 1;
	            while ((i < root1.children.size()) && (j >= 0))
	            {
	                if (!checkSymmetry(root1.children.get(i), root2.children.get(j)))
	                {
	                    break;
	                }
	                i++; j--;
	            }
	            
	            if ((i < root1.children.size()) || (j >= 0))
	            {
	                return false;
	            }
	            else
	            {
	                return true;
	            }
	        }
	        return false;
	    }
	
	    
	    public static void main(String[] args) {
	    	SymmetricTree tree = new SymmetricTree();
	        
	         
	        tree.createSampleTree();
	
	        System.out.print("given n-ary tree is symmetric tree: "  + tree.checkSymmetry(tree.root, tree.root));
	    }
	}