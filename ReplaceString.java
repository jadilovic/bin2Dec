package vjezbe;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ReplaceString {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		if(args.length != 3){
			System.out.println("Usage: java ReplaceString file oldString newString");
			System.exit(0);
		}
		
		File file = new File(args[0]);
		
		if(!file.exists()){
			System.out.println("Entered file " + args[0] + " does not exist");
			System.exit(1);
		}
		
		Scanner input = new Scanner(file);
		//PrintWriter output = new PrintWriter(file);
		
			while(input.hasNext()){
				String word = input.next();
				//if(word == args[1]){
					word.replaceAll(args[1], args[2]);
					//output.print(word);
					
				//	output.write(args[2]);
				// }
			}
			input.close();
			// output.close();
	}

}
