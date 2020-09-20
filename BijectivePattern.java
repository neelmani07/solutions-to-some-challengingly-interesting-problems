
/*
 * Input: pattern = "abba", s = "dog cat cat dog"
Output: true
*/
package leetcode;

import java.util.HashMap;
import java.util.Map;

public class BijectivePattern {
	public static void main(String[] args) {
		System.out.println(wordPattern("abba","dog dog dog dog"));
	}
	public static boolean wordPattern(String p, String s) {
        
        String wrds[]=s.split(" ");
        Map<Character,String> mp=new HashMap<Character,String>();
        int pl=p.length();int wl=wrds.length;
        if(pl!=wl)return false;
        for(int i=0;i<pl;i++){
            Character ch=p.charAt(i);
            if(! mp.containsKey(ch) && ! mp.containsValue(wrds[i])){
                mp.put(ch,wrds[i]);
            }
            else{
            	if(mp.containsKey(ch)) {
	                if(! mp.get(ch).equals(wrds[i]))
	                    return false;
            	}
            	else {
            		if(!mp.containsKey(ch))
            			return false;
            	}
            }
        }
        return true;
    }
}
