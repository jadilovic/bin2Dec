package vjezbe;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class addOwner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		if(args.length != 1){
			System.out.println("Usage: addOwner chapteri");
			System.exit(0);
		}
		
		File chaps = new File(args[0]);
		if(!chaps.exists()){
			System.out.println("Entered directory " + args[0] + " does not exist");
			System.exit(1);
		}
		
		File[] listChaps = chaps.listFiles();
		if(listChaps == null){
			System.out.println("No files in the " + chaps.getName() + " directory");
			System.exit(2);
		}
		
		for(File list: listChaps)
			System.out.println(list.getName());
		
		ArrayList<File> fileChaps = new ArrayList<>();
		for(int i = 0; i < listChaps.length; i++){
			if(listChaps[i].isDirectory() && listChaps[i].getName().contains("chapter")){
				fileChaps.add(listChaps[i]);
			}
		}
		
		for(int i = 0; i < fileChaps.size(); i++){
			System.out.println(fileChaps.get(i).getName());
		}
		
		if(fileChaps.isEmpty()){
			System.out.println("There is no directories in direoctoy " + chaps.getName() + " that have chapter in it");
			System.exit(3);
		}
		
		for(File dir: fileChaps){
			File[] files = dir.listFiles();
			
			if(files == null) continue;
			
			for(File file: files){
				if(file.getName().contains(".java"))
					owner(file, "jasmin");
			}
		}
			
	}

	private static void owner(File file, String string) {
		String lineSeparator = "\n";
		String addOwnerName = "Code made by: " + string + ";";
		
		try {
			Scanner input = new Scanner(file);
			while(input.hasNextLine()){
				String s = input.nextLine();
				if(s.equals(addOwnerName)){
					System.out.println("The code in " + file.getName() + " already has owner name");
					return;
				}
				addOwnerName += s + lineSeparator;
				System.out.print(addOwnerName);
			}
			input.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try{
			PrintWriter output = new PrintWriter(file);
			output.write(addOwnerName);
			output.close();
		} catch (FileNotFoundException e){
			e.printStackTrace();
		}
		
	}

}
