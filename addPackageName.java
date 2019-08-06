package vjezbe;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class addPackageName {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		if(args.length != 1){
			System.out.println("Usage: java Lekcija11 chapteri");
			System.exit(0);
		}
		
		System.out.println("Uneseni directory: " + args[0]);
		
		File mainDir = new File(args[0]);
		if(!mainDir.isDirectory()){
			System.out.println(mainDir.getAbsolutePath());
			System.out.println("Entered directory " + args[0] + " does not exisit");
			System.exit(1);
		}
		
		System.out.println("Ime mainDir je: " + mainDir.getName());
		
        File[] mainDirFiles = mainDir.listFiles();
        if (mainDirFiles == null) {
            System.out.println("No files found in " + mainDir.getName());
            System.exit(3);
        }
        
        for(int i = 0; i < mainDirFiles.length; i ++){
        	System.out.println(mainDirFiles[i].getName());
        }
        
        ArrayList<File> packageDirs = new ArrayList<>();
        for (int i = 0; i < mainDirFiles.length; i++) {
            if (mainDirFiles[i].isDirectory() && mainDirFiles[i].getName().contains("chapter")) {
                packageDirs.add(mainDirFiles[i]);
            }
        }
        
        System.out.println("Lista foldera u chapteri:");
        
        for(int i = 0; i < packageDirs.size(); i ++){
        	System.out.println(packageDirs.get(i).getName());
        }
        
        if (packageDirs.isEmpty()) {
            System.out.print("No package directories found in " + mainDir.getName());
            System.exit(2);
        }

        for (File dir : packageDirs) {
            File[] files = dir.listFiles();

            if (files == null) continue;

            for (File file : files) {

                if (file.getName().contains(".java")) {
                    updateFilePackage(file, dir.getName());
                }
            }
	}

}

	private static void updateFilePackage(File file, String name) {
		String lineSeparator = System.getProperty("line.separator");
        String packageString = "package " + name + ";";


        // read file
        try (Scanner input = new Scanner(file)) {

            while (input.hasNext()) {

                String s = input.nextLine();
                if (s.equals(packageString)) {
                    System.out.println("File: " + file + " already has package " + name);
                    return; // stops method if package is already in file header
                }
                packageString += lineSeparator + s;

            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        // save new file
        try (PrintWriter out = new PrintWriter(file)) {
            out.write(packageString);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        System.out.println(packageString);
	}
}
