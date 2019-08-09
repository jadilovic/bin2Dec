package vjezbe;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class makeDir {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Please enter name of directory to be created");
		Scanner input = new Scanner(System.in);
		String dirName = input.next();
		input.close();
		File file = new File(dirName);
		
		if(file.exists()){
			System.out.println("Directory " + file.getName() + " already exists.");
			System.exit(0);
		}
		
		try {
			PrintWriter output = new PrintWriter(dirName);
			output.print("testTwo tekst");
			output.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		file.mkdirs();
		System.out.println("Directory " + file.getName() + " sucessfuly created");
	}
}
