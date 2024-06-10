public class LargestSmallestWord {

  public static void main(String[] args) {
    String str = "This is a string with words of varying lengths";

    String smallestWord = "";
    String largestWord = "";

    String[] words = str.split(" ");

	smallestWord = words[0];
    largestWord = words[0];

    for (String word : words) {
      if (word.length() < smallestWord.length()) {
        smallestWord = word;
      }
      if (word.length() > largestWord.length()) {
        largestWord = word;
      }
    }

    System.out.println("Smallest word: " + smallestWord);
    System.out.println("Largest word: " + largestWord);
  }
}
