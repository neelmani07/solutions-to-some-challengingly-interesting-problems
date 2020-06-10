/*
Reverse a singly linked list.

Example:

Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution 
{   //iterative 
    public ListNode reverseList(ListNode head)
    {
        ListNode cur=head,prev=null,next=null;
        
        while(cur!=null)
        {
            next=cur.next;
            cur.next=prev;
            prev=cur;
            cur=next;
        }
        
        return prev;
    }
    //recursive
     ListNode ansHead=null;
    public ListNode reverseList(ListNode head)
    {
        if(head==null)
            return null;
         helper(head);
         return ansHead;
    }
    public ListNode helper(ListNode head)
    {
         if(head.next==null)
         {
             ansHead=head;
             return head;
         }
         ListNode next=helper(head.next);
         head.next=next.next;
         next.next=head;
         return head;
    }
}
