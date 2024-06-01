package practise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Iterator;

public class Assignment {
	
	public void readFile(String filenameString) {
		HashSet<String> hashSet=new HashSet<String>();
		try {
			FileReader fileReader=new FileReader(filenameString);
			BufferedReader bufferedReader=new BufferedReader(fileReader);
			String currentlineString;
			while ((currentlineString=bufferedReader.readLine())!=null) {
				hashSet.add(currentlineString);				
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		Iterator<String> iterator	=hashSet.iterator();
		while (iterator.hasNext()) {
			String string = (String) iterator.next();
			System.out.println(string);
		}
	}

	public static void main(String[] args) {
		Assignment assignment= new Assignment();
		assignment.readFile("D:\\java\\abc.txt");
	}
}
