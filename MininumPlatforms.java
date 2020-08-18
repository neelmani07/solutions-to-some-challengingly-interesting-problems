/*
 * Given arrival and departure times of all trains that 
 * reach a railway station. Your task is to 
 * find the minimum number of platforms required for the railway station so that no train waits.
 */
public class MininumPlatforms {

	public static void main(String[] args) {
		int arr[]=new int[] {900 , 940,950,1100,1500,1800};
		int dep[]=new int[] {1220,1200,1120,1130,1900,2000};
		System.out.println(find(arr,dep));
	}

	private static int find(int[] arr, int[] dep) {
		int max=-1;
		for(int i=0;i<dep.length-1;i++) {
			int count=0;
			for(int j=i+1;j<arr.length;j++) {
				if(arr[j]<=dep[i]) {
					count++;
				}
				else
					break;
				max=max>count?max:count;
			}
		}
		return max+1;
	}
}
