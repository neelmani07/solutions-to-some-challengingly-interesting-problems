import java.util.*;
import java.lang.*;
class Twitter
{

    HashMap<Integer,Integer> tweets;
    HashMap<Integer,Integer> followList;
    PriorityQueue<int[]> tweethp; 
    int tweetSNo;
    public Twitter()
    {

        tweets=new HashMap<Integer,Integer>();
        followList=new HashMap<Integer,Integer>();
        tweethp = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int arr1[], int arr2[]) {
                return arr2[2] - arr1[2];
            }
        });
        tweetSNo=0;
    }
    
    
    public void postTweet(int userId, int tweetId)
    {
        tweets.put(userId,tweetId);
        tweethp.add(new int[]{tweetId,userId,tweetSNo});
        tweetSNo++;
        
    }
    
   
    public List<Integer> getNewsFeed(int userId)
    {
    	PriorityQueue<int[]> tweethpCopy = new PriorityQueue<int[]>(tweethp);
    	
    	
        List<Integer> feed=new ArrayList<Integer>();
        List<Integer> followedList=new ArrayList<Integer>();
        for (Map.Entry mapElement : followList.entrySet()) 
        { 
            int key = (int)mapElement.getKey(); 
            int value = (int)mapElement.getValue(); 
            if(key==userId )
                followedList.add(value);           
        }
        followedList.add(userId);
      
        int i=1;
        try{
        while(i<=10)
        {
            int []arr=tweethpCopy.poll();
          
            if(!followedList.isEmpty())
            {	
            	if(followedList.contains(arr[1]))
            	{
		        feed.add(arr[0]);
		        i++;
            	}
            }
        }
        }
        catch(Exception e)
        { }
        return feed;
    }
    
    public void follow(int followerId, int followeeId)
    {
        followList.put(followerId,followeeId);
    }
    
    public void unfollow(int followerId, int followeeId)
    {
       for (Map.Entry mapElement : followList.entrySet()) 
       { 
            int key = (int)mapElement.getKey(); 
            int value = (int)mapElement.getValue(); 
            if(key==followerId && value == followeeId)
                followList.remove(followerId);
                break;
        } 
    }
    public static void main(String s[])
    {
	Twitter obj=new Twitter();
    	while( true)
    	{
    		Scanner sc=new Scanner(System.in);
    		System.out.println("enter 1-> to follow    2-> post tweet    3-> unfollow     4->get feed     5-> to exit");
    		int ch=sc.nextInt();  
    		switch(ch)
    		{
    			case 1:System.out.println("enter the follower Id ");
    			       int fI=sc.nextInt();
    			       System.out.println("enter the followeeId ");
    			       int flI=sc.nextInt();
    			       obj.follow(fI,flI);
    			       break;
    			case 2:System.out.println("enter the userId ");
    			       int uI=sc.nextInt();
    			       System.out.println("enter the postId ");
    			       int pI=sc.nextInt();
    			       obj.postTweet(uI,pI);
    			       break;
    			case 3:System.out.println("enter the follower Id ");
    			       int fI1=sc.nextInt();
    			       System.out.println("enter the followeeId ");
    			       int flI1=sc.nextInt();
    			       obj.unfollow(fI1,flI1);
    			       break;
    			case 4:System.out.println("enter the post Id ");
    			       int uI1=sc.nextInt();
    			       System.out.println(obj.getNewsFeed(uI1));
    			       break;
    			case 5:System.exit(0);
    				
    			       
		}
    	}
   
    }
}

