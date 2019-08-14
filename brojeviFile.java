package vjezbe;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class brojeviFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Enter the file name:");
		Scanner input = new Scanner(System.in);
		String name = input.next();
		input.close();
		
		File file = new File("C:\\NewWorkspace\\Lekcija11\\" + name);
		
		if(!file.exists()){
			System.out.println("Entered file " + file.getName() + " does NOT exist");
			System.exit(0);
		}
		
		ArrayList<Integer> brojeviList = new ArrayList<>();
		int broj = 0;
		
		try {
			Scanner input2 = new Scanner(file);
		
			while(input2.hasNext()){
				broj = input2.nextInt();
				brojeviList.add(broj);
			}
			input2.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int total = 0;
		int average = 0;
		for(int i = 0; i < brojeviList.size(); i++){
			total += brojeviList.get(i);
		}
		average = total / brojeviList.size();
		System.out.println("Total is: " + total + " and average is: " + average);
	}

}
