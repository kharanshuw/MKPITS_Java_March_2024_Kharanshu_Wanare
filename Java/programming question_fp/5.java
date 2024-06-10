public class SumOfNSquares {

  public static void main(String[] args) {
    int n;
	
    n = 5;

   
    double sum = (double) n * (n + 1) * (2 * n + 1) / 6;

    System.out.println("The sum of " + n + " square numbers is " + sum);
  }
}
