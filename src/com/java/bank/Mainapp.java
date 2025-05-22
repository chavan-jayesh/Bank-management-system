package com.java.bank;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Mainapp {


	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		try {
		
			BankOperations app = new BankOperations();
			
			SavingsAcc.setInterest_rate(2.5);
			SalaryAcc.setInterest_rate(2);
			CurrentAcc.setInterestRate(3);
			LoanAcc.setInterest_rate(9.5);
			
			
			int choice;
			
			do {
				System.out.print("\n1. Open new Account\n2. Log In\n3. Display all Accounts \n4. Daily Transcation Report \n5. Harcode Accounts\n0. To Exit\n\nEnter Your Choice: ");
				choice = sc.nextInt();
				
				switch(choice) {
					
					case 1:{
						app.openNewAccount(sc);
						break;
					}
					case 2:{
						app.logIn(sc);
						break;
					}
					
					case 3:{
						app.displayAllaccounts();
						break;
					}
					
					case 4:{
						app.displayReport();
						break;
					}
					
					case 5:{
						app.harcodevalue();	
						break;
					}
		
					case 0:{
						choice = 0;
						System.out.println("\nThank You!");
						break;
					}
					default:{
						System.out.println("\nWrong Input, Please Try Again!");
					}	
				}
			}while(choice!=0);
		}
		catch(InputMismatchException i) {
			System.out.println("\nInvalid input!");
		}
		catch(Exception e) {
			System.out.println("\nAn error occurred: " + e.getMessage());
		}

		finally {
			sc.close();
		}
	}
}
