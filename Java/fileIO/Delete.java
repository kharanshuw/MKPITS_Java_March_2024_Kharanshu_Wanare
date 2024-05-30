package myfile;

import java.io.File;

public class Delete {
    public void deletefile(String filenameString) {
        File objFile=new File(filenameString);
        if (objFile.delete()) {
            System.out.println("file deleted");
        }
        else
        {
            System.out.println("file not deleted");
        }
    }
}
