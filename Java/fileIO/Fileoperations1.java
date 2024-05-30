package myfile;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Fileoperations
 */
public class Fileoperations {

    public void writeStudentOnfile(Student student) {
        File file = new File("D:\\java2\\fileIO\\xyz.txt");
        try {
            BufferedWriter buffer = new BufferedWriter(new FileWriter(file, true));

            buffer.write(String.valueOf(student.getGpaString()));
            buffer.write(String.valueOf(student.getIdString()));
            buffer.write(String.valueOf(student.getNameString()));
            buffer.write(String.valueOf(student.getRollnoString()));
            System.out.println("successful");
            buffer.close();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }
    }
//write a method which write student onbject into file by using object streme method
    public void writeStudent(Student student) {
        try {
            ObjectOutputStream objectOutputStream=new ObjectOutputStream(new FileOutputStream("D:\\java2\\fileIO\\xyz.txt",true));
            objectOutputStream.writeObject(student);
            System.out.println("successfully stores");
            objectOutputStream.close();
            
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }
    }

    public Student readstudent() {
        Student student = null;
        try {
            FileInputStream fileobj=new FileInputStream("D:\\java2\\fileIO\\xyz.txt");
            ObjectInputStream objStream = new ObjectInputStream(fileobj);
            student= (Student)(objStream.readObject());
            objStream.close();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }
        return student;
        
    }

    public List<Student> readAllStudents() {
    List<Student> students = new ArrayList<>();
    try {
        FileInputStream fileobj = new FileInputStream("D:\\java2\\fileIO\\xyz.txt");
        ObjectInputStream objStream = new ObjectInputStream(fileobj);
        while (fileobj.available() > 0) {
            Student student = (Student) objStream.readObject();
            students.add(student);
        }
        objStream.close();
    } catch (Exception e) {
        System.out.println(e);
    }
    return students;
}

}