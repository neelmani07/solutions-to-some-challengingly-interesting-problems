import java.util.Stack;

/*
 * This problem was asked by Google.

You're given a string consisting solely of (, ), 
and *. * can represent either a (, ), or an empty string. 
Determine whether the parentheses are balanced.

For example, (()* and (*) are balanced. )*( is not balanced.
 */
public class BalancedString {
	
	public static boolean checkValidString(String s) {
        Stack<Integer> leftID = new Stack<>();
        Stack<Integer> starID = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(')
                leftID.push(i);
            else if (ch == '*')
                starID.push(i);
            else {
                if (leftID.isEmpty() && starID.isEmpty())   return false;
                if (!leftID.isEmpty())
                    leftID.pop();
                else 
                    starID.pop();
            }
        }
        while (!leftID.isEmpty() && !starID.isEmpty()) {
            if (leftID.pop() > starID.pop()) 
                return false;
        }
        return leftID.isEmpty();
    }
	public static void main(String a[])
	{
		String s="()(**((*(*";
		System.out.println(checkValidString(s));
		
	}

}

/*
 * /*class Solution {
    public boolean checkValidString(String s) {  
    int leftBalance = 0;
    for (int i=0; i<s.length(); i++) {
      if ((s.charAt(i) == '(') || (s.charAt(i) == '*'))
        leftBalance++;        
      else
        leftBalance--;
      
      if (leftBalance<0) return false; // We know we have unbalanced parenthesis
    }
    
    // We can already check if parenthesis are valid
    if (leftBalance == 0) return true;
            
    int rightBalance = 0;
    for (int i=s.length()-1; i>=0; i--) {
      if ((s.charAt(i) == ')') || (s.charAt(i) == '*'))
        rightBalance++;
      else
        rightBalance--;
      
      if (rightBalance<0) return false;  // We know we have unbalanced parenthesis
    }
    
    // Here we know we have never been unbalanced parsing from left to right e.g. ')('
    // We've also already substituted '*' either by '(' or by ')'
    // So we only have 3 possible scenarios here:
    // 1. We had the same amount of '(' and ')'
    // 2. We had more '(' then ')' but enough '*' to substitute
    // 3. We had more ')' then '(' but enough '*' to substitute
    return true;
  }
}

class Solution {
    public boolean checkValidString(String s) {
       int lo = 0, hi = 0;
       for (char c: s.toCharArray()) {
           lo += c == '(' ? 1 : -1;
           hi += c != ')' ? 1 : -1;
           if (hi < 0) break;
           lo = Math.max(lo, 0);
       }
       return lo == 0;
    }
}*/

