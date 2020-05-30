/*
Given a linked list, swap every two adjacent nodes and return its head.

You may not modify the values in the list's nodes, only nodes itself may be changed.

 

Example:

Given 1->2->3->4, you should return the list as 2->1->4->3.


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
    ListNode swapPairs(ListNode head)
    {

        if(head == null) return null;
        if(head.next == null) return head;

        ListNode ptr = head;
        ListNode ptr1 = head.next.next;

        head = head.next;
        head.next = ptr;
        ptr.next = swapPairs(ptr1);

        return head;

    }
}
