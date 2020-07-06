import java.util.*;
import java.util.Scanner;

/*
 * This problem was asked by Facebook.
 * 
Given an unordered list of flights taken by someone, 
each represented as (origin, destination) pairs, 
and a starting airport, compute the person's itinerary. 
If no such itinerary exists, return null. 

If there are multiple possible itineraries, return the 
lexicographically smallest one. All flights must be used in the itinerary.

For example, given the list of flights [('SFO', 'HKO'), 
('YYZ', 'SFO'), ('YUL', 'YYZ'), ('HKO', 'ORD')] 
and starting airport 'YUL', 
you should return the list ['YUL', 'YYZ', 'SFO', 'HKO', 'ORD'].
Given the list of flights [('SFO', 'COM'), ('COM', 'YYZ')] and 
starting airport 'COM', you should return null.
Given the list of flights [('A', 'B'), ('A', 'C'), 
('B', 'C'), ('C', 'A')] and starting airport 'A', 
you should return the list ['A', 'B', 'C', 'A', 'C'] 
even though ['A', 'C', 'A', 'B', 'C'] is also a valid itinerary. 
However, the first one is lexicographically smaller.
 */

public class PersonItinerary {

	HashMap<String,ArrayList<String>> flights;
	PersonItinerary()
	{
		flights=new HashMap<String,ArrayList<String>>();
		fillFlights();
		
	}
	public void fillFlights()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("no of flights?");
		int n=sc.nextInt();
		System.out.println("Enter source and destinations pairs");
		for(int i=1;i<=n;i++)
		{
			String src=sc.next();
			String dest=sc.next();
			if(flights.containsKey(src))
			{
				ArrayList<String> l=flights.get(src);
				l.add(dest);
				flights.put(src,l);
			}
			else
			{
				ArrayList<String> l=new ArrayList<String>();
				l.add(dest);
				flights.put(src,l);
			}
			
			
		}
		System.out.print(flights);
	}
	public void computeItinerary(String src)
	{
		if(! flights.containsKey(src))
		{
			System.out.print("no route");
			return;
		}
		else
		{
			ArrayList<String> citiesFromSrc=flights.get(src);
			for(int i=0;i<citiesFromSrc.size();i++)
			{
				if(! flights.containsKey(citiesFromSrc.get(i)))
					continue;
				ArrayList<String> cities=flights.get(citiesFromSrc.get(i));
				for(int j=0;j<cities.size();j++)
				{
					if( ! citiesFromSrc.contains(cities.get(j)))
							citiesFromSrc.add(cities.get(j));
				}
			}
		}
	
	}
	public static void main(String a[])
	{
		Scanner sc=new Scanner(System.in);
		
		PersonItinerary ob=new PersonItinerary();
		ArrayList<String> route=new ArrayList<String>();
		System.out.println("source?");
		String src=sc.next();
		ob.computeItinerary(src);
		System.out.print(ob.flights.get(src));
		
	}
}
