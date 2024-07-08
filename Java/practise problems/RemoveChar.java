package program_on_string;

public class RemoveChar {
    public void removeCharacters(String aString,String bString) {
        StringBuilder stringBuilder =new StringBuilder();
        for (int i = 0; i < aString.length(); i++) {
            char a=aString.charAt(i);
            for (int j = 0; j < bString.length(); j++) {
                char b=bString.charAt(j);
                if (a!=b) {
                   stringBuilder.append(a);
                   break;
                }

            }

        }
        System.out.println(stringBuilder);
    }
}
