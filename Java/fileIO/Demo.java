package fileIO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Demo {
    public static void main(String[] args) {
        int m=0;
        InputStreamReader inputStreamReader=new InputStreamReader(System.in);
        BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
        try {
            System.out.println("enter number");
            m=Integer.parseInt (bufferedReader.readLine());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Student student=new Student();
        student.calculate(m);

    }
}
