package CTA2;
import java.util.Random;
import java.util.Scanner; 

public class bankAccount {
	String firstName;
	String lastName;
	int accountID; 
	double balance; 
	
	//Constructor that initializes balance to 0
	public bankAccount() { 
		
		}
		
	//Method for deposits
	public void deposit(double value) {
		balance += value; 
		System.out.printf("You deposited %.2f $",value); 
		
	}; 
	
	//Method for withdrawals
	public void withdrawal(double value) {
		balance -= value; 
		System.out.printf("You withdrawn %.2f $",value); 
	}
	
	// Setter for account information 
	public void setAccount(String first, String last) {
		Random random = new Random(); 
		this.firstName = first;
		this.lastName = last;
		this.accountID = random.nextInt(9000) + 1000; 
	}
	
	// Getter for account information
	public String getFirst() {
		return firstName; 
	}
	
	public String getLast() {
		return lastName; 
	}
	
	public int getID() {
		return accountID; 
	}
	
	//getter for returning balance
	public double getBalance() {
		return balance; 
	}
	

	public void accountSummary() {
		System.out.printf("Name: %s %s\nAccount ID: %d\nBalance: %.2f",firstName, lastName, accountID, balance); 
	}
}
