/*
 Given a list of daily temperatures T, return a list such that, for each day in the input, tells you how many days you would have to wait until a warmer temperature. If there is no future day for which this is possible, put 0 instead.

For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].

Note: The length of temperatures will be in the range [1, 30000]. Each temperature will be an integer in the range [30, 100]. 




class Solution {
    public int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];
        Stack<int[]> stack = new Stack<>();
        for(int i = 0; i< T.length; i++){
            while(!stack.isEmpty() && stack.peek()[0] < T[i]){
                int[] curr = stack.pop();
                res[curr[1]] = i - curr[1]; 
            }
            stack.push(new int[]{T[i], i});
        }
        return res;
    }
}*/
class Solution 
{
    public int[] dailyTemperatures(int[] T) 
    {
     
        if(T == null || T.length == 0) return new int[0];
        
        int[] result = new int[T.length];int i=0,j=0;
        for( i = 0; i < T.length; ++i)
        {
            j = i + 1;
            while(j < T.length && !(T[i] < T[j]))
            {
                j++;
            }
            if(!(i != T.length && j== T.length))
                result[i] = j - i;
        }
        if(i != T.length && j== T.length)
        {
            while(i<T.length)
                result[i]=0;
        }
        return result;
    }
  
}



