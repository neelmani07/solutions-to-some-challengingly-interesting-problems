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
class AdditionLinkedList 
{
    public ListNode addTwoNumbers(ListNode l1, ListNode l2)
    {
        if(l2==null && l1 == null)
            return null;
        if(l1==null)
            return l2;
        if(l2==null)
            return l1;
        ListNode sum=new ListNode();int carry=0;
        sum.val=(l1.val+l2.val)%10 + carry;
        carry=(l1.val+l2.val)/10;
        ListNode res=sum;l1=l1.next;l2=l2.next;
        while(l1!=null && l2!=null)
        {
                
                int val=(l1.val+l2.val+carry)%10;
                carry=(l1.val+l2.val+carry)/10;
                sum.next=new ListNode(val);
                sum=sum.next;
                l1=l1.next;l2=l2.next;
        }
        while(l1!=null)
        {
            
           
            sum.next=new ListNode((l1.val+carry)%10);
             carry=(l1.val+carry)/10;
            l1=l1.next;
            sum=sum.next;
            
        }
        while(l2!=null)
        {
            
            
            sum.next=new ListNode((l2.val+carry)%10);
            carry=(l2.val+carry)/10;
            sum=sum.next;
            l2=l2.next;
            
        }
        if(carry >0)
            sum.next=new ListNode(carry);
        
        return res;
    }
}
