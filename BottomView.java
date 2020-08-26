import java.util.Map;
import java.util.TreeMap;

/*
 *        5
 *       /  \
        3     7
      /  \   / \
    1     4 6   9
   /           /
  0           8
  
The bottom view of a tree, then, consists of the lowest node at each horizontal distance.
If there are two nodes at the same depth and horizontal distance, either is acceptable.

For this tree, for example, the bottom view could be [0, 1, 3, 6, 8, 9].

Given the root to a binary tree, return its bottom view.
 */
class node{
	int val;
	node lchld;
	node rchld;
	public node(int v){
		val=v;
		lchld=null;
		rchld=null;
	}
}
public class BottomView {
	public static void main(String[] args) {
		node root=new node(5);
		root.lchld=new node(3);
		root.rchld=new node(7);
		root.rchld.rchld=new node(9);
		root.lchld.lchld=new node(1);
		root.rchld.lchld=new node(6);
		root.lchld.rchld=new node(4);
		root.lchld.lchld.lchld=new node(0);
		root.rchld.rchld.lchld=new node(8);
		TreeMap<Integer,Integer> vals=new TreeMap<Integer,Integer>();
		bottomView(root,vals,0);
		for(Map.Entry<Integer,Integer> i: vals.entrySet())
			System.out.print(i.getValue()+" ");
		
	}

	private static void bottomView(node root,TreeMap<Integer,Integer> v,int dis) {
		if(root==null)return;
		v.put(dis,root.val);
		bottomView(root.lchld,v,dis-1);
		bottomView(root.rchld,v,dis+1);		
	}
}
