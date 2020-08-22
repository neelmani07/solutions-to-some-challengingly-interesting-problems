import java.util.Arrays;

public class KLengthSubstringsWithNoRepeatedCharacters {
	public static void main(String[] args) {
		String s="heyfriendhowareyou",s1="hellow";int k=5;
		System.out.println(find(s,k));
	}

	private static int find(String s, int k) {
		int count=0;int strt=0;
		int lstIndex[]=new int[26];
		Arrays.fill(lstIndex, -1);
		char[] ar=s.toCharArray();
		for(int i=0;i<ar.length;i++) {
			if(i-strt+1==k) {
				count++;
				System.out.println(ar[i]);
			}
			
			if(lstIndex[ar[i]-'a']>strt) {
				strt=lstIndex[ar[i]-'a']+1;
			}
			else if(i+1>=k)
					strt++;
			lstIndex[ar[i]-'a']=i;
		}
		return count;
	}

}
