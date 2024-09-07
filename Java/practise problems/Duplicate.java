package practise_set;

import java.util.HashMap;
import java.util.Map;

public class Duplicate {
	
	public void frequency_of_char(String string)
	{
		HashMap<Character, Integer> hashMap =new HashMap<Character, Integer>();
		
		char[] charArray = string.toCharArray();
		
		for (char c : charArray) {
			hashMap.put(c, hashMap.getOrDefault(c, 0)+1);
		}
		
		for (Map.Entry<Character, Integer> entry: hashMap.entrySet())
		{
			if (entry.getValue()>0) {
				System.out.println(entry.getKey() + ": "+ entry.getValue());
			}
		}
		
		
	}

	public static void main(String[] args) {
		Duplicate duplicate =new Duplicate();
		duplicate.frequency_of_char("hello world ssdmgkdl lcms");
	}

}
