/*
 * This problem was asked by Google.

Given the sequence of keys visited by a postorder traversal of a binary search tree, reconstruct the tree.

For example, given the sequence 2, 4, 3, 8, 7, 5, you should construct the following tree:

    5
   / \
  3   7
 / \   \
2   4   8
 */
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
}
class TreeConstruct {
    public static TreeNode buildTree(int[] p){
        int n=p.length;
        TreeNode root=new TreeNode(p[n-1]);
        for(int i=n-2;i>=0;i--){
            addToTree(p[i],root);
        }
        return root;
    }
    public static void addToTree(int elem,TreeNode root){
        if(root.val<elem){
            if(root.right==null)
                root.right=new TreeNode(elem);
            else
                addToTree(elem,root.right);
        }
        else if(root.val>elem){
            if(root.left==null)
                root.left=new TreeNode(elem);
            else
                addToTree(elem,root.left);
        }  
    }
    public static void inorder(TreeNode root) {
    	if(root==null)
    		return;
    	else {
    		inorder(root.left);
    		System.out.println(root.val);
    		inorder(root.right);
    	}
    }
    public static void main(String[] args) {
		int ar[]=new int[]{2, 4, 3, 8, 7, 5};
		inorder(buildTree(ar));
	}
  
}

