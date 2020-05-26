/*
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

    push(x) -- Push element x onto stack.
    pop() -- Removes the element on top of the stack.
    top() -- Get the top element.
    getMin() -- Retrieve the minimum element in the stack.

 

Example 1:

Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

Output
[null,null,null,null,-3,null,0,-2]
*/
class MinStack {

Node top;
static class Node{
    int value;
    int min;
    Node next;
    public Node(int x){
        value =x;
        next = null;
        min  = x;
        
    }

    
}
/** initialize your data structure here. */
public MinStack() {
    
    
}

public void push(int x) {
    if(top == null){
        top = new Node(x);
    }else{
        Node temp = new Node(x);
        temp.next = top;
        temp.min = Math.min(top.min,x);
        top = temp;
    }
    
}

public void pop() {
    if(top == null){
        return;
    }
    top = top.next;
    
}

public int top() {
    if(top == null)
    {
        return Integer.MAX_VALUE;
    }
     
    return top.value;
    
}

public int getMin() {
    if(top == null){
      return Integer.MAX_VALUE;
    }
    return top.min;
    
}

}

/**

    Your MinStack object will be instantiated and called as such:
    MinStack obj = new MinStack();
    obj.push(x);
    obj.pop();
    int param_3 = obj.top();
    int param_4 = obj.getMin();
    */

