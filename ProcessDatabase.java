package vjezbe;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Locale;
import java.util.Scanner;

public class ProcessDatabase {

	public static void main(String[] args) throws UnknownHostException {
		// TODO Auto-generated method stub

		try {
			URL url = new URL("http://cs.armstrong.edu/liang/data/Salary.txt.");
			Scanner input = new Scanner(url.openStream());
			String line = "";
			while(input.hasNext()){
				line = input.nextLine();
				System.out.println(line);
			}
			input.close();
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Please enter site:");
		Scanner input = new Scanner(System.in);
		String site;
		site = input.nextLine();
		
		try {
			URL url = new URL(site);
			Scanner input2 = new Scanner(url.openStream());
			int count = 0;
			String line;
		
			while(input2.hasNext()){
				line = input2.nextLine();
				count += line.length();
			}
			System.out.println("The site " + site + " has " + count + " characters");
			input2.close();
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String fileName;
		System.out.println("Please enter Salary file: ");
		fileName = input.nextLine();
		input.close();
		
		File file = new File(fileName);
		if(!file.exists()){
			System.out.println("Entered file " + fileName + " does not exist");
			System.exit(0);
		}
		
		try {
			Scanner input4 = new Scanner(file);
			String firstName = null;
			String lastName = null;
			String rank = null;
			double salary = 0;
			int count1 = 0;
			int count2 = 0;
			int count3 = 0;
			double countAss = 0;
			double countAcc = 0;
			double countFul = 0;
			String ass = "assistant";
			String acc = "associate";
			String ful = "full";
			
			while(input4.hasNext()){
				firstName = input4.next();
				lastName = input4.next();
				rank = input4.next();
				salary = input4.nextDouble();
				if(rank.equals(ass)){
					countAss = countAss + salary;
					count1++;
					}
				if(rank.equals(acc)){
					countAcc = countAcc + salary;
					count2++;
					}
				if(rank.equals(ful)){
					countFul = countFul + salary;
					count3++;
					}
				System.out.println(firstName + " " + lastName + " " + rank + " " + salary);
				}

			input4.close();
			
			System.out.printf("Total salary assistant: '%12.2f'%n", countAss);
			System.out.printf("Total salary associate: '%12.2f'%n", countAcc);
			System.out.printf("Total salary full: '%12.2f'%n", countFul);
			System.out.printf("Total average salary assistant: '%12.2f'%n", countAss / count1);
			System.out.printf("Total average salary associate: '%12.2f'%n", countAcc / count2);
			System.out.printf("Total avergae salary full: '%12.2f'%n", countFul / count3);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
