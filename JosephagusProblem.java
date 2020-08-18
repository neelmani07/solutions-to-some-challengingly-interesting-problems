import java.util.ArrayList;
import java.util.Scanner;

public class JosephagusProblem {
	private static void ay(int n, int k) {
		int p=0;
		ArrayList<Integer> aa=new ArrayList<Integer>();
		for(int i=1;i<=n;i++)
		{
			aa.add(i);
		}
		
		while(aa.size()!=1)
		{
			p=(p+k)%aa.size();
		    if(p==0)
			{
		    	aa.remove(aa.size()-1);
				p=aa.size();
            }
			else {
		
				aa.remove(p-1);
				p--;
			}
		}
		System.out.print(aa.get(0));
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int q=sc.nextInt();
		int w=sc.nextInt();
        
	ay(q,w);

	}
}
