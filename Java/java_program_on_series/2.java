public class MySeries {
	public double factorial(int n) {
		double result=1;
		for (int i = 1; i <=n; i++) {
			result=result*i;
		}
		return result;
	}
	
	public void sumOfFactorialSeries(int n) {
		double sum=0;
		for (int i = 1; i <=n; i++) {
			double fact=this.factorial(i);
			sum=sum+(i/fact);
		}
		System.out.println("sum is "+sum);
	}
}
