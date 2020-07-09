package CTCI;

public class FactorialZeros {
	
	public static int countFactorOf5(int i)
	{
		int count=0;
		while(i%5==0)
		{
			count++;
			i/=5;
		}
		return count;
	}	
	public static int findTrailingZeros(int n)
	{
		int i=2;int count=0;
		while(i<=n)
		{
			count+=countFactorOf5(i);
		
			i++;
		}
		return count;
	}
	public static void main(String s[])
	{
		System.out.print(findTrailingZeros(20));
	}

}
