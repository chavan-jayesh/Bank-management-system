package com.java.bank;

public class LoanAcc extends Account {
	
	double approved_loan_amnt;
	static double interest_rate;
	
	
	public LoanAcc(String name, double loan_amnt, int acc_no) {
		super(name, 0, acc_no);
		approved_loan_amnt = loan_amnt;
	}
	
	public static double getInterest_rate() {
		return interest_rate;
	}

	public static void setInterest_rate(double interest_rate) {
		LoanAcc.interest_rate = interest_rate;
	}

	public void withdraw(double withdraw_amnt) throws InsufficientBalanceException {
		
		if((approved_loan_amnt + current_balance) >= withdraw_amnt) {
			current_balance = current_balance - withdraw_amnt;
			System.out.println("\nAmount is Withdrawn!");
		}	
		else
			throw new InsufficientBalanceException("\nInsufficient Balance!");
		
	}
	
	public void display() {
		System.out.println(
				"\nAccount Type: Loan Account\n"
				+ "Account no: "+acc_no+"\n"
				+ "Name: "+name+"\n"
				+ "Current Balance : Rs. "+current_balance);
	}
	
	public double calculateInterest() {
	    return (approved_loan_amnt + current_balance) * interest_rate * 12 / 100;
	}
	
}


