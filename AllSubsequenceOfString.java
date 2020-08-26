/*
 * Given a string s, make a list of all possible combinations of letters of a given string S. 
 * If there are two strings with the same set of characters,
 *  print the lexicographically smallest arrangement of the two strings
 */
import java.util.*; 

public class AllSubsequenceOfString { 

	// Finds and stores result in st for a given 
	// string s. 
	static void generate(Set<String> st, String s) 
	{ 
		if (s.length() == 0) { 
			return; 
		} 

		// If current string is not already present. 
		if (!st.contains(s)) { 
			st.add(s); 

			// Traverse current string, one by one 
			// remove every character and recur. 
			for (int i = 0; i < s.length(); i++) { 
				String t = s; 
				t = t.substring(0, i) + t.substring(i + 1); 
				generate(st, t); 
			} 
		} 
		return; 
	} 

	// Driver code 
	public static void main(String args[]) 
	{ 
		String s = "xyz"; 
		TreeSet<String> st = new TreeSet<>(); 
		generate(st, s);
		generateDPWithBitMasking(s);
		for (String str : st) { 
			System.out.println(str); 
		} 
	}

	private static void generateDPWithBitMasking(String s) {
		TreeSet<String> st=new TreeSet<String>();
		int n=s.length();int N=2<<n-1;
		char str[]=s.toCharArray();
		String cur="";
		for(int i=1;i<=N;i++) {
			cur="";int k=i;int ind=0;
			while(ind<str.length) {
				int m=1<<ind;
				if((k&(m))!=0) {
					cur+=str[ind];
				}
				ind++;;
			}
			st.add(cur);
		}
		System.out.println(st);
		
	} 
} 
