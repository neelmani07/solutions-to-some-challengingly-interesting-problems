
public class SortArrayWithRecursion {
	public static void main(String[] args) {
		int ar[]=new int[] {5,1,2,0,4};
		int ans[]=sort(ar,0);
		for(int i=0;i<ans.length;i++) {
			System.out.println(ans[i]);
		}
	}

	private static int[] sort(int[] ar,int ind) {
		if(ind==ar.length-1) {
			return new int[] {ar[ind]};
		}
		int elemToInsert=ar[ind];
		int []sort=sort(ar,ind+1);
		int ret[]= new int[sort.length+1];
		int i=0;
		while(i<sort.length && sort[i]<=elemToInsert) {
			ret[i]=sort[i];
			i++;
		}
		ret[i]=elemToInsert;
		while(i<sort.length) {
			ret[i+1]=sort[i];
			i++;
		}
		return ret;
	}

}
