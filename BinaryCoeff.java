
public class BinaryCoeff {

	public static void main(String[] args) {
		int n=4; int k=2;
		System.out.println(findBCoeff(n,k));
	}

	private static int findBCoeff(int n, int k) {
		int factDp[]=new int [n+1];
		factDp[0]=1;factDp[1]=1;
		factDp[2]=2;
		
		for(int i=3;i<=n;i++) {
			factDp[i]=factDp[i-1]*i;
		}
		
		int ans=factDp[n]/(factDp[k]*factDp[n-k]);
		
		return ans;
	}
}
