
/*
This problem was asked by Google.

Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could also be considered as a subtree of itself.*/
   
// A binary tree node 
class Node  
{ 
    int data; 
    Node left, right; 
   
    Node(int item)  
    { 
        data = item; 
        left = right = null; 
    } 
} 
   
class FindSubtreeInTree  
{ 
    Node root1, root2; 
    static int found=0;
    /* Given two trees, return true if they are 
       structurally identical */
    boolean identicalTrees(Node a, Node b)  
    { 
        /*1. both empty */
        if (a == null && b == null) 
            return true; 
              
        /* 2. both non-empty -> compare them */
        if (a != null && b != null)  
            return (a.data == b.data 
                    && identicalTrees(a.left, b.left) 
                    && identicalTrees(a.right, b.right)); 
   
        /* 3. one empty, one not -> false */
        return false; 
    }
    
	    void finditself(Node a, Node b)
	    {
	    	
	     	if ( identicalTrees(a,b))
	     	{
	     		
	     		found=1;
	     		return;
	     	}
	     	else
	     	{
	     		if(a.left !=null && a.right !=null)
	     		{
		     		finditself(a.left,b);
		     		finditself(a.right,b);
	     		}
	     	}
	     }
    
   
    /* Driver program to test identicalTrees() function */
    public static void main(String[] args)  
    { 
        FindSubtreeInTree   tree = new FindSubtreeInTree  ();         //          5
   							//			 / \ 
        tree.root1 = new Node(5);                       //			1   7 
        tree.root1.left = new Node(1); 			//		       / \   \
    							//                    2   3   8
    	tree.root1.right = new Node(7); 		//		     / \     /
        tree.root1.left.left = new Node(2); 		//		    4   5   9
        						//
        tree.root1.left.right = new Node(3); 		//                        1
   	tree.root1.left.left.left = new Node(4);
   	tree.root1.left.left.right =new Node(5); 	//			 / \  
        tree.root2 = new Node(1); 			//                      2   3 
        tree.root2.left = new Node(2); 			//		       / \ 
        tree.root2.right = new Node(3); 		//		      4   5
        tree.root2.left.left = new Node(4); 		//
        tree.root2.left.right = new Node(5); 
   	
        tree.finditself(tree.root1,tree.root2);
        if(found==1)
     		System.out.println("2nd tree found itself in 1st tree ");
     	else
     		System.out.println("2nd tree could not find itself in 1st tree");
     
    } 
} 

