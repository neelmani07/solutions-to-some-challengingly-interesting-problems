/*
A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.

The Linked List is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:

    val: an integer representing Node.val
    random_index: the index of the node (range from 0 to n-1) where random pointer points to, or null if it does not point to any node.



// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution
{
    public void printlist(Node h)
    {
        while(h!=null)
        {
            System.out.println(h.val);
            h=h.next;
        }
    }
    public Node copyRandomList(Node head) 
    {
        if(head==null)
            return null;
        
        Node ansH = new Node(head.val);
        Node res = ansH;
        Node Temp = head;

        while (Temp.next != null){
            Temp = Temp.next;
            res.next = new Node(Temp.val);
            res = res.next;
        }
        printlist(ansH.next);
        Node tempOuter=head;
        Node tempInner=head;
        Node tempAO=ansH;
        Node tempAIn=ansH;
        while(tempOuter!=null)
        {
          
            if(tempOuter.random==null)
                tempAO.random=null;
            else
            {   tempInner=head;
                tempAIn=ansH;
                while(tempOuter.random != tempInner)
                {
                    tempInner=tempInner.next;
                    tempAIn=tempAIn.next;
                }
                tempAO.random=tempAIn;
            }
            tempOuter=tempOuter.next;
            tempAO=tempAO.next;
            
        }
        return ansH;
        
        
    }
}
