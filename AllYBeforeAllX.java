
/*
 * This problem was asked by LinkedIn.


You are given a string consisting of the letters x and y, such as xyxxxyxyy. 
In addition, you have an operation called flip, which changes a single x to y or vice versa.

Determine how many times you would need to apply this operation to ensure that all x's come 
before all y's. In the preceding example, it suffices to flip the second and sixth characters, 
so you should return 2.
 */
public class AllYBeforeAllX {
	
	public static int shiftByFlipingY(String s) {
	
		int lastX=-1;
		for(int i=s.length()-1;i>=0;i--) {
			if(s.charAt(i)=='x') {
				lastX=i;
				break;
			}
		}
		int yToFlip=0;
		for(int i=lastX;i>=0;i--) {
			if(s.charAt(i)=='y')
				yToFlip++;
				
		}
		return yToFlip;
		
	}
	public static int shiftByFlipingX(String s) {
		
		int lastY=-1;
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)=='y') {
				lastY=i;
				break;
			}
		}
		int xToFlip=0;
		for(int i=lastY;i<s.length();i++) {
			if(s.charAt(i)=='x')
				xToFlip++;
				
		}
		return xToFlip;
		
	}
	public static void main(String arg[]) {
		String sen="xyxy";
		System.out.print(Math.min(shiftByFlipingX(sen),shiftByFlipingX(sen)));
	}

}
