package vjezbe;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ProcessScores {

	public static void main(String[] args) {
		
		System.out.println("Please enter the name of the file");
		Scanner input = new Scanner(System.in);
		String fileName = input.nextLine();
		
		File file = new File(fileName);
		if(!file.exists()){
			System.out.println("Entered file name " + file + " does not exist");
			input.close();
			System.exit(0);
		}
		
		try {
			Scanner read = new Scanner(file);
			ArrayList list = new ArrayList<>();
			while(read.hasNextInt()){
				int num = read.nextInt();
				list.add(num);
			}
			
			int [] nums = new int[list.size()];
			int total = 0;
			int count = 0;
			for(int i = 0; i < list.size(); i++){
				System.out.print(list.get(i) + " ");
				nums[i] = (int) list.get(i);
				total += nums[i];
			}
			System.out.println();
			System.out.println("Total score: " + total);
			System.out.println("Average score: " + total / list.size());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
