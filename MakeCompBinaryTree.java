/*
 * This problem was asked by Yahoo.

Recall that a full binary tree is one in which each node is either a leaf node, or has two children. Given a binary tree, convert it to a full one by removing nodes with only one child.

For example, given the following tree:

         0
      /     \
    1         2
  /            \
3                 4
  \             /   \
    5          6     7
You should convert it to:

     0
  /     \
5         4
        /   \
       6     7
 */
class node{
	int val;
	node lchld;
	node rchld;
	node(int v){
		val=v;
	}
}
public class MakeCompBinaryTree {
	public static void main(String[] args) {
		node root=new node(0);
		root.lchld=new node(1);
		root.rchld=new node(2);
		root.lchld.lchld=new node(3);
		root.lchld.lchld.rchld=new node(5);
		root.rchld.rchld=new node(4);
		root.rchld.rchld.lchld=new node(6);
		root.rchld.rchld.rchld=new node(7);
		disp(root);
		makeFullBin(root);
		
		
	}

	private static void makeFullBin(node root) {
		root=build(root);
		disp(root);
		
	}

	private static void disp(node root) {
		if(root==null)
			return ;
		disp(root.lchld);
		System.out.println(root.val);
		disp(root.rchld);
		
	}

	private static node build(node root) {
		if(root==null)
			return null;
		if((root.lchld==null) != (root.rchld==null)) {// iska true hona mtlb ek hi child hai
			node ToRepWith=findReplacement(root);
			if(ToRepWith!=null) {
				root.val=ToRepWith.val;
				root.lchld=ToRepWith.lchld;
				root.rchld=ToRepWith.rchld;
			}
			else
				root=null;
		}
		if(root==null)
			return null;
		root.lchld=build(root.lchld);
		root.rchld=build(root.rchld);
		return root;			
	}

	private static node findReplacement(node root) {
		if(root==null) {
			return null;
		}
		if((root.lchld!= null && root.rchld!=null)|| (root.lchld==null && root.rchld==null))
			return root;
		node inlft=findReplacement(root.lchld);
		node inRight=findReplacement(root.rchld);
		if(inlft!=null)return inlft;
		if(inRight!=null)return inRight;
		return null;
	}

}
