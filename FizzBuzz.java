/*Write a program that outputs the string representation of numbers from 1 to n.

But for multiples of three it should output “Fizz” 
instead of the number and for the multiples of five output “Buzz”. 
For numbers which are multiples of both three and five output “FizzBuzz”.
*/

class Solution {
    public List<String> fizzBuzz(int n) {
        
        List<String> l=new ArrayList<String>(); 
        for(int i=1;i<=n;i++)
        {
            if(i%3==0)
            {
                if(i%5==0)
                    l.add("FizzBuzz");
                else
                    l.add("Fizz");
            }
            else if(i%5==0)
            {
                if(i%3==0)
                    l.add("FizzBuzz");
                else
                    l.add("Buzz");
            }
            else
                l.add(String.valueOf(i));
            
                
        }
        return l;
        
    }
}
