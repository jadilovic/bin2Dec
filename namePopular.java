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
		
		ArrayList<NameRanks> rankList = new ArrayList<>();
		NameRanks nr = new NameRanks();
		
		try {
			Scanner input2 = new Scanner(file);
			
				while(input2.hasNext()){
					int rank = input2.nextInt();
					String mName = input2.next();
					int mNumbers = input2.nextInt();
					String fName = input2.next();
					int fNumbers = input2.nextInt();
					nr = new NameRanks(rank, mName, mNumbers, fName, fNumbers);
					rankList.add(nr);
				}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	//	for(int i = 0; i < rank.size(); i++){
	//		System.out.println(rank.get(i) + " " + mName.get(i) + " " + mNumbers.get(i) + " " + fName.get(i) + " " + fNumbers.get(i));
	//	}
		for(int i = 0; i < rankList.size(); i++){
			System.out.println(rankList.get(i).toString());
		}
		
		for(int i = 0; i < rankList.size(); i++){
			if(gender.equals("M") && rankList.get(i).getmName().equals(name)){
					System.out.println(name + " is ranked #" + rankList.get(i).getRank() + " in year " + year);
					System.exit(1);
				}
			if(gender.equals("F") && rankList.get(i).getfName().equals(name)){
				System.out.println(name + " is ranked #" + rankList.get(i).getRank() + " in year " + year);
				System.exit(2);
			}
		}

			System.out.println("No name " + name + " found in the year " + year);
	}

}
