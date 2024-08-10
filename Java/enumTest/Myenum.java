package enumTest;

public class Myenum {
	public enum Season {
		WINTER(5),SPRING(10),SUMMER(20),FALL(30);
		
		 int values;
		Season(int values) {
			this.values=values;
		}
	}
}
