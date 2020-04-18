import java.util.*;

class SuperUglyNo
{
    public static int findMin(int a[])
    {   int minI=0;int min=999;
        for(int i=0;i<a.length;i++)
        {
            if(min>a[i])
            {
                min=a[i];
                minI=i;
            }
        }
        return minI;
    }
    public static int nthSuperUglyNumber(int n, int[] primes)
    {
        int superUgly[]=new int[n+1];
        superUgly[0]=1;
        int nexTprimes[]=new int[primes.length];
        for(int i=0;i<primes.length;i++)
            nexTprimes[i]=primes[i];
        int indexes[]=new int[primes.length];
        Arrays.fill(indexes,0);
        
        for(int i=1;i<n;)
        {
            
            int nextSUindex=findMin(nexTprimes);
            indexes[nextSUindex]++;
            if(nexTprimes[nextSUindex] != superUgly[i-1])
            {
                superUgly[i]=nexTprimes[nextSUindex];
                i++;
            }
            nexTprimes[nextSUindex]=superUgly[indexes[nextSUindex]]*primes[nextSUindex];
            System.out.print(superUgly[i]+" ");
        }
        
        return superUgly[n-1];
    }
    public static void main(String a[])
    {
    	int p[]={2,71,13};
    	System.out.print(" ="+nthSuperUglyNumber(12,p));
    }
}
