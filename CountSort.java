package CTCI;

public class CountSort {
	
	public static int findMax(int ar[]) {
		int max=0;
		for(int i=0;i<ar.length;i++) {
			max=max>ar[i]?max:ar[i];
		}
		return max;
	}
	public static void disp(int ar[]) {
		for(int i=0;i<ar.length;i++) {
			System.out.print(ar[i]+" ");
		}
		System.out.println();
	}
	public static void countSort(int ar[]) {
		int len=ar.length;
		int out[]=new int[len+1];
		int mx=findMax(ar);
		int count[]=new int[mx+1];
		//disp(count);
		for(int i=0;i<len;i++) {
			count[ar[i]]++;
		}
		//disp(count);
		for(int i=1;i<=mx;i++) {
			count[i]+=count[i-1];
		}
		//disp(count);
		for(int i=len-1;i>=0;i--) {
			out[count[ar[i]]]=ar[i];
			count[ar[i]]--;
		}
		disp(out);		
	}
	public static void main(String arg[]) {
		int ar[]=new int []{400,101,3,5,12};
		countSort(ar);
	}

}

/*
 * oid countSort(int *array, int size) {
   int output[size+1];
   int max = getMax(array, size);
   int count[max+1]; //create count array (max+1 number of elements)

   for(int i = 0; i<=max; i++)
      count[i] = 0; //initialize count array to all zero
   for(int i = 1; i <=size; i++)
      count[array[i]]++; //increase number count in count array.
   for(int i = 1; i<=max; i++)
      count[i] += count[i-1]; //find cumulative frequency

   for(int i = size; i>=1; i--) {
      output[count[array[i]]] = array[i];
      count[array[i]] -= 1; //decrease count for same numbers
   }

   for(int i = 1; i<=size; i++) {
      array[i] = output[i]; //store output array to main array
   }*/
