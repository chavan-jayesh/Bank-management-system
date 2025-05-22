package com.java.bank;

public abstract class Account{
	double current_balance;
	String name;
	int acc_no;
	
	
	public Account(String name, double balance, int acc_no) {					
		this.current_balance = balance;
		this.name = name;
		this.acc_no = acc_no;
	}

	public double getCurrent_balance() { 			
		return current_balance;
	}
	
	public void setCurrent_balance(double current_balance) {
		this.current_balance = current_balance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getAcc_no() {
		return acc_no;
	}
	
	public void setAcc_no(int acc_no) {
		this.acc_no = acc_no;
	}

	abstract public void withdraw(double withdraw_amnt) throws InsufficientBalanceException;
	
	public void deposit(double deposit_amnt) {
		current_balance = current_balance + deposit_amnt;
		System.out.println("\nAmount is Deposited!");
	}
	
	public void checkBalance() {
		System.out.println("\nCurrent Balance in your account is Rs. "+this.current_balance);
	}
	
	abstract public double calculateInterest();
	
	
	abstract public void display();
	
	
	
}
