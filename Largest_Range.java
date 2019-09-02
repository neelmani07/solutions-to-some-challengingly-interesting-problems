//Find the largest range  of consecutive numbers jumbled up in an array.
/*   input array[]= {1,11,3,0,15,5,2,4,10,7,12,6}
     output = 0,7
     			*/
import java.util.*;
class Largest_Range
{

	public static int findMin(int arr[],int n)
	{	
		int min=0;
		for(int i=0;i<n;i++)
		{
			min=(min<arr[i])?min:arr[i];
		}
		return min;
	}
	public static int findMax(int arr[],int n)
	{	
		int max=0;
		for(int i=0;i<n;i++)
		{
			max=(max>arr[i])?max:arr[i];
		}
		return max;
	}
	public static void findLarRange(int ar[],int num)
	{
		int min=findMin(ar,num);
		int max=findMax(ar,num);
		int hashArr[]=new int[max-min+1];
		for(int i=0;i<max-min+1;i++)
		{
			hashArr[i]=0;
		}
		for(int i=0;i<num;i++)
		{
			hashArr[ar[i]-min]=1;
		}
		int range=0,st=min,end=0,maxRange=0,start=0;
		for(int i=0;i<max-min;i++)
		{
			if(hashArr[i] != 0)
			{
				range++;
			}
			else
			{
				if(maxRange<range)
				{
					maxRange=range;
					start=st;
					end=i+min-1;
				}
				st=min+i+1;
				range=0;
			}
		}
		System.out.println("Largest Range \t start : end ");
		System.out.println(maxRange+"\t\t"+start+"\t"+end);
		
	}
			
	public static void main(String a[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the array size.");
		int n=sc.nextInt();
		int arr[]=new int[n];
		System.out.println("enter the array");
		for(int i=0;i<n;i++)
			arr[i]=sc.nextInt();	
		
		findLarRange(arr,n);
	}



} 
