package CTCIHard;

public class AddWithoutPlusOperator {
	
	public static int add(int a,int b)
	{
		int carry=0;int sum=0;
		while(b!=0)
		{
			sum=a^b;
			carry=(a&b)<<1;
			b=carry;
			a=sum;
		}
		return sum;
	}
	public static void main(String arg[])
	{
		int a=20;int b=29;
		System.out.println("Sum ="+add(a,b));
	}

}
