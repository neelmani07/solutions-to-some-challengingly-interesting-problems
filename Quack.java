/*
A quack is a data structure combining properties of both stacks and queues. It can be viewed as a list of elements written left to right such that three operations are possible:

    push(x): add a new item x to the left end of the list
    pop(): remove and return the item on the left end of the list
    pull(): remove the item on the right end of the list.

Implement a quack using three stacks and O(1) additional memory, so that the amortized time for any push, pop, or pull operation is O(1).


*/
import java.util.*;
public class Quack 
{
	static Stack<Integer> st1;
	static Stack<Integer> st2;
	static Stack<Integer> st3;
	int pointer;
	
	Quack()
	{
		st1=new Stack<Integer>();
		st2=new Stack<Integer>();
		st3=new Stack<Integer>();
		pointer=1;
	}
	
	private int pop()
	{
		if(pointer % 2 !=0)
			st1.pop();
		else
			st2.pop();
		return st3.pop();
	}


	private int pull()
	{
		if(pointer%2!=0)
		{
			//pull is O(n) Shifting required
			pointer++;
			//System.out.println("->"+pointer);
			//System.out.println(st1);
			while(!st1.isEmpty())
				st2.push(st1.pop());
			//System.out.println(st2);
			return st2.pop();
		}
		else
		{
			return st2.pop();
		}
		
		
	}


	private void push(int n) 
	{
		if(pointer%2!=0)
		{
			//push or enQ is O(1)
			st1.push(n);
			
		}
		else
		{
			// push or enQ is O(n) Shifting required
			pointer++;
			//System.out.println("->"+pointer);
			while(!st2.isEmpty())
				st1.push(st2.pop());
			st1.push(n);
		}
		st3.push(n);
	}
	
	
	
	public static void main(String s[])
	{
		Quack ob=new Quack();
		while(true)
		{
			Scanner sc=new Scanner(System.in);
			System.out.println("1 -> push   2-> pop   3-> pull   4->exit");
			int ch=sc.nextInt();
			switch(ch)
			{
			case 1:System.out.println("enter the element");
				   ob.push(sc.nextInt());
				   break;
			case 2:System.out.println(ob.pop());
				   break;
			case 3:System.out.println(ob.pull());
			   	   break;
			case 4:System.exit(0);
				   break;
			}
		}
		
	}


	
}
