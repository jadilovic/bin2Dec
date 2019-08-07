package vjezbe;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class DataSorted {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File dataSorted = new File("C:\\NewWorkspace\\Lekcija11\\src\\SortedStrings.txt");
		if(!dataSorted.exists()){
			System.out.println("File SortedString does not exist");
			System.exit(0);
		}
		
		boolean Sorted = true;
		String word1 = "";
		String word2 = "";
		try{
			Scanner input = new Scanner(dataSorted);
			word1 = input.nextLine();
			
			while(Sorted){
				word2 = input.nextLine();
				if(word1.compareTo(word2) > 0){
					System.out.println("Words " + word1 + " and " + word2 + " are out of order");
					Sorted = false;
				}
				word1 = word2;
			}
			input.close();
			
		} catch (Exception e){
			e.printStackTrace();
		}
		
	}

}
