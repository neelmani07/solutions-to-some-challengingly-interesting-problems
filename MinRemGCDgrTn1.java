package leetcode;


import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class MinRemGCDgrTn1 {
	public static void main(String[] args) {
		int ar[]=new int[] {4,8,6};
		System.out.println(find(ar));
	}

	private static int find(int[] ar) {
		PriorityQueue<int[]> mp = 
                new PriorityQueue<>((a,b)->(b[1]-a[1]));

	    Set<Integer> st=new HashSet<Integer>();
	    for(int i=0;i<ar.length;i++)st.add(ar[i]);
		int count=0;
		for(int i=0;i<ar.length;i++) {
			for(int j=0;j<ar.length;j++) {
				if(hcf(ar[j],ar[i])==1)
					count++;
			}
			mp.add(new int[] {ar[i],count});
			count=0;
		}
		count=0;
		while(!allHcfGreaterThn1(st)) {
			int a[]=mp.poll();
			st.remove(a[0]);
			count++;
		}
		return count;
	}

	private static int hcf(int ar, int ar2) {
		if(ar==ar2)
			return ar;
		if (ar2 == 0) 
			return  ar; 
		return hcf(ar2,ar % ar2); 
	}

	private static boolean allHcfGreaterThn1(Set<Integer> st) {
		Object[] ar;
		ar=st.toArray();
		int j=1;
		while(j<ar.length) {
			if(hcf((int)ar[j-1],(int)ar[j])>1)
				j++;
			else
				break;
		}
		if(j==ar.length)
			return true;
		return false;
	}
}
