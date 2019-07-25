package vjezbe;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class RemoveText {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Check command line parameter usage
	if (args.length != 2) {
	System.out.println("Usage: java RemoveText stringRemove fileName");
		System.exit(1);
		}
	
	// Check if String
	String name = args[0];
		
		// Check if source file exists
		File sourceFile = new File(args[1]);
		if (!sourceFile.exists()) {
		System.out.println("Source file " + args[1] + " does not exist");
		System.exit(2);
		}
		
		String s = "";
		try (
		// Create input and output files
				Scanner input = new Scanner(sourceFile);
				) {
					while (input.hasNext()) {
						s +=  input.nextLine() + " ";
						System.out.println(s);
						}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		s = s.replaceAll(name, "");
		
		try{
			PrintWriter output = new PrintWriter(sourceFile);
			System.out.println(s);
			output.write(s);
			output.close();
		} catch (FileNotFoundException e){
			e.printStackTrace();
		}
		
		System.out.println("Complete");
	}

}
