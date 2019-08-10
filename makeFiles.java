package vjezbe;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class makeFiles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//for(int i = 0; i < 15; i++){
		//	File file = new File("Exercise" + i + "_" + i);
		//	try {
		//		PrintWriter output = new PrintWriter(file);
		//	} catch (FileNotFoundException e) {
		//		// TODO Auto-generated catch block
		//		e.printStackTrace();
		//	}
		// }
		
		if(args.length != 1){
			System.out.println("Usage: java makeFiles *");
			System.exit(0);
		}
		
		File files = new File(args[0]);
		
		if(!files.exists()){
			System.out.println("Entered directory does not exist" + files.getAbsolutePath());
			System.exit(1);
		}
		
		if(!files.isDirectory()){
			System.out.println("Entered file name is not a directory");
			System.exit(2);
		}
		
		File[] list = files.listFiles();
		try{
		for(File f: list){
			System.out.println(f.getName());
				if(f.getName().contains("Exercise")){
					if(singleDigit(f)){
						addZero(f);
					}
					}
				}
		} catch (NullPointerException ex){
			System.out.println("No files found in the direcotry");
		}
	}

	private static void addZero(File f) {
		f.getName().replace("1_1", "01_01");
	}

	private static boolean singleDigit(File f) {
		if(f.getName().length() < 12)
			return true;
		else
		return false;
	}

}
