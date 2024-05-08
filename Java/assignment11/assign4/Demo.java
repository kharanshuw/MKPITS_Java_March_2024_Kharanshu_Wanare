package assignment11.assign4;

import javax.xml.crypto.dsig.spec.TransformParameterSpec;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		try {
//			TestNumberFormatException testNumberFormatException=new TestNumberFormatException();
//			testNumberFormatException.checkNumberFormatException("shreyash");
//		} catch (NumberFormatException e) {
//			System.out.println(e.getMessage());
//		}
		
		try {
			
			TestStringIndexOutOfBoundsException testStringIndexOutOfBoundsException=new TestStringIndexOutOfBoundsException();
			testStringIndexOutOfBoundsException.testException("shreyash");
			
		} catch (StringIndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
		
		
		
	}

}
