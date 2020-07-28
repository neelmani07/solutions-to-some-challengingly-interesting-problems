/*
 * This problem was asked by Oracle.

We say a number is sparse if there are no adjacent ones in its binary representation. 
For example, 21 (10101) is sparse, but 22 (10110) is not. For a given input N, 
find the smallest sparse number greater than or equal to N.

Do this in faster than O(N log N) time.

 */
public class SparseNumber {
	
	public static boolean hasAlternatingBits2(int n) {
        /*
        n =         1 0 1 0 1 0 1 0
        n >> 1      0 1 0 1 0 1 0 1
        n ^ n>>1    1 1 1 1 1 1 1 1
        n           1 1 1 1 1 1 1 1
        n + 1     1 0 0 0 0 0 0 0 0
        n & (n+1)   0 0 0 0 0 0 0 0
        */

        n = n ^ (n>>1);
        return (n & n+1) == 0;
    }
	
	public static void main(String arg[]) {
		
		int n=22;
		while(!hasAlternatingBits2(n))
			n++;
		System.out.print("the smallest sparse number greater than or equal to N="+n);
	}

}
