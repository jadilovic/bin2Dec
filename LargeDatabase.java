package vjezbe;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class LargeDatabase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("Salary.txt");
		if(file.exists()){
			System.out.println("File " + file.getName() + " already exists.");
			System.exit(0);
		}
		
		String first = "FirstName";
		String last = "LastName";
		String rank = "";
		double salary = 0;
		
		try {
			PrintWriter output = new PrintWriter(file);
			for(int i = 0; i < 1000; i++){
				rank = generateRank();
				salary = generateSalary(rank);
				salary = round(salary, 2);
				output.println(first + i + " " + last + i + " " + rank + " " + salary);
			}
			output.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static double round(double salary, int places) {
		if (places < 0) throw new IllegalArgumentException();
		 
	    BigDecimal bd = new BigDecimal(Double.toString(salary));
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}

	private static double generateSalary(String rank) {
		double salary = 0;
		switch(rank){
		case "assistant": salary = Math.random() * 30001 + 50000;
		break;
		case "associate": salary = Math.random() * 50001 + 60000;
		break;
		case "full": salary = Math.random() * 55001 + 75000;
		break;
		default: salary = 0;
		break;
		}
		return salary;
	}

	private static String generateRank() {
		String rank;
		int random = (int) (Math.random() * 3 + 1);
		switch(random){
		case 1: rank = "assistant";
		break;
		case 2: rank = "associate";
		break;
		case 3: rank = "full";
		break;
		default: rank = "no rank";
		break;
		}
		return rank;
	}

}
