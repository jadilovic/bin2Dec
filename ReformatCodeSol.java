package vjezbe;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ReformatCodeSol {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// Check java arguement usage
		if (args.length != 1) {
			System.out.println("Usage: java Exercise_12_12 file");
			System.exit(1);
		}

		// Create file object
		File file = new File(args[0]);

		// Check if file exists
		if (!file.exists()) {
			System.out.println("File " + args[0] + " does not exist");
			System.exit(2);
		}

		// Create an ArrayList
		ArrayList<String> list = new ArrayList<>();
		String string1 = "";
		String string2 = "";

		// Read text from file
		try (
			// Create an input file
			Scanner input = new Scanner(file);
		) {
			// Convert java source code from next-line 
			// brace style to the end-of-line brace style
			string1 = input.nextLine();
			while (input.hasNext()) {
				string2 = input.nextLine();
				if (string2.length() > 0 && string2.charAt(string2.length() - 1) == '{') {
					list.add(string1.concat(" {"));
					string1 = input.nextLine();
				}
				else {
					list.add(string1);
					string1 = string2;
				}
			}
			list.add(string1);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
			// Create an output file
			PrintWriter output = new PrintWriter(file);
				for (int i = 0; i < list.size(); i++) {
					output.println(list.get(i));
				}
			output.close();
	}

}
