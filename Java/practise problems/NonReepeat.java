/*Let's go through the code step by step:

**Step 1: Importing necessary classes**

The code starts by importing the `HashMap` class from the `java.util` package.

**Step 2: Defining the `NonReepeat` class**

The code defines a class named `NonReepeat`.

**Step 3: Defining the `FirstNonReapeatChar` method**

The code defines a method named `FirstNonReapeatChar` that takes a `String` parameter `string`. This method is used to find the first non-repeating character in the input string.

**Step 4: Creating a `HashMap`**

Inside the `FirstNonReapeatChar` method, a `HashMap` named `hashMap` is created to store the frequency of each character in the input string.

**Step 5: Iterating over the input string**

The code uses a for-each loop to iterate over the characters in the input string. For each character, the code uses the `toCharArray()` method to convert the string to a character array.

**Step 6: Populating the `HashMap`**

For each character, the code uses the `put()` method to add the character to the `HashMap`. If the character is already present in the map, the code uses the `getOrDefault()` method to increment its frequency by 1. If the character is not present in the map, the code sets its frequency to 1.

**Step 7: Commented out code**

The code has a commented out section that finds the first non-repeating character in the input string. This section uses another for-each loop to iterate over the characters in the input string, and checks if the frequency of each character is 1. If it is, the code prints a message indicating that the first non-repeating character has been found, and prints the character and its frequency.

**Step 8: Printing the `HashMap` contents**

The code uses a for-each loop to iterate over the characters in the input string, and prints the character and its frequency from the `HashMap`.

**Step 9: Creating an instance of the `NonReepeat` class**

In the `main()` method, an instance of the `NonReepeat` class is created.

**Step 10: Calling the `FirstNonReapeatChar` method**

The `FirstNonReapeatChar` method is called with the input string "hello how are you".

**Output**

The output of the code will be:

```
h:1
e:1
l:3
l:3
o:2
 :1
h:1
o:2
w:1
 :1
a:1
r:1
e:1
 :1
y:1
o:2
u:1
```

This output shows the frequency of each character in the input string. The commented out section that finds the first non-repeating character is not executed, so the output does not include the message indicating that the first non-repeating character has been found.







*/












package practiseProblems;



import java.util.HashMap;


public class NonReepeat {
	
	public void FirstNonReapeatChar(String string) {
		HashMap<Character, Integer> hashMap =new HashMap<Character, Integer>();
		
		
		/*For each character, the code uses the put() method to add the character to the HashMap. If the character is already present in the map, the code uses the getOrDefault() method to increment its frequency by 1. If the character is not present in the map, the code sets its frequency to 1.*/
		for (char c : string.toCharArray()) {
			hashMap.put(c, hashMap.getOrDefault(c, 0)+1);
		}
		
		
	/*	for (char c : string.toCharArray())
		{
			if (1==hashMap.get(c)) {
				System.out.println("first non repeted charecter found ");
				System.out.println(hashMap.get(c));
				System.out.println(c);
				return;
			}
		}
		
		*/
		
		for (char c : string.toCharArray()) {
			System.out.print(c + ":");
			System.out.print(hashMap.get(c));
			System.out.println(" ");
		}
	}

	public static void main(String[] args) {
		NonReepeat nonReepeat=new NonReepeat();
		
		nonReepeat.FirstNonReapeatChar("hello how are you");
		
	}

}
