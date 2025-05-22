package com.java.bank;

public class CurrentAcc extends Account {

	double max_limit = 20000;	
	static double interest_rate;
	
	public CurrentAcc(String name, double bal, int acc_no) {
		super(name, bal, acc_no);
	}

	public static double getInterest_rate() {
		return interest_rate;
	}

	public static void setInterestRate(double interest_rate) {
		CurrentAcc.interest_rate = interest_rate;
	}

	public void withdraw(double withdraw_amnt) throws InsufficientBalanceException {
		
		if((current_balance + max_limit - withdraw_amnt)>=0) {
			current_balance = current_balance - withdraw_amnt;
			System.out.println("\nAmount is Withdrawn!");
		}
		else
			throw new InsufficientBalanceException("\nInsufficient Balance!");
		
	}
	
	public void display() {
		System.out.println(
				"\nAccount Type: Current Account\n"
				+ "Account no: "+acc_no+"\n"
				+ "Name: "+name+"\n"
				+ "Current Balance : Rs. "+current_balance);
	};
	
	public double calculateInterest() {
	    return current_balance * interest_rate * 12 / 100;
	}

}
