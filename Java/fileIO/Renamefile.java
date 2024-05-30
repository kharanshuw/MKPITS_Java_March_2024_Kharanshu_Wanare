package myfile;

import java.io.File;

public class Renamefile {
    public void rename( ) {
        File file=new File("D:\\java2\\fileIO\\abc.txt");
        File file2=new File("D:\\java2\\fileIO\\xyz.txt");
        boolean flag=file.renameTo(file2);
        if (flag==true) {
            System.out.println("rename successfull");
        }
        else
        {
            System.out.println("not rename");
        }
    }
}
