import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/*Length of the smallest sub-string consisting of maximum distinct characters*/

public class wallmartPractice1 {
	public static void main(String[] args) {
		String s="aabcbcdbca";
		System.out.println(find(s));
		//System.out.println(findEffecient(s));
	}
	private static int find(String s) {

		int frmleft[]=new int[s.length()];frmleft[0]=1;
		int frmright[]=new int[s.length()];
		List<Character> set=new ArrayList<Character>();
		set.add(s.charAt(0));
		for(int i=1;i<s.length();i++) {
			if(!set.contains(s.charAt(i))){
				set.add(s.charAt(i));
				frmleft[i]=frmleft[i-1]+1;
			}
			else
				frmleft[i]=frmleft[i-1];
		}
		printA(frmleft);
		
		set.clear();frmright[s.length()-1]=1;set.add(s.charAt(s.length()-1));
		for(int i=s.length()-2;i>=0;i--) {
			if(!set.contains(s.charAt(i))){
				set.add(s.charAt(i));
				frmright[i]=frmright[i+1]+1;
			}
			else
				frmright[i]=frmright[i+1];
		}
		printA(frmright);
		System.out.println(set);
		return findMin(frmleft,frmright,set.size());
		
		
	}

	private static void printA(int[] a) {
		// TODO Auto-generated method stub
		for(int i=0;i<a.length;i++) {
			System.out.print(a[i]+" ");
		}
		System.out.println();
		
	}

	private static int findMin(int[] frmleft, int[] frmright,int dis) {
		int End1=-1;int st1=-1;
		for(int i=0;i<frmleft.length;i++) {
			if(frmleft[i]==2 && st1==-1)st1=i-1;
			if(frmleft[i]==dis) {
				End1=i;
				break;
			}
		}
		int End2=-1;int st2=-1;
		for(int i=frmright.length-1;i>=0;i--) {
			if(frmright[i]==2 && st2==-1)st2=i+1;
			if(frmright[i]==dis) {
				End2=i;
				break;
			}
		}
		return Math.min(End1-st1+1,st2-End2+1);
	}

}
