package vjezbe;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class replaceWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		if(args.length != 1){
			System.out.println("Usage: replaceWord directory");
			System.exit(0);
		}
		
		File mainDir = new File(args[0]);
		
		if(!mainDir.exists()){
			System.out.println("Entered directory " + mainDir.getName() + " does not exist");
			System.exit(1);
		}
		
		if(!mainDir.isDirectory()){
			System.out.println("Entered directory " + mainDir.getName() + " is NOT directory");
			System.exit(2);
		}
		
		File[] list = mainDir.listFiles();
		
		if(list.length == 0){
			System.out.println("No files in the directoy " + mainDir.getName());
			System.exit(3);
		}
			
		for(File f: list){
			if(f.isFile() && f.getName().contains("Exercise") || f.getName().contains("Copy")){
				addText(f);
			}
		}
		
		for(File f: list){
			if(f.isFile() && f.getName().contains("Exercise")){
				replaceText(f);
			}
		}
		
	}

	private static void replaceText(File f) {
		try {
			Scanner input = new Scanner(f);
			while(input.hasNext()){
				String word = input.next();
				if(word.length() < 13){
					char num1 = word.charAt(8);
					char num2 = word.charAt(10);
					String target = word.substring(8);
					String replace = String.valueOf("" + '0' + num1 + "_" + '0' + num2);
					// System.out.println("replace: " + replace);
					String replaceText = word.replaceAll(target, replace);
					PrintWriter output = new PrintWriter(f);
					output.print(replaceText);
					output.close();
				}
			}
			input.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void addText(File f) {
		try {
			PrintWriter output = new PrintWriter(f);
			output.print(f.getName());
			output.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
