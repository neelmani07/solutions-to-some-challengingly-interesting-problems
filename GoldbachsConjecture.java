/*
 * This problem was asked by Alibaba.

Given an even number (greater than 2), return two prime numbers whose sum will be equal to the given number.

A solution will always exist. See Goldbach’s conjecture.

Example:

Input: 4
Output: 2 + 2 = 4

 */
public class GoldbachsConjecture {
//Java program to find a prime number pair whose 
//sum is equal to given number 
//Java program to print super primes less than 
//or equal to n. 
	// Generate all prime numbers less than n. 
	static boolean SieveOfEratosthenes(int n, boolean isPrime[]) 
	{ 
		// Initialize all entries of boolean 
		// array as true. A value in isPrime[i] 
		// will finally be false if i is Not a 
		// prime, else true bool isPrime[n+1]; 
		isPrime[0] = isPrime[1] = false; 
		for (int i = 2; i <= n; i++) 
			isPrime[i] = true; 
	
		for (int p = 2; p * p <= n; p++) 
		{ 
			// If isPrime[p] is not changed, 
			// then it is a prime 
			if (isPrime[p] == true) 
			{ 
				// Update all multiples of p 
				for (int i = p * p; i <= n; i += p) 
					isPrime[i] = false; 
			} 
		} 
		return false; 
	} 
	
	// Prints a prime pair with given sum 
	static void findPrimePair(int n) 
	{ 
		// Generating primes using Sieve 
		boolean isPrime[]=new boolean[n + 1]; 
		SieveOfEratosthenes(n, isPrime); 
	
		// Traversing all numbers to find first 
		// pair 
		for (int i = 0; i < n; i++) 
		{ 
			if (isPrime[i] && isPrime[n - i]) 
			{ 
				System.out.print(i + " " + (n - i)); 
				return; 
			} 
		} 
	} 
	
	// Driver code 
	public static void main (String[] args) 
	{ 
		int n = 74; 
		findPrimePair(n); 
	} 
} 
 
