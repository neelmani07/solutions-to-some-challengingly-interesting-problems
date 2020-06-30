

class TreeNode {
		    int val;
		    TreeNode left;
		    TreeNode right;
		    TreeNode() {}
		    TreeNode(int val) { this.val = val; }
		    TreeNode(int val, TreeNode left, TreeNode right) {
		      this.val = val;
		      this.left = left;
		      this.right = right;
		    }
		};
public class FindFloorAndCeilInBST {
	
	
	public static TreeNode findLeftMost(TreeNode root)
	{
		while(root.left!=null)
		{
			root=root.left;
		}
		return root;
	}
	
	public static TreeNode findRigthMost(TreeNode root)
	{
		while(root.right!=null)
		{
			root=root.right;
		}
		return root;
	}
	public static int ceil(TreeNode node, int input)  
    {  
  
        // Base case  
        if (node == null) {  
            return -1;  
        }  
  
        // We found equal key  
        if (node.val == input) {  
            return node.val;  
        }  
  
        // If root's key is smaller,  
        // ceil must be in right subtree  
        if (node.val < input) {  
            return ceil(node.right, input);  
        }  
  
        // Else, either left subtree or root 
        // has the ceil value  
        int ceil = ceil(node.left, input);  
          
        return (ceil >= input) ? ceil : node.val;  
    }  
	
	
	public static int floor(TreeNode node,int input)
	{
		// Base case  
        if (node == null) {  
            return -1;  
        }  
  
        // We found equal key  
        if (node.val == input) {  
            return node.val;  
        }  
  
        // If root's key is smaller,  
        // floor must be in left subtree  
        if (node.val > input) {  
            return floor(node.left, input);  
        }  
  
        // Else, either left subtree or root 
        // has the ceil value  
        int floor = floor(node.right, input);  
          
        return (floor <= input && floor!=-1) ? floor : node.val; 
	}
	public static void inorder(TreeNode root)
	{
		if(root==null)return;
		else
		{
			
			System.out.print(root.val+" ");
			inorder(root.left);
			inorder(root.right);
		}
		
	}
	public static TreeNode constructBST(int a[],int st,int end)
    {
        if(st>end)return null;
        int mid=st+(end-st)/2;
        TreeNode root=new TreeNode(a[mid]);
        root.left=constructBST(a,st,mid-1);
        root.right=constructBST(a,mid+1,end);
        return root;
        
    }
	public static void main(String arg[])
	{
		
		int ar[]=new int[]{0,2,3,4,5,7,8,9,10,14,16};
		int key=11;
		TreeNode bst=constructBST(ar,0,ar.length-1);
		inorder(bst);
		System.out.println();
		System.out.println("floor="+floor(bst,key));
		System.out.println("ceil="+ceil(bst,key));
	}

}

