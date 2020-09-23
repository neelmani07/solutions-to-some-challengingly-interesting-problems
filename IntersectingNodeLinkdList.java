

/*
 * 
 * This problem was asked by Google.

Given two singly linked lists that intersect at some point, find the intersecting node. The lists are non-cyclical.

For example, given A = 3 -> 7 -> 8 -> 10 and B = 99 -> 1 -> 8 -> 10, return the node with value 8.

In this example, assume nodes with the same value are the exact same node objects.

Do this in O(M + N) time (where M and N are the lengths of the lists) and constant space.
*/
package leetcode;
class Node{
	int data;
	Node next;
	public Node(int v){
		data=v;
	}
}
public class IntersectingNodeLinkdList {
	private static final String L1 = null;

	public static void main(String[] args) {
		Node l1=new Node(3);
		l1.next=new Node(100);
		l1.next.next=new Node(7);
		Node et=new Node(8);
		Node ten=new Node(10);
		l1.next.next.next=et;
		l1.next.next.next.next=ten;
		
		Node l2=new Node(99);
		l2.next=new Node(1);
		l2.next.next=et;
		l2.next.next.next=ten;
		
		Node iP=find(l1,l2);
		System.out.println(iP.data);
	}

	private static Node find(Node l1, Node l2) {
		int countl1=0;Node t1=l1;
		int countl2=0;Node t2=l2;
		while(t1!=null) {
			countl1++;
			t1=t1.next;
		}
		while(t2!=null) {
			countl2++;
			t2=t2.next;
		}
		int diff=countl1-countl2;
		while(diff!=0) {
			l1=l1.next;
			diff--;
		}
		while(l1!=l2) {
			l1=l1.next;
			l2=l2.next;
		}
		return l1;
	}
}
