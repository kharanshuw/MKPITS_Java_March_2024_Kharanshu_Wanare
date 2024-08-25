//Print all the duplicate characters in a string

package practise_set;

import java.util.HashMap;
import java.util.Map;

public class Frequency {
	
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
		Frequency frequency =new Frequency();
		frequency.frequency_of_char("hello world ssdmgkdl lcms");
	}

}
/*

Steps to implement the above approach:

    Declare a unordered map of the char-int pair.
    Traverse the string using a loop and increase the count of the present char in the map.
    Iterate through the map and print a character that has a value greater than one in map.
	
	
	*/
