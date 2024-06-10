public class CountOccurrences {

  public static void main(String[] args) {
    int[] numbers = {1, 2, 3, 1, 2, 4, 1, 2};
    int numberToFind = 2;

    int count = countOccurrences(numbers, numberToFind);
    System.out.println("The number " + numberToFind + " appears " + count + " times in the array.");
  }

  public static int countOccurrences(int[] arr, int num) {
    int count = 0;
    for (int element : arr) {
      if (element == num) {
        count++;
      }
    }
    return count;
  }
}
