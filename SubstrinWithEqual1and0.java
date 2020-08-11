import java.util.HashMap;

public class SubstrinWithEqual1and0 {

	public static void main(String[] args) {
		int arr[]=new int[] {1,0,0,1,1,1,0,};
		System.out.println(findSubArray(arr,arr.length));
		
	}

	private static int findSubArray(int[] arr,int n) {
		int maxLen=-1;
		HashMap<Integer,Integer> lengths =new HashMap<Integer,Integer>();
		int sumfromLeft[]=new int[n];
		for(int i=0;i<n;i++) {
			sumfromLeft[i]+=arr[i]==0?-1:1;
		}
		
		for(int i=0;i<n;i++) {
			int sum=sumfromLeft[i];
			if(!lengths.containsKey(sum))
				lengths.put(sum, i);
			else {
				int prev_Ind=lengths.get(sum);
				maxLen= maxLen>(i-prev_Ind+1)?maxLen:(i-prev_Ind+1);
			}
		}
		return maxLen;
	}
}
