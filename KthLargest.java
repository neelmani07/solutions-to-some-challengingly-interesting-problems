import java.util.*;
class KthLargest
{
    int k;
    int []minHeap;
    int heapSize;
    public KthLargest(int k, int[] nums) 
    {
        this.k=k;
        
        int num[]=new int[nums.length+1];
        num[0]=0;
        for(int i=0;i<nums.length;i++)
        {
            num[i+1]=nums[i];
            
        }
        buildMinHeap(num);
        minHeap=new int[k+1];
         for(int i=0;i<k+1;i++)
        {
            minHeap[i]=num[i];
            System.out.print(minHeap[i]);
            
        }
       
        
        
    }
    public int left(int i)
	{	
		return (2*i);
	}
    public int right(int i)
	{	
		return  (2*i+1);
	}
    public void swap(int a[], int i, int k)
	{
		int temp=a[i];
		a[i]=a[k];
		a[k]=temp;
	}
    public void minHeapify(int a[],int i)
	{
		int l=left(i);
		int r=right(i);
		int smallestIndex=0;
		
		if (l<heapSize && a[i] > a[l])
			smallestIndex=l;
		else smallestIndex=i;
		if (r<heapSize && a[smallestIndex] > a[r])
			smallestIndex=r;
		if(smallestIndex != i)
		{
			swap(a,i,smallestIndex);
			minHeapify(a,smallestIndex);
		}
	}
    public void buildMinHeap(int a[])
	{	
		heapSize=a.length-1;
		int i=((a.length)/2);
		while( i>=1 )
		{	
			minHeapify(a,i);
			i--;
		}
        
        
			
	}
    public void add(int val)
    {	
        int kt= minHeap[1];
        
        if(val > minHeap[1])
        {
            minHeap[1]=val;
            minHeapify(minHeap,1);
        }
        System.out.println(kt);
    }
    public static void main(String s[])
    {
	Scanner sc=new Scanner(System.in);
    	int stream[]=new int[]{4,5,8,2};
    	KthLargest obj=new KthLargest(3,stream);
    	
    	while(true)
    	{
    		System.out.println("enter the new element");
    		int  nE=sc.nextInt();
    		obj.add(nE);
    		if(nE==999)
    			System.exit(0);
    	}
    }
}


