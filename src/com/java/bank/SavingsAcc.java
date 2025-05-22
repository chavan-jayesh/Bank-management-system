package com.java.bank;

public class SavingsAcc extends Account{
	
	double min_bal = 10000;
	static double interest_rate;
	
	public SavingsAcc(String name, double bal, int acc_no) {
		super(name, bal, acc_no);
	}
	
	public static double getInterest_rate() {
		return interest_rate;
	}

	public static void setInterest_rate(double interest_rate) {
		SavingsAcc.interest_rate = interest_rate;
	}
	
	public void withdraw(double withdraw_amnt) throws InsufficientBalanceException {
		if(withdraw_amnt>current_balance) {
			throw new InsufficientBalanceException("\nInsufficient Balance!");
		}
		else if((current_balance - withdraw_amnt)>=min_bal) {
			current_balance = current_balance - withdraw_amnt;
			System.out.println("\nAmount is Withdrawn!");
		}
		else {
			System.out.println("\nCannot Withdraw because it will exceed the limit of minimum balance!");
		}
	}
	
	public void display() {
		System.out.println(
				"\nAccount Type: Savings Account\n"
				+ "Account no: "+acc_no+"\n"
				+ "Name: "+name+"\n"
				+ "Current Balance: Rs. "+current_balance);
	}
	
	public double calculateInterest() {
	    return current_balance * interest_rate * 12 / 100;
	}

}
