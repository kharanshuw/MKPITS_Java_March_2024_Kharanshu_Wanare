package assignment17;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class Assignment {
	
	public void frequencies(String filenameString) {
		HashMap<String,Integer> hashMap=new HashMap<String, Integer>();
		try {
			FileReader fileReader=new FileReader(filenameString);
			BufferedReader bufferedReader=new BufferedReader(fileReader);
			String lineString;
			while ((lineString=bufferedReader.readLine())!=null) {
				String arr[]=lineString.toLowerCase().split("\\s+");
				for (String wordString:arr) {
					hashMap.put(wordString, hashMap.getOrDefault(wordString, 0)+1);
				}
			}
			bufferedReader.close();
			fileReader.close();
			for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
				String key = entry.getKey();
				Integer val = entry.getValue();
				System.out.println(key + ":"+val);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
	
	public static void main(String[] args) {
		Assignment assignment=new Assignment();
		String pathString="C:\\Users\\khara\\Downloads\\abc.txt";
		assignment.frequencies(pathString);
	}
}
