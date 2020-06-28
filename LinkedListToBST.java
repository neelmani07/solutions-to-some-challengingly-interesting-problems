/*
viven a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example:

Given the sorted linked list: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    public TreeNode makeBst(ListNode head,ListNode tail)
    {
        ListNode start = head; 
        ListNode last = tail; 
        if(last != start)
        {
            TreeNode root;
            ListNode mid = middleNode(start, last); 
            root=new TreeNode(mid.val); 
            root.left=makeBst(start,mid);
            root.right=makeBst(mid.next,last);
            return root; 
        } 
        return null; 
    }
    
    public ListNode middleNode(ListNode start,ListNode last)  
    {
        if (start == null) 
            return null; 
        ListNode slow = start; 
        ListNode fast = start.next; 
        while (fast != last) 
        { 
            fast = fast.next; 
            if (fast != last)  
            { 
                slow = slow.next; 
                fast = fast.next; 
            } 
        } 
        return slow; 
    } 
    public TreeNode sortedListToBST(ListNode head) {
        
        if(head==null)return null;
        ListNode tail=null;
        return makeBst(head,tail);
    }
}

