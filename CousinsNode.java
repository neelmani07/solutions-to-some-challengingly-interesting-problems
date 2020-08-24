/*
 * This problem was asked by Yext.

Two nodes in a binary tree can be called cousins if they are on the same level of the tree but have different parents. 
For example, in the following diagram 4 and 6 are cousins.

    1
   / \
  2   3
 / \   \
4   5   6
Given a binary tree and a particular node, find all cousins of that node.
 */
class node{
	int val;
	node lchld;
	node rchld;
	node(int v){
		val=v;lchld=rchld=null;
	}
}
public class CousinsNode {
	public static void main(String[] args) {
		//forming tree
		node root=new node(1);
		root.lchld=new node(2);
		root.rchld=new node(3);
		root.lchld.lchld=new node(4);
		root.lchld.rchld=new node(5);
		root.rchld.rchld=new node(6);
		findCousins(root,5);
	}
	static node parent=null;
	private static void findCousins(node root,int key) {
		int depth=findDepth(root,key);
		if(depth>999) {
			System.out.println("no such node");
			return;
		}
		dispAllElemAtGivenLevel(root,depth);
	}

	private static void dispAllElemAtGivenLevel(node root, int depth) {
		if(root==null || root==parent)return;
		if(depth==0) {
			System.out.println(root.val);
			return;
		}
		dispAllElemAtGivenLevel(root.lchld, depth-1);
		dispAllElemAtGivenLevel(root.rchld, depth-1);
		
	}

	private static int findDepth(node root,int key) {
		if(root==null || root.rchld==null && root.lchld==null)
			return 999;
		if((root.lchld!= null && key==root.lchld.val )|| (root.rchld!= null && key==root.rchld.val) ){
			parent=root;
			return 1;
		}
		else {
			return 1+Math.min(findDepth(root.lchld,key),findDepth(root.rchld,key));
		}
	}
}
