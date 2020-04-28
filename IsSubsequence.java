class IsSubsequence
{
    public boolean isSubsequence(String s, String t) 
    {
        if(s.length()==t.length())
        {
            for(int i=0;i<s.length();i++)
                if(s.charAt(i)!=t.charAt(i))
                    return false;
            return true;
        }
        int i1=0;int k=0;
        for(int i2=0;i2<t.length() && i1<s.length();)
        {
            while(i2<t.length() && s.charAt(i1)!=t.charAt(i2))
            {
                i2++;
            }
            i1++;k++;i2++;
                
        }
        if(i1==s.length())
            return true;
        else
            return false;
    }
}
