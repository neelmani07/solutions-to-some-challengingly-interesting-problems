import java.util.LinkedList;
import java.util.Queue;

public class ReverseQueue {
	
	
	public static void main(String[] args) {
		
		Queue<Integer> q1=new LinkedList<Integer>();
		for(int i=0;i<=4;i++) {
			q1.add(i+1);
		}
		Queue<Integer> q2=new LinkedList<Integer>();
		reverseQ(q1,q2);
	}

	private static void reverseQ(Queue<Integer> q1, Queue<Integer> q2) {
		int i=1;int n=q1.size(),m=n;
		while(i<=n) {
			for(int j=1;j<=n-i;j++) {
				q1.add(q1.poll());
			}
			q2.add(q1.poll());
			i++;m--;
		}
		System.out.println(q2);
		
	}

}
