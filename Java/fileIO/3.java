package filehandling;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Bufferwriter
 */
public class Bufferwriter {

    public void writingmultiple() {
        InputStreamReader inputStream = new InputStreamReader(System.in);
        BufferedReader bufferreader = new BufferedReader(inputStream);

        try {
            String choice ;

            String nameString;

            FileWriter fileWriter = new FileWriter("D:\\java2\\fileIO\\abc.txt", true);
            BufferedWriter bufferwriter = new BufferedWriter(fileWriter);
            do {
                System.out.println("enter name\n");
                nameString = bufferreader.readLine();
                bufferwriter.write(nameString+"\n");
                System.out.println("enter choice");
                choice = bufferreader.readLine();
            } while (choice.equalsIgnoreCase("y"));
            bufferwriter.close();

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }

    }

    public void writing() {
        // writing into file by using bufferreader
        InputStreamReader inputStream = new InputStreamReader(System.in);
        BufferedReader bufferreader = new BufferedReader(inputStream);
        System.out.println("enter name");
        try {
            String nameString = bufferreader.readLine();
            // FileWriter fileWriter=new FileWriter("D:\\java2\\fileIO\\abc.txt");
            BufferedWriter bufferwriter = new BufferedWriter(new FileWriter("abc.txt", true));
            bufferwriter.write(nameString);
            bufferwriter.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}

