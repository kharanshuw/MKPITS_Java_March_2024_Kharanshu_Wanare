public class RemoveDuplicates {
	
	public void removeduplicates(String aString) 
	{
		StringBuilder stringBuilder = new StringBuilder();
		char prev=aString.charAt(0);
		
		if (aString.length()<=1 || aString==null) {
			System.out.println("empty string");
		}
		
		stringBuilder.append(prev);
		for (int i = 1; i < aString.length(); i++) {
			char current=aString.charAt(i);
			if (current != prev) {
				stringBuilder.append(current);
				prev=current;
			}
			
		}
		System.out.println(stringBuilder);
		
	}

}
