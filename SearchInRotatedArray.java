package CTCI;

public class SearchInRotatedArray {

	public static int search(int ar[],int key,int left,int right) {
		
		if(left>right)return -1;
		
		int mid=left+(right-left)/2;
		
		if(ar[mid]==key)return mid;
		
		if(ar[mid]>key) {
			//checking for anomaly
			if(ar[mid]>ar[right] || ar[mid]<ar[left]) {
				//anomaly on right
				if(ar[mid]>ar[right]) {
					//but key is also in right side
					if(ar[right]<=key)
						return search(ar,key,mid+1,right);
					else //key is on left side
						return search(ar,key,left,mid-1);
				}
				//anomaly is on left side, key has to be on left 
				else {
					return search(ar,key,left,mid-1);
				}
				
			}
			else {
				return search(ar,key,left,mid-1);
			}
			
		}
		else if(ar[mid]<key) {
			//checking for anomaly
			if(ar[mid]>ar[right] || ar[mid]<ar[left]) {
				//anomaly on left
				if(ar[mid]<ar[left]) {
					//but key is also on left side
					if(key>=ar[left])
						return search(ar,key,left,mid-1);
					else//key is on rght side
						return search(ar,key,mid+1,right);
					
				}
				//if(anomaly is on right side, key has to on right
				else {
					return search(ar,key,mid+1,right);
				}
				
			}
			else {
				return search(ar,key,mid+1,right);
			}
			
		}
		return -1;
	}
	public static void main(String arg[]) {
		
		int array[]=new int [] {15,16,19,20,25,1,3,4,5,7,10,14};
		System.out.println("found at index="+search(array,20,0,array.length-1));
	}
}
