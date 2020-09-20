/*
 * An integer has sequential digits if and only if each digit in the 
 * number is one more than the previous digit.

Return a sorted list of all the integers in the range [low, high] 
inclusive that have sequential digits.

 

Example 1:

Input: low = 100, high = 300
Output: [123,234]
Example 2:

Input: low = 1000, high = 13000
Output: [1234,2345,3456,4567,5678,6789,12345]
 */


package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SequentialDigits {
	public static void main(String[] args) {
		List<Integer> ans=sequentialDigits(1000,13000);
		System.out.println(ans);
	}
	public static List<Integer> sequentialDigits(int low, int high) {
        List<Integer> l=new ArrayList<Integer>();
        String s="123456789";
        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                int num=Integer.parseInt(s.substring(i,j+1));
                if(num>=low && num<=high)
                    l.add(num);
            }
        }
        Collections.sort(l);
        return l;
        
    }
}
