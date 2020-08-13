
public class DuplicateInLinearTime {

	public static void main(String[] args) {
		int arr[]=new int[] {1,3,2,4,5,6,2};
		System.out.println(findDup(arr));
	}

	public static int findDup(int[] arr) {
		int dup=-1;
		arr[arr[0]-1]=-1*arr[arr[0]-1];
		for(int i=1;i<arr.length;i++) {
			if(arr[Math.abs(arr[i])-1]<0) {
				dup=arr[i];
				break;
			}
			else
				arr[Math.abs(arr[i])-1]=-1*arr[Math.abs(arr[i])-1];
		}
		return dup;
	}
}
