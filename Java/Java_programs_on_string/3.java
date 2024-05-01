public class ReverseWordsSimple {
	public void reversewordsimple(String aString) {
		StringBuilder stringBuilder=new StringBuilder();
		if (aString.isEmpty() || aString==null) {
			System.out.println("empty string");
		}
		String[] strings=aString.split(" ");
		
		for (String string : strings) {
			StringBuilder stringBuilder1=new StringBuilder(string);
			stringBuilder1=stringBuilder1.reverse();
			String xString=stringBuilder1.toString();
			stringBuilder.append(xString);
			stringBuilder.append(" ");
		}
		String reString=stringBuilder.toString();
		System.out.println(reString);
	}
}
