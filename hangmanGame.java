package vjezbe;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class hangmanGame {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		 File file = new File("hangman.txt");
		 if(!file.exists()){
			 System.out.println("File " + "hangman.txt" + " does not exist");
			 System.exit(0);
		 }
		 
		  Scanner input = new Scanner(file);
		  String ans;
		  ArrayList<String> words = new ArrayList<>();
		  while(input.hasNext()){
			  words.add(input.next());
		  }
		 
		  do {
		   int i = intRandom(0, words.size() - 1);
		   char[] word = words.get(i).toCharArray();
		   boolean[] mask = new boolean[word.length];
		   int numberOfCorrectGuess = 0;
		   int numberOfMisses = 0;
		   while (numberOfCorrectGuess != word.length) {
		    System.out.print("(Guess) Enter a letter in word ");
		 
		    // Print out result
		    for (int j = 0; j < word.length; j++) {
		 
		     if (mask[j])
		      System.out.print(word[j]);
		     else
		      System.out.print("*");
		 
		    }
		 
		    System.out.print(">");
		    char guess = input.next().charAt(0);
		 
		    // Checking
		    boolean miss = true;
		    boolean repeat = false;
		 
		    for (int j = 0; j < word.length; j++) {
		     if (word[j] == guess) {
		      if (mask[j] != true) {
		       mask[j] = true;
		       numberOfCorrectGuess++;
		      } else {
		       repeat = true;
		       break;
		      }
		      miss = false;
		     }
		    }
		 
		    if (miss)
		     numberOfMisses++;
		    if (repeat)
		     System.out.println(guess + " is already in the word");
		 
		   }
		 
		   System.out.println("The word is " + String.valueOf(word)
		     + ". You missed " + numberOfMisses + " time");
		   System.out.print("Do you want to guess another word? Enter y or n>");
		   ans = input.next();
		  } while (ans.charAt(0) != 'n');
		  input.close();
		 }
		 
		 public static int intRandom(int lowerBound, int upperBound) {
		  return (int) (lowerBound + Math.random()
		    * (upperBound - lowerBound + 1));
	}

}
