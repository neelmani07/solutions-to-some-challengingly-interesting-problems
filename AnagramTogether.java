package CTCI;

import java.util.Arrays;
import java.util.Comparator;

class AnagramComparator implements Comparator<String> {
	public String sortChars(String s) {
		char[] content=s.toCharArray();
		Arrays.sort(content);
		return new String(content);
	}
	public int compare(String s1,String s2) {
		return sortChars(s1).compareTo(sortChars(s2));
	}
}
public class AnagramTogether {
	public static void main(String arg[]) {
		String array[]=new String[] {"hello","elolh","holle","caps","pacs"};
		Arrays.sort(array,new AnagramComparator());
		
		for(String wrds:array) {
			System.out.print(wrds+" ");
		}
	}

}
