class Solution
{
    public List<Integer> findSubstring(String s, String[] words)
    {
        int wordL=words[0].length();
        int wordsL=wordL*words.length;
        List<Integer> ans=new ArrayList<Integer>();
        
        if(s.length() < wordsL)
            return ans;
        
        for(int ind=0;ind<=s.length()-wordsL;ind++)
        {
            List<String> wrdslist =new ArrayList<String>(Arrays.asList(words));
            String subS=s.substring(ind,ind+wordsL);
            for(int i=0;i<=subS.length();i++)
            {
                String wrd=subS.substring(i,i+wordL);
                
                if(wrdslist.contains(wrd))
                {
                    wrdslist.remove(wrd);
                    i=i+wordL-1;
                    
                }    
                else
                {
                    break;  
                }
            }
            if(wrdslist.isEmpty())
                ans.add(ind);
               
        }
        return ans;
    }
}
