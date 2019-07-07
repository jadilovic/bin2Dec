package vjezbe;

import java.util.Scanner;

public class HexFormatExc {

	public static void main(String[] args) {
	
		String hex = "";
		
		try{
			Scanner input = new Scanner(System.in);
			// Prompt the user to enter a string
			System.out.print("Enter a hex number: ");
			hex = input.nextLine();
		System.out.println("The decimal value for hex number " + hex + " is " + hexToDecimal(hex.toUpperCase()));
		} catch(CustomHexExcep ex){
			System.out.println(ex);
		}
}
		
		public static int hexToDecimal(String hex) throws CustomHexExcep{
		int decimalValue = 0;
		if(hex.matches("-?[0-9a-fA-F]+")){
			for (int i = 0; i < hex.length(); i++) {
				char hexChar = hex.charAt(i);
				decimalValue = decimalValue * 16 + hexCharToDecimal(hexChar);
				}
				return decimalValue;
		} else
			throw new CustomHexExcep(hex);
	}
		
		public static int hexCharToDecimal(char ch) {
		if (ch >= 'A' && ch <= 'F')
		return 10 + ch - 'A';
		else // ch is '0', '1', ..., or '9'
		return ch - '0';
	}
}
