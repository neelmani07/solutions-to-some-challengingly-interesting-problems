class DecodeWays
{
    public static int decode(int arr[],int i)
    {
    	int count=0;
    	if(arr.length-i ==1 && arr[i]==0)
    		return 0;
    	
    	if(arr.length-i == 0 || arr.length-i == 1)
    	{
    		return 1;
    	}
    	if(arr[i] != 0)
    	{
    		count +=decode(arr,i+1);
    	}
    	if(arr[i]==1 ||( arr[i]<3 && arr[i]>0 && arr[i+1] < 7 && arr[i+1] >0))
    	{
    		count+=decode(arr,i+2);
    	}
    	
    	return count;
    }
	public static int numDecodings(String s) 
    {
        int arr[]=new int[s.length()];
        for(int i=0;i<s.length();i++)
        {
                arr[i]=Integer.parseInt(String.valueOf(s.charAt(i)));
        }
        int count=0;
        count=decode(arr,0);
        
        return count;
    }
    public static void main(String a[])
    {
	System.out.print(numDecodings("01"));
	
    }	
}