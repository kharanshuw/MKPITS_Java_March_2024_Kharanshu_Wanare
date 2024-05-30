//this method is used to count specific string in file 

public void countofword(String fileString,String nameString) {

		File file=new File(fileString);
		if (file.exists()) {
			try {
				
				FileReader fileReader=new FileReader(file);
				BufferedReader bufferedReader =new BufferedReader(fileReader);
				int count=0;
				String string =bufferedReader.readLine();
				while (string != null ) {
					String[] wordString=string.split(" ");
					for (String string2 : wordString) {
						if (string2.equalsIgnoreCase(nameString)) {
							count++;
						}
					}
					string = bufferedReader.readLine(); 
				}
				System.out.println("count of given string is"+count);
				
				bufferedReader.close();
				
			} 
			catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
			}
			
		}
		else {
			System.out.println("file not exist");
		}
	}