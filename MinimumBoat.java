package leetcode;

import java.util.Arrays;

public class MinimumBoat {
	public static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int solution = 0;
        int start = 0;
        int end = people.length -1;
        
        while(start <= end) {
            solution++;
            if(start == end) break; // last person on boat
            if(people[start] + people[end] <= limit) start++; // we can carry two people
            end--;
        }
        return solution;
    }
    public static void main(String s[]) {
    	int ar[]= {2,49,10,7,11,41,47,2,22,6,13,12,33,18,10,26,2,6,50,10};
    	int l=50;
    	System.out.println(numRescueBoats(ar,l));
    }
}