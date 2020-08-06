import java.util.Arrays;
import java.util.HashMap;

public class MoneyHeist {
	
	public static int findMaxHostage(int hostages[],int fearFactor[],int totalM) {
		
		int ans=0;
		for(int k=hostages.length;k>=1;k--) {
			if(findCompability(k,hostages,fearFactor,totalM))
			{		
				ans=k;break;
			}
		}
		return ans;
	}
	private static boolean findCompability(int k, int[] hostages, int[] fearFactor,int totalM) {
	
		int sum=0;
		sortKHostages(k,hostages,fearFactor);
		for(int i=1;i<=k;i++) {
			sum+=hostages[i-1]+(k-1)*fearFactor[i-1];
		}
		if(sum<=totalM)
			return true;
		return false;
	}
	private static void sortKHostages(int k, int[] hostages, int[] fearFactor) {
		
		int n = fearFactor.length; 
        for (int i = 1; i < n; ++i) { 
            int key = fearFactor[i];int key2=hostages[i]; 
            int j = i - 1; 
            while (j >= 0 && fearFactor[j] > key) { 
            	fearFactor[j + 1] = fearFactor[j];
            	hostages[j+1]=hostages[j];
                j = j - 1; 
            } 
            fearFactor[j + 1] = key; 
            hostages[j+1]=key2;
        }
        for (int i = 0; i < n; ++i) 
            System.out.println(hostages[i] + " "+fearFactor[i]); 
  
        System.out.println(); 
        
		
	}

	public static void main(String[] args){
		
		int hostages[]=new int[] {2,5,3,2,4};
		int fearFactor[]=new int[] {30,40,10,20,30};
		
		System.out.println(findMaxHostage(hostages,fearFactor,200));
	}

}
