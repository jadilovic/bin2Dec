package vjezbe;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CountAll {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if(args.length != 1){
			System.out.println("Usage: java CountAll Loan.java");
			System.exit(1);
		}
		
		File text = new File(args[0]);
		if(!text.exists()){
			System.out.println("Entered file " + args[0] + " does not exist. Try again.");
			System.exit(2);
		}
		
		try {
			Scanner input = new Scanner(text);
			String tx = "";
			int totalChar = 0;
			int totalWord = 0;
			int totalLine = 0;
			while(input.hasNext()){
				tx = input.nextLine();
				int charNum = tx.length();
				totalChar += charNum;
				int wordNum = wordCound(tx);
				totalWord += wordNum;
				totalLine++;
			}
			System.out.println(totalChar + " characters");
			System.out.println(totalWord + " words");
			System.out.println(totalLine + " lines");
		} catch (FileNotFoundException ex){
			System.out.println(ex.getStackTrace());
		}
	}

	private static int wordCound(String tx) {
		String[] words = tx.split(" ");
		return words.length;
	}
}
