/*
This problem was asked by Indeed.

Given a 32-bit positive integer N, 
determine whether it is a power of four in faster than O(log N) time.
*/



/*
 * A number n is a power of 4 if following conditions are met.
a) There is only one bit set in the binary representation of 
   n (or n is a power of 2)
b) The bits don’t AND(&) any part of the pattern 0xAAAAAAAA
   i.e.  since there are even no of zeros in bit rep of n if n is power of 4
         so 1st 1 will be at odd position. eg 16=10000-> 1 at 5th pos

 The number 0xAAAAAAAA is a 32 bit number with all even bits 
 set as 1 and all odd bits as 0.
 took lil help  from  gfg
 */ 

public class PowerOfFour {
	
	static boolean isPowerOfFour(int n) { 
        return n != 0 && ((n&(n-1)) == 0) && (n & 0xAAAAAAAA) == 0; 
    }//n&(n-1)==0 checks if n is power of two.  
  
   
    public static void main(String[] args) { 
        int test_no =256; 
          
        if(isPowerOfFour(test_no)) 
            System.out.println(test_no + 
                               " is a power of 4"); 
        else
            System.out.println(test_no + 
                               " is not a power of 4"); 
    } 

}
