package vjezbe;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ReformatCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		if(args.length != 1){
			System.out.println("Usage: java ReformatCode Test.java");
			System.exit(1);
		}
		
		File code = new File(args[0]);
		if(!code.exists()){
			System.out.println("The entered file " + args[0] + " does not exist");
			System.exit(2);
		}
		
		String s = "";
		try{
			Scanner input = new Scanner(code);
			while(input.hasNext()){
				String st = input.nextLine();
				if(st.equals("{")){
					s += st;
					continue;
				}
					s += st + " \n";
			}
			System.out.println(s);
			File code2 = new File("Test.java");
			PrintWriter output = new PrintWriter(code2);
			output.print(s);
			output.close();
			input.close();
			
		} catch (FileNotFoundException e){
			System.out.println("File not found");
		}
		

	}

}
