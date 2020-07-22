import java.util.*;

/*
 * This problem was asked by Amazon.

You are given a list of data entries that represent entries and exits of groups of people into a building. 
An entry looks like this:

{"timestamp": 1526579928, count: 3, "type": "enter"}

This means 3 people entered the building. An exit looks like this:

{"timestamp": 1526580382, count: 2, "type": "exit"}

This means that 2 people exited the building. timestamp is in Unix time.

Find the busiest period in the building, that is, the time with the most people in the building. 
Return it as a pair of (start, end) timestamps. You can assume the building always starts off 
and ends up empty, i.e. with 0 people inside.
 */
public class BusiestHours {

	public static void collectData( SortedMap<Integer,Integer> tAndC) {
		Scanner sc=new Scanner(System.in);
		System.out.print("enter time statmps   count    entry/exit");
		for(int inputs=1;inputs<=7;inputs++) {
			
			int tS=sc.nextInt();
			int c=sc.nextInt();
			String state=sc.next();
			if(state.equals("exit"))
				c=-1*c;
			tAndC.put(tS,c);
			//System.out.println(tS+"  "+c+" "+state);
			
		}
		
	}
	public static void useKadanesAlgo(SortedMap<Integer,Integer> tAndC) { 
        int max_so_far = Integer.MIN_VALUE, max_ending_here = 0; 
        Set s = tAndC.entrySet();Iterator i = s.iterator(); 
        int ts1=1;int tS2=0;
        while (i.hasNext()) 
        { 
        	
            Map.Entry m = (Map.Entry)i.next(); 
  
            int key = (Integer)m.getKey(); 
            int value = (Integer)m.getValue(); 
            if(max_ending_here==0)ts1=key;
            System.out.println(key+" "+value);
            max_ending_here = max_ending_here + value; 
            if (max_so_far < max_ending_here)
            {
            	max_so_far = max_ending_here;
            	tS2=key;
            }
            if (max_ending_here < 0) 
            {
            	max_ending_here = 0;
            }
            
        }
        System.out.println("busiest Hours:"+ts1+" to "+tS2+"  count="+max_so_far);
        
	}
	public static void main(String a[]) {
		SortedMap<Integer,Integer>timeAndCount=new TreeMap<Integer, Integer>(); 
		//taking input
		collectData(timeAndCount);
		//find busiest time range using kadanes algo
		useKadanesAlgo(timeAndCount);
	}
}

/*
 * {"timestamp": 1, count: 10, "type": "enter"}
{"timestamp": 3, count: 2, "type": "exit"}
{"timestamp": 5, count: 1, "type": "enter"}
{"timestamp": 6, count: 1, "type": "enter"}
{"timestamp": 7, count: 1, "type": "enter"}
{"timestamp": 9, count: 3, "type": "exit"}
{"timestamp": 10, count: 8, "type": "exit"}*/
