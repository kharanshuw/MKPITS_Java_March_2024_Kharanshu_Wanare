package streameapi;

public class TestClass {
	public Integer name(Integer x) {
		return x;
	}
	
	public Integer devide(Integer xInteger) {
		return xInteger/5;
	}
	
	public Integer doubleinteger(Integer noInteger) {
		Integer resultInteger=noInteger*2;
		return resultInteger;
	}
	
	public boolean oddno(Integer no) {
		boolean result=false;
		if (no%2!=0) {
			result=true;
		}
		
		return result;
	}
	
	public Integer getint(Integer integer) {
		return integer;
	}
	
	public boolean greaterthanten(Integer integer) {
		return integer>10;
	}
}
