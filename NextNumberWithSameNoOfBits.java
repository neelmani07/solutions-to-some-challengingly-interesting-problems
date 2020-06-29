/*
 * This problem was asked by Facebook.

Given an integer n, find the next biggest
 integer with the same number of 1-bits on. 
 For example, given the number 6 (0110 in binary), return 9 (1001).
 */
public class NextNumberWithSameNoOfBits {

	public static int findNext(int a) {
		//we ll find rightMost non trailing zero and replace it with 1 and then shift
		//all 1s rigth to it to last. And all 0s right to it to left of ones shifted.
		
		// finding the rigthmost non trailing 0at position 'p',
		// no of ones rigth to p as onesRigthToP  and 
		// no of zeros rigth to p as zerosRigthToP
		
		int p=-1;
		int zerosRigthToP=0;int onesRigthToP=0;
		int temp=a;
		while(temp!=0 && (temp & 1) ==0)
		{
			zerosRigthToP++;
			temp>>=1;
		}

		while((temp & 1) ==1)
		{
			
			onesRigthToP++;
			temp>>=1;
		}
		
		//System.out.println(zerosRigthToP+" "+onesRigthToP);
		p=zerosRigthToP+onesRigthToP;
		
		a|=((1<<p));
		
		a&=~((1<<p)-1);
		a|=(1<<(onesRigthToP-1))-1;
		
		return a;
		
	}
	public static void main(String a[]) {
		System.out.println(findNext(13948));
		System.out.println(findNext(6));
	}
}
