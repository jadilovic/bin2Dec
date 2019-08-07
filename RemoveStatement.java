package vjezbe;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class RemoveStatement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		if(args.length != 1){
			System.out.println("Usage: RemoveStatement chapteri");
			System.exit(0);
		}
		
		File mainDir = new File(args[0]);
		if(!mainDir.isDirectory()){
			System.out.println("Entered directory name " + mainDir.getName() + " is not a directory");
			System.exit(1);
		}
		
		File[] dirs = mainDir.listFiles();
		if(dirs == null){
			System.out.println("There are no files in the " + mainDir.getName() + " directory");
			System.exit(2);
		}
		
		ArrayList<File> dirFiles = new ArrayList<>();
		for(File f: dirs){
			if(f.isDirectory() && f.getName().contains("chapter")){
				dirFiles.add(f);
			}
			continue;
		}
		
		for(File ft: dirFiles){
			File[] ftx = ft.listFiles();
				for(int i = 0; i < ftx.length; i++){
					if(ftx[i].isFile() && ftx[i].getName().contains(".java")){
						removeStat(ftx[i], "package vjezbe");
					}
				}
		}
	}

	private static void removeStat(File file, String delTxt) {
		// TODO Auto-generated method stub
		String text;
		String fileText = "";
		String newLine = System.getProperty("line.separator");
		try {
			Scanner input = new Scanner(file);
			while(input.hasNext()){
				text = input.nextLine();
				if(text.contains(delTxt))
					continue;
				fileText += text + newLine;
			}
			input.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try{
			PrintWriter output = new PrintWriter(file);
			output.write(fileText);
			output.close();
		} catch (FileNotFoundException e){
			e.printStackTrace();
		}
	}

}
