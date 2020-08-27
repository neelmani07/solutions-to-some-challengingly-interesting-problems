//Implements Moore's Voting Algo
public class MajortyElement {
	public static void main(String[] args) {
		int ar[]=new int[] {1,2,2,2,3,4,2,2,4,8};
		System.out.println(findMaj(ar));
	}

	private static int findMaj(int[] ar) {
		int c=1;
		int majI=0;
		for(int i=1;i<ar.length;i++) {
			if(ar[i]==ar[majI])
				c++;
			else {
				c--;
				if(c==0) {
					majI=i;
					c=1;
				}
			}
		}
		c=0;
		int majCndidate= ar[majI];
		System.out.println(majCndidate);
		for(int i=0;i<ar.length;i++) {
			if(ar[i]==majCndidate)
				c++;
		}
		if(c>=ar.length/2)
			return majCndidate;
		else
			return -1;
	}
}
