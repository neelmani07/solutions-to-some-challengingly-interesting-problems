package CodeJam;

public class ForegoneSolution {
	public static void findSol(int a)
	{
		int t=a;String sub="";int d=0;int tens=0;
		while(t!=0)
		{
			d=t%10;
			if(d==4)
				sub=1+sub;
			else 
				sub=0+sub;
			t/=10;
			
		}
		System.out.print(sub+" and "+(a-Integer.valueOf(sub)));
	}
	public static  void main(String a[])
	{
		findSol(950440);
	}

}
