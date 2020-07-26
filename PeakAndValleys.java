package CTCI;

public class PeakAndValleys {
	public static void disp(int ar[]) {
		for(int i=0;i<ar.length;i++) {
			System.out.print(ar[i]+" ");
		}
	}
	public static void sortInPeaksAndValleys(int []a) {
		String surfaceWas=" ";
		if(a[0]<a[1])surfaceWas="valley";
		else surfaceWas="peak";
		for(int i=1;i<a.length-1;i++) {
			if(surfaceWas=="valley"){
				if( a[i]>a[i+1] ) {
					surfaceWas="peak";
				}
				else
				{
					//swap a[i] with a[i+1]
					int t=a[i];a[i]=a[i+1];
					a[i+1]=t;
					surfaceWas="peak";
				}
			}
			else if(surfaceWas=="peak" ) {
				if(a[i]<a[i+1]) {
					surfaceWas="valley";
				}
				else
				{
					//swap a[i] with a[i+1]
					int t=a[i];a[i]=a[i+1];
					a[i+1]=t;
					surfaceWas="valley";
				}
			}
		}
	}
	public static void main(String arg[]) {
		int array[]=new int[] {5,8,6,2,2,3,4,6};
		int array2[]=new int[] {9,1,0,4,8,7};
		sortInPeaksAndValleys(array2);
		disp(array2);
	}

}
