/*

Given the head of a linked list, we repeatedly delete consecutive sequences of nodes that sum to 0 until there are no such sequences.

After doing so, return the head of the final linked list.  You may return any such answer.

 

(Note that in the examples below, all sequences are serializations of ListNode objects.)

Example 1:

Input: head = [1,2,-3,3,1]
Output: [3,1]
Note: The answer [1,2,1] would also be accepted.

Example 2:

Input: head = [1,2,3,-3,4]
Output: [1,2,4]
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
class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        
        ListNode temp=head;
        //forming an array
        List<Integer> l=new ArrayList<Integer>();
        while(temp!=null)
        {
            l.add(temp.val);
            temp=temp.next;
        }
        
        for(int i=0;i<l.size();i++)
        {
            int sum=0;
            for(int j=i;j<l.size();j++)
            {
                //System.out.print(l.get(j)+" ");
                sum+=l.get(j);
                if(sum==0)
                {
                    int removEnd=j;
                    int removStart=i;
                    while(removEnd>=removStart)
                    {
                        //System.out.print("remove start"+removStart+" "+"remove end"+removEnd);
                        l.set(removStart,0);
                        removStart++;
                        //System.out.println("\n"+l);
                    }
                }
            }
        }
        //System.out.println("\n"+l);
        //forming linked list back
        
        ListNode start=new ListNode(l.get(0));
        ListNode headToReturn=start;
        for(int st=0;st<l.size();st++)
        {
            if(l.get(st)!=0)
            {
                start.next=new ListNode(l.get(st));
                start=start.next;
            }
        }
        
        
        return headToReturn.next;
            
        
    }
}
