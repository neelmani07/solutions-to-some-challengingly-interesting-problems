/*This problem was asked by Facebook.

Given the mapping a = 1, b = 2, ... z = 26, 
and an encoded message, count the number of ways it can be decoded.

For example, the message '111' would give 3, since it could be decoded as 'aaa', 'ka', and 'ak'.

You can assume that the messages are decodable. For example, '001' is not allowed.
*/
public class waysToDecode {
	

	private static int findWays(char[]  digits,int n) {
		
		int findWaysDp[]=new int [n+1];
		// base cases
		findWaysDp[0]=1;
		findWaysDp[1]=1;
		
 
		for(int i=2;i<=n;i++) {
			// Initialize count 
		    int count = 0;  
		  
		    // If the last digit is not 0, then  
		    // last digit must add to 
		    // the number of words 
		    if (digits[i - 1] > '0') 
		    count = findWaysDp[i - 1]; 
		  
		    // If the last two digits form a number 
		    // smaller than or equal to 26, 
		    // then consider last two digits and recur 
		    if (digits[i - 2] == '1' ||  
		       (digits[i - 2] == '2' && digits[i - 1] < '7')) 
		    count += findWaysDp[ i - 2]; 
		    
		    findWaysDp[i]=count;
		}
	    return findWaysDp[n];
	    
	} 
	  
	// Driver program to test above function 
	public static void main(String[] args)  
	{ 
	    char digits[] = {'1', '2', '2', '4'}; 
	    int n = digits.length;
	    System.out.println(findWays(digits,digits.length));
	}

}
