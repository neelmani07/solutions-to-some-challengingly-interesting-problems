/*class Solution {
    public void sortColors(int[] nums) {
        
        int blue=nums.length-1;
        int red=0;
        
        for(int i=0;i<blue;)
        {
            if(nums[i]==1)
                i++;
            if(nums[i]==2)
            {
                int temp=nums[i];
                nums[i]=nums[blue];
                nums[blue]=temp;
                blue--;
                
            }
            if(nums[i]==0)
            {
                int temp=nums[i];
                nums[i]=nums[red];
                nums[red]=temp;
                red++;
                i++;
               
            }
        }
        
    }
}
*/

class Solution {
    public void sortColors(int[] a) {
        
        int lo = 0; 
        int hi = a.length-1; 
        int mid = 0, temp = 0; 
        while (mid <= hi) { 
            switch (a[mid]) { 
            case 0: { 
                temp = a[lo]; 
                a[lo] = a[mid]; 
                a[mid] = temp; 
                lo++; 
                mid++; 
                break; 
            } 
            case 1: 
                mid++; 
                break; 
            case 2: { 
                temp = a[mid]; 
                a[mid] = a[hi]; 
                a[hi] = temp; 
                hi--; 
                break; 
            } 
            } 
        } 
        
    }
}
