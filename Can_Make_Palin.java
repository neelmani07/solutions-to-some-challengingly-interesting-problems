

import java.util.Scanner;

public class Can_Make_Palin
{
	public static void canMakePal(String s,int k)
	{
		int l;
		int i=0;int j= s.length()-1;
		while(i<j)
		{
			if(s.charAt(i)!= s.charAt(j))
			{
				for(l=1;l<=k;l++)
				{
					if(s.charAt(i+l)==s.charAt(j))
					{
						i=i+l;
						break;
					}
					if(s.charAt(i)==s.charAt(j-l))
					{
						j=j-1;
						break;
					}
				}
				if(l>k)
				{
					System.out.println("cannot");
					return;
				}
			}
			else
			{
				i++;j--;
			}
		}
		System.out.println("can");
		
	}
	public static void main(String a[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the string");
		String st=sc.nextLine();
		System.out.println("enter the k");
		int k=sc.nextInt();
		canMakePal(st,k);
		
	}
}
