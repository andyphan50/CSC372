package CTA1;
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
		
	}
	
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
					break;
				case 3: 
					System.out.println("Here is your account summary:");
					this.accountSummary();
					break;
					
				case 4: 
					System.out.println("Have a good day!"); 
					x= false; 
					break;
				}
				
				
				}
		}
	}
	public void accountSummary() {
		System.out.printf("Name: %s %s\nAccount ID: %d\nBalance: %.2f",firstName, lastName, accountID, balance); 
	}
}
