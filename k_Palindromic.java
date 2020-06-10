/*
This problem was asked by Google.

Given a string which we can delete at most k, return whether you can make a palindrome.

For example, given 'waterrfetawx' and a k of 2, you could delete f and x to get 'waterretaw'.
*/
public class k_Palindromic
{
    public static void main(String[] args) 
    {
        String s="waterrfetawx";
        int k =2 ;
        if (testIt(s, k)) {
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }
    }

    public static boolean testIt(String s, int k) {
        if (s.length() <= 1) {
            return true;
        }

        while (s.charAt(0) == s.charAt(s.length()-1)) {
            s = s.substring(1, s.length()-1);

            if (s.length() <= 1) {
                return true;
   

         }
        }

        if (k == 0) {
            return false;
        }

        // Try to remove the first or last character
        return testIt(s.substring(0, s.length() - 1), k - 1) || testIt(s.substring(1, s.length()), k - 1);
    }
}
