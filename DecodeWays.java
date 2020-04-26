class DecodeWays
{
    public static int numDecodings(String s) 
    {
        int arr[]=new int[s.length()];
        for(int i=0;i<s.length();i++)
        {
                arr[i]=Integer.parseInt(String.valueOf(s.charAt(i)));
        }
    }
    public static void main(String a[])
    {
	numDecodings("1234");
	
    }	
}
