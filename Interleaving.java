/*
 * Given two strings str1 and str2, write a function that prints all interleavings of the given two strings. You may assume that all characters in both strings are different
Example:

Input: str1 = "AB",  str2 = "CD"
Output:
    ABCD
    ACBD
    ACDB
    CABD
    CADB
    CDAB
 */
public class Interleaving {

	public static void main(String[] args) {
		String s1="AB",s2="CD";
		gen(s1,s2,2);
	}

	private static void gen(String s1, String s2,int n) {
		interleave(s1,s2,"",0,0,n);
		
	}
	private static void interleave(String s1,String s2,String s, int i, int j,int n) {
		if(i==n && j==n)
			System.out.println(s);
		if(i<n)
			interleave(s1,s2,s+s1.charAt(i),i+1,j,n);
		if(j<n)
			interleave(s1,s2,s+s2.charAt(j),i,j+1,n);
	}
}
