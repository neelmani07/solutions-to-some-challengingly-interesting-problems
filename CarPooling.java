/*
 * You are driving a vehicle that has capacity empty seats initially available for passengers.  
 * The vehicle only drives east (ie. it cannot turn around and drive west.)

Given a list of trips, trip[i] = [num_passengers, start_location, 
  end_location] contains information about the i-th trip: 
  the number of passengers that must be picked up, and the locations to pick them up and drop them off.  
  The locations are given as the number of kilometers due east from your vehicle's initial location.

Return true if and only if it is possible to pick up and drop off all passengers for all the given trips. 

 

Example 1:

Input: trips = [[2,1,5],[3,3,7]], capacity = 4
Output: false
Example 2:

Input: trips = [[2,1,5],[3,3,7]], capacity = 5
Output: true
Example 3:

Input: trips = [[2,1,5],[3,5,7]], capacity = 3
Output: true
Example 4:

Input: trips = [[3,2,7],[3,7,9],[8,3,9]], capacity = 11
Output: true

[[9,3,4],[9,1,7],[4,2,4],[7,4,5]]
23  =true
 */
package leetcode;

import java.util.SortedMap;
import java.util.TreeMap;

public class CarPooling {
	public static void main(String[] args) {
		int [][]trips=new int[][] {{2,1,5},{3,3,7}};//{{9,3,4},{9,1,7},{4,2,4},{7,4,5}};//{{2,1,5},{3,5,7}};
		System.out.println(find(trips,4
				));
	}

	private static boolean find(int[][] trips,int cap) {
		SortedMap<Integer,Integer> load=new TreeMap<Integer,Integer>();
		SortedMap<Integer,Integer> unload=new TreeMap<Integer,Integer>();
		for(int i=0;i<trips.length;i++) {
			if(load.containsKey(trips[i][1])) {
				load.put(trips[i][1],load.get(trips[i][1])+trips[i][0]);
			}
			else
				load.put(trips[i][1],trips[i][0]);
			
			if(unload.containsKey(trips[i][2])) {
				unload.put(trips[i][2],unload.get(trips[i][2])+trips[i][0]);
			}
			else
				unload.put(trips[i][2],trips[i][0]);
			
		}
		
		while(!load.isEmpty() && !unload.isEmpty()) {
			int nextPickUp=load.firstKey();
			int nextDrop=unload.firstKey();
			if(nextPickUp<nextDrop) {
				cap-=load.get(nextPickUp);
				load.remove(nextPickUp);
				if(cap<0)
					return false;
			}
			else {
				cap+=unload.get(nextDrop);
				unload.remove(nextDrop);
			}
		}
		return true;
	}

}
