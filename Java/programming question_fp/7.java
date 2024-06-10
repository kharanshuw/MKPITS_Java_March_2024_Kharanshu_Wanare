public class SumOfSeries {

  public static void main(String[] args) {
    int n;

    
    n = 5;

    double sum = 0.0;
    int factorial = 1;

  
    for (int i = 1; i <= n; i++) {
      factorial *= i;
      sum += (double) i / factorial;
    }

    System.out.println("The sum of the series 1/1! + 2/2! + 3/3! + ... + " + n + "/n! is: " + sum);
  }
}
