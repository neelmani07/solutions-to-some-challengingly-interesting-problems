
public class PowerUsingBit {
	
	public static int ipow(int base, int exp)
	{
	    int result = 1;
	    while (exp != 0)
	    {
	        if ((exp & 1) == 1)
	            result *= base;
	        exp >>= 1;
	        base *= base;
	    }

	    return result;
	}
	public static void main(String arg[])
	{
		System.out.print(ipow(3,3));
	}
	

}
