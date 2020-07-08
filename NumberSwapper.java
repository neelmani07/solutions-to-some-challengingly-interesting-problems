package CTCI;

public class NumberSwapper {
	public static void main(String s[])
	{
		int a=22;int b=34;
		 
		a=b-a;
		b=b-a;
		a=a+b;
		System.out.println(a+" "+b);
		 
		a=a^b;
		b=b^a;
		a=a^b;
		
		System.out.print(a+" "+b);
	}

}
