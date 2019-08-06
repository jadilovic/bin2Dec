package vjezbe;

import java.io.File;
import java.util.ArrayList;

public class addOwner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		if(args.length != 1){
			System.out.println("Usage: addOwner chapteri");
			System.exit(0);
		}
		
		File chaps = new File(args[0]);
		if(!chaps.exists()){
			System.out.println("Entered directory " + args[0] + " does not exist");
			System.exit(1);
		}
		
		File[] listChaps = chaps.listFiles();
		if(listChaps == null){
			System.out.println("No files in the " + chaps.getName() + " directory");
			System.exit(2);
		}
		
		for(File list: listChaps)
			System.out.println(list.getName());
		
		ArrayList<File> fileChaps = new ArrayList<>();
		for(int i = 0; i < listChaps.length; i++){
			if(listChaps[i].isDirectory() && listChaps[i].getName().contains("chapter")){
				fileChaps.add(listChaps[i]);
			}
		}
		
		for(int i = 0; i < fileChaps.size(); i++){
			System.out.println(fileChaps.get(i).getName());
		}
			
	}

}
