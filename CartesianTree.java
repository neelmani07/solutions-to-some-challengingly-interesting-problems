/*This problem was asked by Netflix.

A Cartesian tree with sequence S is a binary tree defined by the following two properties:

    It is heap-ordered, so that each parent value is strictly less than that of its children.
    An in-order traversal of the tree produces nodes with values that correspond exactly to S.

For example, given the sequence [3, 2, 6, 1, 9], the resulting Cartesian tree would be:

      1
    /   \   
  2       9
 / \
3   6

Given a sequence S, construct the corresponding Cartesian tree.*/
class CNode{
		int val;
		CNode lchld;
		CNode rchld;
		
		CNode(int data){
			val=data;
			lchld=rchld=null;
		}
	}
public class CartesianTree {
	static CNode Tree;
	public static void main(String[] args) {
		int arr[]=new int[] {1,4,5,2,8,49};//{3,2,6,1,9};
		Tree=formTree(arr,Tree);
		inorder(Tree);
		 
	}
	private static void inorder(CNode tree2) {
		if(tree2!=null) {
			inorder(tree2.lchld);
			System.out.println(tree2.val);
			inorder(tree2.rchld);
		}
		
	}
	private static CNode formTree(int []arr, CNode tree) {
		for(int i=0;i<arr.length;i++) {
			tree=formCartesianTree(arr[i],tree);
		}
		return tree;
		
	}
	private static CNode formCartesianTree(int data,CNode root) {
		if(root==null) {
			return new CNode(data);
		}
		if(data>root.val) {
			if(root.rchld==null)
				root.rchld=new CNode(data);
			else 
				root.rchld= formCartesianTree(data,root.rchld);
		}
		else if(data<root.val) {
			CNode newRoot=new  CNode(data);
			newRoot.lchld=root;
			root=newRoot;
		}
		return root;
	}

}
