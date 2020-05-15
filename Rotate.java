/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null){
            return null;
        }
        ListNode tail=head;ListNode prevtail=head;
		int size=0;
		while(tail.next!=null) {
			tail=tail.next;
			
			size++;
		}
		size=size+1;
		
		if(k>=size) {
			k=k%size;
		}
		
		tail.next=head;
		
		for(int i=0;i<size-k;i++) {
			prevtail=head;
			head=head.next;
		}
		
		prevtail.next=null;
		return head;
    }
}
