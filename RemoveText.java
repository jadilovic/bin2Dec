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
		
		// Check if source file exists
		File sourceFile = new File(args[1]);
		if (!sourceFile.exists()) {
		System.out.println("Source file " + args[1] + " does not exist");
		System.exit(2);
		}
		
		try (
		// Create input and output files
				Scanner input = new Scanner(sourceFile);
				PrintWriter output = new PrintWriter(sourceFile);
				) {
					while (input.hasNext()) {
						String s1 = input.nextLine();
						System.out.println(args[0].toString() + " " + s1);
						if(s1 == args[0])
							s1.replace(s1, "");
						String s2 = s1;
						output.print(s2);
					}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
