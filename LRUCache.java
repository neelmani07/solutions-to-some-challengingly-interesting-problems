package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/*
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

The cache is initialized with a positive capacity.

Follow up:
Could you do both operations in O(1) time complexity?
 */
public class LRUCache {

	Queue<Integer> cache;
	HashMap<Integer,Integer> map; 
	int count;int totalCap;
	
	public LRUCache(int capacity) {
	       
		cache=new LinkedList<Integer>();
		map=new HashMap<Integer,Integer>(capacity);
		count=0;totalCap=capacity;
		
	}
	    
	public int get(int key) {
		System.out.println("head="+cache.peek());
		int val=-1;
		if(cache.contains(key))
		{
			val= map.get(key);
			cache.remove(key);
			cache.add(key);
			System.out.println("head="+cache.peek());
		}
		return val;
	        
	}
	    
	public void put(int key, int value) {
		
		if(count==totalCap && !cache.contains(key))
		{
			int removedKey=cache.poll();
			map.remove(removedKey);
			System.out.println("evicted key="+removedKey);
			cache.add(key);
			map.put(key, value);
		}
		else
		{
			if(! cache.contains(key))
			{
				count++;
				cache.add(key);
				map.put(key, value);
			}
			else
				map.replace(key, value);
			
		}
	        
	}
	public static void main(String a[]) {
		LRUCache cache = new LRUCache( 2 /* capacity */ );
		System.out.println(cache.get(2));
		cache.put(2,6);
		System.out.println(cache.get(1));		
		cache.put(1, 5);						
		cache.put(1, 2);;       				
		System.out.println(cache.get(1));       
		System.out.println(cache.get(2));       
		System.out.println(cache.get(4));
		
		
	}
}
