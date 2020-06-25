/*

Implement the following operations of a stack using queues.

    push(x) -- Push element x onto stack.
    pop() -- Removes the element on top of the stack.
    top() -- Get the top element.
    empty() -- Return whether the stack is empty.
*/
//use of two queue.
/*
class MyStack {

    Queue<Integer> q1 = new LinkedList<>(), q2 = new LinkedList<>();
 
   
    public MyStack() {
    }
    
    /
    public void push(int x) {
        
        q1.add(x);
 
    }
    
    
    public int pop() {
        
        while(q1.size()!=1)
        {
            q2.add(q1.poll());
            
        }
        Queue<Integer> temp=q1;
        q1=q2;
        q2=temp;
        
        return q2.poll();
        
    }
    
   
    public int top() {
        
         while(q1.size()!=1)
        {
            q2.add(q1.poll());
            
        }
        Queue<Integer> temp=q1;
        q1=q2;
        q2=temp;
        
        int topEle= q2.peek();
        q1.add(q2.poll());
        
        return topEle;
    }
    
  
    public boolean empty() {
        
        if(q1.size()==0)
            return true;
        else
            return false;
        
    }
}
*/

// use of 1 queue.  
class MyStack {

    private Queue<Integer> queue;
    
    public MyStack() {
        queue = new LinkedList<>();
    }
    
    public void push(int x) {
        queue.add(x);
        int size = queue.size() - 1;
        for (int i = 0; i < size; i++) queue.add(queue.poll());
    }
    
    public int pop() {
        return queue.poll();
    }
    
    public int top() {
        return queue.peek();
    }
    
    public boolean empty() {
        return queue.isEmpty();
    }
}


/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
