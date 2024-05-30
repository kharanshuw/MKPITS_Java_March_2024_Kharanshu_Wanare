import java.io.File;

public class Myfile {
    public void testing() {
        File f=new File("D:\\java2\\Myproject\\src","D:\\java2\\Myproject\\src\\abc.txt");
        File file=new File("D:\\java2\\fileIO\\xx.txt");
        
        // System.out.println(file.exists());//return true if file exist
        // System.out.println(file.getAbsolutePath());//Returns the absolute form of this abstract pathname. Equivalent to new File(this.getAbsolutePath()).
        // System.out.println(file.getPath());//return file name of url
        // if (file.delete()) {
        //     System.out.println("deleted");
        // }
        // else
        // {
        //     System.out.println("not delete");
        // }
            // System.out.println(file.getName());
            // System.out.println(file.getParent());
            // System.out.println(file.getParentFile().getName());
            // System.out.println(file.isDirectory());
            // System.out.println(file.isFile());
            // System.out.println(file.isHidden());
            // System.out.println(file.lastModified());
            // String[]  strings=file.list();
            // for (String string : strings) {
            //     System.out.println(string);
            // }

    }
}


