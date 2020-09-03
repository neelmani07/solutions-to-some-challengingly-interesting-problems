package leetcode;
// 112 = aab,kb,al.


public class AllDecode {
	public static void main(String[] args) {
		String s="112";
		find(s,"",0);
	}
	private static void find(String s,String out,int j) {
		if(j==s.length()) {
			System.out.println(out);
			return;
		}
		for(int i=j+1;i<=s.length();i++) {
			int intVal=Integer.valueOf(s.substring(j,i));
			if(intVal<27)
				find(s,out+(char)(intVal+64),i);
		}
	}
}
