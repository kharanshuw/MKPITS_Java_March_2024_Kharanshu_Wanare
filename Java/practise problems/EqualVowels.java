/*
Question 05:
Check if a string can be split into two substrings with equal number of vowels.
Prepare 50% F
Example :
Input: ixambee
Output: yes
There exists two substrings 'ixa' and 'mbee'
*/

public class EqualVowels {

    public static boolean hasEqualVowels(String text) {
        if (text.isEmpty()) {
            return false; // Empty string has no vowels
        }

        // Count total vowels
        int vowelCount = 0;
        for (char ch : text.toCharArray()) {
            if (isVowel(ch)) {
                vowelCount++;
            }
        }

        // Check if vowel count is even (must be divisible by 2)
        if (vowelCount % 2 != 0) {
            return false;
        }

        // Check if split is possible with equal vowels
        int targetVowels = vowelCount / 2;
        int currentVowels = 0;
        for (char ch : text.toCharArray()) {
            if (isVowel(ch)) {
                currentVowels++;
            }
            if (currentVowels == targetVowels) {
                return true;
            }
        }

        return false;
    }

    private static boolean isVowel(char ch) {
        return "aeiouAEIOU".indexOf(ch) != -1;
    }

    public static void main(String[] args) {
        String text1 = "ixambee";
        String text2 = "munna";

        System.out.println(text1 + " - " + hasEqualVowels(text1)); // Output: ixambee - yes
        System.out.println(text2 + " - " + hasEqualVowels(text2)); // Output: munna - no
    }
}
