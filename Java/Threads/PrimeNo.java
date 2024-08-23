package threads;

public class PrimeNo implements Runnable{
	
	public boolean printcheck(int no) {
		boolean result=false;
		int flag=0;
		if (no==0 || no==1) {
			return false;
		}
		for (int i = 2; i <=no; i++) {
			if (no%i==0) {
				flag++;
			}
		}
		
		if (flag==1) {
			result=true;
		}
		return result;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 2; i < 1000; i++) {
			boolean resule=printcheck(i);
			if (resule==true) {
				System.out.println("prime no "+i);
			}
		}
	}
	
}
