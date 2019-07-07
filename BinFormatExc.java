package vjezbe;

import java.util.Scanner;

public class BinFormatExc {

	public static void main(String[] args) {
	
		String bin = "";
		
		try{
			Scanner input = new Scanner(System.in);
			// Prompt the user to enter a string
			System.out.print("Enter a bin number: ");
			bin = input.nextLine();
			isBinString(bin);
			System.out.println("The decimal value for hex number " + bin + " is " + binToDecimal(bin));
		} catch(CustomBinExcep ex){
			System.out.println(ex);
		}
}
		
		private static boolean isBinString(String bin) throws CustomBinExcep {
			for(int i = 0; i < bin.length(); i++){
				if(bin.charAt(i) == '0' || bin.charAt(i) == '1')
					System.out.print(bin.charAt(i) + " ");
				else {
				throw new CustomBinExcep(bin);
				}
			}
			System.out.println();
		return true;
	}

		public static int binToDecimal(String bin){
		int decimalValue = 0;

		decimalValue = Integer.parseInt(bin, 2);

				return decimalValue;
	}
}
