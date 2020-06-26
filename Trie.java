package leetcode;

public class Trie {

    static class TrieNode 
    { 
        static final int ALPHABET_SIZE = 26;
        TrieNode[] children = new TrieNode[ALPHABET_SIZE]; 
        // isEndOfWord is true if the node represents  end of a word 
        boolean isEndOfWord; 
          
        TrieNode(){ 
            isEndOfWord = false; 
            for (int i = 0; i < ALPHABET_SIZE; i++) 
                children[i] = null; 
        } 
    }; 
    
    TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        
        root=new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        
        TrieNode pointer=root;
       //level is the variable pointing the order level of each character
        for(int level=0;level<word.length();level++)
        {
            char ch=word.charAt(level);
            int index=ch-'a';
            if(pointer.children[index]==null)
                pointer.children[index]=new TrieNode();
            pointer=pointer.children[index];
        }
        
        pointer.isEndOfWord=true;
        
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        
        
        TrieNode pointer=root;
       //level is the variable pointing the order level of each character
        for(int level=0;level<word.length();level++)
        {
        	
            char ch=word.charAt(level);
            System.out.println(ch);
            int index=ch-'a';
            if(pointer.children[index]==null)
            	return false;
            pointer=pointer.children[index];
        }
        return(pointer != null && pointer.isEndOfWord);
            
        
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        
        if(prefix.length()==0)
        	return false;
    	
        TrieNode pointer=root;
       //level is the variable pointing the order level of each character
        for(int level=0;level<prefix.length();level++)
        {
            char ch=prefix.charAt(level);
            int index=ch-'a';
            if(pointer.children[index]==null)
                return false;
            pointer=pointer.children[index];
        }
        return true;
        
    }
    
    public static void main(String sr[])
    {
    	Trie obj=new Trie();
    	obj.insert("appl");
    	System.out.println(obj.startsWith("appl"));
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
