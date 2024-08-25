package threads;

public class NonPrime implements Runnable {

	
	public boolean checkNonPrime(int i) {
		boolean result=false;
		int flag=0;
		for (int j = 2; j <= i ; j++) {
			if (i%2==0) {
				flag=flag+1;
			}
		}
		if (flag>1) {
			result=true;
		}
		return result;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i <= 1000; i++) {
			boolean result=checkNonPrime(i);
			if (result==true) {
				System.out.println("non prime"+i);
			}
		}
	}

	
}
