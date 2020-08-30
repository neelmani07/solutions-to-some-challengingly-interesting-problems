import java.util.HashMap;

/*Before the advent of QWERTY keyboards, texts and numbers were placed on the same key. 
 * For example, 2 has “ABC” if we wanted to write anything starting with ‘A’ we need to type key 2 once. 
 * If we wanted to type ‘B’, press key 2 twice and thrice for typing ‘C’. 
 * Below is a picture of such keypad.
 
Given a keypad as shown in the diagram, and an n digit number, list all words which are possible by pressing these numbers.

Example:

Input number: 234
Output:
adg adh adi aeg aeh aei afg afh 
afi bdg bdh bdi beg beh bei bfg 
bfh bfi cdg cdh cdi ceg ceh cei 
cfg cfh cfi
*/
public class PhoneWords {
	public static void main(String[] args) {
		HashMap<Integer,String> keys=new HashMap<Integer,String>();
		keys.put(2,"abc");keys.put(3,"def");
		keys.put(4,"ghi");keys.put(5,"jkl");
		keys.put(6,"mno");keys.put(7,"pqrs");
		keys.put(8,"tuv");keys.put(9,"wxyz");
		generate(keys,"234",0,"");
	}

	private static void generate(HashMap<Integer,String> k,String key,int ind,String out) {
		if(key.length()==ind) {
			System.out.print(" "+out);
			return;
		}
		char[] chrset=k.get(Character.getNumericValue((key.charAt(ind)))).toCharArray();
		for(int i=0;i<chrset.length;i++) {
			generate(k,key,ind+1,out+chrset[i]);
		}
	}

}
