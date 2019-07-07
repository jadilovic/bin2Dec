package vjezbe;
import java.util.InputMismatchException;
// TODO Auto-generated method stub
import java.util.Scanner;
	public class testLoan {

		public static void main(String[] args) {
			
			double annualInterestRate = 0;
			int numberOfYears = 0;
			double loanAmount = 0;

		Scanner input = new Scanner(System.in);

		try{
		System.out.print("Enter annual interest rate, for example, 8.25: ");
		annualInterestRate = input.nextDouble();

		System.out.print("Enter number of years as an integer: ");
		numberOfYears = input.nextInt();

		System.out.print("Enter loan amount, for example, 120000.95: ");
		loanAmount = input.nextDouble();
		input.close();
		
		} catch (InputMismatchException ex){
			System.out.println("You have entered wrong value. Please try again");
			System.exit(1);
		}

		try{
			Loan loan = new Loan(annualInterestRate, numberOfYears, loanAmount);
			System.out.printf("The loan was created on %s\n" 
					+"The monthly payment is %.2f\nThe total payment is %.2f\n",
					loan.getLoanDate().toString(), loan.getMonthlyPayment(), loan.getTotalPayment());
		} catch (IllegalArgumentException ex){
			System.out.println(ex);
			System.exit(2);
		}
	}
}