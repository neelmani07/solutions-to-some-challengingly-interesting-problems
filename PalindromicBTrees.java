//pgm to check if inorder traversal of binary tree is palindromic in o(1) space.

package leetcode;



 
public class PalindromicBTrees {
	
	static class node 
	{ 
		char val; 
		node left; 
		node right; 
		
		//Function to create the node 
		static node newnode(char i) 
		{ 
			node temp = null; 
			temp = new node(); 
			temp.val = i; 
			temp.left = null; 
			temp.right = null; 
			return temp; 
		}
	}; 
	
	public static void main(String[] args) {
		
		node root = node.newnode('b'); 
		root.left = node.newnode('b'); 
		root.right = node.newnode('a'); 
		root.left.right = node.newnode('b'); 
		root.left.left = node.newnode('a'); 

		node shoot = conv_tree(root, null); 

		if (checkPalin(shoot) == 1) 
			System.out.print("True" + "\n"); 
		else
			System.out.print("False" + "\n"); 
	}
	
	static node conv_tree(node root, 
			node shoot) { 
		if (root.left != null) 
		shoot = conv_tree(root.left, 
						shoot); 
		
		root.left = shoot; 
		
		if (shoot != null) 
		shoot.right = root; 
		
		shoot = root; 
		
		if (root.right != null) 
		shoot = conv_tree(root.right, 
						shoot); 
		
		return shoot; 
	} 

	//Function for checking linked 
	//list is palindrom or not 
	static int checkPalin(node root) { 
		node voot = root; 
		int j = 0; 
		while (voot.left != null) { 
			j = j + 1; 
			voot = voot.left; 
		} 
		int i = 0; 
		while (i < j) { 
			// Check if the value matches 
			if (voot.val != root.val) 
				return 0; 
			else{ 
				i = i + 1; 
				j = j - 1; 
				voot = voot.right; 
				root = root.left; 
			} 
		} 
		return 1; 
	} 
}


