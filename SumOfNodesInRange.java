

/*
 * This problem was asked by Google.

Given a binary search tree and a range [a, b] (inclusive), 
return the sum of the elements of the binary search tree within the range.

For example, given the following tree:

    5
   / \
  3   8
 / \ / \
2  4 6  10
and the range [4, 9], return 23 (5 + 4 + 6 + 8).

Upgrade to premium and get in-depth solutions to every problem
 */
public class SumOfNodesInRange {
	public static void main(String[] args) {
		Node bst=new Node(5);
		bst.lchld=new Node(3);
		bst.rchld=new Node(8);
		bst.lchld.lchld=new Node(2);
		bst.lchld.rchld=new Node(4);
		bst.rchld.lchld=new Node(6);
		bst.rchld.rchld=new Node(10);
		
		System.out.println(findSum(bst,4,9));
		
	}
	static int sum=0;
	private static int findSum(Node bst, int i, int j) {
		//int sum=0;
		utilInOrder(i,j,bst);
		return sum;
	}

	private static void utilInOrder(int i, int j, Node bst) {
		if(bst!=null) {
			utilInOrder(i, j, bst.lchld);
			if(bst.data >= i && bst.data <= j) {
				sum+=bst.data;
			}
			utilInOrder(i, j, bst.rchld);
		}
		
	}

}
