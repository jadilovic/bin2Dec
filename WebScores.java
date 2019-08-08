package vjezbe;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class WebScores {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		ArrayList<Integer> scores = new ArrayList<>();
		
		try{
			URL url = new URL("http://cs.armstrong.edu/liang/data/Scores.txt");
			Scanner input = new Scanner(url.openStream());
			int score = 0;
			
				while(input.hasNext()){
					score = input.nextInt();
					scores.add(score);
				}
				input.close();
		} catch(MalformedURLException ex){
			ex.printStackTrace();
			System.out.println("Invalid URL");
		} catch (java.io.IOException ex) {
			System.out.println("I/O Errors: No so such file");
		} catch (InputMismatchException ex) {
			System.out.println("InputMismatchException Errors: No integeres separated by blanks in the file");
		}
		
		try{
		int total = 0;
		for(int i = 0; i < scores.size(); i++){
			System.out.println(scores.get(i) +  " ");
			total += scores.get(i);
		}
		int average = total / scores.size();
		System.out.println("Total score is: " + total + " and average is: " + average);
		} catch (ArithmeticException ae){
			System.out.println("ArtihmeticException because / by zero, no list of integers in the ArrayList");
		}
	}

}
