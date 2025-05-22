package com.java.bank;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class SalaryAcc extends Account {

	double min_bal = 10000;
	LocalDateTime last_trans_date;
	static double interest_rate;
	

	public SalaryAcc(String name, double bal, int acc_no) {
		super(name, bal, acc_no);
		last_trans_date = LocalDateTime.now();
	}
	
	public static double getInterest_rate() {
		return interest_rate;
	}

	public static void setInterest_rate(double interest_rate) {
		SalaryAcc.interest_rate = interest_rate;
	}


	public LocalDateTime getLast_trans_date() {
		return last_trans_date;
	}

	public void setLastTransDate(LocalDateTime last_Trans_Date) {
		last_trans_date = last_Trans_Date;
	}

	public void withdraw(double withdraw_amnt) throws InsufficientBalanceException {
		
		if(isFreeze()) {
			System.out.println("\nAccount is Frozen!");
		}
		
		else if(withdraw_amnt>current_balance) {
			throw new InsufficientBalanceException("\nInsufficient Balance!");
		}
		
		else if((current_balance - withdraw_amnt)>=min_bal){
			current_balance = current_balance - withdraw_amnt;
			System.out.println("\nAmount is Withdrawn!");
			last_trans_date = LocalDateTime.now();
		}
		else
			System.out.println("\nCannot Withdraw because it will exceed the limit of minimum balance!");
		
	}
	
	
	public void deposit(double deposit_amnt) {
		
		if(isFreeze()) {
			super.deposit(deposit_amnt);
		}
		else {
			super.deposit(deposit_amnt);
			last_trans_date = LocalDateTime.now();
		}	
	}
	
	private boolean isFreeze() {
		
		LocalDateTime current_Date = LocalDateTime.now();
		
		long diff = last_trans_date.until(current_Date, ChronoUnit.MINUTES);
		
		if(diff>1)
			return true;
		else
			return false;
	}
	
	public void display() {
		System.out.println(
				"\nAccount Type: Salary Account\n"
				+ "Account no: "+acc_no+"\n"
				+ "Name: "+name+"\n"
				+ "Current Balance: Rs. "+current_balance);
	}
	
	public double calculateInterest() {
	    return current_balance * interest_rate * 12 / 100;
	}

}
