import java.util.Arrays;
import java.util.HashMap;

/*
 * This problem was asked by Google.

Given an array of numbers and an index i, 
return the index of the nearest larger number of the number at index i, 
where distance is measured in array indices.

For example, given [4, 1, 3, 5, 6] and index 0, you should return 3.

If two distances to larger numbers are the equal, then return any one of them. 
If the array at i doesn't have a nearest larger integer, then return null.

Follow-up: If you can preprocess the array, can you do this in constant time?
 */
public class NearestLarger {
	
	public static int nearestLarger(int ar[],int index)
	{	int cur=ar[index]; 
		HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
		for(int i=0;i<ar.length;i++) {
			map.put(ar[i],i);
		}
		Arrays.sort(ar);
		HashMap<Integer,Integer> nextL=new HashMap<Integer,Integer>();
		for(int i=0;i<ar.length-1;i++) {
			nextL.put(ar[i],ar[i+1]);
		}
		nextL.put(ar[ar.length-1],-1);
		int nextLar=nextL.get(cur);
		if(nextLar==-1)return -1;
		return map.get(nextLar);
		
	}
	public static void main(String[] args) {
		int ar[]=new int[] {4, 1, 3, 15, 6};
		System.out.println(nearestLarger(ar,3));
	}

}
