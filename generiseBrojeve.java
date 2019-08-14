package vjezbe;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class generiseBrojeve {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		File file = new File("100brojeva.txt");
		if(file.exists()){
			System.out.println("File " + file.getAbsolutePath() + "already exists");
			System.exit(0);
		}
		
		PrintWriter output = new PrintWriter(file);
		int random = 0;
		for(int i = 0; i < 100; i++){
			random = (int) (Math.random() * 100 + 1);
			output.print(random + " ");
		}
		output.close();
		
		Scanner input = new Scanner(file);
		int[] listNum = new int[100];
		int count = 0;
		int num = 0;
		while(input.hasNext()){
			num = input.nextInt();
			listNum[count] = num;
			count++;
		}
		Arrays.sort(listNum);
		
		for(int i = 0; i < 100; i++)
			System.out.print(listNum[i] + " ");
	}

}
