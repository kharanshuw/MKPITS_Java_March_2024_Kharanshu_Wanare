public class SumOfSquaresEveryThirdStream {

    public static void main(String[] args) {
        // Sample array with 30 integers
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30};

        // Step size for considering every 3rd element
        int step = 3;

        // Calculate sum of squares using Stream API
        int sumOfSquares = IntStream.of(numbers)
            .filter(index -> index % step == 0) // Filter elements divisible by step (every 3rd element)
            .map(num -> num * num) // Square each element
            .sum(); // Calculate the sum of squares

        // Print the sum of squares
        System.out.println("Sum of squares of every 3rd element: " + sumOfSquares);
    }
}
