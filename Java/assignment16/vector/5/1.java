package practise;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;

public class Myvector {
	
	public void myserialize(Vector<Student> vector,String filenameString) {
		try {
		FileOutputStream fileOutputStream=new FileOutputStream(filenameString);
		ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);
		objectOutputStream.writeObject(vector);
		objectOutputStream.close();
		fileOutputStream.close();
		} 
		catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}

	public void mydeserialization(String filenameString) {
		try {
			FileInputStream fis=new FileInputStream(filenameString);
			ObjectInputStream obj=new ObjectOutputStream(fis);

			Vector<Student> des =(Vector<Student>) obj.readObject();
			obj.close();
			fis.close();
			System.out.println(des);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Vector<Student> vector=new Vector<Student>();
		vector.add(new Student(1, "a"));
		vector.add(new Student(2, "b"));
		System.out.println(vector);

		Myvector myvector=new Myvector();
		myvector.myserialize(vector, "abc.txt");

	}	 
}