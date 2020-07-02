import java.util.Scanner;

/*
 * This problem was asked by Microsoft.

Implement 3 stacks using a single list:

class Stack:
    def __init__(self):
        self.list = []

    def pop(self, stack_number):
        pass

    def push(self, item, stack_number):
        pass

 */
public class ThreeStacksInList {
	
	int stacks[];
	int stackTop1,stackTop2,stackTop3;
	int noOfShift;String lastIndex;
	
	ThreeStacksInList(int n)
	{
		stacks=new int[n];
		stackTop1=0;stackTop2=stacks.length-1;
		stackTop3=n/2;
		noOfShift=0;
		lastIndex="right";
		
	}
	public void printArray()
	{
		for(int i=0;i<stacks.length;i++)
			System.out.println(stacks[i]+" ");
	}
	
	public void push(int ele,int stackNo)
	{
		if(stacks[stackTop1]!=0 || stacks[stackTop2]!=0 || lastIndex=="right" && stacks[stackTop3-noOfShift]!= 0 || lastIndex=="left" && stacks[stackTop3+noOfShift] != 0 )
		{	System.out.println("size full");
			printArray();
			return;
		}
		switch(stackNo)
		{
		case 1: stacks[stackTop1]=ele;
				stackTop1++;
				break;
		case 2: stacks[stackTop2]=ele;
				stackTop2--;
				break;
		case 3: if(lastIndex=="right")
				{
						stacks[stackTop3-noOfShift]=ele;
						noOfShift++;
						lastIndex="left";
				}
				else if(lastIndex=="left")
				{		
						stacks[stackTop3+noOfShift]=ele;
						noOfShift++;
						lastIndex="right";
				}
				break;
		default : System.out.println("wrong stack no.");
					break;
		}
	}
	public  int pop(int stackNo)
	{
		int val=0;
		switch(stackNo)
		{
		case 1: val= stacks[--stackTop1];
			    break;
		case 2: val= stacks[++stackTop2];
				break;
		case 3: 
				if(lastIndex=="left")
				{
					val=stacks[(stackTop3-noOfShift)+1];
					noOfShift--;
					
				}
				if(lastIndex=="right")
				{
					val=stacks[(stackTop3+noOfShift)];
					noOfShift--;
					
				}
				break;
		default: System.out.println("wrong stack no.");
				 break;
		}
		return val;
		
	}
	public static void main(String s[])
	{
		Scanner sc=new Scanner(System.in);
		ThreeStacksInList stcks=new ThreeStacksInList(10);
		while(true)
		{
			System.out.println("enter choice");
			int ch=sc.nextInt();
			switch(ch)
			{
			case 1:System.out.println("enter element and stack no");
				   int ele=	sc.nextInt();
				   int stackNo=sc.nextInt();
				   stcks.push(ele,stackNo);
				   break;
			case 2:System.out.println("enter stack no");
					System.out.println(stcks.pop(sc.nextInt()));
					break;
			case 3:System.exit(0);
			}
		}
		
		
	}

}
