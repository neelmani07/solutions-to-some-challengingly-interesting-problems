
public class AnagramMatching {
	
	public static boolean isEmpty(int dict[]) {
		int count=0;
		for(int i=0;i<dict.length;i++) {
			if(dict[i]==1)
				count+=1;
		}
		return (count==0)?true:false;
	}
	public static void findStartOfAnagrams(String sen,String wrd) {
		
		int dict[]=new int[26];
		for(int i=0;i<wrd.length();i++) {
			dict[(int)(wrd.charAt(i)-'a')]=1;
		}
		for(int i=0;i<wrd.length();i++) {
			dict[(int)(sen.charAt(i)-'a')]--;
		}
		if(isEmpty(dict))System.out.print(0+" ");
		
		for(int i=wrd.length();i<sen.length();i++) {
			
			int toRemove=(int)(sen.charAt(i-wrd.length())-'a');
			int toAdd=(int)(sen.charAt(i)-'a');
			dict[toRemove]++;
			dict[toAdd]--;
			if(isEmpty(dict))System.out.print((i-wrd.length()+1)+" ");
		}
	
	}
	public static void main(String s[])
	{
		String wrd="ab";
		String sen="abajkfsabahbubaihaab";
		findStartOfAnagrams(sen,wrd);
		
	}

}
