package leetcode;

import java.util.PriorityQueue;

public class StackUsingPrioQ {

	class Element implements Comparable<Element> {
		int prio;int KeyElem;
		Element(int p,int key){
			prio=p;KeyElem=key;
		}	
		public int compareTo(Element obj) {
			
	        if(this.prio < obj.prio) {
			        
	        	return 1;
			} 
	        else if (this.prio > obj.prio) {
			            
	        	return -1;
			        
	        } else {
			    return 0;
			        
	        }
		 
		}
	};
	
	PriorityQueue<Element> q;
	int top_priority;
	
	StackUsingPrioQ(){
		q=new PriorityQueue<Element>();
		top_priority=0;
	}

	void push(int  x) { 
		
		q.add(new Element(top_priority++, x)); 
	
	}
	int pop() { 
		
		top_priority--; return q.poll().KeyElem; 
	}
	public static void main(String a[]) {
		StackUsingPrioQ obj=new StackUsingPrioQ();
		obj.push(10);
		obj.push(20);
		obj.push(30);		
		System.out.println(obj.pop() +" "+obj.pop());
		
		
	}
}

