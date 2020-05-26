/*
Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

Example:

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4

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
{
    public void add(ListNode l1,ListNode l2)
    {
        ListNode next=l1.next;
        l1.next=l2;
        l2.next=next;
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2)
    {
        if(l1==null || l2==null)
            return l1==null ? l2:l1;
        
        if(l2.val < l1.val)// to make sure that l1 is the smaller list (smaller by first element)
        {
            ListNode tmp=l2;
            l2=l1;
            l1=tmp;
        }
        ListNode cur1=l1;ListNode cur2=l2;
        while(cur1.next!= null && cur2 != null)
        {
            if(cur1.val<=cur2.val &&  cur1.next.val >= cur2.val)
            {
                ListNode next2=cur2.next;
                add(cur1,cur2);
                cur2=next2;
                cur1=cur1.next;
            }
            else
                cur1=cur1.next;
                  
        }
        if(cur1.next==null)//for left element in l2;
        {
            cur1.next=cur2;
        }
        return l1;
    }
}
