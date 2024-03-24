package CTA1;

import java.util.Scanner;

public class checkingAccount extends bankAccount {
	double interest= 1.5; 
	public checkingAccount() {
		try (Scanner obj = new Scanner(System.in)) {
			System.out.println("Welcome! Please enter your first name?"); 
			this.balance = 0.00; 
			String first = obj.nextLine(); 
			System.out.println("Enter your last name:");
			String last = obj.nextLine(); 
			this.setAccount(first, last);
			this.displayAccount();
			this.menu(); 
	}
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
	public void menu() {
		try (Scanner obj = new Scanner(System.in)) {
			boolean x = true;
			while(x) {  
				System.out.println("\nWhat would you like to do?\n1.Deposit\n2.Withdraw\n3.Account Summary\n4.Close"); 
				int input = obj.nextInt(); 
				switch(input) {
				case 1: 
					System.out.println("How much would you like to deposit?");
					double deposit = obj.nextDouble(); 
					this.deposit(deposit);
					break;
					
				case 2: 
					System.out.println("How much would you like to withdraw?"); 
					double withdraw = obj.nextDouble(); 
					this.withdrawal(withdraw);
					this.overdraftCheck();
					break;
				case 3: 
					System.out.println("Here is your account summary:");
					this.displayAccount();
					break;
					
				case 4: 
					System.out.println("Have a good day!"); 
					x= false; 
					break;
				}
				
				
				}
		}
	}

}
