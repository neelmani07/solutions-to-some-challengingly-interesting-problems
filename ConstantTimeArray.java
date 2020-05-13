/*
Design a deterministic scheme by which reads and writes to an
uninitialized array can be made in 0(1) time. You may ~e O(n) additional storage;reads to
uninitialized entry should return false.
*/
import java.util.*;
class ConstantTimeArray
{
   int ar[];
   int from[];
   int to[];
   int bckP;
   public ConstantTimeArray(int size)
   {
   	ar=new int[size];
   	from=new int[size];
   	to=new int[size];
   	bckP=0;
   
   }
   public void write(int val,int in)
   {
   	ar[in]=val;
   	from[in]=bckP;
   	to[bckP]=in;
   	bckP++;	
   	
   }
   public void read(int in)
   {
   	if (from[in] < bckP && to[from[in]] == in)
            System.out.println(ar[in]);
        else
            System.out.println("no init");
   }
   public static void main(String a[])
   {
   	ConstantTimeArray ob=new ConstantTimeArray(10);
   	ob.read(2);
   	ob.write(2,2);
   	ob.read(9);
   	ob.read(2);
   		
   }
}
