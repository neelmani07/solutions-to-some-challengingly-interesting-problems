class QuerrySum {

    int[] range;
    
    public NumArray(int[] nums) {
        
        int sum=0;
        range=new int[nums.length];
        for(int i=0;i<nums.length;i++)
        {
            sum+=nums[i];
            range[i]=sum;
            
        }
        
    }
    
    public int sumRange(int i, int j) {
        
        if(i==0)
        {
            return range[j];
        }
        else
        {
            return range[j]-range[i-1];
        }
        
    }
}
