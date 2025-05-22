package com.java.bank;

import java.util.Scanner;

public class BankOperations {
		
		int ctr = 0, size = 10, report_ctr = 0, records = 20;
		Account[] acc_arr = new Account[size];
		static int current_acc_no = 1;
		static double loan_ROI = 11.5;
		DailyReport[] trans_report = new DailyReport[records];
		
		
		public void openNewAccount(Scanner sc) {
			
			System.out.print("\nSelect Which type of Account You want to open\n1. Savings Account\n2. Salary Account\n3. Current Account\n4. Loan Account\n\nEnter Your Choice: ");
			int choice = sc.nextInt();
			
			switch(choice) {
			
			case 1:{
				createSavingsAccount(sc);
				break;
			}
			case 2:{
				createSalaryAccount(sc);
				break;
			}
			case 3:{
				createCurrentAccount(sc);
				break;
			}
			case 4:{
				createLoanAccount(sc);
				break;
			}
			}

		}
		
		public void logIn(Scanner sc) {
			
			System.out.print("\nEnter Account no: ");
			int user_acc_no = sc.nextInt();
			sc.nextLine();
			
			for(int i = 0; i<ctr; i++) {

				if(acc_arr[i]==null) {
					continue;
				}
				if(user_acc_no == acc_arr[i].getAcc_no()) {
					System.out.println("\nLogin Succesfull! Welcome " + acc_arr[i].getName()+"...");
					int choice;
					do {
						System.out.print("\n\n1. Check Balance \n2. Withdraw \n3. Deposit \n4. Calculate Interest \n5. Close Account \n0. To Exit \n\nEnter Your Choice: ");
						choice = sc.nextInt();
						
						switch(choice) {
							case 1:{
								acc_arr[i].checkBalance();
								break;
							}
							
							case 2:{
								System.out.print("\nEnter Amount to Withdraw: ");
								double amnt = sc.nextDouble();
								try {
									acc_arr[i].withdraw(amnt);
								} catch (InsufficientBalanceException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								if(report_ctr < records) {
									trans_report[report_ctr] = new DailyReport(acc_arr[i].getAcc_no(), "Withdraw", amnt);
									report_ctr++;
								}
								break;
							}
							
							case 3:{
								System.out.print("\nEnter Amount to Deposit: ");
								double amnt = sc.nextDouble();
								acc_arr[i].deposit(amnt);
								if(report_ctr < records) {
									trans_report[report_ctr] = new DailyReport(acc_arr[i].getAcc_no(), "Deposit", amnt);
									report_ctr++;
								}
								break;
							}
							
							case 4:{
								double interestvalue = acc_arr[i].calculateInterest();
								System.out.println("Interest: Rs. "+interestvalue);
								break;
							}
							
							case 5:{
								for(int j = i; j<ctr-1; j++) {
									acc_arr[j] = acc_arr[j+1];
								}
								acc_arr[--ctr] = null;
								System.out.println("\nAccount Closed Successfully!");
								choice=0;
								return;
							}
							
							case 0:{
								choice = 0;
								System.out.println("\nThank You!");
								return;
							}
							
							default:{
								System.out.println("\nWrong Input, Please Try Again!");
							}
						}
					}while(choice!=0);
				}

				
			}
			
			System.out.println("\nAccount not Found!");
			return;
	
		}

		private void createSavingsAccount(Scanner sc){
			if(ctr<size) {
				System.out.print("\nEnter Account Holder's name: ");
				sc.nextLine();
				String name = sc.nextLine(); 
				
				System.out.print("\nEnter Balance (Minimum Rs.10000): ");
				double bal = sc.nextDouble();
				
				if(bal>=10000) {
					acc_arr[ctr] = new SavingsAcc(name, bal, current_acc_no++);
					if(report_ctr < records) {
						trans_report[report_ctr] = new DailyReport(acc_arr[ctr].getAcc_no(), "Account Opened", bal);
						report_ctr++;
					}
					ctr++;
					
					System.out.println("\nAccount Created Successfully!");
				}
				else {
					System.out.print("\nPlease Enter Minimum balace Rs.10000");
					bal = sc.nextDouble();
					if(bal>=10000) {
						acc_arr[ctr] = new SavingsAcc(name, bal, current_acc_no++);
						if(report_ctr < records) {
							trans_report[report_ctr] = new DailyReport(acc_arr[ctr].getAcc_no(), "Account Opened", bal);
							report_ctr++;
						}
						ctr++;
						System.out.println("\nAccount Created Successfully!");
					}
					else {
						System.out.println("\nInsufficient Balance!");
					}
				}
			}
			else {
				System.out.println("\nAccount Limit Over!");
			}
			
		}

		private void createSalaryAccount(Scanner sc) {
			if(ctr<size) {
				System.out.print("\nEnter Account Holder's name: ");
				sc.nextLine();
				String name = sc.nextLine(); 
				
				System.out.print("\nEnter Balance (Minimum Rs.10000): ");
				double bal = sc.nextDouble();
				
				if(bal>=10000) {
					acc_arr[ctr] = new SalaryAcc(name, bal, current_acc_no++);
					if(report_ctr < records) {
						trans_report[report_ctr] = new DailyReport(acc_arr[ctr].getAcc_no(), "Account Opened", bal);
						report_ctr++;
					}
					ctr++;
					System.out.println("\nAccount Created Successfully!");
				}
				else {
					System.out.print("\nPlease Enter Minimum balace Rs.10000");
					bal = sc.nextDouble();
					if(bal>=10000) {
						acc_arr[ctr] = new SalaryAcc(name, bal, current_acc_no++);
						if(report_ctr < records) {
							trans_report[report_ctr] = new DailyReport(acc_arr[ctr].getAcc_no(), "Account Opened", bal);
							report_ctr++;
						}
						ctr++;
						System.out.println("\nAccount Created Successfully!");
					}
					else {
						System.out.println("\nInsufficient Balance!");
					}
				}
			}
			else {
				System.out.println("\nAccount Limit Over!");
			}
			
		}

		private void createCurrentAccount(Scanner sc) {
			if(ctr<size) {
				System.out.print("\nEnter Account Holder's name: ");
				sc.nextLine();
				String name = sc.nextLine(); 
				
				System.out.print("\nEnter Balance (Minimum Rs.10000): ");
				double bal = sc.nextDouble();
				
				if(bal>=0) {
					acc_arr[ctr] = new CurrentAcc(name, bal, current_acc_no++);
					if(report_ctr < records) {
						trans_report[report_ctr] = new DailyReport(acc_arr[ctr].getAcc_no(), "Account Opened", bal);
						report_ctr++;
					}
					ctr++;
					System.out.println("\nAccount Created Successfully!");
				}
				else {
					System.out.println("\nInsufficient Balance!");
				}
			}
			else {
				System.out.println("\nAccount Limit Over!");
			}
			
		}

		private void createLoanAccount(Scanner sc) {
			if(ctr<size) {
				System.out.print("\nEnter Account Holder's name: ");
				sc.nextLine();
				String name = sc.nextLine(); 
				
				System.out.print("\nEnter Loan Amount: ");
				double loanAmnt = sc.nextDouble();
				
				if(loanAmnt>=0) {
					acc_arr[ctr] = new LoanAcc(name, loanAmnt, current_acc_no++);
					if(report_ctr < records) {
						trans_report[report_ctr] = new DailyReport(acc_arr[ctr].getAcc_no(), "Account Opened", loanAmnt);
						report_ctr++;
					}
					ctr++;
					System.out.println("\nAccount Created Successfully!");
				}
				else {
					System.out.println("\nWrong Input!");
				}
			}
			else {
				System.out.println("\nAccount Limit Over!");
			}
			
		}
		
		public void displayAllaccounts() {
			
			if(ctr==0) {
				System.out.println("\nNo Accounts to Display!");
				return;
			}
			
			for(int i = 0; i<ctr; i++) {
				if(acc_arr[i] == null) {
					continue;
				}
				acc_arr[i].display();
			}
		}
		
		public void harcodevalue() {
			acc_arr[ctr] = new LoanAcc("Jayesh", 200000, current_acc_no++);
			acc_arr[++ctr] = new SavingsAcc("Satish", 10000, current_acc_no++);
			acc_arr[++ctr] = new SalaryAcc("Suvarna", 50000, current_acc_no++);
			acc_arr[++ctr] = new CurrentAcc("Bunty", 30000, current_acc_no++);
			acc_arr[++ctr] = new SavingsAcc("Jayesh_Savings", 65000, current_acc_no++);
			ctr++;
			System.out.println("\nAccounts Hardcoded Successfully!");
		}
		
		public void displayReport() {
			
			if(report_ctr==0) {
				System.out.println("No Transcation to display!");
				return;
			}
			
			System.out.println("\n+------------+-------------------+--------------+--------------+");
	        System.out.print(    "| Account no |     Operation     |     Date     |    Amount    |");
	        System.out.println("\n+------------+-------------------+--------------+--------------+");
	        
	        
	        for(int i = 0; i<report_ctr; i++) {
	        	trans_report[i].display();
	        }
		}
}
