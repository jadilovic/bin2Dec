package vjezbe;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class CountWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		File file = new File("C:\\NewWorkspace\\Lekcija11\\src\\lincoln.txt");
		
		if(!file.exists()){
			System.out.println("File " + file.getName() + " does not exist");
			System.exit(0);
		}
		
		ArrayList<String> words = new ArrayList<>();
		try{
			Scanner input = new Scanner(file);
			String word;
			while(input.hasNext()){
				word = input.next();
				words.add(word);
			}
			input.close();
		} catch(Exception e){
			e.printStackTrace();
		}
		
		System.out.println("Number of words is " + words.size());
	}

}
