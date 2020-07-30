import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
 * This problem was asked by Google.

Given a set of distinct positive integers, 
find the largest subset such that every pair of elements in the subset (i, j) 
satisfies either i % j = 0 or j % i = 0.

For example, given the set [3, 5, 10, 20, 21], you should return [5, 10, 20]. 
Given [1, 3, 6, 24], return [1, 3, 6, 24].
 */
public class EachPairDivides {
	
	
	// Java program to find largest divisible 
	// subset in a given arrayimport java.io.*; 
		// Prints largest divisible subset 
		static void findLargest(int[] arr) { 

			// array that maintains the maximum index 
			// till which the condition is satisfied 
			int divCount[] = new int[arr.length]; 
			
			// we will always have atleast one 
			// element divisible by itself 
			Arrays.fill(divCount, 1); 

			// maintain the index of the last increment 
			int prev[] = new int[arr.length]; 
			Arrays.fill(prev, -1); 

			// index at which last increment happened 
			int max_ind = 0; 

			for (int i = 1; i < arr.length; i++) { 
				for (int j = 0; j < i; j++) { 

					// only increment the maximum index if 
					// this iteration will increase it 
					if (arr[i] % arr[j] == 0 && 
						divCount[i] < divCount[j] + 1) { 
						prev[i] = j; 
						divCount[i] = divCount[j] + 1; 

					} 

				} 
			// Update last index of largest subset if size 
			// of current subset is more. 
				if (divCount[i] > divCount[max_ind]) 
					max_ind = i; 
			} 

			// Print result 
			int k = max_ind; 
			while (k >= 0) { 
				System.out.print(arr[k] + " "); 
				k = prev[k]; 
			} 

		} 

		public static void main(String[] args) { 

			int[] x = {3, 5, 10, 20, 21}; 

			// sort the array 
			Arrays.sort(x); 

			findLargest(x); 
		} 
	} 
