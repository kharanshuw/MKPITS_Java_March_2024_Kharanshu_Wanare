public class MinMaxSum {

  public static void main(String[] args) {
    int[] arr = {9, 5, 3, 7, 1};

    long minSum = calculateSum(arr, 0);
    long maxSum = calculateSum(arr, 1);

    System.out.println(minSum + " " + maxSum);
  }

  private static long calculateSum(int[] arr, int excludedIndex) {
    return LongStream.of(arr) // Convert array to LongStream
        .filter(num -> Arrays.asList(excludedIndex).indexOf(num) == -1) // Filter out the excluded element
        .sum(); // Sum the remaining elements
  }
}
