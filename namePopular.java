package vjezbe;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class namePopular {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the year: ");
		int year = input.nextInt();
		System.out.println("Enter the gender: ");
		String gender = input.next();
		System.out.println("Enter the name: ");
		String name = input.next();
		input.close();
		
		File file = new File("C:\\NewWorkspace\\Lekcija11\\src\\imena\\imena" + year + ".txt");
		
		if(!file.exists()){
			System.out.println("Entered year / file name does not exist " + file.getAbsolutePath());
			System.exit(0);
		}
		
		ArrayList<Integer> rank = new ArrayList<>();
		ArrayList<String> mName = new ArrayList<>();
		ArrayList<Integer> mNumbers = new ArrayList<>();
		ArrayList<String> fName = new ArrayList<>();
		ArrayList<Integer> fNumbers = new ArrayList<>();
		try {
			Scanner input2 = new Scanner(file);
				while(input2.hasNext()){
					rank.add(input2.nextInt());
					mName.add(input2.next());
					mNumbers.add(input2.nextInt());
					fName.add(input2.next());
					fNumbers.add(input2.nextInt());
				}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	//	for(int i = 0; i < rank.size(); i++){
	//		System.out.println(rank.get(i) + " " + mName.get(i) + " " + mNumbers.get(i) + " " + fName.get(i) + " " + fNumbers.get(i));
	//	}
		
		for(int i = 0; i < rank.size(); i++){
			if(gender.equals("M") && mName.get(i).equals(name)){
					System.out.println(name + " is ranked #" + rank.get(i) + " in year " + year);
					System.exit(1);
				}
			if(gender.equals("F") && fName.get(i).equals(name)){
				System.out.println(name + " is ranked #" + rank.get(i) + " in year " + year);
				System.exit(2);
			}
		}

			System.out.println("No name " + name + " found in the year " + year);
	}

}
