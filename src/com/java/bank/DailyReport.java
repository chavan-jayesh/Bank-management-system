package com.java.bank;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
//import java.time.temporal.ChronoUnit;

public class DailyReport {
	
	int acc_no;
	String Operation_name;
	LocalDateTime Trans_Date;
	double trans_amnt;
	
	
	public DailyReport(int accNo, String operation_name, double trans_amnt) {
		this.acc_no = accNo;
		Operation_name = operation_name;
		Trans_Date = LocalDateTime.now();
		this.trans_amnt = trans_amnt;
	}
	
	public void display() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	    String formattedDate = this.Trans_Date.format(formatter);
//		System.out.println("\nAccount No: "+this.accNo+"\nOperation: "+this.Operation_name+"\nTransaction Date: \nTranscation Amount: "+this.trans_amnt);
		
	    System.out.printf("|%12d|%19s|%14s|%14.2f|", this.acc_no, this.Operation_name, formattedDate, this.trans_amnt);
	    System.out.println("\n+------------+-------------------+--------------+--------------+");
	}
	
	
	
	

}
