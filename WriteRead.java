package vjezbe;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class WriteRead {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File randomFile = new File("Random.txt");
		
		if(randomFile.exists()){
			System.out.println("This file already exists");
			System.exit(0);
		}
		
		PrintWriter output = new PrintWriter(randomFile);
			int random;
			for(int i = 0; i < 40; i++){
				random = (int) (Math.random() * 40) + 1;
				System.out.print(random + " ");
				output.print(random + " ");
			}
			output.close();
			
			Scanner input = new Scanner(randomFile);
			ArrayList<Integer> nums = new ArrayList<Integer>();
			try{
				while(input.hasNext()){
					int num = input.nextInt();
					nums.add(num);
				}
				input.close();
				int [] list = new int[nums.size()];
				for(int i = 0; i < list.length; i++){
					list[i] = (int) nums.get(i);
				}
				
				Arrays.sort(list);
				
				System.out.println();
				System.out.println("In Ascending Order:");
				//output.println();
				//output.println("In Ascending Order:");
				for(int i: list){
					System.out.print(i + " ");
					//output.print(i + " ");
				}
					
			} catch (NumberFormatException ex){
				System.out.println("Not a number in the file");
			}
	}

}
