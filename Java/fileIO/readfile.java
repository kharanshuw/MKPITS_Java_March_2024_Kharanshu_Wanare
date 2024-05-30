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
	//read from file and display content
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
}

package fileoperation;

import java.util.Scanner;

public class Demo {
	public static void main(String[] args) {
		Myfile myfile=new Myfile();
		System.out.println("enter file name");
		Scanner scanner = new Scanner(System.in);
		String filenameString=scanner.nextLine();
		myfile.readfromfile(filenameString);
	}
}

