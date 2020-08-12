
package KickStart;

import java.util.ArrayList;
import java.util.List;

//link https://codingcompetitions.withgoogle.com/kickstart/round/0000000000050edd/00000000001a274e#problem
public class H_Index {

	public static void main(String[] args) {
		int ar[]=new int[] {1,3,3,2,2,15};
		findHIndexes(ar);
	}

	private static void findHIndexes(int[] ar) {
		int count[]=new int[ar.length+1];
		List<Integer> ans=new ArrayList<Integer>();
		for(int i=0;i<ar.length;i++) {
			int cit=ar[i];
			ans.add(fillAndGetMaxCit(ar,count,i,cit));
		}
		System.out.println(ans);
	}

	private static int fillAndGetMaxCit(int[] ar, int[] count, int i, int cit) {
		int max=0;
		if(cit>count.length)
			cit=count.length-1;
		for(int i1=cit;i1>0;i1--) {
			count[i1]+=+1;
			if(count[i1]>=i1) {
				max=max>i1?max:i1;
			}
		}
		
		return max;
	}
}
