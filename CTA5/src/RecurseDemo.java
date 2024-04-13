import java.util.Scanner;

public class RecurseDemo { 
	private static int sum=0; 
	static Scanner scnr = new Scanner(System.in) ;
	
	//Method sums user inputs up to n times 
	public static void sum(int n) {
		//base case
		if(n == 0) {
			System.out.printf("Your total sum is %d",sum);
		//recursive case	
		} else {
			Integer value = null; 
			//Error handler for invalid inputs
			while(value == null) {
				try {
					System.out.println("Please enter an integer: "); 
					value = Integer.valueOf(scnr.nextLine());
					sum+= value; 
				} catch(Exception e) {
					System.out.println("INVALID OPTION PLEASE TRY AGAIN"); 
				}

			}
			sum(n-1); 
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sum(5);
	}

}
