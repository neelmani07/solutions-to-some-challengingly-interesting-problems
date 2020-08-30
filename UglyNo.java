
/*
 * Write a program to find the n-th ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 

Example:

Input: n = 10
Output: 12
Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
 */
public class UglyNo {

	public static void main(String[] args) {
		System.out.println(findNthUgly(10));
	}

	 
private static	int findNthUgly(int n) {
	        int ugly[]=new int[n];
	        ugly[0]=1;
	        int nextUgly=1;
	        int i2, i3, i5, next2, next3, next5;
	        i2=i3=i5=0;
	        next2=2;next3=3;next5=5;
	        for(int i=1;i<n;i++){
	            nextUgly=Math.min(next2, Math.min(next3, next5));
	            ugly[i]=nextUgly;
	            if(nextUgly==next2){
	                i2++;
	                next2=2*ugly[i2];
	            }
	            if(nextUgly==next3){
	                i3++;
	                next3=3*ugly[i3];
	            }
	            if(nextUgly==next5){
	                i5++;
	                next5=5*ugly[i5];
	            }
	        }
	        return ugly[n-1];
	}
}
