public void countline(String fileString) {

		File file = new File(fileString);
		if (file.exists()) {
			try {
				FileReader fileReader = new FileReader(file);
				BufferedReader bufferedReader = new BufferedReader(fileReader);
				String string = bufferedReader.readLine();
				int countofwords = 0;
				int countofwords2 = 0, countofline = 0;
				int charcount = 0;
				while (string != null) {
					countofline++;
					countofwords2 = string.split(" ").length;
					countofwords = countofwords + countofwords2;
					String[] wordStrings = string.split(" ");
					for (String string2 : wordStrings) {
						charcount = charcount + string2.length();
					}
					string = bufferedReader.readLine();

				}
				System.out.println("count of lines" + countofline);
				System.out.println("count of words" + countofwords);
				System.out.println("count of char" + charcount);
				bufferedReader.close();

			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
			}

		} else {
			System.out.println("file not exist");
		}
	}