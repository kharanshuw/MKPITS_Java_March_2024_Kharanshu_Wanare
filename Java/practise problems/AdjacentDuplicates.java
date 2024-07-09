package program_on_string;

public class AdjacentDuplicates {
    public void removeAdjacentDuplicates(String one) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < stringBuffer.length() - 1; i++) {
            if (stringBuffer.charAt(i) == stringBuffer.charAt(i + 1)) {
                stringBuffer.deleteCharAt(i);
            }
        }
        System.out.println(stringBuffer);
    }
}
