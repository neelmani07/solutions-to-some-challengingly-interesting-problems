/*
Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3 
Explanation: The answer is "abc", with the length of 3. 

*/
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int max = 0;
        
        for(int right = 0; right < s.length(); ++right){
            int c = s.charAt(right);
            //String sub = s.substring(left, right);
            int left2 = s.substring(left, right).indexOf(c);
            if(left2 > -1){
                left += left2 + 1;
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}
