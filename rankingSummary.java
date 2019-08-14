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
		
		System.out.println("________________________________________________________________________________________________________________________________");
		System.out.printf("'%-6s%-12s%-12s%-12s%-12s%-12s%-12s%-12s%-12s%-12s%-12s'\n", "Year", "Rank 1", "Rank 2", "Rank 3", "Rank 4", "Rank 5", "Rank 1", "Rank 2", "Rank 3", "Rank 4", "Rank 5");
		System.out.print("__________________________________________________________________________________________________________________________________\n");
		
		for(File file: fileList){
			if(file.isFile() && file.getName().contains("imena")){
				read(file);
			}
		}
	}

	private static void read(File file) {
		ArrayList<NameRanks> listRanks = new ArrayList<>();
		NameRanks nr = null;
		try {
			Scanner input = new Scanner(file);
			for(int i = 0; i < 5; i++){
				int rank = input.nextInt();
				String mName = input.next();
				int mNumbers = input.nextInt();
				String fName = input.next();
				int fNumbers = input.nextInt();
				nr = new NameRanks(rank, mName, mNumbers, fName, fNumbers);
				listRanks.add(nr);
			}
			input.close();
			
			print(file.getName(), listRanks);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void print(String year, ArrayList<NameRanks> listRanks) {
		year = year.substring(5, 9);
		System.out.printf("%-7s", year);
		for(int i = 0; i < 5; i++){
			System.out.printf("%-12s", listRanks.get(i).getfName());
		}
		for(int i = 0; i < 5; i++){
			System.out.printf("%-12s", listRanks.get(i).getmName());
		}
		System.out.println();
	}
}
