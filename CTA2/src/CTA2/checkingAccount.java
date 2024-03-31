package CTA2;

import java.util.Scanner;

public class checkingAccount extends bankAccount {
	double interest= 1.5; 
	public checkingAccount(String first,String last) {
			this.balance = 0.00; 
			this.setAccount(first, last);
	
	}
	public void overdraftCheck() {
			if(balance <0 ) {
				System.out.println(" You overdrafted a withdrawal, you will be charged a 30$ fee.");
				this.withdrawal(30);
			}
	}
	
	public void displayAccount() {
		this.accountSummary(); 
		System.out.printf("\nInterest rate: %.2f", this.interest); 
	}

}
