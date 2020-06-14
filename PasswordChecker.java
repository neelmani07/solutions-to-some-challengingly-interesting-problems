package leetcode;
/*
 * A password is considered strong if below conditions are all met:

    It has at least 6 characters and at most 20 characters.
    It must contain at least one lowercase letter, at least one uppercase letter, and at least one digit.
    It must NOT contain three repeating characters in a row ("...aaa..." is weak, but "...aa...a..." is strong, assuming other conditions are met).

Write a function strongPasswordChecker(s), that takes a string s as input, and return the MINIMUM change required to make s a strong password. If s is already strong, return 0.

Insertion, deletion or replace of any one character are all considered as one change.
 */

public class PasswordChecker  {
	
    public static void strongPasswordChecker(String s) {
        
        boolean noOfCharacFault = false,LowerCase=false,UpperCase=false,repeatCh=false;
        boolean digit=false;
        if(s.length()<6 || s.length()>20)
            noOfCharacFault=true;
        
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if(Character.isLowerCase(ch))
                LowerCase=true;
            if(Character.isUpperCase(ch))
                UpperCase=true;
            if(Character.isDigit(ch))
            	digit=true;
            
            if(i>0 && i < s.length()-1)
            {
                if(s.charAt(i-1)==s.charAt(i+1) && s.charAt(i+1) == ch  )
                    repeatCh=true;
            }
        }
        
        if(!LowerCase || !UpperCase || !digit || repeatCh || noOfCharacFault)
            System.out.println("not strong");
        else 
        	System.out.println("Strong");
        
        
        
    }
    
    public static void main(String a[])
    {
    	String s="hee2loQ";
    	strongPasswordChecker(s);
    }

}