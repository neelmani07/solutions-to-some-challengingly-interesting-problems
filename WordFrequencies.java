package CTCI;

import java.util.HashMap;

public class WordFrequencies {
	
	static HashMap<String,Integer> dict=new HashMap<String,Integer>();
	//setting up dictionary
	public static void setDict(String[] book)
	{
		for(String w:book)
		{	w=w.trim();
			w=w.toLowerCase();
			if(dict.containsKey(w))
			{
				dict.put(w,dict.get(w)+1);
			}
			else
				dict.put(w,1);
			
		}
	}
	
	public static int countFrequencies(String w)
	{
		w=w.trim();
		w=w.toLowerCase();	
		if(dict.containsKey(w))
		{
			return dict.get(w);
		}
		else
			return 0;
			
	}
	
	public static void main(String arg[])
	{
		String book[]=new String[] {"erwtc","ukjh","ijcj","khkjj"};
		String wrd="hi";
		setDict(book);
		System.out.println("count="+countFrequencies(wrd));
		
	}

}
