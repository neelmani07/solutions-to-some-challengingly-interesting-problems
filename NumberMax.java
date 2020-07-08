package CTCI;

public class NumberMax {

	
	public static int sign(int a)
	{
		return ((a>>31)& 0x1);
	}
	public static void main(String s[])
	{
		int a=3;int b=5;
		
		int k=sign(a-b);
		int q=1^k;
		System.out.print(a*k+b*q);
	}
}
