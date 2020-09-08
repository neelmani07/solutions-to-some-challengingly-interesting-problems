
public class BalancedHeight {
	static boolean isTrue=true;
	public static void main(String[] args) {
		node root=new node(5);
		root.lchld=new node(3);
		root.rchld=new node(7);
		root.rchld.rchld=new node(9);
		root.lchld.lchld=new node(1);
		root.rchld.lchld=new node(6);
		root.lchld.rchld=new node(4);
		root.lchld.lchld.lchld=new node(0);
		root.lchld.lchld.lchld.lchld=new node(10);
		root.rchld.rchld.lchld=new node(8);
		System.out.println("max depth="+finfIfBalanced(root));
		System.out.println("if height balanced="+(isTrue==true));
	}
	
	private static int finfIfBalanced(node root) {
		if(root==null)
			return 0;
		int lht=finfIfBalanced(root.lchld);
		int rht=finfIfBalanced(root.rchld);
		if(Math.abs(lht-rht)>1) {
			isTrue=false;
			System.out.println("diff of height at"+root.val);
		}
		return Math.max(lht, rht)+1;
	}

	

}
