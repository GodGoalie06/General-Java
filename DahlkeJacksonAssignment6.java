/*Jackson Dahlke
 * CS1150 Mon-Wed, Mich
 * Oct. 8, 2025
 * Assignment #6
 * This program is a massive while loop that keeps a 
 * vending machine on unit 999 and COOKIES is entered in
 * that order. In this loop, the machine asks for the users
 * snack numbers and their selections, and prints out a
 * receipt. Overall receipt is printed when shutdown initiated.
 */

//Imports
import java.util.Scanner;
public class DahlkeJacksonAssignment6 {
	public static void main(String[] args) {
		
		// Constants and Variables
		Scanner userinput = new Scanner(System.in);
		final double ITEMP1 = 0.9;
		final double ITEMP2 = 0.7;
		final double ITEMP3 = 1.5;
		String item1 = "Pop Tarts";
		String item2 = "Pretzels";
		String item3 = "Funyuns";
		boolean Systemon = true;
		double totalSales = 0;
		int totalSnacks = 0;
		int totalItem1 = 0;
		int totalItem2 = 0;
		int totalItem3 = 0;
		
		
		//Start the loop, print the menu and ask for the user input
		while(Systemon) {
			System.out.printf("************************************"
					+ "*****\n\t      Snack Machine\n**************"
					+ "***************************\n%s\t%s\t%s\n1A  "
					+ "$%.2f\t1B  $%.2f\t1C  $%.2f\n--------------"
					+ "----------------------------\n%s \t%s \t%s\n2A"
					+ "  $%.2f\t2B  $%.2f\t2C  $%.2f\n--------------"
					+ "----------------------------\n%s  \t%s  \t%s\n3A"
					+ "  $%.2f\t3B  $%.2f\t3C  $%.2f"
					, item1, item1, item1, ITEMP1, ITEMP1, ITEMP1
					, item2, item2, item2, ITEMP2, ITEMP2, ITEMP2
					, item3, item3, item3, ITEMP3, ITEMP3, ITEMP3);
			System.out.println("\n\nHow many snacks would you like? "
					+ "Enter either 1, 2, or 3.");
			int numSnacks = userinput.nextInt();
			
			//Check if the user input is valid
			while(numSnacks != 1 && numSnacks != 2 && numSnacks != 3 &&
					numSnacks != 999) {
				System.out.println("Number of Snacks is invaild! Please"
						+ " enter 1, 2, or 3:");
				numSnacks = userinput.nextInt();
			}
			
			//If shutdown mode is initiated
			if(numSnacks == 999) {
				System.out.println("Please enter the shutdown password:");
				String shutDownPass = userinput.next();
				if(shutDownPass.equals("COOKIES")) {
					System.out.printf("\nShutting Down...\nTotal Sales: $%.2f"
							+ "\nTotal Snacks Sold: %d\n%s Sold: %d"
							+ "\n%s Sold: %d\n%s Sold: %d", totalSales, 
							totalSnacks, item1, totalItem1, item2, totalItem2
							, item3, totalItem3);
					Systemon = false;
				}
				else {
					System.out.println("Wrong password.");
				}
			}
				
			else {
				//If the user wants snacks ask for snack selection
				for(int i = numSnacks; i > 0; i--) {
					System.out.println("\nWhat snack selection would you like?");
					String snackSelec = userinput.next();
					snackSelec = snackSelec.toUpperCase();
						
					//Check if the selection is valid
					while(!snackSelec.equals("1A") && !snackSelec.equals("2A") &&
						!snackSelec.equals("3A") && !snackSelec.equals("1B") &&
						!snackSelec.equals("2B") && !snackSelec.equals("3B") &&
						!snackSelec.equals("1C") && !snackSelec.equals("2C") &&
						!snackSelec.equals("3C")) {
						System.out.println("Snack Selectiong is invaild! "
							+ "Please enter a valid selection 1A-1C, 2A-2C"
							+ ", or 3A-3C:");
						snackSelec = userinput.next();
						snackSelec = snackSelec.toUpperCase();
					}
						
					//Print selection receipt update global variables
					//If Pop Tarts
					if(snackSelec.equals("1A") || snackSelec.equals("1B") ||
						snackSelec.equals("1C")) {
						System.out.printf("\n--------------------\n---Selection: %s"
							+ "----\n--------------------\nSnack Item: %s"
							+ "\nSnack Price: $%.2f\n", snackSelec, item1, ITEMP1);
						totalItem1++;
						totalSnacks++;
						totalSales = totalSales + ITEMP1;
					}
						
					//If Pretzels
					if(snackSelec.equals("2A") || snackSelec.equals("2B") ||
						snackSelec.equals("2C")) {
						System.out.printf("\n--------------------\n---Selection: %s"
							+ "----\n--------------------\nSnack Item: %s"
							+ "\nSnack Price: $%.2f\n", snackSelec, item2, ITEMP2);
						totalItem2++;
						totalSnacks++;
						totalSales = totalSales + ITEMP2;
					}
						
					//If Funyuns
					if(snackSelec.equals("3A") || snackSelec.equals("3B") ||
						snackSelec.equals("3C")) {
						System.out.printf("\n--------------------\n---Selection: %s"
							+ "----\n--------------------\nSnack Item: %s"
							+ "\nSnack Price: $%.2f\n", snackSelec, item3, ITEMP3);
						totalItem3++;
						totalSnacks++;
						totalSales = totalSales + ITEMP3;
					}
				}//End For
				System.out.println("\n-----------------------------\nThank you "
					+ "for your busniess!\n-----------------------------\n");
			}//End else
		}//End main while
	userinput.close();
	}//End main
}//End class