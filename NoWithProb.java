/*
 * This problem was asked by Triplebyte.

You are given n numbers as well as n probabilities that sum up to 1. 
Write a function to generate one of the numbers with its corresponding probability.

For example, given the numbers [1, 2, 3, 4] and 
probabilities [0.1, 0.5, 0.2, 0.2], your function should return 1 10% of the time, 
2 50% of the time, and 3 and 4 20% of the time.

You can generate random numbers between 0 and 1 uniformly.
 */
public class NoWithProb {
	public static void main(String[] args) {
		int num[]=new int[] {1, 2, 3, 4};
		double prob[]=new double[] {0.1, 0.5, 0.2, 0.2};
		generete(num,prob);
	}

	private static void generete(int[] num, double[] prob) {
		System.out.println((int)(Math.random()*10));
		int ar[]=new int[10];int j=0;
		for(int i=0;i<prob.length;i++) {
			int r=(int) (prob[i]*10);int limit=j+r;
			while(j<limit)
			{
				ar[j]=num[i];
				j++;
			}
		}
		System.out.println(ar[(int)(Math.random()*10)]);
	}
	

}
