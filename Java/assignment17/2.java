package practise;


import java.util.LinkedHashSet;
import java.util.Scanner;

public class Assignment{
	
	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        LinkedHashSet<String> userInputs = new LinkedHashSet<>();

	        System.out.println("Enter words type done to finish");

	        while (true) {
	            String input = scanner.nextLine();

	            if (input.equalsIgnoreCase("done")) {
	                break;
	            }

	            userInputs.add(input);
	        }

	        System.out.println("You entered:");
	        for (String input : userInputs) {
	            System.out.println(input);
	        }

	        scanner.close();
	    }
	 
}