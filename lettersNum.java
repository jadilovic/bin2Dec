package vjezbe;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class lettersNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter a file name: ");
		
		String fileName = input.next();
		input.close();
		
		File file = new File("C:\\NewWorkspace\\Lekcija11\\src\\" + fileName);
		
		if(!file.exists()){
			System.out.println("Entered file " + file.getAbsolutePath() + " does not exitst");
			System.exit(0);
		}
		
		try {
			Scanner input2 = new Scanner(file);
			int [] count = new int[27];
			int [] letter = new int[27];
			for(int i = 64, j = 0; i < 91; i++, j++){
				letter[j] = i;
			}
			
			while(input2.hasNext()){
				String word = input2.nextLine();
				char[] charArr = word.toCharArray();
				for(char numChar: charArr){
					if(Character.isLetter(numChar)){
						int num = numChar;
							if(num > 96)
								num -= 32;
						for(int i = 0; i < count.length; i++){
							if(num == letter[i]){
								count[i]++;
								}
							}
					}
					
						}
				}
			int total = 0;
			for(int i = 0; i < count.length; i++){
				char ch = (char) letter[i];
				System.out.println("Number of " + ch + "'s: " + count[i]);
				total += count[i];
			}
			System.out.println("total num of letters: " + total);
			input2.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}


