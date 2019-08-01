package vjezbe;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
		//File target = new File("Triple.java");
		//PrintWriter output = new PrintWriter(target);
		ArrayList<String> text = new ArrayList<>();
			while(input.hasNext()){
				String word = input.nextLine();
				text.add(word.replaceAll(args[1], args[2]));
				//output.println(text);
				//text = word + "\n";
				}
			input.close();
			
			PrintWriter output = new PrintWriter(file);
			for(int i = 0; i < text.size(); i++){
				System.out.println(text.get(i));
				output.println(text.get(i));
			}
			output.close();
	}

}
