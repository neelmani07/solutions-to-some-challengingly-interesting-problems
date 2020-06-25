/*
You have an infinite number of stacks arranged in a row and numbered (left to right) from 0, each of the stacks has the same maximum capacity.

Implement the DinnerPlates class:

    DinnerPlates(int capacity) Initializes the object with the maximum capacity of the stacks.
    void push(int val) pushes the given positive integer val into the leftmost stack with size less than capacity.
    int pop() returns the value at the top of the rightmost non-empty stack and removes it from that stack, and returns -1 if all stacks are empty.
    int popAtStack(int index) returns the value at the top of the stack with the given index and removes it from that stack, and returns -1 if the stack with that given index is empty.
*/

class DinnerPlates {
    int c;
    int l=0,r=0;
    ArrayList<Stack<Integer>>stacks;
    public DinnerPlates(int capacity) {
        this.c=capacity;
        stacks=new ArrayList<>();
    }
    
    public void push(int val) {//leftmose
        if(stacks.size()==l)stacks.add(new Stack<>());
        stacks.get(l).push(val);
        while(l<stacks.size()&&stacks.get(l).size()==c){
            l++;
        }
    }
    
    public int pop() {//rightmost
        int size=stacks.size();
        while(stacks.size()>0&&stacks.get(size-1).size()==0){
            stacks.remove(size-1);
            size--;
        }
        if(stacks.size()==0)return -1;
        int res=stacks.get(size-1).pop();
        return res;
    }
    
    public int popAtStack(int index) {
        if(index<0||index>=stacks.size())return -1;
        if(stacks.get(index).size()==0)return -1;
        int res=stacks.get(index).pop();
        if(l>index)l=index;
        return res;
    }
}

/**
 * Your DinnerPlates object will be instantiated and called as such:
 * DinnerPlates obj = new DinnerPlates(capacity);
 * obj.push(val);
 * int param_2 = obj.pop();
 * int param_3 = obj.popAtStack(index);
 */
