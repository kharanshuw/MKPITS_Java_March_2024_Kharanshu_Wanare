package fileoperation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Myfile {
	public void readfile() {
		//read from file and display on screen
		try {
			FileReader fileReader=new FileReader("D:\\java2\\fileIO\\abc.txt");
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String string;
			while ((string=bufferedReader.readLine())!=null) {
				System.out.println(string);
			}
			bufferedReader.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		catch (Exception e) {
			System.out.println(e);// TODO: handle exception
		}
	}
	
	
	public void readfromfile(String filename) {
		File file=new File(filename);
		if (file.exists()) {
			try {
				FileReader fileReader=new FileReader(file);
				BufferedReader bufferedReader = new BufferedReader(fileReader);
				String string;
				while ((string=bufferedReader.readLine())!=null) {
					System.out.println(string);
				}
				bufferedReader.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println(e);
			}
			catch (Exception e) {
				System.out.println(e);// TODO: handle exception
			}
		}
		else {
			System.out.println("file not exisit");
		}
	}
	
	public void copypaste(String sourceString,String targetString) {
		//copy one file content to targetString file use writer and reader class
		File file=new File(targetString);
		File file2=new File(sourceString);
		if (file2.exists()) {
			try {
				FileReader fileReader=new FileReader(file2);
				BufferedReader bufferedReader=new BufferedReader(fileReader);
				FileWriter fileWriter=new FileWriter(file,true);
				BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
				String string = null,line;
				while ((line=bufferedReader.readLine())!=null) {
					//string=string+" "+line;
					bufferedWriter.write(line);
					bufferedWriter.newLine();
					line=bufferedReader.readLine();
				}
				//bufferedWriter.write(string );
				bufferedReader.close();
				bufferedWriter.close();
				System.out.println("copy successfull");
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
			}
		}
		else {
			System.out.println("file does not exist");
		}
	}
}