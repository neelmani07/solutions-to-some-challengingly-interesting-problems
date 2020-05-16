/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
 //https://cs.stackexchange.com/questions/10360/floyds-cycle-detection-algorithm-determining-the-starting-point-of-cycle
 //for better aproach
 
 
public class Solution 
{
    public ListNode detectCycle(ListNode head)
    {
        if(head==null || head.next==null)
            return null;
        if(head.next.next==null)
            return null;
        ListNode p1=head.next.next;
        ListNode p2=head;
        while(p1.next!=null && p1.next.next!=null)
        {
            if(p1 == p2)
            {
                int lenOfCyc=1;
                p2=p2.next;
                while(p2!=p1)
                {
                    lenOfCyc++;
                    p2=p2.next;
                }
                p1=head;
                p2=head;
                while(lenOfCyc > 0)
                {
                    p1=p1.next;
                    lenOfCyc--;
                }
                while(p1!=p2)
                {
                    
                    p1=p1.next;
                    p2=p2.next;
                    
                }
                return p1;
            }
            p1=p1.next.next;
            p2=p2.next;
        }
        return null;
            
    }
}
