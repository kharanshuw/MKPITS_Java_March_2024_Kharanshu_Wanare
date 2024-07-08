package program_on_string;

public class MaskString {
    public void markstring(String a,String b){
        StringBuffer stringBuffer = new StringBuffer(a);
        int length=stringBuffer.length();
        StringBuffer stringBuffer1=new StringBuffer(b);
        StringBuffer stringBuffer2=new StringBuffer();
        for (int i = 0; i < stringBuffer.length()-1; i++) {
            for (int j = 0; j < stringBuffer1.length(); j++) {
                char x=stringBuffer.charAt(i);
                char y=stringBuffer1.charAt(j);
                if (Character.compare(x,y)!=0) {
                    stringBuffer2.append(x);
                }
            }
        }

        System.out.println(stringBuffer2);
    }
}
