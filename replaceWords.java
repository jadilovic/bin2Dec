package vjezbe;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

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
