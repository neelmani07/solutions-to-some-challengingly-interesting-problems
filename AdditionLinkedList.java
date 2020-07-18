/*
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.

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
