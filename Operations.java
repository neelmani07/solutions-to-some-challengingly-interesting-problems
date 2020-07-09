package CTCI;

import java.util.Scanner;

//operations here refers to performing 
//substraction, multiplications, division using only '+' operator
public class Operations {
	
	public static void multiply(int a,int b)
	{
		for(int i=1;i<=b;i++)
		{
			a=a+a;
		}
		System.out.println(a);
	}
	
	public static int   substraction(int a,int b)
	{
		//just do a+(-b)
		//getting -b without using '-'
		int minus1=-1;
		int negOfB=0;
		while(b!=0)
		{
			negOfB+=minus1;
			b--;
		}
		
		return (a+negOfB);
		
	}
	
	public static void division(int a,int b)
	{
		int quotient=0;
		while(a!=0)
		{
			a=substraction(a,b);
			quotient++;
		}
		System.out.println(quotient);
		
	}
	public static void main(String arg[])
	{
		while(true)
		{
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter 1=multiply \t 2=substraction \t 3=division \t 4=exit");
			int ch=sc.nextInt();
			int a=sc.nextInt();
			int b=sc.nextInt();
			switch(ch)
			{
			case 1:multiply(a,b);
					break;
			case 2:System.out.println(substraction(a,b));
					break;
			case 3:division(a,b);
					break;
			case 4:System.exit(0);
			}
		}
		
	}
	
	
	

}
