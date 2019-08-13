package vjezbe;

public class charToInt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char numChar = 'c';
		int num = numChar;
		System.out.println(num);
		numChar -= 32;
		System.out.println(numChar);
		num = numChar;
		System.out.println(num);
		char ch = (char) num;
		System.out.println(ch);
	}

}
