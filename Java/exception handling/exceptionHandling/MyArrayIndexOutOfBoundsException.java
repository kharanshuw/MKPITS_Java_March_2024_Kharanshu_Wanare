package exceptionHandling;

public class MyArrayIndexOutOfBoundsException {
	public void checkException(int arr[]) {
		try 
		{
			for (int i = 0; i <= arr.length; i++) {
				System.out.println(arr[i]);				
			}
		} 
		catch (Exception e) 
		{
			// TODO: handle exception
			System.out.println(e);
		}
		finally {
			System.out.println("handled exception");
		}
	}
}
