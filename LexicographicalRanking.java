/*Given a string, find its rank among all its permutations sorted lexicographically. For example, rank of “abc” is 1, rank of “acb” is 2, and rank of “cba” is 6.

Examples:

Input : str[] = "acb"
Output : Rank = 2

Input : str[] = "string"
Output : Rank = 598

Input : str[] = "cba"
Output : Rank = 6*/
public class LexicographicalRanking {
	public static void main(String[] args) {
		String s = "string";
		System.out.println(findRank(s));
	}
	static int fact[];
	private static int findRank(String s) {
		fact=new int[s.length()];
		fact[0]=1;fact[1]=1;fact[2]=2;
		int sum=0;
		char str[]=s.toCharArray();
		for(int i=0;i<str.length;i++) {
			char ch=str[i];int count=0;
			for(int j=i+1;j<str.length;j++) {
				if(str[j]<str[i])
					count++;
			}
			sum+=count*fact(str.length-i-1);
		}
		return sum+1;
	}

	private static int fact(int i) {
		if(fact[i]!=0)
			return fact[i];
		else {
			fact[i]=fact(i-1)*i;
			return fact[i];
		}
		
	}
}
