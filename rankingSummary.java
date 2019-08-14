package vjezbe;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class rankingSummary {

	public static void main(String[] args) {
		
		File mainDir = new File("C:\\NewWorkspace\\Lekcija11\\src\\imena");
		
		if(!mainDir.exists()){
			System.out.println("Directory " + mainDir.getAbsolutePath() + " does not exist");
			System.exit(0);
		}
		
		if(!mainDir.isDirectory()){
			System.out.println("Entered directory " + mainDir.getName() + " is NOT a directory");
			System.exit(1);
		}
		
		File[] fileList = mainDir.listFiles();
		
		if(fileList.length == 0){
			System.out.println("No file in the " + mainDir.getName() + " directory");
			System.exit(2);
		}
		
		System.out.println("______________________________________________________________________________________________________________________");
		System.out.printf("'%-6s%-11s%-11s%-11s%-11s%-11s%-11s%-11s%-11s%-11s%-11s'\n", "Year", "Rank 1", "Rank 2", "Rank 3", "Rank 4", "Rank 5", "Rank 1", "Rank 2", "Rank 3", "Rank 4", "Rank 5");
		System.out.println("______________________________________________________________________________________________________________________\n");
		
		for(File file: fileList){
			if(file.isFile() && file.getName().contains("imena")){
				read(file);
			}
		}
	}

	private static void read(File file) {
		ArrayList<String> fRanks = new ArrayList<>();
		ArrayList<String> mRanks = new ArrayList<>();
		
		try {
			Scanner input = new Scanner(file);
			for(int i = 0; i < 5; i++){
				int rank = input.nextInt();
				String mName = input.next();
				int mNumbers = input.nextInt();
				String fName = input.next();
				int fNumbers = input.nextInt();
				System.out.print(fName + " ");
				fRanks.add(fName);
				mRanks.add(mName);
			}
			input.close();
			System.out.println();
		System.out.printf("%-6s", file.getName().substring(5));

			//print(fRanks);
			//print(mRanks);
			//System.out.printf("\n");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i = 5; i < 5; i++){
			System.out.print(fRanks.get(i) + " ");
		}
	}

	public static void print(String[] ranks) {
		
		for(int i = 5; i < 5; i++){
			System.out.print("test");
			System.out.printf("%-11s", ranks[i]);
		}
	}
}
