package vjezbe;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
		
		ArrayList list = new ArrayList<>();
		try {
			Scanner input = new Scanner(code);
			while(input.hasNext()){
				String st = input.nextLine();
						list.add(st);
			}
			for(int i = 0; i < list.size(); i++){
				System.out.println(list.get(i));
			}
			
			PrintWriter output = new PrintWriter(code);
			String tx = "";
			for(int i = 0; i < list.size(); i++){
				tx = list.get(i).toString();
			    if(list.get(i).equals("{") || list.get(i).equals("}") || tx.charAt(0) == '/'){
			    	output.println(list.get(i));
			    	continue;
			    }
			    output.print(list.get(i) + " ");
			}
			//output.println(s);
			output.close();
			input.close();
			
		} catch (FileNotFoundException e){
			System.out.println("File not found");
		}
		

	}

}
