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
		
		for(File f: list){
			System.out.println(f.getName());
			addText(f);
		}
		
		try{
		for(File f: list){
			System.out.println(f.getName() + " - " + f.getAbsolutePath());
			//addText(f);
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

	private static void addText(File f) {
		try {
			PrintWriter output = new PrintWriter(f);
			System.out.println("addText method");
			output.print(f.getName());
			output.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	private static void addZero(File f) {
		System.out.println("Add zero Method" + f.getAbsolutePath());
		String replaceName;
		char num1 = f.getName().charAt(8);
		char num2 = f.getName().charAt(10);
		String target = f.getName().substring(8);
		String replace = String.valueOf("" + '0' + num1 + "_" + '0' + num2);
		System.out.println("replace: " + replace);
		replaceName = f.getName().replaceAll(target, replace);
		
		File f2 = new File("C:\\NewWorkspace\\Lekcija11\\src\\FirstDirectory\\" + replaceName);
		f.renameTo(f2);
	//	try {
	//	} catch (FileNotFoundException e) {
	//		// TODO Auto-generated catch block
	//		e.printStackTrace();
	//	}
		System.out.println("f je path " + f.getAbsolutePath());
		System.out.println("f2 je path " + f2.getAbsolutePath());
	}

	private static boolean singleDigit(File f) {
		System.out.println("Single Digit Method");
		if(f.getName().length() < 12)
			return true;
		else
		return false;
	}

}
