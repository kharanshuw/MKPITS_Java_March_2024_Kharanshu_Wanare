//this is example of anonymous  thread class

public static void main(String[] args) {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for (int i = 0; i < 10; i=i+2) {
					System.out.println(i);
					
				}
			}
		}).start();
	}