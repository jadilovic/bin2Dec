package vjezbe;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class RepStringsFiles {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		if(args.length != 3){
			System.out.println("Usage: java ReplaceString dir oldString newString");
			System.exit(0);
		}
		
		File dirMain = new File(args[0]);
		
		if(!dirMain.exists()){
			System.out.println("Entered directory " + args[0] + " does not exist");
			System.exit(1);
		}
		
		if(!dirMain.isDirectory()){
			System.out.println("Entered directory " + args[0] + " is not a directory");
			System.exit(2);
		}
		
		
		File[] filesList = dirMain.listFiles();
		
		ArrayList<File> files = new ArrayList<>();
		
		for(File data: filesList){
			if(data.isFile() && data.getName().contains(".java")){
				replace(data, args[1], args[2]);
			}
		}

	}

	private static void replace(File data, String oldString, String newString) throws FileNotFoundException {
		Scanner input = new Scanner(data);
		ArrayList<String> text = new ArrayList<>();
			while(input.hasNext()){
				String word = input.nextLine();
				text.add(word.replaceAll(oldString, newString));
				//output.println(text);
				//text = word + "\n";
				}
			input.close();
			
			PrintWriter output = new PrintWriter(data);
			for(int i = 0; i < text.size(); i++){
				System.out.println(text.get(i));
				output.println(text.get(i));
			}
			output.close();
	}

}