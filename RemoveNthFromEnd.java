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
{
    public ListNode removeNthFromEnd(ListNode head, int n)
    {   
        //for null or single node
        if(head==null || head.next == null)
            return null;
        
        //for 2 nodes list
        if(head.next.next==null)
        {
            if(n==1)
            {
                head.next=null;
                return head;
            }
            else
                return head.next;
        }
        
        ListNode p1=head,p2=head;
        int count=1;
        while(count<n)
        {
            p1=p1.next;
            count++;
        }
        
        //if n==length of list
        if(p1.next==null)
        {
            return head.next;
        }
        
        //rest cases
        ListNode prev=head;
        while(p1.next!=null)
        {
            prev=p2;
            p1=p1.next;
            p2=p2.next;
        }
        prev.next=prev.next.next;
        
        return head;
    }
}
