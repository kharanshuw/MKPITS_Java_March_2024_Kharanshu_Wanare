public class StringUtils {
    public void reverseString(){
        String name1="abcde";
        String name2="";
        int j=0;
        for (int i = name1.length()-1; i >=0; i--) {
            name2=name2+name1.charAt(i);
        }
        System.out.println("reverse string"+name2);
    }
    public void countSubstring(char c,String name1){
        int count=0;
        for (int i = 0; i < name1.length(); i++) {
            char x=name1.charAt(i);
            if (x == c)
            {
                count++;
            }
        }
        System.out.println("count is"+count);
    }

    public String convertUppercase(String name1){
       return name1.toUpperCase();
    }

}
