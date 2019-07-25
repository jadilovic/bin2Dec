package vjezbe;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class RemoveText2 {

	public static void main(String[] args) throws Exception{
		
		// Check command line parameter usage
	if (args.length != 2) {
	System.out.println("Usage: java RemoveText2 stringTex sourceFile");
		System.exit(1);
		}
		
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
				PrintWriter output = new PrintWriter(sourceFile);) {
					while (input.hasNext()) {
						String s1 = input.nextLine();
						if(s1 == args[0])
							s1 = "";
						s += s1;
					}
					output.println(s);
			} catch (FileNotFoundException e){
				e.getStackTrace();
			}
	}
}
