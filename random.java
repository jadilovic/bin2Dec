package vjezbe;

public class random {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		for(int i = 0; i < 20; i++){
			int broj = (int) (Math.random() * 3 + 1);
			System.out.print(broj + " ");
		}
	}

}
